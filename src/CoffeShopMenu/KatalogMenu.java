package CoffeShopMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Menyimpan seluruh daftar menu coffee shop (makanan dan minuman).
 *
 * Data menu sengaja dimulai kosong. Menu hanya dapat diisi, diubah, dan
 * dihapus oleh admin melalui method CRUD yang tersedia di class ini.
 */
public class KatalogMenu {
    private final List<Makanan> daftarMakanan;
    private final List<Minuman> daftarMinuman;

    public KatalogMenu() {
        this.daftarMakanan = new ArrayList<>();
        this.daftarMinuman = new ArrayList<>();
    }

    // ================== GETTER ==================

    public List<Makanan> getDaftarMakanan() {
        return daftarMakanan;
    }

    public List<Minuman> getDaftarMinuman() {
        return daftarMinuman;
    }

    public boolean isKosong() {
        return daftarMakanan.isEmpty() && daftarMinuman.isEmpty();
    }

    public int getJumlahMakanan() {
        return daftarMakanan.size();
    }

    public int getJumlahMinuman() {
        return daftarMinuman.size();
    }

    // ================== CRUD MAKANAN ==================

    public void tambahMakanan(Makanan makanan) {
        daftarMakanan.add(makanan);
    }

    public Makanan ambilMakanan(int nomor) {
        return daftarMakanan.get(nomor - 1);
    }

    public void ubahMakanan(int nomor, Makanan makananBaru) {
        daftarMakanan.set(nomor - 1, makananBaru);
    }

    public boolean hapusMakanan(int nomor) {
        if (nomor < 1 || nomor > daftarMakanan.size()) {
            return false;
        }
        daftarMakanan.remove(nomor - 1);
        return true;
    }

    // ================== CRUD MINUMAN ==================

    public void tambahMinuman(Minuman minuman) {
        daftarMinuman.add(minuman);
    }

    public Minuman ambilMinuman(int nomor) {
        return daftarMinuman.get(nomor - 1);
    }

    public void ubahMinuman(int nomor, Minuman minumanBaru) {
        daftarMinuman.set(nomor - 1, minumanBaru);
    }

    public boolean hapusMinuman(int nomor) {
        if (nomor < 1 || nomor > daftarMinuman.size()) {
            return false;
        }
        daftarMinuman.remove(nomor - 1);
        return true;
    }

    // ================== TAMPILAN ==================

    public void tampilkanDaftarMakanan() {
        System.out.println("--- Daftar Makanan ---");
        if (daftarMakanan.isEmpty()) {
            System.out.println("(belum ada makanan)");
            return;
        }
        for (int i = 0; i < daftarMakanan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMakanan.get(i).getKeterangan());
        }
    }

    public void tampilkanDaftarMinuman() {
        System.out.println("--- Daftar Minuman ---");
        if (daftarMinuman.isEmpty()) {
            System.out.println("(belum ada minuman)");
            return;
        }
        for (int i = 0; i < daftarMinuman.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMinuman.get(i).getKeterangan());
        }
    }

    public void tampilkanSemuaMenu() {
        System.out.println("=== DAFTAR MENU COFFEE SHOP ===");
        tampilkanDaftarMakanan();
        System.out.println();
        tampilkanDaftarMinuman();
    }
}
