package CoffeShopMenu;

public class MinumanCoffee extends Minuman {
    private String gula; // non / less / normal

    public MinumanCoffee(String nama, double harga, char ukuran, String jenisPenyajian, String gula) {
        super(nama, harga, ukuran, jenisPenyajian);
        this.gula = gula;
    }

    public String getGula() {
        return gula;
    }

    public void setGula(String gula) {
        this.gula = gula;
    }

    @Override
    public String getKeterangan() {
        return super.getKeterangan() + " | Gula: " + gula;
    }
}
