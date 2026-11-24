import java.util.Scanner;

public class RekapLaundry16 {

    public static void tampilkanTabelDinamis(int[][] data, String[] namaLayanan, int[] hargaPerKg, int jmlHari) {
        System.out.println("\n============================= TABEL REKAP LAUNDRY =============================");
        System.out.printf("%-15s %-12s", "Layanan", "Harga/kg");
        for (int j = 0; j < jmlHari; j++) {
            System.out.printf("%-10s", "Hari-" + (j + 1));
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-15s Rp%-10d", namaLayanan[i], hargaPerKg[i]);
            for (int j = 0; j < jmlHari; j++) {
                System.out.printf("%-10d", data[i][j]);
            }
            System.out.println();
        }
        System.out.println("===============================================================================");
    }

    public static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    public static void hitungPendapatanDinamis(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
        System.out.println("\n======================= PENDAPATAN LAYANAN DINAMIS =======================");
        int totalPendapatanKeseluruhan = 0;

        for (int i = 0; i < data.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            int pendapatan = totalKg * hargaPerKg[i];
            totalPendapatanKeseluruhan += pendapatan;
            System.out.printf("%-15s : %d kg x Rp%d = Rp%d\n", namaLayanan[i], totalKg, hargaPerKg[i], pendapatan);
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total Pendapatan Keseluruhan : Rp" + totalPendapatanKeseluruhan);
        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah jenis layanan laundry: ");
        int jmlLayanan = sc.nextInt();
        System.out.print("Masukkan jumlah hari pencatatan: ");
        int jmlHari = sc.nextInt();

        String[] namaLayanan = new String[jmlLayanan];
        int[] hargaPerKg = new int[jmlLayanan];
        int[][] beratCucian = new int[jmlLayanan][jmlHari];

        sc.nextLine();

        for (int i = 0; i < jmlLayanan; i++) {
            System.out.println("\n--- Data Layanan ke-" + (i + 1) + " ---");
            System.out.print("Masukkan nama layanan: ");
            namaLayanan[i] = sc.nextLine();
            System.out.print("Masukkan harga per kg untuk " + namaLayanan[i] + " (Rp): ");
            hargaPerKg[i] = sc.nextInt();
            sc.nextLine(); // Membersihkan buffer

            for (int j = 0; j < jmlHari; j++) {
                System.out.print("  Masukkan berat cucian untuk Hari ke-" + (j + 1) + " (kg): ");
                beratCucian[i][j] = sc.nextInt();
            }
            sc.nextLine(); 
        }

        tampilkanTabelDinamis(beratCucian, namaLayanan, hargaPerKg, jmlHari);

        hitungPendapatanDinamis(beratCucian, namaLayanan, hargaPerKg);

        sc.close();
    }
}
