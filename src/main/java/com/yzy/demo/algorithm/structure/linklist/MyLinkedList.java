package com.yzy.demo.algorithm.structure.linklist;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implements a simple double linked list
 *
 * @author yangzyh
 * @date 2022/8/31 14:16
 */
public class MyLinkedList<T> implements Iterable<T> {

    private int size;
    private int modCount;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public MyLinkedList() {
        doClear();
    }

    private int size() {
        return size;
    }

    public void clear() {
        doClear();
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public T get(int idx) {
        return getNode(idx).data;
    }

    /**
     * adds an item to this collection, at the end.
     *
     * @param item
     * @return
     */
    public boolean add(T item) {
        add(size(), item);
        return true;
    }

    /**
     * adds an item to this collection, at the specified position
     *
     * @param idx  postion to add it.
     * @param item
     */
    public void add(int idx, T item) {
        addBefore(getNode(idx, 0, size()), item);
    }

    /**
     * adds an item to this collection, before node.
     *
     * @param node
     * @param item
     */
    private void addBefore(Node<T> node, T item) {
        Node n = new Node<>(item, node.prev, node);
        n.prev.next = n;
        n.next.prev = n;
        modCount++;
        size++;
    }

    /**
     * changes item's data at position idx.
     *
     * @param idx
     * @param newVal
     * @return
     */
    public T set(int idx, T newVal) {
        Node<T> item = getNode(idx);
        T oldVal = item.data;
        item.data = newVal;
        return oldVal;
    }

    /**
     * removes item from this collection, at position idx
     *
     * @param idx
     * @return
     */
    public T remove(int idx) {
        return remove(getNode(idx));
    }

    /**
     * removes the object contained in Node p
     *
     * @param p
     * @return
     */
    private T remove(Node<T> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        modCount++;

        return p.data;
    }

    //@Override
    //public String toString() {
    //    StringBuilder builder = new StringBuilder("[ ");
    //    Node<T> p = beginMarker;
    //    while (p != endMarker) {
    //        p = p.next;
    //        builder.append(p.data).append(", ");
    //    }
    //    builder.append("]");
    //
    //    return builder.toString();
    //}

    /**
     * Returns a String representation of this collection.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        // don't understand, how can x means node.data?
        for (T x : this)
            sb.append(x + " ");
        sb.append("]");

        return new String(sb);
    }

    /**
     * gets node at position idx, which must range from 0 to size() - 1
     *
     * @param idx
     * @return
     */
    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * gets the node at position idx, which must range from lower to upper.
     *
     * @param idx
     * @param i
     * @param size
     * @return
     */
    private Node<T> getNode(int idx, int lower, int upper) {
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException("idx out of Range!");
        }
        Node<T> p;
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }


    private void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        size = 0;
        // why count 1 not 2(begin, end)?
        modCount++;
    }


    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            okToRemove = true;
            return data;
        }

        /**
         * I guess this method could only be invoked after next(),
         * cause only next() set 'okToRemove' to true, then remove() can remove item
         */
        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> lst = new MyLinkedList<>();

        for (int i = 0; i < 10; i++)
            lst.add(i);
        for (int i = 20; i < 30; i++)
            lst.add(0, i);

        lst.remove(0);
        lst.remove(lst.size() - 1);

        System.out.println(lst);

        java.util.Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            itr.next();
            itr.remove();
            System.out.println(lst);
        }
    }
}
