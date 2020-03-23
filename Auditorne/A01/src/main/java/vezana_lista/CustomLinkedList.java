/*
- Razmotrit ćemo jednostavan primjer izgradnje jednostavne
vezane liste
- Treba podržati mogućnost dodavanja u listu i ispis liste
- Prikazano rješenje nije u duhu OOP-a; Javu ovdje koristimo za
proceduralno programiranje, 
    -"kao što smo programirali u C-u”
    - Varijable ne mora definirati na početku bloka, već prije samog korištenja
 */
package vezana_lista;

/**
 *
 * @author Matija
 */
public class CustomLinkedList {

    public static void main(String[] args) {
        Node head = null; // similar to Node *head = null in C/C++

        head = add(head, "Ana");
        head = add(head, "Ivana");
        head = add(head, "Jasna");
        printList(head);

        //delete list
        while (head != null) {
            Node temp = head;
            head = head.next;
            System.out.println("Removed element: " + temp.value);
        }
    }

    static Node add(Node head, String name) {
        if (head == null) {
            head = new Node();
            head.value = name;
            head.next = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node();
            temp.next.value = name;
            temp.next.next = null;
        }
        return head;
    }

    static void printList(Node head) {
        int pos = 1;
        while (head != null) {
            System.out.format("%d. %s%n", pos++, head.value);
            head = head.next;
        }

    }
}
