package CoffeShopMenu;

public class MakananRingan extends Makanan {
    private String topping;
 
    public MakananRingan(String namaMenu, double harga, String kategoriRasa, String porsi,
                         String topping) {
        super(namaMenu, harga, kategoriRasa, porsi);
        this.topping = topping;
    }
 
    public String getTopping() {
        return topping;
    }
 
    public void setTopping(String topping) {
        this.topping = topping;
    }
 
    @Override
    public String getKeterangan() {
        return super.getKeterangan() + " | Topping: " + topping;
    }
}
