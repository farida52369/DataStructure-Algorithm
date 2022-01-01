#include <bits/stdc++.h>

#define LL long long int
#define vec std::vector<int>

/************** QUESTION 1
*** Implementation of sieve of Eratosthenes algorithm for finding all prime numbers up to any given limit.
*** INPUT: THE NUM N AS THE USER WANT PRIME NUMBERS TO IT
*** OUTPUT: ALL THE PRIME NUMBERS TO THE VALUE N
*/
void sieveOfEratosthenes(int n) {
    // ARRAY OF SIZE N+1 TO GET THE VALUES TO N
    bool prime_nums[n + 1];
    // INITAIALIZE TEH ARRAY OF PRIME NUMBERS TO TRUE
    memset(prime_nums, true, sizeof(prime_nums));

    // NESTED LOOP FIRST ITERATION FORM 2 TO SQARE ROOT OF N
    // IF THE PRIME NUMBERS[I] IS TRUE
    // THE SECOND ITERATION FROM I * I TO THE VALUE N INCREMENTED BY I EACH ITERATION
    // MAKE THE VALUES IN THE SECOND ITERATION FALSE
    for (int i = 2; i * i <= n; i++) {
        if (prime_nums[i] == true) {
            for (int j = i * i; j <= n; j += i)
                prime_nums[j] = false;
        }
    }

    // TIME FOR PRINTING THE ARARY
    for (int i = 2; i <= n; i++)
        if (prime_nums[i])
            std::cout << i << " ";
}


/************ QUESTION 2
*** Implementation of Trial Division algorithm for integer factorization
*** INPUT: NUM WHAT IT'S PRIME FACTORIZATION
*** OUTPUT: VECTOR OF PRIME FACTORIZATION
*/
void primeFactorization(int n) {
  vec res;

  // IF THE NUMBER IS DIVISIBLE BY 2
  // DIVIDE IT AND ADD TWO THE RES VECTOR
  while (n % 2 == 0) res.push_back(2), n /= 2;

  // ITERATION I FROM 3 TO THE SQUARE ROOT OF N
  // EACH ITERATION INCREMENTED BY 2
  // THE SECOND ITERATION WHILE THE NUM IS DIVISIBLE BY I
  // ADD THE I VALUE TO THE RESULT VECTOR AND DIVIDE THE NUMBY I
  for (int i = 3; i * i <= n; i = i + 2)
    while (n % i == 0) res.push_back(i), n /= i;

  // IF THE NUM N GREATER THAN 2, ADD THE VALUE OF N TO THE VECTOR
  if (n > 2) res.push_back(n);

  // RETURN THE VECTOR
  for(int i = 0; i < (int) res.size(); i++) std::cout << res[i] << " ";
  std::cout << "\n";
}


/************ QUESTION 3
*** Implementation of the extended Euclidean algorithm that finds the greatest common divisor d of two
*** positive integers a and b. In addition, it outputs Bezout’s coefficients s and t such that
*** d = s a + t b
*** INPUT: A, B, POINTER TO X, POINTER TO Y
*** OUTPUT: GREATEST COMMON DIVISOR (D) AND THE VALUE OF S, T
*/
int gcdExtended(int a, int b, int *x, int *y) {
	// BASE CONDITION
	if (a == 0) {
		*x = 0;
		*y = 1;
		return b;
	}

	int x1, y1; // TO STORE RESULTS OF RECURSIVE CALL
	// RECURSIVE CALL UNTILL A HIT THE ZERO VALUE
	int gcd = gcdExtended(b%a, a, &x1, &y1);

	// UPDATE X AND Y FROM RECURSIVE CALL
	*x = y1 - (b/a) * x1;
	*y = x1;
	return gcd;
}

/************ QUESTION 4
*** Implement Chinese remainder theorem that takes as input m1, m2, m3, …., mn that are
*** pairwise relatively prime and (a1, a2, …., an) and calculates X
*** INPUT: TWO VECTORS M AND A
*** OUTPUT: X VALUE
*/
// AS A HELP FUNCTION COZ WE NEED MODULAR INVERSE
int modInverse(int a, int m) {
    // ITERATION I FROM 1 TO THE M VALUE TO FIND AN I VALUE SATISFY
    // THE CONDITION (A % M) * (I % M) THE WHOLE MODILE M EQUAL 1
    for (int i = 1; i < m; i++)
        if (((a%m) * (i%m)) % m == 1)
            return i;
    // IF NOT FOUND RETURN -1
    return -1;
}
// THE MAIN FUNCTION
int chineseRemainder(vec a, vec m) {
    // variable M INITIALIZED to value 1
    LL M = 1;
    // GET THE M VALUE
    for (int i = 0; i < (int) m.size(); i++) M *= m[i];

    // TWO VECTORS WITH THE M1, M2, M3 ... MN
    // AND THE INVERSE OF THEIR VALUES
    vec all_m, inverse_m;
    for(int i = 0; i < (int) m.size(); i++) {
        int temp = M / m[i];
        all_m.push_back(temp);
        inverse_m.push_back(modInverse(temp, m[i]));
    }

    // TIME FOR THE RESULT VALUE
    int res = 0;
    // FROM THE EQUATION OF CHINESE REMAINDER
    // THE SUM OF THE MULTIPLICATION OF A[I] AND M[I] AND INVERSEM[I]
    for (int i = 0; i < (int) m.size(); i++) {
        res += (a[i] * all_m[i] * inverse_m[i]);
    }

    // RETURN MODUE THE RESULT
    return res % M;
}

