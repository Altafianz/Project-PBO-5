package CoffeShopMenu;

import java.util.ArrayList;
import java.util.List;

public class Pesanan {
    private final String kodePesanan;
    private final String namaPemesan;
    private final List<ItemPesanan> daftarItem;

    private static int jumlahPesanan = 0;
    public static final double PAJAK = 0.2;

    public Pesanan(String kode, String namaPemesan) {
        this.kodePesanan = kode;
        this.namaPemesan = namaPemesan;
        this.daftarItem = new ArrayList<>();
        jumlahPesanan++;
    }

    public Pesanan(String kode) {
        this(kode, "Umum");
    }

    public Pesanan(String kode, Makanan makanan, int jmlMakanan) {
        this(kode);
        addItem(makanan, jmlMakanan);
    }

    public Pesanan(String kode, Minuman minuman, int jmlMinuman) {
        this(kode);
        addItem(minuman, jmlMinuman);
    }

    public Pesanan(String kode, Makanan makanan, int jmlMakanan, Minuman minuman, int jmlMinuman) {
        this(kode);
        addItem(makanan, jmlMakanan);
        addItem(minuman, jmlMinuman);
    }

    public static int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public String getKodePesanan() {
        return kodePesanan;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public List<ItemPesanan> getDaftarItem() {
        return daftarItem;
    }

    public boolean isKosong() {
        return daftarItem.isEmpty();
    }

    public boolean addItem(Menu menu, int jumlah) {
        if (menu == null) {
            System.out.println("  [!] Menu tidak valid.");
            return false;
        }
        if (jumlah <= 0) {
            System.out.println("  [!] Jumlah harus lebih dari 0.");
            return false;
        }
        daftarItem.add(new ItemPesanan(menu, jumlah));
        return true;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (ItemPesanan item : daftarItem) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public double getPajak() {
        return getSubtotal() * PAJAK;
    }

    public double getTotal() {
        return getSubtotal() + getPajak();
    }

    public void tampilkanInfo() {
        System.out.println("=== Pesanan " + kodePesanan + " | Pemesan: " + namaPemesan + " ===");
        if (daftarItem.isEmpty()) {
            System.out.println("(belum ada item)");
            return;
        }
        for (ItemPesanan item : daftarItem) {
            System.out.println("- " + item.getMenu().getNamaMenu()
                    + " x" + item.getJumlah() + " = " + item.getSubtotal());
        }
        System.out.println("Subtotal: " + getSubtotal());
        System.out.println("Pajak   : " + getPajak());
        System.out.println("Total   : " + getTotal());
    }
}
