import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Belanja {
    private String name;
    private int cost;
    private int jum;

    public Belanja(){}

    public void setNamaBarang(String nama) {
        this.name = nama;
    }

    public void setHargaBarang(int harga) {
        this.cost = harga;
    }

    public void setJumBarang(int jumlah){
        this.jum = jumlah;
    }

    public String nama(){
        return this.name;
    }

    public int harga() {
        return this.cost;
    }

    public int jumlah(){
        return this.jum;
    }

    public String CetakInvoice(ArrayList<Belanja> barang){
        Locale negara = new Locale.Builder().setLanguage("id").setRegion("ID").build();
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(negara);  
        int total = 0;
        for (Belanja item : barang) {
            System.out.println(item.nama());
            System.out.println(item.jumlah() + " * " + item.harga());
            total += (item.harga() * item.jumlah());
        }
        return rupiah.format(total);
    }
}
