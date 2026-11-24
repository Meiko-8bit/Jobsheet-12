public class RekapLaundry16 {
    public static void tampilkanTabel(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        System.out.println("\n============================== REKAP DATA LAUNDRY ==============================");
        System.out.printf("%-15s %-12s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%-8s", h);
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-15s Rp%-10d", namaLayanan[i], hargaPerKg[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-8d", data[i][j]);
            }
            System.out.println();
        }
        System.out.println("================================================================================");
    }

    public static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    public static void tampilkanLayananTertinggi(int[][] data, String[] namaLayanan) {
        int maxBerat = -1;
        String namaTertinggi = "";
        for (int i = 0; i < data.length; i++) {
            int total = totalPerLayanan(data, i);
            if (total > maxBerat) {
                maxBerat = total;
                namaTertinggi = namaLayanan[i];
            }
        }
        System.out.println("\nLayanan dengan total berat cucian tertinggi: " + namaTertinggi + " (" + maxBerat + " kg)");
    }

    public static int hariTersibuk(int[][] data) {
        int jmlHari = data[0].length;
        int hariTersibukIdx = 0;
        int maxBeratHari = -1;

        for (int j = 0; j < jmlHari; j++) {
            int totalHariIni = 0;
            for (int i = 0; i < data.length; i++) {
                totalHariIni += data[i][j];
            }
            if (totalHariIni > maxBeratHari) {
                maxBeratHari = totalHariIni;
                hariTersibukIdx = j;
            }
        }
        return hariTersibukIdx;
    }

    public static void hitungPendapatan(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
        System.out.println("\n======================= PENDAPATAN LAYANAN =======================");
        int totalPendapatanKeseluruhan = 0;

        for (int i = 0; i < data.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            int pendapatan = totalKg * hargaPerKg[i];
            totalPendapatanKeseluruhan += pendapatan;
            System.out.printf("%-15s : %d kg x Rp%d = Rp%d\n", namaLayanan[i], totalKg, hargaPerKg[i], pendapatan);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Total Pendapatan Selama 6 Hari: Rp" + totalPendapatanKeseluruhan);
        System.out.println("==================================================================");
    }

    public static void main(String[] args) {
        String[] namaLayanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] hargaPerKg = {6000, 8000, 5000, 12000};
        
        int[][] beratCucian = {
            {12, 15, 10, 18, 20, 25}, // Cuci Kering
            {20, 18, 22, 15, 30, 35}, // Cuci Setrika
            {8, 5, 10, 7, 6, 12},     // Setrika Saja
            {3, 6, 2, 5, 8, 10}       // Express
        };

        tampilkanTabel(beratCucian, namaLayanan, hargaPerKg);

        tampilkanLayananTertinggi(beratCucian, namaLayanan);

        String[] daftarHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int idxHariSibuk = hariTersibuk(beratCucian);
        System.out.println("Hari tersibuk (total cucian terbesar): " + daftarHari[idxHariSibuk]);

        hitungPendapatan(beratCucian, namaLayanan, hargaPerKg);
    }
}
