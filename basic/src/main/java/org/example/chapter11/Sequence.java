package org.example.chapter11;


interface Selector {
    boolean end();

    Object current();

    void next();
}


public class Sequence {


    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selectorV1 = sequence.selector();
        while (!selectorV1.end()) {
            System.out.print(selectorV1.current() + " ");
            selectorV1.next();
        }
        Selector selectorV2 = sequence.selector();
        while (!selectorV2.end()) {
            System.out.print(selectorV2.current() + " ");
            selectorV2.next();
        }
    }
}
