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
public class PersonaggioVita extends Personaggio{
    
    public PersonaggioVita(String nome, int fame, int sete, int salute) {
        super(nome, fame, sete, salute);
    }
    
    @Override
    public void abilitaSpeciale(JLabel lblCibo, JLabel lblAcqua, JLabel lblInventarioCorrente, JTextArea txtArea, Inventario inventario){
        this.aumentaVita(40);
        this.bevi(-20);
        
        txtArea.append("--------ABILITA SPECIALE USATA--------\n");
        txtArea.append("Hai ottenuto 40 di vita ma hai perso 20 di SETE\n");
    }
}
