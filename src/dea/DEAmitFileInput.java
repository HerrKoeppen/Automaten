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
    
    public boolean wortAbarbeiten(String wort){
        return false;
    }
    public void zustandWechseln(char c){
        
    }

    public static void main(String args[]) {
        
    }
}
