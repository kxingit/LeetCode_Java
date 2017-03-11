/*
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    // 5:41 - 5:54
    List<Integer> peeked;
    Iterator<Integer> iterator;
 
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        peeked = new ArrayList();
        this.iterator = iterator;
    }
 
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peeked.size() == 0) {
            int pk = this.next();
            peeked.add(pk);
        }
        return peeked.get(0);
    }
 
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peeked.size() > 0) {
            int res = peeked.get(0);
            peeked.remove(peeked.size() - 1);
            return res;
        } else {
            return iterator.next();
        }
    }
 
    @Override
    public boolean hasNext() {
        return iterator.hasNext() || peeked.size() > 0;
    }
}

// v2
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator it;
    Integer peeked;
 
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        peeked = null;
    }
 
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peeked == null) {
            peeked = (Integer)it.next();
        }
        return peeked;
    }
 
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peeked == null) {
            peeked = (Integer)it.next();
        }
        int res = peeked;
        peeked = null;
        return res;
    }
 
    @Override
    public boolean hasNext() {
        return peeked != null || it.hasNext();
    }
}
