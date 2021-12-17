#include <bits/stdc++.h>

#define LL long long

LL mod_exp(LL b, LL n, LL m) {

    LL result = 1;
    do {
        if(n & 1) result = (result * b) % m;
        b *= b;
    } while((n >>= 1) > 0);
    return result;
}

int main()
{
    LL b, n, m;
    std::cout << "Enter the (Base, Power, Mod) numbers: ";
    std::cin >> b >> n >> m;
    std::cout << "The res: " << mod_exp(b, n, m) << "\n";
    return 0;
}
