package CoffeShopMenu;

public class Menu {
    private String namaMenu;
    private double harga;

    public Menu(String namaMenu, double harga) {
        this.namaMenu = namaMenu;
        setHarga(harga);
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public double getHarga() {
        return harga;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public void setHarga(double hargaMenu) {
        if (hargaMenu >= 0) {
            this.harga = hargaMenu;
        } else {
            System.out.println("Harga Tidak Valid!");
        }
    }

    public String getKeterangan() {
        return namaMenu + " | Harga: " + harga;
    }
}
