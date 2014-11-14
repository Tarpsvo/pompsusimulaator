import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PompsuSimulaator extends JFrame {

	public static void main(String[] args) throws IOException {
		new PompsuSimulaator();
	}
	
	/** Loob kasutajaliidese akna */
	public PompsuSimulaator() {
		/** EventQueue invokeLater tähendab, et UI ja arvutused on eraldi threadidel (?) */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame aken = new JFrame("Pompsusimulaator "+PompsuInfo.versioon);
                aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                aken.add(new manguPane());
                aken.setResizable(false);
                aken.pack();
                aken.setLocationRelativeTo(null);
                aken.setVisible(true);
            }
        });
    }
	
	
	// ---- Akna sisu ja kujundus
	public class manguPane extends JLabel {

		// Konstruktor akna jaoks
		public manguPane() {
            muudaTaust("taust.jpg");
    
    		// ---- Akna komponendid
            // -- Esimene rida:
            final JLabel misToimub = new JLabel(PompsuInfo.misToimubTekst, JLabel.CENTER); 

            // -- Teine rida:
            final JLabel pudelidTekst = new JLabel("Pudeleid", JLabel.CENTER);
            final JLabel pudelid = new JLabel(""+PompsuInfo.pudeleid(), JLabel.CENTER);
            final JLabel rahaTekst = new JLabel("Raha", JLabel.CENTER);
            final JLabel rahaSeis = new JLabel(PompsuInfo.raha() + "€", JLabel.CENTER);
            final JLabel hetkeAsukoht = new JLabel(PompsuInfo.asukohaInfo("nimi"), JLabel.CENTER); 
            final JButton myyPudelid = new JButton("Müü pudelid"); 
            final JLabel asukohaKirjeldus = new JLabel(PompsuInfo.asukohaKirjeldus(), JLabel.CENTER);
            
            // -- Kolmas rida:
            final JLabel jargminePeatus = new JLabel(PompsuInfo.asukohaInfo("jargmiseNimi"), JLabel.CENTER);
            final JButton ostaPilet = new JButton(PompsuInfo.asukohaInfo("jargmiseHindOsta"));
 
    		// Neljas rida:
            final JButton otsiPudeleid = new JButton("Otsi pudeleid"); 
    		
    		
    		
    		
    		
            // ---- Komponentide stiilid
            PompsuStiil.misToimubStiil(misToimub);
            PompsuStiil.numbriStiil(pudelidTekst, rahaTekst);
    		PompsuStiil.rahaSeisStiil(rahaSeis);
    		PompsuStiil.pudelidStiil(pudelid);
    		PompsuStiil.hetkeAsukohtPeatusStiil(hetkeAsukoht, jargminePeatus);
    		PompsuStiil.otsiPudeleidStiil(otsiPudeleid);
    		PompsuStiil.asukohaKirjeldusStiil(asukohaKirjeldus);
    		myyPudelid.setEnabled(false);
    		ostaPilet.setEnabled(false);
    		
    		
    		
    		// ---- GBC ülesehitus
    		// misToimub GBC
    		setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
    		c.fill = GridBagConstraints.HORIZONTAL;
    
    		c.gridx = 0;
    		c.gridy = 0;
    		c.gridwidth = 4;
    		c.ipady = 25;
    		seaSuurus(misToimub, 540, 50);
    		add(misToimub, c);
    
    		// hetkeInfo GBC
    		c.gridy = 1;
    		c.gridx = 0;
    		c.gridwidth = 1;
    		c.ipady = 15;
    		c.ipadx = 15;
    		c.insets = new Insets(15, 0, 0, 0);
    
    		c.anchor = GridBagConstraints.PAGE_START;
    		add(pudelidTekst, c);
    		c.gridx = 1;
    		c.insets = new Insets(15, 0, 0, 10);
    		add(pudelid, c);
    
    		c.insets = new Insets(15, 0, 0, 0);
    		c.gridx = 0;
    		c.anchor = GridBagConstraints.PAGE_END;
    		add(rahaTekst, c);
    		c.gridx = 1;
    		c.insets = new Insets(15, 0, 0, 10);
    		add(rahaSeis, c);
    
    		// hetkeAsukoht GBC
    		c.gridy = 1;
    		c.gridx = 2;
    		c.ipady = 15;
    		c.anchor = GridBagConstraints.PAGE_START;
    		add(hetkeAsukoht, c);
    
    		c.anchor = GridBagConstraints.PAGE_END;
    		c.ipady = 5;
    		c.ipadx = 45;
    		add(myyPudelid, c);
    
    		// asukohaKirjeldus GBC
    		c.insets = new Insets(10, 0, 0, 0);
    		c.gridy = 1;
    		c.gridx = 3;
    		c.gridwidth = 1;
    		c.ipady = 40;
    		c.anchor = GridBagConstraints.PAGE_START;
    		add(asukohaKirjeldus, c);
    
    		// jargminePeatus ja ostaPilet GBC
    		c.gridx = 0;
    		c.gridy = 2;
    		c.gridwidth = 3;
    		c.anchor = GridBagConstraints.PAGE_END;
    		c.insets = new Insets(10, 0, 0, 10);
    		c.ipady = 10;
    		add(jargminePeatus, c);
    
    		c.gridx = 3;
    		c.ipady = 11;
    		c.insets = new Insets(10, 0, 2, 00);
    		add(ostaPilet, c);
    
    		// otsiPudeleid GBC
    		c.gridx = 0;
    		c.gridy = 3;
    		c.gridwidth = 4;
    		c.ipady = 25;
    		c.fill = GridBagConstraints.HORIZONTAL;
    		c.anchor = GridBagConstraints.PAGE_END;
    		add(otsiPudeleid, c);
    		
    		
    		// ---- Actionid (klikid)
    		// otsiPudeleid click -> pudelClick()
    		otsiPudeleid.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent arg0) {
    	        	PompsuInfo.pudelClick();
    	        	PompsuEventid.eventiKontroll();
    	        	
    	            if (PompsuInfo.pudeleid() != 0) myyPudelid.setEnabled(true);
    	            
    	            String lihtneSundmus = PompsuInfo.lihtneSundmus();
    	            String tekst = "";
    	            if (lihtneSundmus != "") tekst = lihtneSundmus; else tekst = PompsuInfo.otsinguTulemus();
    	            misToimub.setText("<html><div style='text-align: center;'>"+tekst+"</div></html>");
    	            rahaSeis.setText(String.valueOf(PompsuInfo.raha()+"€"));
    	            pudelid.setText(String.valueOf(PompsuInfo.pudeleid()));
    	            repaint();
    	        }
    	    });
    		
    		/** ActionListener pudelite müümis nupule. Lisab raha ja uuendab raha ja pudelite arvu liideses. */
    		myyPudelid.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent arg0) {
    	        	PompsuInfo.myyPudelid();
    	            pudelid.setText(String.valueOf(PompsuInfo.pudeleid()));
    	            rahaSeis.setText(String.valueOf(PompsuInfo.raha()+"€"));
    	            myyPudelid.setEnabled(false);
    	            if (!PompsuInfo.viimane() && PompsuInfo.raha() >= Integer.parseInt(PompsuInfo.asukohaInfo("jargmiseHind"))) ostaPilet.setEnabled(true);
    	            repaint();
    	        }
    	    });
    		
    		/** ActionListener pileti ostmis nupule. Muudab kasutajaliideses tekstid ja numbrid. */
    		ostaPilet.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent arg0) {
    	        	misToimub.setText(PompsuInfo.soidaJargmisesse());
    	        	rahaSeis.setText(String.valueOf(PompsuInfo.raha()+"€"));
    	        	hetkeAsukoht.setText(PompsuInfo.asukohaInfo("nimi"));
    	        	ostaPilet.setText(PompsuInfo.asukohaInfo("jargmiseHindOsta"));
    	        	jargminePeatus.setText(PompsuInfo.asukohaInfo("jargmiseNimi"));
    	        	ostaPilet.setEnabled(false);
    	        	asukohaKirjeldus.setText(PompsuInfo.asukohaKirjeldus());
    	        	if (PompsuInfo.asukoht == 1) muudaTaust("taust2.jpg");
    	            repaint();
    	        }
    	    });

        }
        
		/**
		 * Muudab komponendi suurust aknas
		 * @param comp Komponent mida muuta
		 * @param w Laius
		 * @param h Kõrgus
		 */
    	private void seaSuurus(Component comp, int w, int h) {
    		comp.setMinimumSize(new Dimension(w, h));
    		comp.setPreferredSize(new Dimension(w, h));
    		comp.setMaximumSize(new Dimension(w, h));
    	}
    	
    	/**
    	 * Muudab taustapilti
    	 * @param pilt Taustapildi faili täisnimi
    	 */
    	private void muudaTaust (String pilt) {
    		try {
            	setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/"+pilt))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    	}
	
	}
}