public class PompsuInfo {
	public static String versioon = "0.0.1";
	private static double raha = 0.0;
	private static int pudeleid = 0;
	public static int asukoht = 0;

	// Algne tervitav tekst
	public static String misToimubTekst = "�rkad p�rast joomingut kivim�e poe juures �les...";

	// Massiiv v�imalike asukohtade nimedega
	public static String[] asukohad = 
		{	
		"Kivim�e pood",
		"N�mme Comarket",
		"Kadaka Selver"
	};
	
	public static int[] asukohaHinnad = 
		{	
		0,
		4,
		8
	};
	
	public static int[] maxPudeleid = 
		{	
		2,
		4,
		7
	};
	
	public static double[] pudeliHind = 
		{	
		0.02,
		0.03,
		0.04
	};
	
	public static String jargminePeatusTekst = "<html><body>"
			+ "<div style='text-align: center;'>" + "N�mme Comarket ";

	public static String asukohaKirjeldusTekst = "<html><body>"
			+ "<div style='text-align: center;'>"
			+ "Kivim�e poe l�heduses pudeleid otsides v�id iga otsimiskorraga kuni 6 pudelit."
			+ "<br>"
			+ "Kivim�e taaraautomaat annab sulle 0.05� iga pudeli eest.";

	private static int viimatiLeitudPudelid = 0;

	// Genereerib otsingu tulemuse teksti leitud pudelite ja suvaliste s�ndmuste p�hjal
	// TODO Lisa suvalised s�ndmused
	public static String otsinguTulemus() {
		if (viimatiLeitudPudelid == 1) {
			return "Leidsid �he pudeli.";
		} else if (viimatiLeitudPudelid == 0) {
			return "Ei leidnud �htegi pudelit.<br>Tundsid ka natuke h�bi, kui t�hjad k�ed pr�gikastist v�lja t�mbasid.";
		} else {
		return "Leidsid " + viimatiLeitudPudelid + " pudelit.";
		}
	}

	// Tagastab hetkel olevate pudelite arvu
	public static int loePudel() {
		return pudeleid;
	}

	// Tagastab hetke rahaseisu
	public static double loeRaha() {
		raha = raha * 100;
		raha = Math.round(raha);
		raha = raha / 100;
		return raha;
	}

	// Annab kliki eventi puhul pudeleid. Pudelite arv s�ltub asukohast
	public static void pudelClick() {
			viimatiLeitudPudelid = random(0, maxPudeleid[asukoht]); // TODO Pudelite arv asukohaks s�ltuvaks
			pudeleid += viimatiLeitudPudelid;
	}

	// M��b k�ik pudelid ja annab raha. Pudelite eest saadud raha s�ltub asukohast
	public static void myyPudelid() {
		raha += pudeleid * pudeliHind[asukoht];
		pudeleid = 0;
	}
	
	public static void s6idaJ2rgmisesse() {
		int s6iduHind = asukohaHinnad[asukoht+1];
		if (loeRaha() < s6iduHind) {
			misToimubTekst = "Sul ei ole selle reisi sooritamiseks raha"; // TODO Targem tekst
		} else {
			raha -= s6iduHind;
			asukoht++;
			misToimubTekst = "Istud bussi tahaotsa ja vaatad aknast, kuidas kivim�e pood kaugusesse kaob...";
		}
	}
	
	// Tagastab info asukoha kohta:
	// 1: asukoha nimi; 2: asukoha kirjeldus
	public static String asukohaInfo(String tyyp) {
		String info = "";
		switch (tyyp) {
		case "nimi":
			info = asukohad[asukoht]; break;
		case "kirjeldus":
			info = ""; break;
		case "j2rgmine":
			info = asukohad[asukoht+1]; break;
		case "j2rgmiseHind":
			info = String.valueOf(asukohaHinnad[asukoht+1]);
		}
		return info;
	}
	
	
	// Meetod, mis tagastab antud vahemikus suvalise arvu
	public static int random(int min, int max) {
		int vahemik = max - min + 1;
		int summa = (int) (Math.random() * vahemik);
		return summa + min;
	}

}
