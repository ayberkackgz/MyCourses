package spark.template.freemarker.furkancelik.finalproje.modeller;

public class Kullanici {

    private String kullaniciAdi;
    private String kullaniciTipi;
    private Integer yas;
    private String cinsiyet;
    private String sifre;

    public Kullanici(String kullaniciAdi, String kullaniciTipi, Integer yas, String cinsiyet, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciTipi = kullaniciTipi;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.sifre = sifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciTipi() {
        return kullaniciTipi;
    }

    public void setKullaniciTipi(String kullaniciTipi) {
        this.kullaniciTipi = kullaniciTipi;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}