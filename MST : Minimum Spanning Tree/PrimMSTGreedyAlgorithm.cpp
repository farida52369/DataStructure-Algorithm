#include <bits/stdc++.h>

// NUM OF VERTICES IN THE GRAPH
#define V 9

void printTree(int parent[V], int graph[V][V]) {

    for(int i = 1; i < V; i++)
        std::cout << parent[i] << "  --  " << i << "  Weight: " << graph[i][parent[i]] << '\n';
}


int minKeyToGoTo(int key[V], bool mstSet[V]) {

    int min_value = INT_MAX, min_index = 0;
    for(int i = 0; i < V; i++) {
        if(!mstSet[i] && min_value > key[i])
            min_value = key[i], min_index = i;
    }
    return min_index;
}

void primMST(int graph[V][V]) {
    // MAIN ARRAYS TO START WORKING
    int parent[V];  // HAVE THE CONSTRUCTED TREE
    int key[V];   // TO PICK MINUM WEIGHTED EDGE
    bool mstSet[V];   // VERTIX INCLUDED OR NOT IN THE MST

    for(int i = 0; i < V; i++)
        key[i] = INT_MAX, mstSet[i] = false;

    // TO START WITH FOR EXAMPLE VERTEX (0) AS THE ROOT OF THE TREE
    parent[0] = -1;
    key[0] = 0;

    // AS WE HAVE (V-1) EDGES
    // OR ALL VERTICES EXCLUDING LAST ONE AS IT'S ADDED ANYWAY
    for(int i = 0; i < V - 1; i++) {

        // MINUM WEIGHT FOR UNADDED VERTIX TO GO TO.
        int u = minKeyToGoTo(key, mstSet);

        mstSet[u] = true;  // WE ARE VISITING
        for(int v = 0; v < V; v++) {
                // GOING THROUGH ALL THE ROW
                // THE VALUE NOT ZERO AS IT HAS AN EDGE HERE
                // THE VERTIX NOT INCLUDED IN THE SET
                // KEY VALUE IS ABSOLUTE BIGGER THAN THE GRAPH VALUE
                // SO WE COULD UPDATE THE KEY VALUE!!!
            if(graph[u][v] && !mstSet[v] && graph[u][v] < key[v])
                key[v] = graph[u][v], parent[v] = u;
        }
    }

    // PRINT THE MINIMUM SPANNING TREE
    printTree(parent, graph);
}


int main()
{

    int graph[V][V] = { {0, 4, 0, 0, 0, 0, 0, 8, 0},
                        {4, 0, 8, 0, 0, 0, 0, 11, 0},
                        {0, 8, 0, 7, 0, 4, 0, 0, 2},
                        {0, 0, 7, 0, 9, 14, 0, 0, 0},
                        {0, 0, 0, 9, 0, 10, 0, 0, 0},
                        {0, 0, 4, 14, 10, 0, 2, 0, 0},
                        {0, 0, 0, 0, 0, 2, 0, 1, 6},
                        {8, 11, 0, 0, 0, 0, 1, 0, 7},
                        {0, 0, 2, 0, 0, 0, 6, 7, 0} };
    /*
    int graph[V][V] = { { 0, 2, 0, 6, 0 },
                        { 2, 0, 3, 8, 5 },
                        { 0, 3, 0, 0, 7 },
                        { 6, 8, 0, 0, 9 },
                        { 0, 5, 7, 9, 0 } };
    */
    primMST(graph);
    return 0;
}
