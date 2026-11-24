import java.util.Scanner;

public class KubusLimas16 {

    public static int luasPersegi(int s) {
        return s * s;
    }

    public static int volumeKubus(int s) {
        return s * s * s;
    }

    public static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    public static double volumeLimasPersegi(int s, int t) {
        double luasAlas = luasPersegi(s);
        return (luasAlas * t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== MENU PERHITUNGAN KUBUS & LIMAS PERSEGI =====");
            System.out.println("1. Hitung Volume Kubus");
            System.out.println("2. Hitung Luas Permukaan Kubus");
            System.out.println("3. Hitung Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi kubus: ");
                    int sisiKubus = sc.nextInt();
                    System.out.println("Volume Kubus: " + volumeKubus(sisiKubus));
                    break;
                case 2:
                    System.out.println("Masukkan panjang sisi kubus: ");
                    int sisiLP = sc.nextInt();
                    System.out.println("Luas Permukaan Kubus: " + luasPermukaanKubus(sisiLP));
                    break;
                case 3:
                    System.out.print("Masukkan panjang sisi alas limas: ");
                    int sisiLimas = sc.nextInt();
                    System.out.print("Masukkan tinggi limas: ");
                    int tinggiLimas = sc.nextInt();
                    System.out.println("Volume Limas Persegi: " + volumeLimasPersegi(sisiLimas, tinggiLimas));
                    break;
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}