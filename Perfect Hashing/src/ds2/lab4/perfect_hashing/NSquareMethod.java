package ds2.lab4.perfect_hashing;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * -> I've tested this method
 * -> For my PC, if the data generated to be hashed is more than 20000 word
 * -> RunTimeError: OutOfMemory will pop up
 */
public class NSquareMethod implements IMap {

    private UniversalHashF hashFamily;
    private int N, collisionCount;
    // Wrapped Class Integer
    // (Slower but will provide null for Not assigned yet)
    public Integer[] hashTable;

    @Override
    public void hash(Integer[] keys) {
        // get unique keys only __ if there's repeated (random data)
        Set<Integer> setOfUniqueKeys = new LinkedHashSet<>(Arrays.asList(keys));

        this.N = setOfUniqueKeys.size();
        this.collisionCount = 0;
        boolean isCollision = true;

        while (isCollision) {
            // increase the collisionCount
            collisionCount += 1;
            isCollision = false;

            // System.out.println("OOOOPS");
            // HashTable Slots M = N * N = O(N ^ 2)
            this.hashTable = new Integer[N * N];
            this.hashFamily = new UniversalHashF(N * N);

            // Iterate over the uniqueKeys to set the values correctly
            for (int key : setOfUniqueKeys) {
                int id = hashFamily.hash(key);
                if (hashTable[id] != null) {
                    isCollision = true;
                    break;
                }
                hashTable[id] = key;
            }
        }
        // System.out.println("YARAB");
    }

    @Override
    public void print() {
        StringBuilder s = new StringBuilder();
        s.append("\n****   The Hash Table N^2 Space Complexity   ****\n");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                s.append(String.format("Index %d has Unique Key: %d%n", i, hashTable[i]));
            }
        }
        System.out.print(s);
    }

    @Override
    public boolean contains(int key) {
        // Empty HashTable
        if (hashTable == null) return false;

        // And Finally, The desirable O(1) time complexity
        // for looks up.
        int id = hashFamily.hash(key);
        // System.out.println("ID In Contain: " + id);
        return hashTable[id] != null && hashTable[id] == key;
    }

    @Override
    public int spaceConsumed() {
        // How many Place For Integer?
        return (N * N);
    }

    @Override
    public int collisionCount() {
        return this.collisionCount;
    }
}
