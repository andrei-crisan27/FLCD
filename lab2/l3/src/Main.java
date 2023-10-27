public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable(7);

        symbolTable.add("1");
        Pair position1 = symbolTable.findPositionOfTerm("1");
        if(symbolTable.containsTerm("1"))
            System.out.println("Term 1 is found in the table at position " + position1);
        else
            System.out.println("Term 1 is not found!");

        symbolTable.add("2");
        Pair position2 = symbolTable.findPositionOfTerm("2");
        if(symbolTable.containsTerm("2"))
            System.out.println("Term 2 is found in the table at position " + position2);
        else
            System.out.println("Term 2 is not found!");


        symbolTable.add("8");
        Pair position3 = symbolTable.findPositionOfTerm("8");
        if(symbolTable.containsTerm("8"))
            System.out.println("Term 8 is found in the table at position " + position3);
        else
            System.out.println("Term 8 is not found!");

        symbolTable.add("9");
        Pair position4 = symbolTable.findPositionOfTerm("9");
        if(symbolTable.containsTerm("9"))
            System.out.println("Term 9 is found in the table at position " + position4);
        else
            System.out.println("Term 9 is not found!");

        System.out.println(symbolTable.getHashTable());
    }
}