
// Knight Tour!!
// Using BackTracking ...

#include <bits/stdc++.h>
#define N 8

int board[N][N];

// Moves For the Knight
int dx[N] = {1, 2, 2, 1, -1, -2, -2, -1};
int dy[N] = {-2, -1, 1, 2, 2, 1, -1, -2};

void printBoard() {
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++)
      std::cout << " " << std::setw(2) << board[i][j] << " ";
    std::cout << '\n';
  }
}

bool safe(int x, int y) {
  return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
}

bool solveKnightUnit(int x, int y, int move) {
  int i, xNext, yNext;

  // Reaching the N*N move Last One
  // What after the LasT :))
  if (move == N * N) return true;

  // For every (x, y) try all its possible ways
  // Eight moves possible for every Knight ..
  for (i = 0; i < N; i++) {
    // The Next (x, y)
    xNext = x + dx[i], yNext = y + dy[i];
    // Checking if it's a valid move or Not
    if (safe(xNext, yNext)) {
      // Put a value in the Next (x, y)
      board[xNext][yNext] = move;
      if (solveKnightUnit(xNext, yNext, move + 1))
        return true;
      else
        board[xNext][yNext] = -1;
    }
  }
  return false;
}

void solveKnight() {
  // Initializing The array So that know if visited or NoT ..
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) board[i][j] = -1;
  }

  // Starting Point (0, 0) = 0
  board[0][0] = 0;

  // SolveKnightUnit is false then No Solution
  if (!solveKnightUnit(0, 0, 1))
    std::cout << "Solution Doesn't exist!\n";
  else
    printBoard();
}
int main() {
  // printBoard();
  solveKnight();
  return 0;
}
