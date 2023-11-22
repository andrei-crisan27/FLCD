import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner();
        try{
            sc.computePif("inputs/p1.txt");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        FA fa = new FA("inputs/FAct.in");
        while(true){
            System.out.println("1. Set of states");
            System.out.println("2. The alphabet");
            System.out.println("3. All the transitions");
            System.out.println("4. The initial state");
            System.out.println("5. The set of final states");
            System.out.println("6. Check the word");
            System.out.println("7. Close program");
            var option = new java.util.Scanner(System.in).nextInt();
            if(option > 7 || option < 1){
                System.out.println("Invalid option");
            } else if(option == 6){
                if(!fa.isDFA()){
                    System.out.println("This is not a DFA!");
                    break;
                }
                var word = new java.util.Scanner(System.in).nextLine();
                System.out.println(fa.isAccepted(word));
            }else if(option == 7){
                break;
            } else {
                fa.doAction(option);
            }
        }
    }
}