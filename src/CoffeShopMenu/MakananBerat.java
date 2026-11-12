package CoffeShopMenu;

public class MakananBerat extends Makanan {
    private String tingkatPedas; 
    private String jenisLauk;
 
    public MakananBerat(String namaMenu, double harga, String kategoriRasa, String porsi,
                        String tingkatPedas, String jenisLauk) {
        super(namaMenu, harga, kategoriRasa, porsi);
        this.tingkatPedas = tingkatPedas;
        this.jenisLauk = jenisLauk;
    }
 
    public String getTingkatPedas() {
        return tingkatPedas;
    }
 
    public String getJenisLauk() {
        return jenisLauk;
    }
 
    public void setTingkatPedas(String tingkatPedas) {
        this.tingkatPedas = tingkatPedas;
    }
 
    public void setJenisLauk(String jenisLauk) {
        this.jenisLauk = jenisLauk;
    }
 
    @Override
    public String getKeterangan() {
        return super.getKeterangan() + " | Pedas: " + tingkatPedas + " | Lauk: " + jenisLauk;
    }
}
