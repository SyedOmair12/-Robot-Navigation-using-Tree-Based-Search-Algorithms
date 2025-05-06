public class Main {
    public static void main(String[] arguments) {

        if (arguments.length != 2) {
            System.out.println("Please check your input. Required Input Format: [Algorithm] [File]");
            System.out.println("Available Algorithms: ");
            System.out.println("TT");
            System.out.println("FC");
            System.out.println("BC");

        }
        else {
            ReadFile(arguments[1]);

            switch (arguments[0].toUpperCase()) {
                case "TT":
                    System.out.println(new TruthTable().execute(new Scentence(Query.getQueryList().get(0))));
                    break;
                case "FC":
                    System.out.println(new ForwardChaining().execute(new Scentence(Query.getQueryList().get(0))));
                    break;
                case "BC":
                    System.out.println(new BackwardChaining().execute(new Scentence(Query.getQueryList().get(0))));
                    break;
                default:
                    System.out.println("Invalid Algorithm");
                    System.out.println("Available Algorithms: ");
                    System.out.println("TT");
                    System.out.println("FC");
                    System.out.println("BC");
                    break;
            }
        }
    }

    private static void ReadFile(String filename) {
        if (!Parser.readTextFile(filename)) {
            System.exit(1);
        }
    }
}
