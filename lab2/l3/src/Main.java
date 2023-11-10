import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner();
        try{
            sc.computePif("inputs/p1.txt");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}