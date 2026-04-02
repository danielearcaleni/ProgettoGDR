/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author arcaleni.daniele2
 */
public class Inventario {
    private ArrayList<String> inventario;
    
    public Inventario(){
        inventario = new ArrayList<>();
    }
    
    public ArrayList<String> getInventario(){
        return inventario;
    }
    
    public void aggiungiOggetto(String oggetto){
        if(inventario.size() < 10){
            inventario.add(oggetto);
        }
        else{
            JOptionPane.showMessageDialog(null, "Inventaro pieno!! Non puoi raccogliere altri oggetti");
        }
    }
    public int interaLista(){
        return inventario.size();
    }
}
