/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author K
 */
public class DEAmitFileInput {

    private ArrayList<String> zustaende;
    private ArrayList<String> alphabet;
    private String[][] delta;
    private String q0;
    private ArrayList<String> endzustaende;
    String aktuellerZustand;

    public DEAmitFileInput() {
    }

    public DEAmitFileInput(String filename) {

    }

    /**
     * Open and read a file, and return the lines in the file as a list of
     * Strings. (Demonstrates Java FileReader, BufferedReader, and Java5.)
     */
    private ArrayList<String> readFile(String filename) {
        ArrayList<String> records = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            //System.out.println(Arrays.toString(records.toArray()));

            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

    public boolean wortAbarbeiten(String wort) {
        return false;
    }

    public void zustandWechseln(char c) {

    }

    public static void main(String args[]) {
        /*DEAmitFileInput d = new DEAmitFileInput();
        ArrayList<String> Ergebnis = d.BananaSplit("Sigma = [a,b]");
        for(int i = 0;i<Ergebnis.size();i++){
            System.out.println(Ergebnis.get(i));
            
            
            
            
        }*/
        DEAmitFileInput d = new DEAmitFileInput();
        ArrayList<String> DateiInArray = d.readFile("TEstDEA.txt");
        d.MethodenWählen(DateiInArray);
        
        
        
        
        
        
        
        
        
    }

    /**
     * Diese Funktion kann die Parameter Q,Sigma und F einlesen und in einer
     * ArrayList zurückgeben.
     *
     *
     *
     * @param Zeile
     * @return
     */
    public ArrayList BananaSplit(String Zeile) {
        String[] gesplitted = Zeile.split("\\[");
        String[] finalSplit = gesplitted[1].split("\\]");
        String[] superfinalSplit = finalSplit[0].split("\\,");
        return new ArrayList<>(Arrays.asList(superfinalSplit));

    }
    /**
     * Die Methode geht die übergebene ArrayList durch und führt für jede
     * Zeile die korrekte Funktion aus.
     * 
     * 
     * 
     * @param list 
     */
    
    
    

    public void MethodenWählen(ArrayList list) {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:BananaSplit(""+list.get(0));
                    break;
                case 1:BananaSplit(""+list.get(1));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:BananaSplit(""+list.get(4));
                    break;
                default:break;
            }

        }

    }

}
