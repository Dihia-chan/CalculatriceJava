package interfacesGraphiques;

import miniProjet2.*;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
  
public class CalculatriceScientifique extends JFrame{
  private JPanel container = new JPanel();
  //Tableau stockant les éléments à afficher dans la calculatrice
  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "Cos", "Sin", "Log", "Exp"};
  //Un bouton par élément à afficher
  JButton[] tab_button = new JButton[tab_string.length];
  private JLabel ecran = new JLabel();
  private Dimension dim = new Dimension(50, 40);
  private Dimension dim2 = new Dimension(60, 31);
  private double chiffre;
  private boolean clicOperateur = false, update = false;
  private String operateur = "";
  private OperationUnaire op ;
  private Cos cos ;
  private Sin sin;
  private Log log;
  private Exp exp;
  
  public CalculatriceScientifique(){
    this.setSize(340, 260);
    this.setTitle("Calculette");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(500,350);
    this.setResizable(false);
    //On initialise le conteneur avec tous les composants
	  initComposant();
	  //On ajoute le conteneur
    this.setContentPane(container);
    this.setVisible(true);
  }
      
  private void initComposant(){
    //On définit la police d'écriture à utiliser
    Font police = new Font("Arial", Font.BOLD, 20);
    ecran = new JLabel("0");
    ecran.setFont(police);
    //On aligne les informations à droite dans le JLabel
    ecran.setHorizontalAlignment(JLabel.RIGHT);
    ecran.setPreferredSize(new Dimension(220, 20));
    JPanel operateur = new JPanel();      
    operateur.setPreferredSize(new Dimension(70, 225));
    JPanel chiffre = new JPanel();
    chiffre.setPreferredSize(new Dimension(165, 225));
    JPanel panEcran = new JPanel();
    panEcran.setPreferredSize(new Dimension(220, 30));
    operateur .setBackground(Color.BLUE);
    panEcran .setBackground(Color.white);
    chiffre .setBackground(Color.yellow);
    container.setBackground(Color.DARK_GRAY);

    //On parcourt le tableau initialisé
    //afin de créer nos boutons
    for(int i = 0; i < tab_string.length; i++){
      tab_button[i] = new JButton(tab_string[i]);
      tab_button[i].setPreferredSize(dim);
      switch(i){
        //Pour chaque élément situé à la fin du tableau
        //et qui n'est pas un chiffre
        //on définit le comportement à avoir grâce à un listener
        case 11 :
          tab_button[i].setForeground(Color.red);
          tab_button[i].addActionListener(new EgalListener());
          chiffre.add(tab_button[i]);
          break;
        case 12 :
          tab_button[i].setForeground(Color.red);
          tab_button[i].addActionListener(new ResetListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        case 13 :
          tab_button[i].addActionListener(new CosListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        case 14 :
          tab_button[i].addActionListener(new SinListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;	
        case 15 :	
          tab_button[i].addActionListener(new LogListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        case 16 :
          tab_button[i].addActionListener(new ExpListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
          
        default :
          //Par défaut, ce sont les premiers éléments du tableau
          //donc des chiffres, on affecte alors le bon listener
          chiffre.add(tab_button[i]);
          tab_button[i].addActionListener(new ChiffreListener());
          break;
      }
    }
    panEcran.add(ecran);
    panEcran.setBorder(BorderFactory.createLineBorder(Color.red));
    container.add(panEcran, BorderLayout.EAST);
    container.add(chiffre, BorderLayout.EAST);
    container.add(operateur, BorderLayout.CENTER);
  }

  //Méthode permettant d'effectuer un calcul selon l'opérateur sélectionné
  private void calcul(){
    if(operateur.equals("Cos")){
      cos = new Cos (chiffre);
      ecran.setText(String.valueOf(cos.calcul()));
    }
    if(operateur.equals("Sin")){
     // chiffre = Double.valueOf(ecran.getText()).doubleValue();
      sin = new Sin (chiffre);
      ecran.setText(String.valueOf(sin.calcul()));
    }          
    if(operateur.equals("Log")){
      //chiffre = Double.valueOf(ecran.getText()).doubleValue();
      log = new Log (chiffre);
      ecran.setText(String.valueOf(log.calcul()));
    }     
    if(operateur.equals("Exp")){	     
      //  chiffre = Double.valueOf(ecran.getText()).doubleValue();
        exp = new Exp (chiffre);
        ecran.setText(String.valueOf(exp.calcul()));	      
      }
    }
  

  //Listener utilisé pour les chiffres
  //Permet de stocker les chiffres et de les afficher
  class ChiffreListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      //On affiche le chiffre additionnel dans le label
      String str = ((JButton)e.getSource()).getText();
      if(update){
        update = false;
      }
      else{
        if(!ecran.getText().equals("0"))
          str = ecran.getText() + str;
      }
      ecran.setText(str);
    }
  }

  //Listener affecté au bouton =
  class EgalListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      calcul();
      update = true;
      clicOperateur = false;
    }
  }

  //Listener affecté au bouton Cos
  class CosListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre));
      }
      else{
        chiffre = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "Cos";
      update = true;
    }
  }

  //Listener affecté au bouton Sin
  class SinListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre));
      }
      else{
        chiffre = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "Sin";
      update = true;
    }
  }

  //Listener affecté au bouton Log
  class LogListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre));
      }
      else{
        chiffre = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "Log";
      update = true;
    }
  }

  //Listener affecté au bouton Exp
  class ExpListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre));
      }
      else{
        chiffre = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "Exp";
      update = true;
    }
  }

  //Listener affecté au bouton de remise à zéro
  class ResetListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      clicOperateur = false;
      update = true;
      chiffre = 0;
      operateur = "";
      ecran.setText("");
    }
  }     
}




