// TODO Nimekiri:
// TODO Kaart
// TODO Seljakott asjadega
// TODO Saavutused

public class PompsuInfo {
	//// Lihtsad arvulised väärtused/konstandid
	public static String versioon = "0.0.4";
	private static double raha = 0.0;
	private static int pudeleid = 0;
	private static double lihtsaSundmuseVoimalus = 0.03;
	private static int viimatiLeitudPudelid = 0;
	
	// Loome asukoha info klassi
	static PompsuAsukoht asukoht = new PompsuAsukoht();

	// Mängu sisu info massiivid
	private static String[][] lihtsadSundmused = {
			{ "Su kilekott purunes ootamatult, pidid mõned pudelid maha jätma...", "pudel", "-3" },
			{ "Makaagid tulid sind ähvardama, nende eest joostes kaotasid mõned pudelid", "pudel", "-3" } };

	//// Mängu põhiosa funktsioonid
	/**
	 * Loeb pudelite arvu
	 * @return Pudelite arv
	 */
	public static int pudeleid() {
		return pudeleid;
	}

	/**
	 * Loeb raha
	 * @return Rahasumma kahe komakohaga
	 */
	public static double raha() {
		return Math.round(raha*100)/100.0;
	}

	/**
	 * Genereerib otsingu tulemuse teksti
	 * @return Tekst, mis kajastab otsingu tulemust
	 */
	public static String otsinguTulemus() {
		if (viimatiLeitudPudelid == 1) {
			return "Leidsid ühe pudeli.";
		} else if (viimatiLeitudPudelid == 0) {
			return "Ei leidnud ühtegi pudelit.<br>"
					+ "Tundsid ka natuke häbi, kui tühjad käed prügikastist välja tõmbasid.";
		} else {
			return "Leidsid " + viimatiLeitudPudelid + " pudelit.";
		}
	}

	/** Lisab kliki peale pudeleid kasutaja kontole, arvestab asukohta */
	public static void pudelClick() {
		viimatiLeitudPudelid = random(0, asukoht.maxPudeleid());
		pudeleid += viimatiLeitudPudelid;
	}

	/**
	 * 
	 */
	// Müüb kõik pudelid asukohale vastava hinnaga
	// TODO Tekst, mis ütleb palju müüsid ja said
	public static String myyPudelid() {
		String tagastus = "";
		double saadudRaha = Math.round(pudeleid * asukoht.pudeliHind() * 100)/100.0;
		if (pudeleid > 1) {
			tagastus = "Toppisid " + pudeleid + " pudelit taaraautomaati ja said " + saadudRaha + "€.";
		} else {
			tagastus = "Pistsid oma ainsa pudeli masinasse ja said " + asukoht.pudeliHind() + "€.";
		}
		raha += saadudRaha;
		pudeleid = 0;
		return tagastus;
	}

	// Reisib ühe asukoha võrra edasi
	// @return Tekst järgmisesse kohta sõitmise kohta
	public static String soidaJargmisesse() {
		int soiduHind = asukoht.soiduHind();
		if (raha < soiduHind) {
			return "Sul ei ole selle reisi sooritamiseks raha"; // TODO Targem
																// tekst
		} else {
			raha -= soiduHind;
			String tagastus =  "Istud bussi tahaotsa ja vaatad aknast, kuidas " + asukoht.nimi() + " kaugusesse kaob...";
			asukoht.asukohtEdasi();
			return tagastus;
			// TODO Targem tekst
		}
	}

	// Genereerib asukoha kirjelduse
	// @return asukoha kirjeldus
	public static String asukohaKirjeldus() {
		String esimeneSona[] = asukoht.nimi().split(" ", 2);
		return "<html><body>" + "<div style='text-align: center; font-size: 8px;'>" + "Koha " + asukoht.nimi()
				+ " läheduses pudeleid otsides võid iga otsimiskorraga leida kuni "
				+ "<span style='font-size: 9px; color: #58d615;'>" + asukoht.maxPudeleid() + "</span> pudelit." + "<br>"
				+ esimeneSona[0] + " taaraautomaat annab sulle <span style='color: #58d615;'>"
				+ asukoht.pudeliHind() + "€</span> iga pudeli eest.";
	}

	public static String lihtneSundmus() {
		String tekst = "";
		if (Math.random() < lihtsaSundmuseVoimalus) {
			int sundmus = random(0, lihtsadSundmused.length - 1);
			tekst = lihtsadSundmused[sundmus][0];
			String tyyp = lihtsadSundmused[sundmus][1];
			int arv = Integer.parseInt(lihtsadSundmused[sundmus][2]);
			arv = (arv < 0) ? random(arv, 0) : random(0, arv);
			if (tyyp == "pudel")
				pudeleid += arv;
			if (pudeleid < 0)
				pudeleid = 0;
			if (tyyp == "raha")
				raha += arv;
			if (raha < 0)
				raha = 0;
		}
		return tekst;
	}
	
	public static double teostaTulemus(String tyyp, String palju) {
		double tulemus = 0;
		if (tyyp == "raha") {
			double maxRaha = Double.parseDouble(palju);
			if (maxRaha > 0) {
				tulemus = randomDouble(0.1, maxRaha);
				raha += tulemus;
			} else {
				tulemus = randomDouble(-0.1, maxRaha);
				raha += tulemus;
			}
		} else if (tyyp == "pudel") {
			int maxPudelid = Integer.parseInt(palju);
			if (maxPudelid > 0) {
				int tulemusInt = random(1, maxPudelid);
				pudeleid += tulemusInt;
				tulemus = (double) tulemusInt;
			} else {
				int tulemusInt = random(-1, maxPudelid);
				pudeleid += tulemusInt;
				tulemus = (double) tulemusInt;
			}
		}
		return tulemus;
	}

	// ---- Lisafunktsioonid, mis teevad elu lihtsamaks
	// @param min Minimaalne väärtus
	// @param max Maksimaalne väärtus
	// @return Suvaline arv nende kahe väärtuse vahel (k.a.)
	public static int random(int min, int max) {
		int vahemik = (max > 0) ? max - min + 1 : max - min - 1;
		int summa = (int) (Math.random() * vahemik);
		return summa + min;
	}
	
	private static double randomDouble(double min, double max) {
		double vahemik = max - min;
		double summa = Math.random() * vahemik;
		return Math.round((summa + min)*100)/100.0;
	}

}