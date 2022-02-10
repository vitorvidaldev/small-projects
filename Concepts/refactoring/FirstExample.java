import java.util.List;

public class FirstExample {

    public static String statement(Invoice invoice, Plays plays) {
        int totalAmout = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoice.customer();

        for (Performace perf : invoice.performaces()) {
            Play play;
            if (perf.playId().equals("hamlet")) {
                play = new Hamlet();
            } else if (perf.playId().equals("as-like")) {
                play = new AsLike();
            } else {
                play = new Othello();
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

            totalAmout += thisAmount;
        }

        return result;
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
}

class Hamlet extends Play {
}

class Othello extends Play {
}

class AsLike extends Play {
}

record Plays(
        Hamlet hamlet,
        AsLike asLike,
        Othello othello) {
}