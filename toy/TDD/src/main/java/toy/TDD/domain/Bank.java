package toy.TDD.domain;

public class Bank {

    public Money reduce(Expression source, String to){
        return source.reduce(this, to);
    }
}
