public class PompsuInfo {
	public static String versioon = "0.0.1";
	private static double raha = 0.0;
	private static int pudeleid = 0;
	public static int asukoht = 1;

	public static String misToimubTekst = "Ärkad pärast joomingut kivimäe poe juures üles...";
	public static String hetkePudelidTekst = "Pudeleid";
	public static String hetkeRahaTekst = "Raha";

	public static String hetkeAsukohtTekst = "Kivimäe pood";
	public static String jargminePeatusTekst = "<html><body>"
			+ "<div style='text-align: center;'>" + "Nõmme Comarket ";

	public static String asukohaKirjeldusTekst = "<html><body>"
			+ "<div style='text-align: center;'>"
			+ "Kivimäe poe läheduses pudeleid otsides võid iga otsimiskorraga kuni 6 pudelit."
			+ "<br>"
			+ "Kivimäe taaraautomaat annab sulle 0.05€ iga pudeli eest.";

	private static int viimatiLeitudPudelid = 0;

	public static String otsinguTulemus() {
		if (viimatiLeitudPudelid == 1) {
			return "Leidsid ühe pudeli.";
		} else if (viimatiLeitudPudelid == 0) {
			return "Ei leidnud ühtegi pudelit.<br>Tundsid ka natuke häbi, kui tühjad käed prügikastist välja tõmbasid.";
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
