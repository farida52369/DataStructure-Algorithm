package ds2.lab4.perfect_hashing;

import java.util.LinkedList;
import java.util.List;

/**
 * -> I've tested this method
 * -> For my PC, if the data generated to be hashed is more than 1000000 word
 * -> The PC really Struggling
 */
public class NMethod implements IMap {

    private UniversalHashF hashFamily;
    private NSquareMethod[] hashTable;
    private int memorySpace;

    @Override
    public void hash(Integer[] keys) {
        int N = keys.length;

        // To be of N Space Complexity Only
        hashFamily = new UniversalHashF(N);
        hashTable = new NSquareMethod[N];

        @SuppressWarnings("unchecked")
        List<Integer>[] NHashTable = new LinkedList[N];

        // Constructing array of LinkedList
        // To get number of elements in each Slot
        // To Construct NSquareMethod
        for (int val : keys) {
            int id = hashFamily.hash(val);
            if (NHashTable[id] == null)
                NHashTable[id] = new LinkedList<>();
            NHashTable[id].add(val);
        }

        this.memorySpace = 0;
        for (int i = 0; i < N; i++) {
            hashTable[i] = new NSquareMethod();
            if (NHashTable[i] != null) {
                Integer[] temp = new Integer[NHashTable[i].size()];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = NHashTable[i].get(j);
                }

                hashTable[i].hash(temp);
                memorySpace += hashTable[i].spaceConsumed();
            } else hashTable[i] = null;
        }
    }

    @Override
    public void print() {
        StringBuilder s = new StringBuilder();
        s.append("\n****   The Hash Table N Space Complexity   ****\n");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                s.append(String.format("Index %d In The First Level has Hash Table In The Second Level%n", i));
                for (int j = 0; j < hashTable[i].hashTable.length; j++) {
                    if (hashTable[i].hashTable[j] != null) {
                        s.append(String.format("Index %d has Unique Key: %d%n", j, hashTable[i].hashTable[j]));
                    }
                }
            }
        }
        System.out.println(s);
    }

    @Override
    public boolean contains(int key) {
        // Time Complexity In The Worst Case: O(1)
        int id = hashFamily.hash(key);
        if (hashTable[id] == null) return false;
        return hashTable[id].contains(key);
    }

    @Override
    public int spaceConsumed() {
        // How many Place For Integer?
        return memorySpace;
    }

    @Override
    public int collisionCount() {
        throw new UnsupportedOperationException();
    }
}
