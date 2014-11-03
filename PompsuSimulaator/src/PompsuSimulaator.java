

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PompsuSimulaator extends JFrame {

	public static void main(String[] args) throws IOException {
		new PompsuSimulaator();
	}
	
	// ---- UI akna kokkupanek
	public PompsuSimulaator() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

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
    		// misToimub stiil
    		misToimub.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    		misToimub.setFont(new Font("Verdana", 1, 11));
    		misToimub.setForeground(Color.BLACK);
    		misToimub.setOpaque(true);
    		misToimub.setBackground(new Color(255, 255, 255, 165));
    
    		// hetkePudelid stiil
    		pudelidTekst.setFont(new Font("Verdana", 1, 12));
    		pudelidTekst.setForeground(Color.WHITE);
    
    		// hetkeRaha stiil
    		rahaTekst.setFont(new Font("Verdana", 1, 12));
    		rahaTekst.setForeground(Color.WHITE);
    
    		// rahaSeis stiil
    		rahaSeis.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    		rahaSeis.setForeground(Color.BLACK);
    		rahaSeis.setOpaque(true);
    		rahaSeis.setBackground(new Color(255, 255, 255, 165));
    		rahaSeis.setFont(new Font("Arial", 1, 12));
    		seaSuurus(rahaSeis, 35, 15);
    		
    		// pudelid stiil
    		pudelid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    		pudelid.setForeground(Color.BLACK);
    		pudelid.setOpaque(true);
    		pudelid.setBackground(new Color(255, 255, 255, 165));
    		pudelid.setFont(new Font("Arial", 1, 12));
    		seaSuurus(pudelid, 35, 15);
    		myyPudelid.setEnabled(false);
    
    		// hetkeAsukoht stiil
    		hetkeAsukoht.setBorder(BorderFactory.createTitledBorder(null,"Asukoht", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
    		hetkeAsukoht.setForeground(new Color(0xf29324));
    		hetkeAsukoht.setFont(new Font("Verdana", 1, 13));
    
    		// jargminePeatus stiil
    		jargminePeatus.setBorder(BorderFactory.createTitledBorder(null,"Järgmine peatus", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
    		jargminePeatus.setForeground(new Color(0xf29324));
    		jargminePeatus.setFont(new Font("Verdana", 1, 13));
    		ostaPilet.setEnabled(false);
    
    		//  otsiPudeleid stiil
    		otsiPudeleid.setFont(new Font("Verdana", 1, 16));
    
    		// asukohaKirjeldus stiil
    		asukohaKirjeldus.setBorder(BorderFactory.createTitledBorder(null,"Asukoha kirjeldus", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
    		asukohaKirjeldus.setForeground(Color.WHITE);
    		seaSuurus(asukohaKirjeldus, 300, 50);
    		asukohaKirjeldus.setFont(new Font("Arial", 1, 11));
    		
    		
    		
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
    	            if (PompsuInfo.lihtneSundmus() != "") tekst = lihtneSundmus; else tekst = PompsuInfo.otsinguTulemus();
    	            
    	            misToimub.setText("<html><body><div style='text-align: center;'>"+tekst+"</div></body></html>");
    	            
    	            rahaSeis.setText(String.valueOf(PompsuInfo.raha()+"€"));
    	            pudelid.setText(String.valueOf(PompsuInfo.pudeleid()));
    	            repaint();
    	        }
    	    });
    		
    		// myyPudelid click -> myyPudelid()
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
    		
    		// ostaPilet click -> soidaJargmisesse()
    		ostaPilet.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent arg0) {
    	        	misToimub.setText(PompsuInfo.soidaJargmisesse());
    	        	rahaSeis.setText(String.valueOf(PompsuInfo.raha()+"€"));
    	        	hetkeAsukoht.setText(PompsuInfo.asukohaInfo("nimi"));
    	        	ostaPilet.setText(PompsuInfo.asukohaInfo("jargmiseHindOsta"));
    	        	jargminePeatus.setText(PompsuInfo.asukohaInfo("jargmiseNimi"));
    	        	ostaPilet.setEnabled(false);
    	        	asukohaKirjeldus.setText(PompsuInfo.asukohaKirjeldus());
    	        	muudaTaust("taust2.jpg");
    	            repaint();
    	        }
    	    });

        }
        
		// Seab komponendi suuruse
    	private void seaSuurus(Component comp, int w, int h) {
    		comp.setMinimumSize(new Dimension(w, h));
    		comp.setPreferredSize(new Dimension(w, h));
    		comp.setMaximumSize(new Dimension(w, h));
    	}
    	
    	private void muudaTaust (String pilt) {
    		try {
            	setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/"+pilt))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    	}
	
	}
}
