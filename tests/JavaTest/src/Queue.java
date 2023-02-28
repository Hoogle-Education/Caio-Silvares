public class Queue<T> {
    private Entry<T> start;

    public T take() {
        if (start == null)
            return null;

        Entry<T> result = start;
        start = result.next;
        return result.value;
    }

    public String toString() {
        StringBuffer res = new StringBuffer("[");
        Entry<T> current = start;
        while (current != null) {
            res.append(current.value + " ");
            current = current.next;
        }
        return res.toString().trim() + "]";
    }

    public void append(T value)
    {
        if(start == null) {
            start = new Entry<T>();
            start.value = value;
            return;
        }

        Entry<T> current = start;

        while(current.next != null) {
            current = current.next;
        }

        current.next = new Entry<T>();
        current.next.value = value;
    }
}
class Entry<T> {
    T value;
    Entry<T> next;
}

class ProgramTest {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();

        integerQueue.append(2);
        integerQueue.append(3);
        integerQueue.append(4);
        integerQueue.append(5);

        var taked = integerQueue.take();

        System.out.println("taked = " + taked);

        System.out.println(integerQueue);
    }
}