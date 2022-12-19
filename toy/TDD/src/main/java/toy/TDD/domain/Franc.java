package toy.TDD.domain;

public class Franc extends Money{

    private String currency;

    public Franc(int amount, String currency) {
        this.amount = amount;
        currency = "CHF";
    }

    public Money times(int multiplier){
        return new Franc(amount * multiplier, null);
    }

    @Override
    public String currency() {
        return currency;
    }
}
