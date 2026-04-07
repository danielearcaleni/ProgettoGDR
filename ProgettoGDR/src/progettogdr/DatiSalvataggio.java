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
    private static final long serialVersionUID = 1L;

    public Personaggio playerSalvato;
    public Inventario inventarioSalvato;
    public int giornoSalvato;
    public String immaginePersonaggio;
    public String ciboSalvato;
    public String acquaSalvato;
    public String inventarioCorrenteSalvato;
    public String InventarioMassimoSalvato;

    public DatiSalvataggio(Personaggio playerSalvato, Inventario inventarioSalvato, int giornoSalvato, String immaginePersonaggio, String ciboSalvato, String acquaSalvato, String inventarioCorrenteSalvato, String InventarioMassimoSalvato){
        this.playerSalvato = playerSalvato;
        this.inventarioSalvato = inventarioSalvato;
        this.giornoSalvato = giornoSalvato;
        this.immaginePersonaggio = immaginePersonaggio;
        this.ciboSalvato = ciboSalvato;
        this.acquaSalvato = acquaSalvato;
        this.inventarioCorrenteSalvato = inventarioCorrenteSalvato;
        this.InventarioMassimoSalvato = InventarioMassimoSalvato;
    }
}
