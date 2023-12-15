import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Grammar g = new Grammar("inputs/g1.txt");
        Parser p = new Parser(g);
        while(true){
            System.out.println("1. Set of non terminals");
            System.out.println("2. Set of terminals");
            System.out.println("3. Set of productions");
            System.out.println("4. Productions for a given non terminal");
            System.out.println("5. CFG check");
            System.out.println("6. Compute first function for a given symbol");
            System.out.println("7. Compute follow function for a given symbol");
            System.out.println("8. Exit");
            var option = new java.util.Scanner(System.in).nextInt();
            if(option == 8) {
                break;
            }else if (option == 6){
                String symbol = new java.util.Scanner(System.in).nextLine();
                String first = p.first(symbol, new StringBuilder());
                System.out.println(first);
            }else if (option == 7){
                String symbol = new java.util.Scanner(System.in).nextLine();
                String follow = p.follow(symbol, new StringBuilder());
                System.out.println(follow);
            }else if(option > 7 || option < 1){
                System.out.println("Invalid option");
            } else{
                g.doAction(option);
            }
        }
    }
}