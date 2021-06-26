#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#include "Stack.h"

/******* THAT MACRO MAKES THE IMPLEMENTATION FOR Linked Stack *******/
#define Linked_Stack

/******  
TO DISPLAY THE ELEMENT -- IT'S A GOOD IMPLEMETATION MAKING FOR EEVRY SIMPLE TASK A FUNCTION -- REUSE  
******/
void Display(StackEntry e)
{
    printf("%d ", e);
}

#ifdef Linked_Stack

/****** 
FOR CREATING THE STACK AS C PROGRAMMING DOESN'T SUPPORT OOP --- IT'S GOOD IMPLEMETATION MAKING A CONSTRUCTOR!!
*******/
void initializeStack(Stack *ps)
{
    ps->top = NULL;
    ps->size = 0;
}

/************ CREATING NODE ***********/
Node *MakeNode(StackEntry data)
{
    Node *p;
    p = (Node*) malloc(sizeof(Node));
    p->data = data;
    p->next = NULL;
    return p;
}

/*******
AS LAST - IN - FIRST - OUT
WE PUSH AT THE TOP POINTER
******/
void push(StackEntry e, Stack *ps)
{
    Node *p = MakeNode(e);
    p->next = ps->top;
    ps->top = p;
    ps->size += 1;
}

/*******
REMOVING THE TOP ELEMENT
******/
StackEntry pop(Stack *ps)
{
    Node *p = ps->top;
    int item = p->data;
    ps->top = p->next;
    free(p);
    ps->size -= 1;
    return item;
}

/*****  CHECKING THE EMPTINESS  ****/
bool isEmpty(Stack *ps)
{
    return (ps->top == NULL);
}

/******  
CHECKING THE FULL  
HARD CODED -- AS THE IMPLEMETATION IN ARRAY BASED THIS FUNCTION IS IMPORTANT 
SO TO SUPPORT CONSISTENT SOFTWARE WE ADD IT IN LINKED LIST ..
*******/
bool isFull(Stack *ps)
{
    return false;
}

/*****  SIZE OF THE STACK  *****/
int sizeStack(Stack *ps)
{
    return (ps->size);
}

/***  RETURN THE TOP ELEMENT  ***/
StackEntry Top(Stack *ps)
{
    return ps->top->data;
}

/*** TRAVERSATION IN ALL ELEMENTS  ***/
void traverse(Stack *ps, void (*pf) (StackEntry))
{
    for(Node *pn = ps->top; pn; pn = pn->next)
        (*pf)(pn->data);
}

/** 
IN C, YOU HAVE TO DEALLOCATE THE ELEMENTS MANUALLY 
SO THETA N IS THE COMPLEXITY OF THIS ALGORITHIM
**/
void clearStack(Stack *ps)
{
    Node *pn = ps->top;
    while(pn)
    {
        pn = pn->next;
        free(ps->top);
        ps->top = pn;
    }
}



/************************  ARRAY BASED IMPLEMENTATION   *********************/
#else
/************  SAME FUNCTIONS AS LINKED LIST  **********/
void initializeStack(Stack *ps)
{
    ps->top = 0;
}


void push(StackEntry e, Stack *ps)
{
    ps->entry[ps->top++] = e;
}

StackEntry pop(Stack *ps)
{
   return ps->entry[--ps->top];
}

bool isEmpty(Stack *ps)
{
    return (ps->top == 0);
}

bool isFull(Stack *ps)
{
    return (ps->top == MAXSIZE);
}

int sizeStack(Stack *ps)
{
    return (ps->top);
}

StackEntry Top(Stack *ps)
{
    return (ps->entry[ps->top - 1]);
}


void traverse(Stack *ps, void (*pf) (StackEntry))
{
    for(int i = ps->top; i > 0; i--)
        (*pf) (ps->entry[i - 1]);
}

#endif // :))))
