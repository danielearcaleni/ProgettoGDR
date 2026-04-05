/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author compu
 */
public class PersonaggioOscuro extends Personaggio{
    
    public PersonaggioOscuro(String nome, int fame, int sete, int salute){
        super(nome, fame, sete, salute);
    }
    
    @Override
    public void abilitaSpeciale(JLabel lblCibo, JLabel lblAcqua, JLabel lblInventarioCorrente, JTextArea txtArea){
        this.diminuisciVita(10);
        
        lblCibo.setText("" + (Integer.parseInt(lblCibo.getText()) + 1));
        lblAcqua.setText("" + (Integer.parseInt(lblAcqua.getText()) + 1));
        lblInventarioCorrente.setText("" + (Integer.parseInt(lblInventarioCorrente.getText()) + 2));
        
        txtArea.append("--------ABILITA SPECIALE USATA--------\n");
        txtArea.append("Hai ottenuto uno di CIBO  e uno di ACQUA, ma hai perso 10 di vita\n");
    }
}
