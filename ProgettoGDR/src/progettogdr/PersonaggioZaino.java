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
public class PersonaggioZaino extends Personaggio{
    
    public PersonaggioZaino(String nome, int fame, int sete, int salute){
        super(nome, fame, sete, salute);
    }
    
    @Override
    public void abilitaSpeciale(JLabel lblCibo, JLabel lblAcqua, JLabel lblInventarioCorrente, JTextArea txtArea){
        txtArea.append("--------ABILITA SPECIALE USATA--------\n");
        txtArea.append("Hai preso uno di CIBO  e uno di ACQUA, ma hai perso 10 di vita\n");
    }
}
