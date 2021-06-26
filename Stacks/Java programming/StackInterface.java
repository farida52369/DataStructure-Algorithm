

/***********************************************************
*************** STACK INTERFACE ****************************
************************************************************/

import java.util.EmptyStackException;

public interface StackInterface {
    public void push(Object element) throws StackOverflowError;
    public Object pop() throws EmptyStackException;
    public boolean isEmpty();
    public boolean isFull();
    public int size();
    public Object peek() throws EmptyStackException;
    public void Display(Object element);
    public void traverse();
    public void clear();

}
