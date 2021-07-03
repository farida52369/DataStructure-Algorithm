/******************** GCD -- Greatest Common Divisor ******************

the greatest common divisor (GCD) of two or more integers, which are not all zero, is the largest positive integer that divides each of the integers. 
For two integers x, y, the greatest common divisor of x and y is denoted gcd(x,y). 
For example, the GCD of 8 and 12 is 4, that is, gcd(8,12)=4

In MATH: it could be solved in an easy way using Euclidean Algorithm

Khan Academy has great resource to know more about the algorithm: 
https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm

*/

#include <stdio.h>
#include <stdlib.h>


// APPLING EUCLIDEAN ALGORITHM USING RECURSION
int GCD(int a, int b){
    if (b == 0)
        return a;
    return GCD(b, a % b);
}

// APPLING EUCLIDEAN ALGORITHM USING LOOPS
int GCD2(int a, int b)
{
    while(b != 0)
    {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}


int main()
{

   int a, b;
    scanf("%d %d", &a, &b);
    // CONDITIONS TO HANDLE THAT (a > b) ---> WHICH IS A CONDITION TO USE EUCLIDEAN ALGORITHM
    if(b >= 0)
    {
        if(a >= b){printf("%d", GCD(a, b));}
        else {a = a ^ b; b = b ^ a; a = a ^ b; printf("%d", GCD(a, b));}
    }
    else
    {
        b *= -1;
        if(a >= b){printf("%d", GCD(a, b));}
        else{a = a ^ b; b = b ^ a; a = a ^ b;  printf("%d", GCD(a, b));}
    }
   return 0;
}

// The end :"))
