
public class PompsuAsukoht {
	 
		private static int asukohaNr = 0;
	
		private String[] asukohaNimed = {
			"Kivimäe pood",
			"Nõmme Comarket",
			"Valdeku Maxima",
			"Kadaka Selver"
			};

		private int[] asukohaHinnad = { // Asukohta sõitmise hinnad
			0,	// Kivimäe
			1,	// Nõmme
			3,	// Valdeku
			5	// Kadaka
			};

		private int[] maxPudeleid = { // Maksimaalne pudelite arv
			2,	// Kivimäe
			3,	// Nõmme
			4,	// Valdeku
			5	// Kadaka
			};

		private double[] pudeliHind = { // Ühe pudeli eest saadav raha
			0.01,	// Kivimäe
			0.02,	// Nõmme
			0.02,	// Valdeku
			0.03 	// Kadaka
			};
		
		
		String nimi() {
			return asukohaNimed[asukohaNr];
		}
		
		String jargmiseNimi() {
			String nimi = "- Oled lõpp-peatuses  -";
			if (asukohaNr < asukohaNimed.length-1) nimi = asukohaNimed[asukohaNr+1];
			return nimi;
		}
		
		int maxPudeleid() {
			return maxPudeleid[asukohaNr];
		}
		
		double pudeliHind() {
			return pudeliHind[asukohaNr];
		}
		
		int soiduHind() {
			int hind = 0;
			if (asukohaNr < asukohaHinnad.length-1) hind = asukohaHinnad[asukohaNr+1];
			return hind;
		}
		
		void asukohtEdasi() {
			asukohaNr++;
		}
		
		boolean viimane() {
			return asukohaNr == asukohaNimed.length-1 ? true : false;
		}
		
		String ostaPiletTekst() {
			String tekst = "- Oled lõpp-peatuses -";
			if (!viimane()) tekst = "Osta pilet ("+soiduHind()+"€)";
			return tekst;
		}
		
		int asukohaNr() {
			return asukohaNr;
		}
}
