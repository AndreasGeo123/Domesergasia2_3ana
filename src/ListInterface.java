public interface ListInterface <T>{
    boolean isEmpty();

    void insertAtFront(T data);

    void insertAtBack(T data);

    T removeFromFront();

    T removeFromBack();

    T getFirst();

    T getNext();

    T getPrev();
}
