/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettogdr;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author arcaleni.daniele2
 */
public class FileManager {

    private String filePath = "PrendiFrase.txt";
    ArrayList<String> frasi = new ArrayList<>();
    ArrayList<String> tipoNemico = new ArrayList<>();
    ArrayList<String> tipoOggetto = new ArrayList<>();
    private boolean nemico;
    
    public ArrayList<String> letturaFile(){
    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
        String line;
        String[] dati;
        while((line = reader.readLine()) != null){
                dati = line.split(";");
                frasi.add(dati[0]);
            }
        
            if (dati[1].equals("Nemico")) {
                nemico = true;
                tipoNemico.add(dati[0]);
            } else {
                nemico = false;
                tipoOggetto.add(dati[0]);
            }
        }
    catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }
        return frasi;
    }
    
    public boolean isEnemy(){
        return nemico;
    }
}
