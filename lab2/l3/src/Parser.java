import java.util.*;

public class Parser {

    private Grammar grammar;

    public Parser(Grammar grammar){
        this.grammar=grammar;
    }

    public String first(String nonTerminal, StringBuilder firsts){
        for(String element:this.grammar.getProductions().get(nonTerminal)){
            String firstOfElement=String.valueOf(element.charAt(0));
            if(this.grammar.getTerminals().contains(firstOfElement) || firstOfElement.equals("ε")){
                firsts.append(firstOfElement);
            }
            else if(this.grammar.getNonTerminals().contains(firstOfElement)){
                first(firstOfElement,firsts);
            }
        }
        return firsts.toString();
    }

    public String follow(String nonTerminal, StringBuilder result) {
        if(nonTerminal.equals(this.grammar.getStartingSymbol())){
            result.append("$");
            return result.toString();
        }
        for(Map.Entry<String, List<String>> entry : this.grammar.getProductions().entrySet()){
            for(String production : entry.getValue()){
                for(int i=0; i<production.length(); i+=1){
                    if(String.valueOf(production.charAt(i)).equals(nonTerminal)){
                        if(i == production.length() - 1){
                            result.append(follow(entry.getKey(), new StringBuilder()));
                        } else if (this.grammar.getNonTerminals().contains(String.valueOf(production.charAt(i + 1)))) {
                            result.append(first(String.valueOf(production.charAt(i + 1)), new StringBuilder()));
                        } else if (this.grammar.getTerminals().contains(String.valueOf(production.charAt(i + 1)))) {
                            result.append(production.charAt(i + 1));
                        }
                    }
                }
            }
        }
        return result.toString();
    }

}