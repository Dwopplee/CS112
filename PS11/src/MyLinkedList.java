import java.util.AbstractList;
import java.util.Collections;
import java.util.Random;

public class MyLinkedList<E extends Comparable<E>> extends AbstractList<E> {

    private Node<E> first, last;

    public void shuffle(long seed) {
        Random rng = new Random(seed);

        Node<E> ref = first;
        for(int i = 0; ref != null; i++) {
            int rnum = rng.nextInt(size());
            E temp = get(i);

            set(i, get(rnum));
            set(rnum, temp);

            ref = ref.getNext();
        }
    }

    public void sort() {
        QuickSort.quickSort(this);
    }

    public void reverse() {
        for (int i = 0; i < size() / 2; i++) {
            Collections.swap(this, i, size() - 1 - i);
        }
    }

    public E removeMinimum() {
        if (isEmpty()) {
            return null;
        }

        int minIndex = 0;

        for (int i = 1; i < size(); i++) {
            if (get(minIndex).compareTo(get(i)) > 0) {
                minIndex = i;
            }
        }

        return remove(minIndex);
    }

    public void removeDuplicates() {
        Node<E> ref = first;
        int index = 0;
        while (ref != null) {
            for (int i = 0; i < index; i++) {
                if (get(i).equals(ref.getValue())) {
                    remove(index);
                    index--;
                    break;
                }
            }

            index++;
            ref = ref.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public E get (int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Out of bounds: " + i);
        }

        Node<E> ref = first;
        for (int j = 0; j < i; j++) {
            ref = ref.getNext();
        }

        return ref.getValue();
    }

    @Override
    public int size() {
        Node<E> ref = first;
        int count = 0;

        while (ref != null) {
            count ++;
            ref = ref.getNext();
        }

        return count;
    }

    @Override
    public boolean add (E e) {
        if (isEmpty()) {
            first = new Node<E> (e);
            last = first;
        } else {
            last.setNext(new Node<E> (e));
            last = last.getNext();
        }

        return true;
    }

    @Override
    public void add (int i, E e) {
        if (i < 0 || i > size()) {
            throw new IndexOutOfBoundsException("Out of bounds: " + i);
        }

        if (i == size()) {
            add(e);
            return;
        }

        if (i == 0) {
            first = new Node<E> (e, first);
            return;
        }

        Node<E> ref = first;
        for (int j = 0; j < i - 1; j++) {
            ref = ref.getNext();
        }
        ref.setNext(new Node<E> (e, ref.getNext()));
    }

    @Override
    public E remove (int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Out of bounds: " + i);
        }

        E removed;

        if (i == 0) {
            removed = first.getValue();
            first = first.getNext();

            return removed;
        }

        Node<E> ref = first;
        for (int j = 0; j < i - 1; j++) {
            ref = ref.getNext();
        }

        removed = ref.getNext().getValue();
        ref.setNext(ref.getNext().getNext());

        return removed;
    }

    @Override
    public E set (int i, E e) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Out of bounds: " + i);
        }

        Node<E> ref = first;
        for (int j = 0; j < i; j++) {
            ref = ref.getNext();
        }

        E replaced = ref.getValue();
        ref.setValue(e);

        return replaced;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        } else {
            return super.toString();
        }
    }

}
