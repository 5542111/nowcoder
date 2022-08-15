public class a0641MyCircularDeque {

    private int[] elements;
    private int first, last;
    private int capacity;

    public a0641MyCircularDeque(int k) {
        elements = new int[k + 1];
        first = 0;
        last = 0;
        capacity = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        first = (first - 1 + capacity) % capacity;
        elements[first] = value;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[last] = value;
        last = (last + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        first = (first + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        last = (last - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[first];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(last - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return first == last;
    }

    public boolean isFull() {
        return (last + 1) % capacity == first;
    }
}
