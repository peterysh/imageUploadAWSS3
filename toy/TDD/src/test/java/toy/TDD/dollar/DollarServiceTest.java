package toy.TDD.dollar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import toy.TDD.domain.Dollar;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarServiceTest {
    @Test
    public void testMultiplication() throws Exception{
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(10).isEqualTo(five.amount);
    }

    @Test
    public void testMultiplication2times() throws Exception{
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);
        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }
}
