#include <stdbool.h>

#define MAXSIZE 100
#define StackEntry int

/************* For Linked Lists Implementation ****************/
// COMMENTING THIS LINE WILL MAKE THE IMPLEMETATION AS ARRAY BASED (ELSE) .. :))
#define Linked_Stack

/************* If it's Linked List Implementation **************/
#ifdef Linked_Stack

typedef struct node
{
    StackEntry data;
    struct node *next;
}Node;

typedef struct stack
{
    int size;
    Node *top;
}Stack;

/************ If it's Array Based Implementation **************/
#else

typedef struct stack
{
    int top;
    StackEntry entry[MAXSIZE];
} Stack;

#endif

/****************************************************************
************************** METHODS FOR STACKS *******************
*****************************************************************/

void push(StackEntry, Stack *);
StackEntry pop(Stack *);
bool isEmpty(Stack *);
bool isFull(Stack *);
int sizeStack(Stack *);
StackEntry Top(Stack *);
void traverse(Stack *, void (*) (StackEntry));
void clearStack(Stack *);
void initializeStack(Stack *);

