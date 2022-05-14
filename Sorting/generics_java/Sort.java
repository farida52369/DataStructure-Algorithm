
public interface Sort<T extends Comparable<? super T>> {
    void sort(T[] arr);
}
