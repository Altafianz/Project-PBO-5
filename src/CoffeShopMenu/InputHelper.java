package CoffeShopMenu;

import java.util.Scanner;

/**
 * Kelas bantu untuk membaca dan memvalidasi input dari console.
 * Semua method di sini akan terus meminta input sampai pengguna
 * memasukkan nilai yang sesuai, sehingga program tidak crash
 * ketika input bukan angka.
 */
public final class InputHelper {

    // Utility class: tidak perlu dibuat objeknya
    private InputHelper() {
    }

    /**
     * Membaca satu angka bulat. Jika input bukan angka, program
     * akan menampilkan pesan dan meminta input ulang.
     */
    public static int bacaInt(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input tidak valid. Masukkan angka bulat, contoh: 1");
            }
        }
    }

    /**
     * Membaca angka bulat yang harus berada di antara min dan max (inklusif).
     */
    public static int bacaInt(Scanner scanner, String label, int min, int max) {
        while (true) {
            int nilai = bacaInt(scanner, label);
            if (nilai >= min && nilai <= max) {
                return nilai;
            }
            System.out.println("  [!] Pilihan harus antara " + min + " dan " + max + ".");
        }
    }

    /**
     * Membaca angka bulat yang harus lebih dari nol (untuk jumlah pesanan).
     */
    public static int bacaIntPositif(Scanner scanner, String label) {
        while (true) {
            int nilai = bacaInt(scanner, label);
            if (nilai > 0) {
                return nilai;
            }
            System.out.println("  [!] Jumlah harus lebih dari 0.");
        }
    }

    /**
     * Membaca angka desimal. Dipakai untuk input harga.
     */
    public static double bacaDouble(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input tidak valid. Masukkan angka, contoh: 25000");
            }
        }
    }

    /**
     * Membaca harga: angka desimal yang tidak boleh negatif.
     */
    public static double bacaHarga(Scanner scanner, String label) {
        while (true) {
            double nilai = bacaDouble(scanner, label);
            if (nilai >= 0) {
                return nilai;
            }
            System.out.println("  [!] Harga tidak boleh negatif.");
        }
    }

    /**
     * Membaca teks yang tidak boleh kosong.
     */
    public static String bacaTeks(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("  [!] Input tidak boleh kosong.");
        }
    }

    /**
     * Membaca satu karakter dari daftar pilihan yang diizinkan.
     * Contoh: bacaKarakter(scanner, "Ukuran (S/M/L): ", 'S', 'M', 'L').
     */
    public static char bacaKarakter(Scanner scanner, String label, char... pilihanValid) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            if (input.length() == 1) {
                char karakter = Character.toUpperCase(input.charAt(0));
                for (char valid : pilihanValid) {
                    if (karakter == Character.toUpperCase(valid)) {
                        return karakter;
                    }
                }
            }
            StringBuilder daftar = new StringBuilder();
            for (int i = 0; i < pilihanValid.length; i++) {
                if (i > 0) {
                    daftar.append("/");
                }
                daftar.append(pilihanValid[i]);
            }
            System.out.println("  [!] Masukkan salah satu dari: " + daftar);
        }
    }

    /**
     * Membaca jawaban ya/tidak.
     */
    public static boolean bacaYaTidak(Scanner scanner, String label) {
        char jawaban = bacaKarakter(scanner, label + " (y/t): ", 'y', 't');
        return jawaban == 'Y';
    }
}
