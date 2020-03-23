package hr.fer.oop.lab4.zad2;

/**
 * Implementirajte listu koje se interno oslanja na polja kao strukturu
 * podataka. Inicijalizirajte interno polje na veličinu 2 te poduplajte
 * kapacitet ako u listi nestane prostora. Iz liste je moguće dobiti indeks
 * traženog objekta. Objekte je moguće dohvaćati po indeksu.
 */
public class SimpleArrayList<T> {

    private T[] elementData;
    int size;

    public SimpleArrayList() {
        elementData = (T[]) new Object[2];
        size = 0; // Was not necessary
    }

    // Appends the specified element to the end of this list.
    public boolean add(T t) {

        try {
            if (t == null) {
                throw new IllegalArgumentException("I don't want null in my list!");
            }

        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            System.out.println("Null not added to the list.");
            return false;

        } finally {
            if (t != null) {
                ensureCapacity(size + 1);
                elementData[size++] = t;
                System.out.println("Added " + t + " to the list.");

            }
        }
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
    public T get(int index) {
        T found = null;

        if (index < size) {
            found = elementData[index];
        }
        return found;
    }

    // Returns the index of the first occurrence of the specified element in this
    // list, or -1 if this list does not contain the element.
    public int indexOf(T t) {
        int found = -1;

        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(t)) {
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
            T[] newData = (T[]) new Object[Math.max(current * 2, minCapacity)];
            System.arraycopy(elementData, 0, newData, 0, size);
            elementData = newData;
        }
    }

}
