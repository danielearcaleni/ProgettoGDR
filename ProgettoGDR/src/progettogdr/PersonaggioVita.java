/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import javax.swing.*;
/**
 *
 * @author compu
 */
public class PersonaggioVita extends Personaggio{
    private JTextArea txtArea;
    
    public PersonaggioVita(String nome, int fame, int sete, int salute){
        super(nome, fame, sete, salute);
    }
    
    public void abilitaSpeciale(){
        this.aumentaVita(30);
        this.bevi(-10);
        txtArea.append("--------ABILITA SPECIALE USATA--------\n");
        txtArea.append("Ti sei curato ma hai perso 10 di Sete\n");
    }
}
