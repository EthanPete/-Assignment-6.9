import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TwoWayLinkedList<E> {
    private Node head, tail;
    private int size = 0; // Number of elements in the list

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(i, objects[i]);
        }
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        newNode.previous = null;

        if (head != null) {
            head.previous = newNode;
        }

        head = newNode;

        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        newNode.previous = tail;
        newNode.next = null;

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;

        if (head == null) {
            head = newNode;
        }

        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node current = getNodeAtIndex(index);

            Node newNode = new Node(e);
            newNode.next = current;
            newNode.previous = current.previous;

            current.previous.next = newNode;
            current.previous = newNode;

            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }

        E element = head.element;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }

        return element;
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }

        E element = tail.element;
        tail = tail.previous;
        size--;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        return element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node current = getNodeAtIndex(index);
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
            return current.element;
        }
    }

    // Implement the remaining methods...

    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return new LinkedListIterator(index);
    }

    private class Node {
        E element;
        Node next;
        Node previous;

        Node(E element) {
            this.element = element;
        }
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Node current;
        private int index;
        private boolean canRemove;

        LinkedListIterator() {
            current = head;
            index = 0;
            canRemove = false;
        }

        LinkedListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index);
            }
            current = getNodeAtIndex(index);
            this.index = index;
            canRemove = false;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            index++;
            canRemove = true;
            return element;
        }

        public boolean hasPrevious() {
            return current != null && current.previous != null;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = tail;
            } else {
                current = current.previous;
            }
            index--;
            canRemove = true;
            return current.element;
        }

        public int nextIndex() {
            return index;
        }

        public int previousIndex() {
            return index - 1;
        }

        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            if (current == head) {
                removeFirst();
            } else if (current == tail) {
                removeLast();
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
                index--;
            }
            canRemove = false;
        }

        public void set(E e) {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            current.element = e;
        }

        public void add(E e) {
            Node newNode = new Node(e);
            newNode.previous = current;
            newNode.next = current.next;
            current.next = newNode;

            if (newNode.next != null) {
                newNode.next.previous = newNode;
            } else {
                tail = newNode;
            }

            size++;
            index++;
            canRemove = false;
        }
    }
}