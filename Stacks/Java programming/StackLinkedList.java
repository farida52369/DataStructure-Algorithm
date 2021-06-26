package fareeda.ragab;

import java.util.EmptyStackException;
import java.util.Scanner;

public class StackLinkedList implements StackInterface{

    Node top;
    int size;

    static class Node
    {
        Object data;
        Node next;

        Node(Object element)
        {
            this.data = element;
            this.next = null;
        }
    }

    StackLinkedList()
    {
        size = 0;
        top = null;
    }

    public void push(Object element) throws StackOverflowError
    {
        if (isFull())
            throw new StackOverflowError();
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size ++;
    }

    public Object pop() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        Object item = top.data;
        if (size == 1)
            top = null;
        else
            top = top.next;
        size --;
        return item;
    }

    public boolean isEmpty()
    {
        return (top == null);
    }

    public boolean isFull()
    {
        return false;
    }

    public int size()
    {
        return (size);
    }

    public Object peek() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        return (top.data);
    }

    public void Display(Object element)
    {
        System.out.print(element + " ");
    }

    public void traverse()
    {
        for (Node newNode = top; newNode != null; newNode = newNode.next)
            Display(newNode.data);
        System.out.println();
    }

    /**
    // I'M NOT SURE IF THIS METHOD DEALLOCATE ALL THE NODES OR NOT
    public void clear()
    {
        top = null;
    }
    **/

    public void clear()
    {
        Node newNode = top;
        while (newNode != null)
        {
            newNode = newNode.next;
            top = null;
            top = newNode;
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String sin = input.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");

        StackLinkedList obj = new StackLinkedList();
        if (s.length >= 1 && !(s[0].isEmpty()))
        {
            for(String i: s)
                obj.push(Integer.parseInt(i));
        }

        // The Option --
        String option = input.nextLine();
        while (!(option.equals("\n") || option.equals("")))
        {
            switch (option)
            {
                case "push":
                    int value = input.nextInt();
                    try {
                        obj.push(value);
                        obj.traverse();
                    }
                    catch (StackOverflowError e)
                    {
                        System.out.println("Error");
                    }
                    input.nextLine();
                    break;

                case "pop":
                    try {
                        Object e = obj.pop();
                        obj.Display(e);
                        System.out.println();
                    }
                    catch (EmptyStackException e)
                    {
                        System.out.println("Error");
                    }
                    break;

                case "peek":
                    try {
                        value = (Integer) obj.peek();
                        System.out.println(value);
                    }
                    catch (EmptyStackException e)
                    {
                        System.out.println("Error");
                    }
                    break;

                case "isEmpty":
                    if (obj.isEmpty())
                        System.out.println("True");
                    else
                        System.out.println("False");
                    break;


                case "size":
                    System.out.println(obj.size());
                    break;

                case "isFull":
                    if (obj.isFull())
                        System.out.println("True");
                    else
                        System.out.println("False");
                    break;
                case "clear":
                    obj.clear();
                    break;

                default:
                    System.out.println("Error");
                    break;
            }

            option = input.nextLine();
        }
    }
}
