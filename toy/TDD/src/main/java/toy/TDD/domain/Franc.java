package toy.TDD.domain;

import lombok.ToString;

@ToString
public class Franc extends Money{

    public Franc(int amount, String currency) {
        super(amount, currency);
    }
}
