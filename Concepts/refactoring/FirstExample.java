import java.util.List;

public class FirstExample {

    public static String statement(Invoice invoice, Plays plays) {
        int totalAmout = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoice.customer();

        for (Performace perf : invoice.performaces()) {
            Play play;
            if (perf.playId().equals("hamlet")) {
                play = new Hamlet("Hamlet", "tragedy");
            } else if (perf.playId().equals("as-like")) {
                play = new AsLike("As You Like It", "comedy");
            } else {
                play = new Othello("Othello", "tragedy");
            }

            int thisAmount = 0;
            switch (play.type) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.audience() > 30) {
                        thisAmount += 1000 * (perf.audience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.audience() > 20) {
                        thisAmount += 10000 + 500 * (perf.audience() - 20);
                    }
                    thisAmount += 300 * perf.audience();
                    break;
                default:
                    throw new Error("Unkown type: " + play.type);
            }

            // add volume credits
            volumeCredits += Math.max(perf.audience() - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(play.type)) {
                volumeCredits += Math.floor(perf.audience() / 5.0);
            }

            result += play.name + ": " + (thisAmount / 100) + " (" + perf.audience() + " seats)\n";
            totalAmout += thisAmount;
        }

        result += "Amount owed is " + totalAmout / 100 + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        return result;
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice(
                "BigCo",
                List.of(
                        new Performace("hamlet", 55),
                        new Performace("as-like", 35),
                        new Performace("othello", 40)));
        Plays plays = new Plays(
                new Hamlet("Hamlet", "tragedy"),
                new AsLike("As You Like It", "comedy"),
                new Othello("Othello", "tragedy"));
        String result = statement(invoice, plays);
        System.out.println(result);
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

class Play {
    public String name;
    public String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

class Hamlet extends Play {

    public Hamlet(String name, String type) {
        super(name, type);
    }
}

class Othello extends Play {

    public Othello(String name, String type) {
        super(name, type);
    }
}

class AsLike extends Play {

    public AsLike(String name, String type) {
        super(name, type);
    }
}

record Plays(
        Hamlet hamlet,
        AsLike asLike,
        Othello othello) {
}