import java.util.Scanner;

public class Kafe16 {

    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        System.out.println("\nSelamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("==========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga16(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        
        if (pilihanMenu < 1 || pilihanMenu > hargaItems.length) {
            System.out.println("Menu tidak tersedia");
            return 0;
        }
        
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static double hitungDiskon(int total, String kodePromo, boolean isMember) {
        double diskon = 0;
        
        if (kodePromo.equals("DISKON50")) {
            diskon = total * 0.50;
        } else if (kodePromo.equals("DISKON30")) {
            diskon = total * 0.30;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            diskon += total * 0.10;
        }
        
        return diskon;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String nama = sc.nextLine();

        System.out.print("Apakah pelanggan member? (y/n): ");
        String jawab = sc.nextLine();
        boolean isMember = jawab.equalsIgnoreCase("y");

        System.out.print("Masukkan jam kunjung: ");
        int jam = sc.nextInt();
        sc.nextLine();

        Menu(nama, isMember, jam);

        int totalKeseluruhan = 0;
        char lanjut;

        do {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();
            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            int subTotal = hitungTotalHarga16(pilihanMenu, banyakItem);
            totalKeseluruhan += subTotal;

            System.out.print("Apakah ingin memesan menu lain? (y/n): ");
            lanjut = sc.next().charAt(0);
        } while (lanjut == 'y' || lanjut == 'Y');

        System.out.println("\nTotal harga awal pesanan Anda: Rp" + totalKeseluruhan);


        sc.nextLine();
        System.out.print("Masukkan kode promo (jika ada, misal DISKON50 / DISKON30): ");
        String kodePromo = sc.nextLine();

        double besarDiskon = hitungDiskon(totalKeseluruhan, kodePromo, isMember);
        double totalBayarAkhir = totalKeseluruhan - besarDiskon;


        System.out.println("\n===== RINCIAN PEMBAYARAN =====");
        System.out.println("Total Harga : Rp" + totalKeseluruhan);
        System.out.println("Besar Diskon: Rp" + (int) besarDiskon);
        System.out.println("Total Bayar : Rp" + (int) totalBayarAkhir);

        sc.close();
    }
}