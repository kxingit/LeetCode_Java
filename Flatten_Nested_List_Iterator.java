/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.
*/
public class NestedIterator implements Iterator<Integer> {
    // 2:53 - 3:09
    Stack<NestedInteger> stack = new Stack<>();
 
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
 
    @Override
    public Integer next() {
        NestedInteger t = stack.pop();
        return t.getInteger();
    }
 
    @Override
    public boolean hasNext() {
        while(stack.size() > 0) {
            NestedInteger t = stack.peek(); // don't pop yet
            if(t.isInteger()) return true;
            stack.pop();
            for(int i = t.getList().size() - 1; i >= 0; i--) {
                stack.push(t.getList().get(i));
            }
        }
        return false;
    }
}


