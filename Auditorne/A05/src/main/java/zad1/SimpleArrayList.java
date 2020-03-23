package zad1;

/**
 * Implementirajte listu koje se interno oslanja na polja kao strukturu
 * podataka. Inicijalizirajte interno polje na veličinu 2 te poduplajte
 * kapacitet ako u listi nestane prostora. Iz liste je moguće dobiti indeks
 * traženog objekta. Objekte je moguće dohvaćati po indeksu.
 */
public class SimpleArrayList {

    private Object[] elementData;
    private int size;

    public SimpleArrayList() {
        elementData = new Object[2];
        size = 0; // Was not necessary
    }

    // Appends the specified element to the end of this list.
    public boolean add(Object o) {
        ensureCapacity(size + 1);
        elementData[size++] = o;
        return true;
    }

    // Removes the last element of the list
    public boolean removeLastElement() {
        for (int i = 0; i < size - 1; i++) {
            elementData[i + 1] = null;
        }
        return true;
    }

    // Returns the number of elements in this list.
    public int size() {
        return size;
    }

    // Returns the element at the specified position in this list.
    public Object get(int index) {
        Object found = null;

        if (index < size) {
            found = elementData[index];
        }
        return found;
    }

    // Returns the index of the first occurrence of the specified element in this
    // list, or -1 if this list does not contain the element.
    public int indexOf(Object o) {
        int found = -1;

        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                found = i;
                break;
            }
        }
        return found;
    }

    // Increases the capacity of this SimpleArrayList instance, if
    // necessary, to ensure that it can hold at least the number of elements
    // specified by the minimum capacity argument.
    public void ensureCapacity(int minCapacity) {
        int current = elementData.length;

        if (minCapacity > current) {
            // Ensure some extra space so as not to copy too many times
            Object[] newData = new Object[Math.max(current * 2, minCapacity)];
            System.arraycopy(elementData, 0, newData, 0, size);
            elementData = newData;
        }
    }

}
