package zadatak;

/**
 *
 * @author Matija
 */
public class StringImena {

    private static boolean isEnd = false;

    public static void main(String[] args) {
        Node head = null; // similar to Node *head = null in C/C++

        while (isEnd) {
            head = add(head, "Matija");
            head = add(head, "Davorka");
            head = add(head, "Marin");
            head = add(head, "Margareta");
            head = add(head, "kraj");
            head = add(head, "Marko");

        }
        printList(head);

        //delete list
        while (head != null) {
            Node temp = head;
            head = head.next;
            System.out.println("Removed element: " + temp.value);
        }
    }

    static Node add(Node head, String name) {
        if ("kraj".equals(head.value.toLowerCase())) {
            isEnd = true;
        } else {
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
