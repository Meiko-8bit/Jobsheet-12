public class PengunjungCafe16 {
    // Fungsi dengan parameter nomorMeja dan varargs namaPengunjung menggunakan perulangan for-each
    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung (Meja ke-" + nomorMeja + "):");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
        System.out.println();
    }
 
    public static void main(String[] args) {

        daftarPengunjung(1, "Ali", "Budi", "Citra");
        daftarPengunjung(2, "Andi");
        daftarPengunjung(3, "Doni", "Eti", "Fahmi", "Galih");
        

        String[] tamuArray = {"Rian", "Sinta", "Joko"};
        daftarPengunjung(4, tamuArray);
    }
}