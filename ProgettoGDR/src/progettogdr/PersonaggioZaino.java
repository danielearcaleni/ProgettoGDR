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
    private JTextArea txtArea;
    private JLabel lblCibo;
    private JLabel lblAcqua;
    
    public PersonaggioZaino(String nome, int fame, int sete, int salute, JLabel lblCibo, JLabel lblAcqua){
        super(nome, fame, sete, salute);
        this.lblCibo = lblCibo;
        this.lblAcqua = lblAcqua;
    }
    
}
