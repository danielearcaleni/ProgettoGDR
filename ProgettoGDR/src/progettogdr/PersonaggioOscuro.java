/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;

import javax.swing.JTextArea;
import javax.swing.JLabel;

/**
 *
 * @author compu
 */
public class PersonaggioOscuro extends Personaggio{
    private JTextArea txtArea;
    private JLabel lblCibo;
    private JLabel lblAcqua;
    
    public PersonaggioOscuro(String nome, int fame, int sete, int salute, JLabel lblCibo, JLabel lblAcqua){
        super(nome, fame, sete, salute);
        this.lblCibo = lblCibo;
        this.lblAcqua = lblAcqua;
    }
    
    public void AbilitaSpeciale(){
        this.lblAcqua.setText("" + (Integer.parseInt(lblAcqua.getText()) + 1));
        this.lblCibo.setText("" + (Integer.parseInt(lblCibo.getText()) + 1));
        this.diminuisciVita(-10);
        txtArea.append("--------ABILITA SPECIALE USATA--------\n");
        txtArea.append("Hai raccolto 1 Cibo e 1 Acqua ma hai perso 10 di vita\n");
    }
}
