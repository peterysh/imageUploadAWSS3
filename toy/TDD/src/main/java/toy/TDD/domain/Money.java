package toy.TDD.domain;

public abstract class Money {
    protected int amount;

    public abstract Money times(int multiplier);

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }
}
