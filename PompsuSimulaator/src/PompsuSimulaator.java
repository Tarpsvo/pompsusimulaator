

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PompsuSimulaator extends JFrame {

	// Main class
	public static void main(String[] args) throws IOException {
		new PompsuSimulaator();
	}
	
	// Ühendab osad, ehitab akna
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
                aken.add(new m2nguPane());
                aken.setResizable(false);
                aken.pack();
                aken.setLocationRelativeTo(null);
                aken.setVisible(true);
            }
        });
    }
	
	
	// Teeb akna sisu (raami sisu pmst)
	public class m2nguPane extends JLabel {

		public m2nguPane() {
            try {
            	setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/taust.jpg"))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    
    		// ---- Akna komponendid
            // Esimene rida:
            final JLabel misToimub = new JLabel(PompsuInfo.misToimubTekst, JLabel.CENTER); 
            
            // Teine rida:
            final JLabel pudelidTekst = new JLabel("Pudeleid", JLabel.CENTER);
            final JLabel pudelid = new JLabel(String.valueOf(PompsuInfo.loePudel()), JLabel.CENTER);
            final JLabel rahaTekst = new JLabel("Raha", JLabel.CENTER);
            final JLabel rahaSeis = new JLabel(PompsuInfo.loeRaha() + "€", JLabel.CENTER);
            
            final JLabel hetkeAsukoht = new JLabel(PompsuInfo.hetkeAsukohtTekst, JLabel.CENTER); 
            final JButton myyPudelid = new JButton("Müü pudelid"); 
            
            final JLabel asukohaKirjeldus = new JLabel(PompsuInfo.asukohaKirjeldusTekst, JLabel.CENTER);
            
            // Kolmas rida:
            final JLabel jargminePeatus = new JLabel(PompsuInfo.jargminePeatusTekst, JLabel.CENTER);
            final JButton ostaPilet = new JButton("Osta pilet ( 3€ )");
 
    		// Neljas rida:
            final JButton otsiPudeleid = new JButton("Otsi pudeleid"); 
    		
    		
    		
    		
    		

    		// ---- misToimub stiil
    		misToimub.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    		misToimub.setFont(new Font("Verdana", 1, 11));
    		misToimub.setForeground(Color.BLACK);
    		misToimub.setOpaque(true);
    		misToimub.setBackground(new Color(255, 255, 255, 165));
    		// ---- misToimub stiil
    
    		// ---- hetkePudelid stiil
    		pudelidTekst.setFont(new Font("Verdana", 1, 12));
    		pudelidTekst.setForeground(Color.WHITE);
    		// ---- hetkePudelid stiil
    
    		// ---- hetkeRaha stiil
    		rahaTekst.setFont(new Font("Verdana", 1, 12));
    		rahaTekst.setForeground(Color.WHITE);
    		// ---- hetkePudelid stiil
    
    		// ---- rahaSeis stiil
    		rahaSeis.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    		rahaSeis.setForeground(Color.BLACK);
    		rahaSeis.setOpaque(true);
    		rahaSeis.setBackground(new Color(255, 255, 255, 165));
    		rahaSeis.setFont(new Font("Arial", 1, 12));
    		seaSuurus(rahaSeis, 35, 15);
    
    		pudelid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    		pudelid.setForeground(Color.BLACK);
    		pudelid.setOpaque(true);
    		pudelid.setBackground(new Color(255, 255, 255, 165));
    		pudelid.setFont(new Font("Arial", 1, 12));
    		seaSuurus(pudelid, 35, 15);
    		// ---- rahaSeis stiil
    
    		// ---- hetkeAsukoht stiil
    		hetkeAsukoht.setBorder(BorderFactory.createTitledBorder(null,"Asukoht", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
    		hetkeAsukoht.setForeground(Color.WHITE);
    		hetkeAsukoht.setFont(new Font("Arial", 1, 11));
    		// ---- hetkeAsukoht stiil
    
    		// ---- soiduHind stiil
    		jargminePeatus.setBorder(BorderFactory.createTitledBorder(null,"Järgmine peatus", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
    		jargminePeatus.setForeground(Color.WHITE);
    		jargminePeatus.setFont(new Font("Arial", 1, 11));
    		// ---- soiduHind stiil
    
    		// ---- otsiPudeleid stiil
    		otsiPudeleid.setFont(new Font("Verdana", 1, 16));
    		// ---- otsiPudeleid stiil
    
    		// ---- asukohaKirjeldus stiil
    		asukohaKirjeldus.setBorder(BorderFactory.createTitledBorder(null,"Asukoha kirjeldus", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", 1, 12), Color.WHITE));
    		asukohaKirjeldus.setForeground(Color.WHITE);
    		seaSuurus(asukohaKirjeldus, 300, 50);
    		asukohaKirjeldus.setFont(new Font("Arial", 1, 11));
    		// ---- asukohaKirjeldus stiil
    		
    		
    		
    		// ---- ACTIONID
    		
    		otsiPudeleid.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent arg0) {
    	        	PompsuInfo.pudelClick(PompsuInfo.asukoht);
    	            pudelid.setText(String.valueOf(PompsuInfo.loePudel()));
    	            misToimub.setText("<html><body><div style='text-align: center;'>"+PompsuInfo.otsinguTulemus()+"</div></body></html>");
    	            repaint();
    	        }
    	    });
    		
    		myyPudelid.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent arg0) {
    	        	PompsuInfo.myyPudelid(PompsuInfo.asukoht);
    	            pudelid.setText(String.valueOf(PompsuInfo.loePudel()));
    	            rahaSeis.setText(String.valueOf(PompsuInfo.loeRaha()+"€"));
    	            repaint();
    	        }
    	    });
    		// ---- Akna komponendid

    
    		// ---- misToimub GBC
    		setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
    		c.fill = GridBagConstraints.HORIZONTAL;
    
    		c.gridx = 0;
    		c.gridy = 0;
    		c.gridwidth = 4;
    		c.ipady = 25;
    		seaSuurus(misToimub, 530, 50);
    		add(misToimub, c);
    		// ---- misToimub GBC
    
    		// ---- hetkeInfo GBC
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
    		// ---- hetkeInfo GBC
    
    		// ---- hetkeAsukoht GBC
    		c.gridy = 1;
    		c.gridx = 2;
    		c.ipady = 15;
    		c.ipadx = 5;
    		c.anchor = GridBagConstraints.PAGE_START;
    		add(hetkeAsukoht, c);
    
    		c.anchor = GridBagConstraints.PAGE_END;
    		c.ipady = 5;
    		add(myyPudelid, c);
    		// ---- hetkeAsukoht GBC
    
    		// ---- asukohaKirjeldus GBC
    		c.insets = new Insets(10, 0, 0, 0);
    		c.gridy = 1;
    		c.gridx = 3;
    		c.gridwidth = 1;
    		c.ipady = 40;
    		c.anchor = GridBagConstraints.PAGE_START;
    		add(asukohaKirjeldus, c);
    		// ---- asukohaKirjeldus GBC
    
    		// ---- Rändamine
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
    		// ---- Rändamine
    
    		// ---- otsiPudeleid GBC
    		c.gridx = 0;
    		c.gridy = 3;
    		c.gridwidth = 4;
    		c.ipady = 25;
    		c.fill = GridBagConstraints.HORIZONTAL;
    		c.anchor = GridBagConstraints.PAGE_END;
    		add(otsiPudeleid, c);
    		// ---- otsiPudeleid GBC

        }
        
    	private void seaSuurus(Component comp, int w, int h) {
    		comp.setMinimumSize(new Dimension(w, h));
    		comp.setPreferredSize(new Dimension(w, h));
    		comp.setMaximumSize(new Dimension(w, h));
    	}
	
	}
}
