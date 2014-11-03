// TODO Nimekiri:
// TODO Random s�ndmused
// TODO Kaart
// TODO Seljakott asjadega
// TODO Saavutused

public class PompsuInfo {
	// ---- Lihtsad arvulised v��rtused/konstandid ----
	public static String versioon = "0.0.2";
	private static double raha = 0.0;
	private static int pudeleid = 0;
	public static int asukoht = 0;
	public static String misToimubTekst = "�rkad p�rast joomingut kivim�e poe juures �les..."; // Algne tervitus
	private static int viimatiLeitudPudelid = 0;

	// ---- M�ngu sisu info massiivid ----
	private static String[] asukohad = {	// Asukohtade NIMED
		"Kivim�e pood",
		"N�mme Comarket",
		"Kadaka Selver"
	};
	
	private static int[] asukohaHinnad = { // Asukohta s�itmise HINNAD
		0,
		1,
		3
	};
	
	private static int[] maxPudeleid = {	// Maksimaalne pudelite arv
		2,
		3,
		5
	};
	
	private static double[] pudeliHind = { // �he pudeli hind
		0.02,
		0.02,
		0.03
	};

	
	// ---- M�ngu p�hiosa funktsioonid ----
	
	// @return Pudelite arv
	public static int pudeleid() {
		return pudeleid;
	}

	// @return Rahaseis kahe komakohaga
	public static double raha() {
		raha *= 100;
		raha = Math.round(raha);
		raha /= 100;
		return raha;
	}
	
	// Genereerib otsingu tulemuse teksti leitud pudelite ja suvaliste s�ndmuste p�hjal
	// @return Tekst, mis �tleb otsingu tulemuse
	public static String otsinguTulemus() {
		if (viimatiLeitudPudelid == 1) {
			return "Leidsid �he pudeli.";
		} else if (viimatiLeitudPudelid == 0) {
			return "Ei leidnud �htegi pudelit.<br>"
					+ "Tundsid ka natuke h�bi, kui t�hjad k�ed pr�gikastist v�lja t�mbasid.";
		} else {
		return "Leidsid " + viimatiLeitudPudelid + " pudelit.";
		}
	}

	// Lisab asukohale vastavalt �he kliki jagu pudeleid
	public static void pudelClick() {
			viimatiLeitudPudelid = random(0, maxPudeleid[asukoht]); // TODO Pudelite arv asukohaks s�ltuvaks
			pudeleid += viimatiLeitudPudelid;
	}

	// M��b k�ik pudelid asukohale vastava hinnaga
	public static void myyPudelid() {
		raha += pudeleid * pudeliHind[asukoht];
		pudeleid = 0;
	}
	
	// Reisib �he asukoha v�rra edasi
	// @return Tekst j�rgmisesse kohta s�itmise kohta
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
	
	// @param tyyp String, mis m��rab, mis t��pi info tagastatakse
	// @return "nimi" - hetkeasukoha nimi
	// @return "jargmiseNimi" - j�rgmise asukoha nimi
	// @return "jargmiseHindOsta" - genereerib 'Osta pilet' nupu teksti
	public static String asukohaInfo(String tyyp) {
		String info = "";
		switch (tyyp) {
		case "nimi":
			info = asukohad[asukoht]; break;
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
	
	// Genereerib asukoha kirjelduse
	// @return asukoha kirjeldus
	public static String asukohaKirjeldus() {
		String esimeneSona[] = asukohad[asukoht].split(" ", 2);
		return "<html><body>"
				+ "<div style='text-align: center;'>"
				+ "Koha "+asukohad[asukoht]+" l�heduses pudeleid otsides v�id iga otsimiskorraga leida kuni "
				+ "<span style='font-size: 9px;'>"+maxPudeleid[asukoht]+"</span> pudelit."
				+ "<br>"
				+ esimeneSona[0]+" taaraautomaat annab sulle <span style='font-size: 9px;'>"+pudeliHind[asukoht]+"�</span> iga pudeli eest.";
	}
	
	
	
	
	
	// ---- Lisafunktsioonid, mis teevad elu lihtsamaks
	// @param min Minimaalne v��rtus
	// @param max Maksimaalne v��rtus
	// @return Suvaline arv nende kahe v��rtuse vahel (k.a.)
	public static int random(int min, int max) {
		int vahemik = max - min + 1;
		int summa = (int) (Math.random() * vahemik);
		return summa + min;
	}
	
	// @return true, kui on viimane, false kui ei ole viimane
	public static boolean viimane() {
		return (asukoht < asukohad.length-1) ? false : true;
	}

}
