import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;


public class PompsuStiil {
	// Fondid
	static Font DejaVuSans = looUusFont("DejaVuSans.ttf");
	static Font infoFont = new Font("Verdana", 1, 11);
	
	public static void misToimubStiil(JLabel misToimub) {
		misToimub.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		misToimub.setFont(DejaVuSans);
		misToimub.setForeground(Color.BLACK);
		misToimub.setOpaque(true);
		misToimub.setBackground(new Color(255, 255, 255, 165));
	}
	
	public static void numbriStiil(JLabel pudelidTekst, JLabel rahaTekst) {
		pudelidTekst.setFont(new Font("Verdana", 1, 12));
		pudelidTekst.setForeground(Color.WHITE);
		
		rahaTekst.setFont(new Font("Verdana", 1, 12));
		rahaTekst.setForeground(Color.WHITE);
	}

	public static void rahaSeisStiil(JLabel rahaSeis) {
		rahaSeis.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rahaSeis.setForeground(Color.BLACK);
		rahaSeis.setOpaque(true);
		rahaSeis.setBackground(new Color(255, 255, 255, 165));
		rahaSeis.setFont(new Font("Arial", 1, 12));
		seaSuurus(rahaSeis, 35, 15);
	}
	
	public static void pudelidStiil(JLabel pudelid) {
		pudelid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pudelid.setForeground(Color.BLACK);
		pudelid.setOpaque(true);
		pudelid.setBackground(new Color(255, 255, 255, 165));
		pudelid.setFont(new Font("Arial", 1, 12));
		seaSuurus(pudelid, 35, 15);
	}
	
	public static void hetkeAsukohtPeatusStiil(JLabel hetkeAsukoht, JLabel jargminePeatus) {
		hetkeAsukoht.setBorder(BorderFactory.createTitledBorder(null,"Asukoht", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
		hetkeAsukoht.setForeground(new Color(0xf29324));
		hetkeAsukoht.setFont(new Font("Verdana", 1, 13));
		jargminePeatus.setBorder(BorderFactory.createTitledBorder(null,"Järgmine peatus", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
		jargminePeatus.setForeground(new Color(0xf29324));
		jargminePeatus.setFont(new Font("Verdana", 1, 13));
	}

	public static void otsiPudeleidStiil(JButton otsiPudeleid) {
		otsiPudeleid.setFont(new Font("Verdana", 1, 16));
	}

	public static void asukohaKirjeldusStiil(JLabel asukohaKirjeldus) {
		asukohaKirjeldus.setBorder(BorderFactory.createTitledBorder(null,"Asukoha kirjeldus", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, infoFont, Color.WHITE));
		asukohaKirjeldus.setForeground(Color.WHITE);
		seaSuurus(asukohaKirjeldus, 300, 50);
		asukohaKirjeldus.setFont(DejaVuSans);
	}
	
	/**
	 * Muudab komponendi suurust aknas
	 * @param comp Komponent mida muuta
	 * @param w Laius
	 * @param h Kõrgus
	 */
	private static void seaSuurus(Component comp, int w, int h) {
		comp.setMinimumSize(new Dimension(w, h));
		comp.setPreferredSize(new Dimension(w, h));
		comp.setMaximumSize(new Dimension(w, h));
	}
	
	
	/**
	 * Loob uue Fonti failist DejaVuSans.ttf
	 * @param fondifail Fondifaili täisnimi
	 * @return Uus Font tüüpi objekt
	 */
	private static Font looUusFont(String fondifail) {
		Font uusFont = null;
		try {
			InputStream fondiFail = PompsuStiil.class.getResourceAsStream(fondifail);
			uusFont = Font.createFont(Font.TRUETYPE_FONT, fondiFail);
			uusFont = uusFont.deriveFont(Font.BOLD, 14.0f);
		} catch (IOException | FontFormatException ex) {
			ex.printStackTrace();
		}
		return uusFont;
	}
	
}
