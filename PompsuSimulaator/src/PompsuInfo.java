public class PompsuInfo {
	public static String versioon = "0.0.1";
	private static double raha = 0.0;
	private static int pudeleid = 0;
	public static int asukoht = 1;

	public static String misToimubTekst = "�rkad p�rast joomingut kivim�e poe juures �les...";
	public static String hetkePudelidTekst = "Pudeleid";
	public static String hetkeRahaTekst = "Raha";

	public static String hetkeAsukohtTekst = "Kivim�e pood";
	public static String jargminePeatusTekst = "<html><body>"
			+ "<div style='text-align: center;'>" + "N�mme Comarket ";

	public static String asukohaKirjeldusTekst = "<html><body>"
			+ "<div style='text-align: center;'>"
			+ "Kivim�e poe l�heduses pudeleid otsides v�id iga otsimiskorraga kuni 6 pudelit."
			+ "<br>"
			+ "Kivim�e taaraautomaat annab sulle 0.05� iga pudeli eest.";

	private static int viimatiLeitudPudelid = 0;

	public static String otsinguTulemus() {
		if (viimatiLeitudPudelid == 1) {
			return "Leidsid �he pudeli.";
		} else if (viimatiLeitudPudelid == 0) {
			return "Ei leidnud �htegi pudelit.<br>Tundsid ka natuke h�bi, kui t�hjad k�ed pr�gikastist v�lja t�mbasid.";
		} else {
		return "Leidsid " + viimatiLeitudPudelid + " pudelit.";
		}
	}

	public static int loePudel() {
		return pudeleid;
	}

	public static double loeRaha() {
		raha = raha * 100;
		raha = Math.round(raha);
		raha = raha / 100;
		return raha;
	}

	public static void pudelClick(int asukoht) {
		switch (asukoht) {
		case 1:
			viimatiLeitudPudelid = random(0, 6);
			pudeleid += viimatiLeitudPudelid;
		}
	}

	public static void myyPudelid(int asukoht) {
		double hind = 0;
		switch (asukoht) {
		case 1:
			hind = 0.05;
		}
		raha += pudeleid * hind;
		pudeleid = 0;
	}

	public static int random(int min, int max) {
		int vahemik = max - min + 1;
		int summa = (int) (Math.random() * vahemik);
		return summa + min;
	}

}
