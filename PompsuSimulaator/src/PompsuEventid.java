import javax.swing.JOptionPane;
// Proovime commitida

public class PompsuEventid {

	public static String eventiKontroll() {
		String tekst = "";
		if (kasJuhtus(1)) {
			tekst = event1();
		}
		return tekst;
	}
	
	// Bussijaamas magav kodutu
	private static String event1() {
		String tekst = "";
		String[][] tulemused1 = {
				{"Taarakoti juurde astudes ärkab vana üles ja sa jooksed minema.<br>"
						+ "Joostes pillad paar oma pudelit maha.", "pudel", "-3"},
				{"Võtad sujuvalt ta taarakoti ja paned ajama.", "pudel", "+8"}
		};

		String[][] tulemused2 = {
				{"Mehe taskutes sobrades lööd teda kogemata küünernukiga näkku ja kaod nagu tuul.", null, null},
				{"Mehe jopetaskust leiad peotäie sente.", "raha", "+0.5"}
		};
		Object[] valikud = {
				"Võta mehe taarakott",
                "Otsi ta taskutest raha",
                "Ei tee midagi"};
		int n = JOptionPane.showOptionDialog(null,
		"Leidsid bussipeatuse pingilt magava saatusekaaslase. Kuidas käitud?",
		"Midagi juhtus",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		valikud,
		valikud[2]);
		if (n == 0) {
			tekst = eventiTulemus(tulemused1);
		} else if (n == 1) {
			tekst = eventiTulemus(tulemused2);
		}
		return tekst;
	}
	
	private static String eventiTulemus(String[][] tulemused) {
		int nr = random(0, tulemused.length-1);
		String syndmusTekst = tulemused[nr][0];
		double tulemus = PompsuInfo.teostaTulemus(tulemused[nr][1], tulemused[nr][2]);
		if (tulemus != 0) {
		tulemus = (tulemused[nr][1] == "pudel") ? (int) tulemus : tulemus;
		syndmusTekst += (tulemus > 0) ? " Said "+tulemus : " Kaotasid "+Math.abs(tulemus);
		syndmusTekst += (tulemused[nr][1] == "raha") ? " eurot." : " pudelit.";
		}
		return syndmusTekst;
	}
	
	public static int random(int min, int max) {
		int vahemik = max - min + 1;
		int summa = (int) (Math.random() * vahemik);
		return summa + min;
	}
	
	private static boolean kasJuhtus(double protsent) {
		protsent /= 100;
		double random = Math.random();
		return (random < protsent) ? true : false;
	}

}