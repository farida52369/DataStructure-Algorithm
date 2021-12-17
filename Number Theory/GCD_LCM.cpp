
#include <bits/stdc++.h>

/*
 * GCD -- Greatest Common Divisor
 * LARGEST INTEGER WHICH CAN PERFECTLY DIVIDE TWO INTEGERS
 * LCM -- Least Common Multiple
 * THE SMALLEST NUMBER WHICH CAN BE DIVIDED BY BOTH NUMBERS
 */

/*
 * APPLING EUCLIDEAN ALGORITHM USING RECURSION
 * A SHOULD BE GREATER THAN b IN THE FIRST CALL AND IT WILL REMAIN THAT WAY
 * A AND b COULD BE POSITIVE OR NEGATIVE
 */
int GCD(int a, int b) { return (b == 0) ? a : GCD(b, a % b); }

/*
 * FOR TWO NUMBERS A AND B
 * A * B = GCD(A, B) * LCM(A, B)
 * LCM(A, B) = (A * B) / GCD(A, B)
 */
int LCM(int a, int b) { return (a * b) / GCD(a, b); }

// APPLING EUCLIDEAN ALGORITHM USING LOOPS
int GCD2(int a, int b) {
  while (b != 0) {
    int temp = b;
    b = a % b;
    a = temp;
  }
  return a;
}

int main() {
  int a, b;
  std::cin >> a >> b;

  std::cout << "GCD: " << GCD(a, b) << "\n";
  std::cout << "LCM: " << LCM(a, b) << "\n";
}

// The End :)))
