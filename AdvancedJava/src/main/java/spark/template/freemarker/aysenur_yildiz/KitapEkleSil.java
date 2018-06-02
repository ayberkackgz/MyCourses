package spark.template.freemarker.aysenur_yildiz;
import static spark.Spark.*;
import Request *;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.omg.CORBA.Request;
/**
 * @author 
 *
 */
public class KitapEkleSil{
	private static final ArrayList<Kitap> KITAPLAR = new ArrayList<Kitap>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VeriTabani.veritabaniniYukle();
		VeriTabani.veritabaninaBaglan();
		VeriTabani.tablolariOlustur();
		KITAPLAR.add(new Kitap(Kitap.ID++, "Kurk Mantolu Madonna", 55, "Sabahattin Ali"));
		kitaplarJson();
		// http://localhost:4567/anasayfa
		kitaplariGoruntule();
		// http://localhost:4567/kitapekle
		kitapEklemeIslemi();
		// http://localhost:4567/kitapekle 
	kitapEklemeIslemi();
		// http://localhost:4567/kitapsil 
		kitapSilmeIslemi();
	}
	/* OZKANS DUZELTME
	private static void kitaplariGoruntule() {	
	}
	*/
	private static void kitaplarJson() {
	}
	private static void kitapSilmeIslemi() {
		 /**
		 * @author
		 *
		 */
		FreeMarkerRoute kitapSilmeIslemi =new FreeMarkerRoute() {
			/* (non-Javadoc)
			 * @see spark.Route#handle(spark.Request, spark.Response)
			 */
			@Override
			public Object handle(Request istek, Response cevap) {
				int id = Integer.valueOf(istek.queryParams("id"));
				VeriTabani.kitapSil(id);
				cevap.redirect("/anasayfa");

				return null;
			}
		};
		get(kitapSilmeIslemi);
	}
	/**
	 * 
	 */
	private static void kitapEklemeIslemi() {
		FreeMarkerRoute kitapEkleIslemi = new FreeMarkerRoute() {
			/* (non-Javadoc)
			 * @see spark.Route#handle(spark.Request, spark.Response)
			 */
			@Override
			public Object handle(Request istek, Response cevap) {
				String kitapAdi = istek.queryParams("kitapadi");
				String kitapDetayi = istek.queryParams("kitapdetay");
				}
				Kitap kitap = new Kitap(kitap.ID++, kitapAdi, fiyat, kitapDetayi);
				VeriTabani.kitapEkle(Kitap);
				cevap.redirect("/anasayfa");
				return null;
			}
		};
		post(kitapEkleIslemi);
	}
	/**
	 * 
	 */
	private static void kitapEklemeSayfasi() {
		FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute() {
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", KİTAPLAR);
				return new ModelAndView(ozellikler, "kitapekle.html");
			}
		};
		get(kitapEkleSayfasi);
	}
	/**
	 * 
	 */
	private static void kitaplariGoruntule() {
		FreeMarkerRoute kitaplariGoruntule = new FreeMarkerRoute("/anasayfa") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				List<Kitap> kitaplar =VeriTabani.kayitlariAl();
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar",kitaplar);
				return new ModelAndView(ozellikler, "anasayfa.html");
			}
		};
		get(kitaplari);
	}
