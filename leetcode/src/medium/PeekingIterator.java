package medium;

import java.util.Iterator;

/**
 * Created by cksharma on 9/25/15.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int currentValue = Integer.MIN_VALUE;
    boolean nextInPeek = false;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (nextInPeek == false) {
            currentValue = iterator.next();
            nextInPeek = true;
        }
        return currentValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (nextInPeek == true) {
            nextInPeek = false;
        } else {
            currentValue = iterator.next();
        }
        return currentValue;
    }

    @Override
    public boolean hasNext() {
        if (nextInPeek) return true;
        return iterator.hasNext();
    }
}
