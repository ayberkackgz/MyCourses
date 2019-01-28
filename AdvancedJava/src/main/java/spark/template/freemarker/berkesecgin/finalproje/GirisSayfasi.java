package spark.template.freemarker.berkesecgin.finalproje;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;

public class GirisSayfasi {

	public static void sayfalariTanimla() {

		girisSayfasiTanimla();
		girisFormPostTanimla();

	}

	private static void girisFormPostTanimla() {

		Route girisFormPostAction = new Route("/berkesecgin/giris_sayfasi/login") {
			@Override
			public Object handle(Request istek, Response cevap) {

				String kullaniciadi = istek.queryParams("kullaniciadi"); 
				
				Kullanici kullanici = VeritabaniYonetimi.kullaniciSorgula(kullaniciadi);
				if(kullanici == null) {
					System.out.println("Verilen kullanici bulunamadi " + kullaniciadi);
					cevap.redirect("/berkesecgin/giris_sayfasi/");
				} else {
					String sifre = istek.queryParams("sifre");
					
					if(kullanici.getSifre().equals(sifre)) {
						System.out.println("Sifre dogru. Giris basarili");
						UygulamaMain.girisYapmisKullanici = kullanici;
						cevap.redirect("/berkesecgin/");
					} else {
						System.out.println("Sifre hatali.");
						cevap.redirect("/berkesecgin/giris_sayfasi/");
					}
				}
				
				return null;
			}
		};
		post(girisFormPostAction);

	}

	private static void girisSayfasiTanimla() {
		FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/berkesecgin/giris_sayfasi/" ) {
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(null, "/berkesecgin/finalproje/giris_sayfasi.html");
			}
		};
		get(girisSayfasi);
	}
}