public class MyPair<T, U> {
    private final T first;
    private final U second;

    public MyPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> MyPair<T, U> of(T first, U second) {
        return new MyPair<>(first, second);
    }

    public T getKey() {
        return first;
    }

    public U getValue() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
