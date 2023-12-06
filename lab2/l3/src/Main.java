import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Grammar g = new Grammar("inputs/g1.txt");
        while(true){
            System.out.println("1. Set of non terminals");
            System.out.println("2. Set of terminals");
            System.out.println("3. Set of productions");
            System.out.println("4. Productions for a given non terminal");
            System.out.println("5. CFG check");
            System.out.println("6. Exit");
            var option = new java.util.Scanner(System.in).nextInt();
            if(option == 6) {
                break;
            }else if(option > 5 || option < 1){
                System.out.println("Invalid option");
            } else{
                g.doAction(option);
            }
        }
    }
}