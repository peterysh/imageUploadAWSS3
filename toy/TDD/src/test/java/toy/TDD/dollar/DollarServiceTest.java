package toy.TDD.dollar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import toy.TDD.domain.Dollar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DollarServiceTest {
    @Test
    public void testMultiplication() throws Exception{
        Dollar five = new Dollar(5);
        assertThat(10).isEqualTo(five.times(2).amount);
    }

    @Test
    public void testMultiplication2times() throws Exception{
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
    }
}
