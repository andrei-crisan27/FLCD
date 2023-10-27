public class Pair {
    private final int mainArrayPosition;
    private final int secondaryArrayPosition;

    public int getMainArrayPosition() {
        return mainArrayPosition;
    }

    public int getSecondaryArrayPosition() {
        return secondaryArrayPosition;
    }

    public Pair(int first, int second) {
        this.mainArrayPosition = first;
        this.secondaryArrayPosition = second;
    }

    @Override
    public String toString() {
        return "Main: " + this.mainArrayPosition + ", Secondary: " + this.secondaryArrayPosition;
    }
}