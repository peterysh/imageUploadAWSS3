package toy.TDD.dollar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import toy.TDD.domain.Dollar;
import toy.TDD.domain.Franc;
import toy.TDD.domain.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DollarServiceTest {
    @Test
    public void testMultiplication() throws Exception{
        Money five = Money.dollar(5);
        assertThat(Money.dollar(10)).isEqualTo(five.times(2));
    }

    @Test
    public void testMultiplication2times() throws Exception{
        Money five = Money.dollar(5);
        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testDifferentClassEquality(){
        assertTrue(new Money(10,"CHF").equals(
                new Franc(10,"CHF")));
    }
}
