import java.util.Scanner;
 
public class HitungBalok16 {
    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }
 
    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        int luasPermukaan = 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
        return luasPermukaan;
    }
 
    public static void main(String[] args) {

        int[][] ukuranBalok = {
            {4, 3, 5}, // Balok 1: panjang=4, lebar=3, tinggi=5
            {6, 2, 4}, // Balok 2: panjang=6, lebar=2, tinggi=4
            {5, 5, 5}  // Balok 3: panjang=5, lebar=5, tinggi=5
        };

        for (int i = 0; i < ukuranBalok.length; i++) {
            int p = ukuranBalok[i][0];
            int l = ukuranBalok[i][1];
            int t = ukuranBalok[i][2];

            int luasPermukaan = hitungLuasPermukaanBalok(p, l, t);
            int volume = hitungVolume(t, p, l);

            System.out.println("--- Balok ke-" + (i + 1) + " (p=" + p + ", l=" + l + ", t=" + t + ") ---");
            System.out.println("Luas Permukaan Balok adalah : " + luasPermukaan);
            System.out.println("Volume Balok adalah         : " + volume);
            System.out.println();
        }
    }
}