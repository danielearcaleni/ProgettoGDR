/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import java.io.Serializable;
/**
 *
 * @author compu
 */
public class DatiSalvataggio implements Serializable {

    private Personaggio playerSalvato;
    private Inventario inventarioSalvato;

    public DatiSalvataggio(Personaggio playerSalvato, Inventario inventarioSalvato){
        this.playerSalvato = playerSalvato;
        this.inventarioSalvato = inventarioSalvato;
    }
}
