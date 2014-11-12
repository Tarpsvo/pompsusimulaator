import javax.swing.JOptionPane;
// Proovime commitida

public class PompsuEventid {

	public static void eventiKontroll() {
		if (kasJuhtus(10)) event1();
	}
	
	// Bussijaamas magav kodutu
	private static void event1() {
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
	}
	
	
	
	
	
	
	private static boolean kasJuhtus(double protsent) {
		return (Math.random()<(protsent/100)) ? true : false;
	}

}