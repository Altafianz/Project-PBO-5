package CoffeShopMenu;

public class Minuman extends Menu {
    private char ukuran;
    private String jenisPenyajian;

    public Minuman(String namaMenu, double harga, char ukuran, String jenisPenyajian) {
        super(namaMenu, harga);
        this.ukuran = ukuran;
        this.jenisPenyajian = jenisPenyajian;
    }

    public String getJenisPenyajian() {
        return jenisPenyajian;
    }

    public char getUkuran() {
        return ukuran;
    }

    public void setJenisPenyajian(String jenisPenyajian) {
        this.jenisPenyajian = jenisPenyajian;
    }

    public void setUkuran(char ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public String getKeterangan() {
        return getNamaMenu() + " | Harga: " + getHarga()
                + " | Ukuran: " + ukuran + " | Penyajian: " + jenisPenyajian;
    }
}
