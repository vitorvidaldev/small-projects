import java.util.List;

public class FirstExample {

    public static void statement(Invoice invoice, Object play) {
        int totalAmout = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoice.customer();
    }
}

record Invoice(
        String customer,
        List<Performace> performaces) {
}

record Performace(
        String playId,
        int audience) {
}