/************* QUESTION 5
*** Implementation of Miller’s test (a probabilistic primality test)
*** INPUT: N THE NUM WANNA CHECK IF PRIME OR NOT, K THE ACCURACY OF THE TRIAL
*** OUTPUT: TRUE IF PRIME, FALSE NOT PRIME
*/
// HELPED FUNCTION TO GET THE MODULARITY EXPONENTIAL
LL mod_exp(LL b, LL n, LL m) {
    // THE VALUE OF THE RESULT INITIALIZED TO 1
    LL result = 1;
    do {
        // Means one value of the binary representation
        if(n & 1) result = (result * b) % m;
        // UPDATE THE VALUE OF THE BASE BY MULTIPLYING BY ITSELF AND MODULE M
        b = (b * b) % m; // MORE EFFICIENT
        // USING RIGHT SHIFTING BY 1 TO GET THE BINARY REPRESENTATION
    } while((n >>= 1) > 0);
    // RETURN THE RESULT VALUE
    return result;
}

// THE FUNCTION CALLS K TRIALS.
// IT RETURNS FALSE IF N IS A COMPOSITE AND RETURN TRUE IF N IS PROBABLY PRIME.
// D IS AN ODD NUMBER SUCH THAT (D * 2 POW(R) = N - 1) FOR R >= 1
bool millerTest(int d, int n) {

    // PICK A RANDOM VARIABLE A.
    int a = 2 + rand() % (n - 4);

    // Compute T = a^d % n
    LL x = mod_exp(a, d, n);

    if (x == 1  || x == n-1)
       return true;

    // KEEP SQUARING X WHILE ONE OF THE FOLLOWING DOESN'T HAPPEN
    // D DOESN'T REACH N - 1
    // X^2 % N ISN'T ONE
    // X^2 % N ISN'T N - 1
    while (d != n-1) {
        x = (x * x) % n;
        d *= 2;
        if (x == 1) return false;
        if (x == n-1) return true;
    }
    return false;
}

// IT RETURN FALSE IF N IS A COMPOSITE NUMBER AND RETRNS TRUE IF N IS A PROBABLY PRIME
// K IS AN INPUT PARAMETER THAT DETERMINES ACCURACY LEVEL
// HIFHER K INDICATES HIGHER ACCURACY
bool isPrime(int n, int k)
{
    // IF N LESS THAN OR EQUAL 4 CAN'T BE PRIME
    if (n <= 1 || n == 4)  return false;
    // IF N LESS OR EQUAL 3 IT'S ABSOLUTELY PRIME {2, 3}
    if (n <= 3) return true;

    // THE VALUE OF D = N-1
    int d = n - 1;
    // IF D DIVIDES BY 2, DIVIDE IT
    while (d % 2 == 0)
        d /= 2;

    // K ITERATIONS TO TEST MILLER IF THE NUM IS PRIME OR NOT
    for (int i = 0; i < k; i++)
         if (!millerTest(d, n))
              return false;
    return true;
}


int main()
{
    std::string determine = "yes";
    std::cout << "************* THE PROGRAM IS STARTING, HELLO USER! *************\n";
    int whichMethod;
    while(determine == "yes" || determine == "y") {
        std::cout << "\n\nChoose The number of Algorithm you wanna implement:";
        std::cout << "\n1. Sieve of Eratosthenes algorithm\n2. Trial Division algorithm";
        std::cout << "\n3. Extended Euclidean algorithm";
        std::cout << "\n4. Chinese remainder theorem\n5. Miller’s test\n";
        /////
        std::cin >> whichMethod;
        int n, x, y, w;
        vec a, m;
        switch(whichMethod) {
        case 1:
            std::cout << "Enter the num n: ";
            std::cin >> n;
            std::cout << "The Prime Numbers: ";
            sieveOfEratosthenes(n);
            break;
        case 2:
            std::cout << "Enter The num n: ";
            std::cin >> n;
            std::cout << "The Factors: \n";
            primeFactorization(n);
            break;
        case 3:
            std::cout << "Enter the values of A, B: ";
            std::cin >> n >> w;
            std::cout << "The GCD(" << n << ", " << w << ") = " << gcdExtended(n, w, &x, &y) << "\n";
            std::cout << "The Expression: GCD(a, b) = as + bt \nt= " << x << "  s="  << y;
            break;
        case 4:
            std::cout << "Enter the number of equation: ";
            std::cin >> n;
            a.resize(n);
            m.resize(n);
            std::cout << "Enter the values of A vector: ";
            for(int i = 0; i < n; i++) std::cin >> a[i];
            std::cout << "Enter the values of M vector: ";
            for(int i = 0; i < n; i++) std::cin >> m[i];
            std::cout << "X=" << chineseRemainder(a, m);
            break;
        case 5:
            std::cout << "Enter the number wanna check: ";
            std::cin >> n;
            std::cout << "Enter the accuracy level: ";
            std::cin >> w;
            if(isPrime(n, w)) std::cout << "The number " << n << " is probably Prime.";
            else std::cout << "The number " << n << " is Not prime.";
            break;
        default:
            std::cout << "Unvalid Method...";
            break;

        }
        std::cout << "\n\nWanna Continue?\nIf yes, enter 'y': ";
        std::cin >> determine;
    }
    return 0;
}
