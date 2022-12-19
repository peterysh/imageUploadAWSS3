package toy.TDD.domain;

public class Dollar extends Money{

    private String currency;

    public Dollar(int amount) {
        this.amount = amount;
        this.currency = "USD";
    }

    public Money times(int multiplier){
        return new Dollar(amount * multiplier);
    }

    @Override
    public String currency() {
        return currency;
    }
}
