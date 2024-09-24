package Constants;

public enum Chips {
    White(1),
    Red(5),
    Green(10),
    Blue(25),
    Black(50);

    private final int amount;

    Chips(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
