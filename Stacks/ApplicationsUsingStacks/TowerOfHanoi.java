
/*
************************** Tower Of Hanoi **********************

A PROBLEM WITH HISTORICAL BACKGROUND ABOUT PRAYER IN INDIA CLAIMED HE SAW A PROPHET THAT THE DAY WILL BE WHEN THEY COULD SOLVE THE TOWER OF 64!!

The Tower of Hanoi is a mathematical game or puzzle. 
It consists of three rods and a number of disks of different diameters, which can slide onto any rod. 

THE RULES:
Only one disk may be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or an empty rod.
No disk may be placed on top of a disk that is smaller than it..

Space Complexity: The height of the binary tree = N
Time Complexity: 2^N - 1 = O(2^N)

*/

import java.util.Scanner;

public class TowerOfHanoi {

    // If you want to make Sure how many recursion happens
    // num = 2^N - 1
    static int num = 0;
    public void towerOfHanoi(int n, char from, char to, char temp)
    {
        num += 1;
        if (n == 1)
        {
            System.out.println("Disk " + n + " From " + from + " To " + to);
            return;
        }
        towerOfHanoi(n - 1, from, temp, to);
        System.out.println("Disk " + n + " From " + from + " To " + to);
        towerOfHanoi(n - 1, temp, to, from);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Num of Disks: ");
        int n = input.nextInt();

        TowerOfHanoi obj = new TowerOfHanoi();
        obj.towerOfHanoi(n, 'A', 'C', 'B');
        System.out.println("Num Of recursions happen: " + num);
    }
}
