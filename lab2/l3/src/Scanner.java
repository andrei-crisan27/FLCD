import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private SymbolTable ST = new SymbolTable(100);
    private List<Pair> PIF = new ArrayList<>(); // Pair(token, st_pos); token: -1 for id, -2 for const
    private String[] tokens;

    public Scanner(){
        this.tokens = readTokensFromFile("inputs/tokens.in");
    }

    public SymbolTable getST() {
        return ST;
    }

    public String[] readTokensFromFile(String filename){
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append(" ");
            }
            br.close();
            return text.toString().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void computePif(String filename) throws Exception {
        String[] tokenizedFile = readTokensFromFile(filename);
        for(int i=0; i< tokenizedFile.length; i++){
            if(checkIfID(tokenizedFile[i])){
                this.ST.add(tokenizedFile[i]);
                this.PIF.add(new Pair(-1, this.ST.findPositionOfTerm(tokenizedFile[i]).getMainArrayPosition()));
            } else if(checkIfConst(tokenizedFile[i])){
                this.ST.add(tokenizedFile[i]);
                this.PIF.add(new Pair(-2, this.ST.findPositionOfTerm(tokenizedFile[i]).getMainArrayPosition()));
            } else if(checkIfToken(tokenizedFile[i])){
                this.PIF.add(new Pair(1, -1));
            } else{
                throw new Exception("Lexical error at word " + tokenizedFile[i]);
            }
        }
        writeOutput();
    }

    private boolean checkIfToken(String token){
        for(int i=0; i<this.tokens.length; i++){
            if(this.tokens[i].equals(token)){
                return true;
            }
        }
        return false;
    }

    private boolean checkIfID(String token){
        if((int)(token.charAt(0)) >= 97 && (int)(token.charAt(0)) <= 122){
            for(int i=1; i<token.length(); i++){
                if(((int)(token.charAt(i)))!=95){
                    if(!((int)(token.charAt(i)) >= 97 && (int)(token.charAt(i)) <= 122)){
                        if(!Character.isDigit(token.charAt(i)) && (int)(token.charAt(i))!=91 && (int)(token.charAt(i))!=93)
                            return false;
                    }
                }
            }
        } else{
            return false;
        }
        return true;
    }

    private boolean checkIfConst(String token){
        if(token.charAt(0) == '\'' && token.charAt(token.length()-1) == '\'')
            return true;
        if(token.charAt(0) == '"' && token.charAt(token.length()-1) == '"')
            return true;
        for(int i=0; i<token.length(); i++){
            if(!Character.isDigit(token.charAt(i)))
                return false;
        }
        return true;
    }

    private void writeOutput() throws IOException {
        try (FileWriter fileWriter = new FileWriter("outputs/PIF.txt")) {
            fileWriter.write("PIF:\n");
            for (Pair p : PIF) {
                fileWriter.write("token: "+ p.getMainArrayPosition()+ ", ST position: " + p.getSecondaryArrayPosition() + "\n");
            }
        } catch (IOException e) {
        }

        try (FileWriter fileWriter = new FileWriter("outputs/ST.txt")) {
            fileWriter.write("ST:\n");
            fileWriter.write(ST.getHashTable().toString());
        } catch (IOException e) {
        }
        System.out.println("lexically correct!");
    }

}
