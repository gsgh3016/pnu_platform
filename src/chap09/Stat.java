package chap09;

class Stat {
    private final String name;
    private final int value;

    public Stat(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", name, value);
    }
}
