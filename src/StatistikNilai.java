import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class StatistikNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();
        int nilai;

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) continue;

            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);
        } while (nilai != SELESAI);

        if (daftar.isEmpty()) {
            System.out.println();
            System.out.println("Tidak ada nilai yang valid.");
            return;
        }

        System.out.println();
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        // maks dan min dimulai dari elemen PERTAMA (bukan 0).
        // Untuk maks, mulai dari 0 kebetulan masih benar. Tetapi untuk min,
        // kalau dimulai dari 0 hasilnya selalu 0 karena tidak ada nilai ujian
        // yang lebih kecil dari 0. Mulai dari elemen pertama menjamin
        // hasilnya selalu nilai yang benar-benar ada di daftar.
        int total = 0;
        int maks = daftar.get(0);
        int min = daftar.get(0);

        for (int x : daftar) {
            total += x;
            if (x > maks) maks = x;
            if (x < min) min = x;
        }

        double rata = (double) total / daftar.size();

        // Tidak bisa dihitung di putaran pertama, karena rata-rata baru
        // diketahui setelah SEMUA nilai dijumlahkan. Saat nilai pertama
        // dibaca, belum ada rata-rata untuk dibandingkan. Karena itu perlu
        // putaran kedua, dan itulah alasan nilai harus disimpan.
        int diAtas = 0;
        for (int x : daftar) {
            if (x > rata) diAtas++;
        }

        input.close();
    }
}