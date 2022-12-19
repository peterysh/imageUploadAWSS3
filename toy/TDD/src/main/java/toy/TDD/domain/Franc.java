package toy.TDD.domain;

public class Franc extends Money{

    private String currency;

    public Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int multiplier){
        return Money.franc(amount * multiplier);
    }

    @Override
    public String currency() {
        return currency;
    }
}
