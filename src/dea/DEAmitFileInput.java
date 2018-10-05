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
    private ArrayList<Hashtable> delta;
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

    /**
     *
     * Methode funktioneirt nur mit einzelnen Zeichen als erlaubte Eingabewerte.
     *
     * @param wort
     * @return
     */
    public boolean wortAbarbeiten(String wort) {
        this.aktuellerZustand = this.q0;

        for (int i = 0; i < wort.toCharArray().length; i++) {
            char c = wort.toCharArray()[i];
            //Wenn Buchstabe nicht im Alphabet vorkommt
            if (!this.getAlphabet().contains((Character.toString(c)))) {
                System.out.println("\u001B[31m Dieses Zeichen kommt nicht im Alphabet vor.Wort gehört nicht zur Sprache");
                return false;
            }
            char t = this.aktuellerZustand.charAt(1);
            int zustandsindex = Integer.parseInt(Character.toString(t)) - 1;
            System.out.println("Zustandsindex:" + zustandsindex);
            try {
                if (this.delta.get(zustandsindex).get(Character.toString(c)) != null) {
                    //Wenn letzter Buchstabe erreicht.
                    //FEHLER
                    if (i == wort.toCharArray().length - 1) {

                        if (this.endzustaende.contains(this.aktuellerZustand)) {
                            System.out.println("\u001B[32mWort gehört zur Sprache!");
                            return true;

                        } else {
                            System.out.println("\u001B[31mWort gehört nicht zur Sprache!");
                            
                            return false;

                        }

                    }

                    //System.out.println("String-Character:" + Character.toString(c));
                    //System.out.println("Transition:" + this.delta.get(zustandsindex).get(Character.toString(c)));
                    this.aktuellerZustand = (String) this.delta.get(zustandsindex).get(Character.toString(c));
                }

            } catch (Exception e) {
                System.out.println("\u001B[31m Wort gehört nicht zur Sprache");
                return true;

            }

        }

        return false;
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
                case 2:
                    this.setDelta(this.DeltaDefenieren("" + list.get(2)));
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
     * @return the delta
     */
    public ArrayList<Hashtable> getDelta() {
        return delta;
    }

    /**
     * @param delta the delta to set
     */
    public void setDelta(ArrayList<Hashtable> delta) {
        this.delta = delta;
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

        System.out.println("Delta:");
        ArrayList<Hashtable> ListDelta = this.getDelta();
        for (int i = 0; i < ListDelta.size(); i++) {
            System.out.println(ListDelta.get(i));
        }

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
     * Korrekte Syntax der Teile:delta = [(q1,a) ->q2;(q1,b)
     * ->q3;(q2,a)->q2;(q2,b)->q2;(q3,a)->q3;(q3,b)->q3]
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
        d.ObjektToString();

        d.wortAbarbeiten("ba");

    }

    /*
    Korrekte Sytnax der gelesenen Datei:
    Q = [q1,q2,q3]
    Sigma = [a,b]
    delta = [(q1,a) ->q2;(q1,b) ->q3;(q2,a)->q2;(q2,b)->q2;(q3,a)->q3;(q3,b)->q3]
    q0 = q1
    F = [q2]
    
    
    
    
    
    
    
    
     */
}
