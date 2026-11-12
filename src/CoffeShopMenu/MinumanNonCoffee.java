package CoffeShopMenu;

public class MinumanNonCoffee extends Minuman {
    private boolean isSoda; // true = iya, false = tidak

    public MinumanNonCoffee(String nama, double harga, char ukuran, String jenisPenyajian, boolean isSoda) {
        super(nama, harga, ukuran, jenisPenyajian);
        this.isSoda = isSoda;
    }

    public boolean getIsSoda() {
        return isSoda;
    }

    public void setIsSoda(boolean isSoda) {
        this.isSoda = isSoda;
    }

    @Override
    public String getKeterangan() {
        return super.getKeterangan() + " | Soda: " + (isSoda ? "ya" : "tidak");
    }
}
