package CoffeShopMenu;

public class Makanan extends Menu {
    private String kategoriRasa;
    private String porsi;

    public Makanan (String namaMenu, double harga, String kategoriRasa, String porsi) {
        super(namaMenu, harga);
        this.kategoriRasa = kategoriRasa;
        this.porsi = porsi;
    }

    public String getKategoriRasa() {
        return kategoriRasa;
    }

    public String getPorsi() {
        return porsi;
    }

    public void setKategoriRasa(String kategoriRasa) {
        this.kategoriRasa = kategoriRasa;
    }

    public void setPorsi(String porsi) {
        this.porsi = porsi;
    }

    @Override
    public String getKeterangan() {
        return getNamaMenu() + " | Harga: " + getHarga()
                + " | Rasa: " + kategoriRasa + " | Porsi: " + porsi;
    }
}
