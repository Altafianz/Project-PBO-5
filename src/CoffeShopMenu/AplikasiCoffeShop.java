package CoffeShopMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class utama aplikasi console coffee shop.
 *
 * Aplikasi memiliki dua role:
 *  - Admin    : mengelola menu (tambah, ubah, hapus) dan melihat semua pesanan.
 *  - Konsumen : melihat menu dan memesan makanan/minuman.
 *
 * Data menu dimulai kosong, sehingga admin harus menambahkan menu terlebih dahulu.
 */
public class AplikasiCoffeShop {

    private static final String PASSWORD_ADMIN = "admin123";

    private final Scanner scanner;
    private final KatalogMenu katalog;
    private final List<Pesanan> daftarPesanan;

    public AplikasiCoffeShop() {
        this.scanner = new Scanner(System.in);
        this.katalog = new KatalogMenu();
        this.daftarPesanan = new ArrayList<>();
    }

    /**
     * Titik masuk program: menampilkan menu login berulang sampai pengguna keluar.
     */
    public void jalankan() {
        System.out.println("========================================");
        System.out.println("     SELAMAT DATANG DI COFFEE SHOP      ");
        System.out.println("========================================");

        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuLogin();
            int pilihan = InputHelper.bacaInt(scanner, "Pilih: ", 0, 2);

            switch (pilihan) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginKonsumen();
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("\nTerima kasih telah berkunjung. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal.");
                    break;
            }
        }

        scanner.close();
    }

    private void tampilkanMenuLogin() {
        System.out.println("\n=== MENU LOGIN ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Konsumen");
        System.out.println("0. Keluar");
    }

    // ================== LOGIN ==================

    private void loginAdmin() {
        String password = InputHelper.bacaTeks(scanner, "Masukkan password admin: ");
        if (!PASSWORD_ADMIN.equals(password)) {
            System.out.println("  [!] Password salah.");
            return;
        }
        System.out.println("\nLogin berhasil. Selamat datang, Admin!");
        menuAdmin();
    }

    private void loginKonsumen() {
        String nama = InputHelper.bacaTeks(scanner, "Masukkan nama Anda: ");
        System.out.println("\nSelamat datang, " + nama + "!");
        menuKonsumen(nama);
    }

    // ================== MENU ADMIN ==================

    private void menuAdmin() {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Lihat daftar menu");
            System.out.println("2. Tambah makanan");
            System.out.println("3. Tambah minuman");
            System.out.println("4. Ubah menu");
            System.out.println("5. Hapus menu");
            System.out.println("6. Lihat semua pesanan");
            System.out.println("0. Logout");
            int pilihan = InputHelper.bacaInt(scanner, "Pilih: ", 0, 6);

            switch (pilihan) {
                case 1:
                    katalog.tampilkanSemuaMenu();
                    break;
                case 2:
                    tambahMakanan();
                    break;
                case 3:
                    tambahMinuman();
                    break;
                case 4:
                    ubahMenu();
                    break;
                case 5:
                    hapusMenu();
                    break;
                case 6:
                    lihatSemuaPesanan();
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal.");
                    break;
            }
        }
    }

    private void tambahMakanan() {
        System.out.println("\n--- Tambah Makanan ---");
        Makanan makanan = buatMakananDariInput();
        katalog.tambahMakanan(makanan);
        System.out.println("Makanan berhasil ditambahkan.");
    }

    private void tambahMinuman() {
        System.out.println("\n--- Tambah Minuman ---");
        Minuman minuman = buatMinumanDariInput();
        katalog.tambahMinuman(minuman);
        System.out.println("Minuman berhasil ditambahkan.");
    }

    private void ubahMenu() {
        if (katalog.isKosong()) {
            System.out.println("Belum ada menu yang dapat diubah.");
            return;
        }

        int jenis = pilihJenisMenu();
        if (jenis == 0) {
            return;
        }

        if (jenis == 1) {
            if (katalog.getDaftarMakanan().isEmpty()) {
                System.out.println("Belum ada makanan yang dapat diubah.");
                return;
            }
            katalog.tampilkanDaftarMakanan();
            int nomor = InputHelper.bacaInt(scanner, "Pilih nomor makanan yang diubah: ",
                    1, katalog.getJumlahMakanan());
            System.out.println("\nMasukkan data baru:");
            katalog.ubahMakanan(nomor, buatMakananDariInput());
            System.out.println("Makanan berhasil diubah.");
        } else {
            if (katalog.getDaftarMinuman().isEmpty()) {
                System.out.println("Belum ada minuman yang dapat diubah.");
                return;
            }
            katalog.tampilkanDaftarMinuman();
            int nomor = InputHelper.bacaInt(scanner, "Pilih nomor minuman yang diubah: ",
                    1, katalog.getJumlahMinuman());
            System.out.println("\nMasukkan data baru:");
            katalog.ubahMinuman(nomor, buatMinumanDariInput());
            System.out.println("Minuman berhasil diubah.");
        }
    }

    private void hapusMenu() {
        if (katalog.isKosong()) {
            System.out.println("Belum ada menu yang dapat dihapus.");
            return;
        }

        int jenis = pilihJenisMenu();
        if (jenis == 0) {
            return;
        }

        if (jenis == 1) {
            if (katalog.getDaftarMakanan().isEmpty()) {
                System.out.println("Belum ada makanan yang dapat dihapus.");
                return;
            }
            katalog.tampilkanDaftarMakanan();
            int nomor = InputHelper.bacaInt(scanner, "Pilih nomor makanan yang dihapus: ",
                    1, katalog.getJumlahMakanan());
            if (InputHelper.bacaYaTidak(scanner, "Yakin ingin menghapus "
                    + katalog.ambilMakanan(nomor).getNamaMenu() + "?")) {
                katalog.hapusMakanan(nomor);
                System.out.println("Makanan berhasil dihapus.");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        } else {
            if (katalog.getDaftarMinuman().isEmpty()) {
                System.out.println("Belum ada minuman yang dapat dihapus.");
                return;
            }
            katalog.tampilkanDaftarMinuman();
            int nomor = InputHelper.bacaInt(scanner, "Pilih nomor minuman yang dihapus: ",
                    1, katalog.getJumlahMinuman());
            if (InputHelper.bacaYaTidak(scanner, "Yakin ingin menghapus "
                    + katalog.ambilMinuman(nomor).getNamaMenu() + "?")) {
                katalog.hapusMinuman(nomor);
                System.out.println("Minuman berhasil dihapus.");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        }
    }

    private void lihatSemuaPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        System.out.println("=== SEMUA PESANAN (" + daftarPesanan.size() + ") ===");
        double totalPendapatan = 0;
        for (Pesanan pesanan : daftarPesanan) {
            pesanan.tampilkanInfo();
            totalPendapatan += pesanan.getTotal();
            System.out.println();
        }
        System.out.println("Total pendapatan: " + totalPendapatan);
    }

    // ================== MENU KONSUMEN ==================

    private void menuKonsumen(String nama) {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n=== MENU KONSUMEN ===");
            System.out.println("1. Lihat daftar menu");
            System.out.println("2. Pesan makanan/minuman");
            System.out.println("3. Lihat pesanan saya");
            System.out.println("0. Logout");
            int pilihan = InputHelper.bacaInt(scanner, "Pilih: ", 0, 3);

            switch (pilihan) {
                case 1:
                    katalog.tampilkanSemuaMenu();
                    break;
                case 2:
                    buatPesanan(nama);
                    break;
                case 3:
                    lihatPesananSaya(nama);
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal.");
                    break;
            }
        }
    }

    private void buatPesanan(String namaPemesan) {
        if (katalog.isKosong()) {
            System.out.println("Menu masih kosong. Silakan tunggu admin menambahkan menu.");
            return;
        }

        Pesanan pesanan = new Pesanan(buatKodePesanan(), namaPemesan);
        boolean memesan = true;

        while (memesan) {
            System.out.println("\n--- Tambah Item ---");
            System.out.println("1. Tambah makanan");
            System.out.println("2. Tambah minuman");
            System.out.println("0. Selesai & checkout");
            int pilihan = InputHelper.bacaInt(scanner, "Pilih: ", 0, 2);

            switch (pilihan) {
                case 1:
                    if (katalog.getDaftarMakanan().isEmpty()) {
                        System.out.println("Belum ada makanan.");
                        break;
                    }
                    Makanan makanan = katalog.ambilMakanan(pilihNomorMakanan());
                    int jumlahMakanan = InputHelper.bacaIntPositif(scanner, "Jumlah: ");
                    if (pesanan.addItem(makanan, jumlahMakanan)) {
                        System.out.println(makanan.getNamaMenu() + " x" + jumlahMakanan + " ditambahkan.");
                    }
                    break;
                case 2:
                    if (katalog.getDaftarMinuman().isEmpty()) {
                        System.out.println("Belum ada minuman.");
                        break;
                    }
                    Minuman minuman = katalog.ambilMinuman(pilihNomorMinuman());
                    int jumlahMinuman = InputHelper.bacaIntPositif(scanner, "Jumlah: ");
                    if (pesanan.addItem(minuman, jumlahMinuman)) {
                        System.out.println(minuman.getNamaMenu() + " x" + jumlahMinuman + " ditambahkan.");
                    }
                    break;
                case 0:
                    memesan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal.");
                    break;
            }
        }

        if (pesanan.isKosong()) {
            System.out.println("Tidak ada item yang dipesan. Pesanan dibatalkan.");
            return;
        }

        daftarPesanan.add(pesanan);
        System.out.println("\nPesanan berhasil dibuat!");
        pesanan.tampilkanInfo();
    }

    private void lihatPesananSaya(String nama) {
        List<Pesanan> pesananSaya = new ArrayList<>();
        for (Pesanan pesanan : daftarPesanan) {
            if (pesanan.getNamaPemesan().equalsIgnoreCase(nama)) {
                pesananSaya.add(pesanan);
            }
        }

        if (pesananSaya.isEmpty()) {
            System.out.println("Anda belum memiliki pesanan.");
            return;
        }

        System.out.println("=== PESANAN " + nama.toUpperCase() + " (" + pesananSaya.size() + ") ===");
        for (Pesanan pesanan : pesananSaya) {
            pesanan.tampilkanInfo();
            System.out.println();
        }
    }

    // ================== METHOD BANTU ==================

    private Makanan buatMakananDariInput() {
        String nama = InputHelper.bacaTeks(scanner, "Nama makanan: ");
        double harga = InputHelper.bacaHarga(scanner, "Harga: ");
        String rasa = InputHelper.bacaTeks(scanner, "Kategori rasa: ");
        String porsi = InputHelper.bacaTeks(scanner, "Porsi: ");
        return new Makanan(nama, harga, rasa, porsi);
    }

    private Minuman buatMinumanDariInput() {
        String nama = InputHelper.bacaTeks(scanner, "Nama minuman: ");
        double harga = InputHelper.bacaHarga(scanner, "Harga: ");
        char ukuran = InputHelper.bacaKarakter(scanner, "Ukuran (S/M/L): ", 'S', 'M', 'L');
        String penyajian = InputHelper.bacaTeks(scanner, "Jenis penyajian (dingin/panas): ");

        System.out.println("Jenis minuman:");
        System.out.println("1. Coffee");
        System.out.println("2. Non-coffee");
        int jenis = InputHelper.bacaInt(scanner, "Pilih: ", 1, 2);

        if (jenis == 1) {
            String gula = InputHelper.bacaTeks(scanner, "Tingkat gula (non/less/normal): ");
            return new MinumanCoffee(nama, harga, ukuran, penyajian, gula);
        }

        boolean soda = InputHelper.bacaYaTidak(scanner, "Bersoda?");
        return new MinumanNonCoffee(nama, harga, ukuran, penyajian, soda);
    }

    /**
     * @return 1 = makanan, 2 = minuman, 0 = batal
     */
    private int pilihJenisMenu() {
        System.out.println("Jenis menu:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.println("0. Batal");
        return InputHelper.bacaInt(scanner, "Pilih: ", 0, 2);
    }

    private int pilihNomorMakanan() {
        katalog.tampilkanDaftarMakanan();
        return InputHelper.bacaInt(scanner, "Pilih nomor makanan: ", 1, katalog.getJumlahMakanan());
    }

    private int pilihNomorMinuman() {
        katalog.tampilkanDaftarMinuman();
        return InputHelper.bacaInt(scanner, "Pilih nomor minuman: ", 1, katalog.getJumlahMinuman());
    }

    /**
     * Kode pesanan dibuat berurutan, misalnya P001, P002, dan seterusnya.
     */
    private String buatKodePesanan() {
        return String.format("P%03d", daftarPesanan.size() + 1);
    }
}
