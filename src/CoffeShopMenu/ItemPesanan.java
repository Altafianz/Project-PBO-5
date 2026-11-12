package CoffeShopMenu;

/**
 * Satu baris item di dalam pesanan: menu apa yang dipesan dan berapa jumlahnya.
 * Relasi HAS-A antara Pesanan dan Menu.
 */
public class ItemPesanan {
    private final Menu menu;
    private final int jumlah;

    public ItemPesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getSubtotal() {
        return menu.getHarga() * jumlah;
    }
}
