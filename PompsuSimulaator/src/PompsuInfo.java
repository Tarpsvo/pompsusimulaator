public class PompsuInfo {
	public static String versioon = "0.0.2";
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
		1,
		1
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
	
	public static String soidaJargmisesse() {
		int soiduHind = asukohaHinnad[asukoht+1];
		if (raha < soiduHind) {
			return "Sul ei ole selle reisi sooritamiseks raha"; // TODO Targem tekst
		} else {
			raha -= soiduHind;
			asukoht = asukoht+1;
			return "Istud bussi tahaotsa ja vaatad aknast, kuidas "+asukohad[asukoht-1]+" kaugusesse kaob..."; 
			// TODO Targem tekst
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
		case "jargmiseNimi":
			if (!viimane()) {
				info = asukohad[asukoht+1]; break;
			} else {
				info = "-";
			}
		case "jargmiseHindOsta":
			if (!viimane()) {
				info = "Osta pilet ("+String.valueOf(asukohaHinnad[asukoht+1])+"�)";
			} else {
				info = "- Oled j�udnud l�ppu -";
			}
		}
		return info;
	}
	
	public static String asukohaKirjeldus() {
		String esimeneSona[] = asukohad[asukoht].split(" ", 2);
		return "<html><body>"
				+ "<div style='text-align: center;'>"
				+ asukohad[asukoht]+" l�heduses pudeleid otsides v�id iga otsimiskorraga kuni "+maxPudeleid[asukoht]+" pudelit."
				+ "<br>"
				+ esimeneSona[0]+" taaraautomaat annab sulle "+pudeliHind[asukoht]+"� iga pudeli eest.";
	}
	
	
	// Meetod, mis tagastab antud vahemikus suvalise arvu
	public static int random(int min, int max) {
		int vahemik = max - min + 1;
		int summa = (int) (Math.random() * vahemik);
		return summa + min;
	}
	
	// Tagastab true, kui on viimane asukoht, false kui ei ole viimane
	public static boolean viimane() {
		return (asukoht < asukohad.length-1) ? false : true;
	}

}
