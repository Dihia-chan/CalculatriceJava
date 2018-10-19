package interfacesGraphiques;

import javax.swing.AbstractButton;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import java.awt.*;
import javax.swing.border.Border;

import miniProjet2.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		
		
	    JFrame frame = new JFrame ("MiniProjet2");
	    frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 200);
		frame.setLocation(130,150);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		 //Définition de sa couleur de fond
	    panel.setBackground(Color.magenta);
		
	    JPanel pan1 = new JPanel();
	    panel.add(pan1);
	   
	    JLabel label1 = new JLabel();		
		label1.setText("Veuillez choisir le type de l'opération");
		pan1.add(label1);
	    
	    
		JPanel pan2 = new JPanel();
		panel.add(pan2);
		JButton bouton1 = new JButton("* Opérations Binaires *");
		pan2.add(bouton1);
		bouton1.addActionListener(new Action1());
		JPanel pan3 = new JPanel();
		panel.add(pan3);
		JButton bouton2 = new JButton("* Opérations Unaires *");
		pan3.add(bouton2);
		bouton2.addActionListener(new Action2());
		
		
		
		
	}			
		static class Action1 implements ActionListener {
            public void actionPerformed(ActionEvent e){
            	Calculatrice calculette = new Calculatrice();
            	
            }
	}
		static class Action2 implements ActionListener {
		 public void actionPerformed(ActionEvent e){
         	CalculatriceScientifique calculette = new CalculatriceScientifique();
	}
}
	}

