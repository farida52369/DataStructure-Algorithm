/* 
 * EXTENDED EUCLIDEAN ALGORITHM FINDS INTEGER CPEFFICIENTS X AND Y SUCH THAT: 
 *  ax + by = gcd(a, b) 
 */
 
#include <bits/stdc++.h>

int gcdExtended(int a, int b, int *x, int *y) {
    // BASE CASE WHEN A REACHES ZERO VALUE
    if (a == 0) {
        *x = 0, *y = 1;
        return b;
    }

    int temp_x, temp_y;
    int gcd = gcdExtended(b%a, a, &temp_x, &temp_y);

    // UPDATE X, Y DEPENDING ON RECURSION CALLS
    *x = temp_y - (b/a) * temp_x;
    *y = temp_x;

    return gcd;
}


int main() 
{
    int x, y, a, b;
    std::cout << "The value of a, b: ";
    std::cin >> a >> b;
    // THE ADDRESS OF X, Y ARE PROVIDED
    int g = gcdExtended(a, b, &x, &y);
    std::cout << "GCD(" << a << ", " << b << ") = " << g << '\n';
    std::cout << "AS GCD(a, b) = as + bt, Then s = " << x << ", t = " << y << '\n';
    return 0;
}
