package ds2.lab4.perfect_hashing;

public interface IMap {

    void hash(Integer[] keys);

    boolean contains(int key);

    void print();

    int spaceConsumed();

    int collisionCount();
}
