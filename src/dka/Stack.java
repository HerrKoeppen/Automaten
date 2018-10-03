package dka;

import java.util.ArrayList;

/**
 * Ein Stack oder Stapel ist eine abstrakte Datenstruktur, die Elemente
 * aufbewahrt. Ein Stack fügt neue Elemente immer ganz vorne ein. Wenn ein
 * Element zurückgeliefert wird, dann wird es ganz vorne entnommen. Dieses
 * Prinzip nennt sich LIFO (last in first out).
 *
 * Die zugrundeliegende Struktur kann unter anderem ein Array, eine Liste oder
 * eine ArrayList sein.
 *
 * Unser Stack soll diese Methoden zur Verfügung stellen: push: Fügt ein neues
 * Element vorne in den Stapel ein pop: Entfernt das vorderste Listenelement aus
 * der Datenstruktur und liefert es zurück top: Zeigt das vorderste Element an,
 * ohne es aus der Datenstruktur zu löschen isEmpty: Zeigt an, ob der Stapel
 * leer ist
 *
 * Der Stapel kennt zwei Attribute: Eine ArrayList stapel, die die Element
 * ablegt Eine Zahl indexVorderstesElement, welche der Index des vordersten
 * Eintrags ist
 *
 * @author K
 */
public class Stack {

    private ArrayList<String> stapel;
    private int indexVorderstesElement;

    public Stack() {

    }

    public static void main(String[] args) {

    }

    /**
     * Fügt das Element s in den Stapel ein
     *
     * @param s das einzufügende Element
     */
    public void push(String s) {
        ArrayList<String> nstapel = new ArrayList<String>();
        nstapel.add(s);
        for (String e : this.stapel) {
            nstapel.add(e);

        }
        this.stapel = nstapel;

    }

    /**
     * Entfernt das vorderste Element aus der Datenstruktur und gibt es zurück.
     *
     * @return ein String als vorderstes Element oder null, wenn es keine
     * Elemente im Stapel gibt
     */
    public String pop() {
        try {
            String s = this.stapel.get(indexVorderstesElement);
            this.stapel.set(indexVorderstesElement, null);
            this.indexVorderstesElement = this.indexVorderstesElement + 1;

            return s;
        } catch (Exception e) {
            System.out.println("\u001B[31mDie ArrayList ist zu Ende. Keine weiteren "
                    + "Objekte gefunden!(return: null)(Methode:pop)");

        }
        return null;
    }

    /**
     * Zeigt das vorderste Element aus der Datenstruktur an. Das Element wird
     * nicht entfern, es ist weiterhin das vorderste Element.
     *
     * @return ein String als vorderstes Element oder null, wenn es keine
     * Elemente im Stapel gibt
     */
    public String top() {
        try {
            return this.stapel.get(indexVorderstesElement);
        } catch (Exception e) {
            System.out.println("\u001B[31mDer index des vordersten Elements befindet sich"
                    + "nicht in der ArrayList!(return:null)(Methode:top)");

        }
        return null;
    }

    /**
     * Zeigt an, ob der Stapel leer ist.
     *
     * @return true, wenn der Stapel kein Element enthält, sonst false
     */
    public boolean isEmpty() {
        if (this.top() == null) {
            return true;

        }

        return false;
    }

}
