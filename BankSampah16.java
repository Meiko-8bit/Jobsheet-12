import java.util.Scanner;

public class BankSampah16 {

    public static double[] inputSetoran(int n) {
        Scanner sc = new Scanner(System.in);
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\n--- Daftar Berat Setoran Nasabah ---");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    public static void hitungSaldo(double[] setoran, double hargaPerKg) {
        System.out.println("\n--- Saldo Setiap Nasabah (Rp3.000/kg) ---");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = setoran[i] * hargaPerKg;
            System.out.println("Nasabah ke-" + (i + 1) + " : Rp" + saldo);
        }
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int indexMax = 0;
        double max = setoran[0];
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > max) {
                max = setoran[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n);
        tampilSetoran(dataSetoran);

        double totalBerat = totalSetoran(dataSetoran);
        System.out.println("\nTotal keseluruhan berat setoran: " + totalBerat + " kg");

        hitungSaldo(dataSetoran, 3000);

        int idxTerbesar = nasabahTerbanyak(dataSetoran);
        System.out.println("\nNasabah dengan setoran terbanyak adalah Nasabah ke-" + (idxTerbesar + 1) + " dengan berat sebesar " + dataSetoran[idxTerbesar] + " kg.");

        sc.close();
    }
}
