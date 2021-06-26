
/***********************************************************
************** ARRAY BASED IMPLEMENTATION ******************
************************************************************/

import java.util.EmptyStackException;
import java.util.Scanner;

public class StackArrayBased implements StackInterface {
    int maxSize;
    Object[] stackArray;
    int top;

    StackArrayBased(int maxSize)
    {
       this.maxSize = maxSize;
       this.top = 0;
       stackArray = new Object[maxSize];
    }

    public void push(Object element) throws StackOverflowError
    {
        if (isFull())
            throw new StackOverflowError();
        stackArray[top] = element;
        top ++;
    }

    public Object pop() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        return stackArray[top--];
    }

    public boolean isEmpty()
    {
        return (top == 0);
    }

    public boolean isFull()
    {
        return (top == maxSize);
    }

    public int size()
    {
        return (top);
    }

    public Object peek() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        return (stackArray[top - 1]);
    }

    public void Display(Object element)
    {
        System.out.print(element + " ");
    }

    public void traverse()
    {
        for (int i = 0; i < top; i++)
            Display(stackArray[i]);
        System.out.println();
    }

    public void clear()
    {
        top = 0;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String sin = input.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");

        StackArrayBased obj = new StackArrayBased(100);
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
