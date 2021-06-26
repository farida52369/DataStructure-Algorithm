

/***********************************************************
*************** STACK INTERFACE ****************************
************************************************************/

import java.util.EmptyStackException;

public interface StackInterface {
    void push(Object element) throws StackOverflowError;
    Object pop() throws EmptyStackException;
    boolean isEmpty();
    boolean isFull();
    int size();
    Object peek() throws EmptyStackException;
    void Display(Object element);
    void traverse();
    void clear();

}

