import org.example.BonusService;

public class Main {
    public static void main(String[] args) {
        BonusService service = new BonusService();

        long amount = 1;
        boolean registered = true;
        int expected = 0;
        long actual = service.calculate(amount, registered);

        System.out.println(expected + "==" + actual);
    }
}