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
import java.util.Hashtable;

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
    private String aktuellerZustand;

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
     * Die Methode geht die übergebene ArrayList durch und führt für jede Zeile
     * die korrekte Funktion aus.
     *
     *
     *
     * @param list
     */
    public void MethodenWählen(ArrayList list) {
        for (int i = 0; i <= 4; i++) {
            switch (i) {
                case 0:
                    this.setZustaende(BananaSplit("" + list.get(0)));
                    break;
                case 1:
                    this.setAlphabet(BananaSplit("" + list.get(1)));
                    break;
                case 2://Delta-Methode
                    break;
                case 3:
                    this.setQ0(this.StartZustandDefenieren("" + list.get(3)));
                    break;
                case 4:
                    this.endzustaende = BananaSplit("" + list.get(4));
                    break;
                default:
                    break;
            }

        }

    }

    /**
     * @return the zustaende
     */
    public ArrayList<String> getZustaende() {
        return zustaende;
    }

    /**
     * @param zustaende the zustaende to set
     */
    public void setZustaende(ArrayList<String> zustaende) {
        this.zustaende = zustaende;
    }

    /**
     * @return the alphabet
     */
    public ArrayList<String> getAlphabet() {
        return alphabet;
    }

    /**
     * @param alphabet the alphabet to set
     */
    public void setAlphabet(ArrayList<String> alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * @return the delta
     */
    public String[][] getDelta() {
        return delta;
    }

    /**
     * @param delta the delta to set
     */
    public void setDelta(String[][] delta) {
        this.delta = delta;
    }

    /**
     * @return the q0
     */
    public String getQ0() {
        return q0;
    }

    /**
     * @param q0 the q0 to set
     */
    public void setQ0(String q0) {
        this.q0 = q0;
    }

    /**
     * @return the endzustaende
     */
    public ArrayList<String> getEndzustaende() {
        return endzustaende;
    }

    /**
     * @param endzustaende the endzustaende to set
     */
    public void setEndzustaende(ArrayList<String> endzustaende) {
        this.endzustaende = endzustaende;
    }

    /**
     * @return the aktuellerZustand
     */
    public String getAktuellerZustand() {
        return aktuellerZustand;
    }

    /**
     * @param aktuellerZustand the aktuellerZustand to set
     */
    public void setAktuellerZustand(String aktuellerZustand) {
        this.aktuellerZustand = aktuellerZustand;
    }

    /**
     *
     * Ließt eine Zeile und gibt dann den Startzustand zurück.
     *
     * @param zeile
     * @return
     */
    public String StartZustandDefenieren(String zeile) {
        String[] Split = zeile.split("= ");
        return Split[1];

    }

    public void ObjektToString() {

        System.out.println("Zustaende:");
        ArrayList<String> List = this.getZustaende();
        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i));
        }

        System.out.println("Sigma:");
        List = this.getAlphabet();
        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i));
        }

        //Delta fehlt(Datentyp unklar).
        System.out.println("Q0:" + this.getQ0());

        System.out.println("Endzustände:");
        List = this.getEndzustaende();
        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i));
        }

    }

    /**
     * Diese Methode... Sie nimmt die Delta-Zeile entgegen und gibt eine
     * ArrayList mit Hashtables zurück. In der ArrayList symbolisiert jeder
     * index einen Zustand(i:0 -> q1] .die Hashtable gibt nun an was passieren
     * soll wenn bestimmte Keys (Transitionen) auf Grundlage der erlaubten
     * Buchstaben des Aplhabets) eingegeben werden.
     * -ACHTUNG-ATTENTION-ATTENTION-ATTENZIONE DIESE METHODE DARF ERST
     * AUSGEFÜHRT WERDEN WENN DIE ZUSTEANDE BEREITS DEFENIERT SIND!
     *
     *
     *
     *
     *
     * @param zeile
     * @return
     */

    public ArrayList<Hashtable> DeltaDefenieren(String zeile) {
        try {
            ArrayList<String> zustaende = this.getZustaende();
            ArrayList<Hashtable> allehashtable = new ArrayList<Hashtable>();
            //Für jeden Zustand wird eine neue Hashtable angelegt.
            for (String zustand : zustaende) {
                allehashtable.add(new Hashtable<String, Integer>());
            }

            String[] gesplitted = zeile.split("\\[");
            gesplitted = gesplitted[1].split("\\]");
            gesplitted = gesplitted[0].split("\\;");
            for (String transition : gesplitted) {
                String[] stringsplit = transition.split("->");
                String[] klammersplit = stringsplit[0].split("\\(");
                klammersplit = klammersplit[1].split("\\)");
                klammersplit = klammersplit[0].split("\\,");

                for (int i = 0; i < zustaende.size(); i++) {
                    if (zustaende.get(i).equalsIgnoreCase(klammersplit[0])) {

                        System.out.println("stringsplit" + Arrays.toString(stringsplit));//Just Debugging
                        System.out.println("klammersplit:" + Arrays.toString(klammersplit));//Just Debugging
                        allehashtable.get(i).put(klammersplit[1], stringsplit[1]);

                    }

                }

            }

            return allehashtable;
        } catch (Exception e) {
            System.out.println("\u001B[31mDie Methode DeltaDefenieren benötigt die "
                    + "Zustände des DEA.Bitte erst BananaSplit auf die Zustände "
                    + "anwenden");

            return null;
        }

    }

    public static void main(String args[]) {
        /*DEAmitFileInput d = new DEAmitFileInput();
        ArrayList<String> Ergebnis = d.BananaSplit("Sigma = [a,b]");
        for(int i = 0;i<Ergebnis.size();i++){
            System.out.println(Ergebnis.get(i));
            
            
            
            
        }*/
        DEAmitFileInput d = new DEAmitFileInput();
        ArrayList<String> DateiInArray = d.readFile("TestDEA.txt");
        d.MethodenWählen(DateiInArray);
        System.out.println(d.DeltaDefenieren(DateiInArray.get(2)));

    }

}
