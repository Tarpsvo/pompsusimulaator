import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class PompsuStiil {
	static Font OpenSans = looUusFont("OpenSans.ttf");
	static Font infoFont = new Font("Verdana", 1, 11);

	public static void muudaStiil(boolean opaque, float fontSize, JLabel... jlabels) {
		for (JLabel jlabel : jlabels) {
			jlabel.setFont(OpenSans.deriveFont(fontSize));
			if (opaque) {
				jlabel.setOpaque(true);
				jlabel.setForeground(Color.BLACK);
				jlabel.setBackground(new Color(255, 255, 255, 165));
				jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			} else {
				jlabel.setForeground(Color.WHITE);
			}
		}
	}

	public static void muudaStiilBorder(String borderText, float fontSize, String color, JLabel... jlabels) {
		for (JLabel jlabel : jlabels) {
			jlabel.setFont(OpenSans.deriveFont(fontSize));
			jlabel.setForeground(Color.decode(color));
			jlabel.setBorder(BorderFactory.createTitledBorder(null, borderText, TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, OpenSans.deriveFont(11.0f), Color.decode("#f0f0f0")));
		}
	}
	
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
