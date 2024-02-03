import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    //зарегестрирован, ниже минимального значения
    @Test
    void shouldCalculateForRegisteredUnderMin() {
        BonusService service = new BonusService();
        long amount = 33;
        boolean registered = true;
        long expected = 0;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //зарегестрирован, минимальное значение
    @Test
    void shouldCalculateForRegisteredMin() {
        BonusService service = new BonusService();
        long amount = 34;
        boolean registered = true;
        long expected = 1;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //зарегестрирован, ниже максимального значения
    @Test
    void shouldCalculateForRegisteredUnderMax() {
        BonusService service = new BonusService();
        long amount = 16_666;
        boolean registered = true;
        long expected = 499;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //зарегестрирован, максимальное значение
    @Test
    void shouldCalculateForRegisteredMax() {
        BonusService service = new BonusService();
        long amount = 16_667;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
    // зарегестрирован, ниже лимита
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    // зарегестрирован, выше лимита
    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //----------------------------------------------------------------

    //не зарегестрирован, ниже минимального значения
    @Test
    void shouldCalculateForNotRegisteredUnderMin() {
        BonusService service = new BonusService();
        long amount = 99;
        boolean registered = false;
        long expected = 0;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //не зарегестрирован, минимальное значение
    @Test
    void shouldCalculateNotForRegisteredMin() {
        BonusService service = new BonusService();
        long amount = 100;
        boolean registered = false;
        long expected = 1;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //не зарегестрирован, ниже максимального значения
    @Test
    void shouldCalculateForNotRegisteredUnderMax() {
        BonusService service = new BonusService();
        long amount = 49_999;
        boolean registered = false;
        long expected = 499;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //не зарегестрирован, максимальное значение
    @Test
    void shouldCalculateForNotRegisteredMax() {
        BonusService service = new BonusService();
        long amount = 50_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
    //не зарегестрирован, ниже лимита
    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 3000;
        boolean registered = false;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    //не зарегестрирован, выше лимита
    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 50_100;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}