/****************** IMPLEMENTATION OF DIJKSTRA ALGORITHM *****************
* USING AGJACENCY MATRIX AS THE IMPLEMENTATION OF THE GRAPH 
* THE INITIAL GRAPH IS IN THE SAME DIRECTORY WITH PDF FILE EXPLAINNING THE PROBLEM  
*************************************************************************/


public class DijkstraShortestPath {

    // Using Adjacency Matrix Implementation for Graphs
    static int dimensionOfGraph;

    DijkstraShortestPath(int num)
    {
        dimensionOfGraph = num;
    }

    // I'm Not NOW So good in implementation of Algorithms
    // But to just starting and Force mySelf I will rewrite this Algorithm
    // https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
    // Explaining EveryStep ...


    // At every Iteration in DijkstraSP: we need the min Distance in result
    // and Point it as it's CHECKED ..
    public int minDistance(int[] result, boolean[] check)
    {
        // We need infinite value So minValue and the index for it
        // The initialization for index -1 as we didn't start yet!!
        int minValue = Integer.MAX_VALUE, minIndex = - 1;

        for (int i = 0; i < dimensionOfGraph; i++)
        {
            if (!check[i] && minValue >= result[i])
            {
                minValue = result[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void printResultArray(int[] result)
    {
        System.out.println("Vertex\t\tLength Shortest Path");
        for (int i = 0; i < dimensionOfGraph; i++)
            System.out.println(i + "\t\t\t" + result[i]);
    }

    public void DijkstraSP(int[][] graphs, int startingVertex)
    {

        // Result Array that have DSP
        int[] result = new int[dimensionOfGraph];

        // To prevent infinite Loops -- Checker
        boolean[] check = new boolean[dimensionOfGraph];

        // INITIALIZE RESULT ARRAY IS INFINITE ELEMENTS
        for (int i = 0; i < dimensionOfGraph; i++)
        {
            result[i] = Integer.MAX_VALUE;
            check[i] = false;
        }

        // To STart by the startingVertex
        result[startingVertex] = 0;
        for (int i = 0; i < dimensionOfGraph; i++)
        {
            int minIndexInResult = minDistance(result, check);
            check[minIndexInResult] = true;

            for (int j = 0; j < dimensionOfGraph; j ++)
            {
                if (!check[j] &&
                graphs[minIndexInResult][j] != 0 &&
                // result[minIndexInResult] != Integer.MAX_VALUE &&
                result[minIndexInResult] + graphs[minIndexInResult][j] < result[j])
                {
                    result[j] = result[minIndexInResult] + graphs[minIndexInResult][j];
                }
            }
        }
        printResultArray(result);

    }

    public static void main(String[] args)
    {
        int dimensionOfMatrix = 9;
        
        // Representation Using Adjacency Matrix
        int[][] graph = new int[][] {{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                     { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                     { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                     { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                     { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                     { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                     { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                     { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                     { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        DijkstraShortestPath obj = new DijkstraShortestPath(dimensionOfMatrix);
        obj.DijkstraSP(graph, 0);
    }
}

/************** THE OUTPUT: ****************

Vertex		Length Shortest Path
0			0
1			4
2			12
3			19
4			21
5			11
6			9
7			8
8			14

******************************************/
