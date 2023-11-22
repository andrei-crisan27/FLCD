import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FA {
    private List<String> alphabet;
    private List<Transition> transitions;
    private List<String> states;
    private String initialState;
    private List<String> outStates;

    public FA(String filename){
        this.alphabet = new ArrayList<>();
        this.transitions = new ArrayList<>();
        this.states = new ArrayList<>();
        this.initialState = "";
        this.outStates = new ArrayList<>();
        this.readFromFile(filename);
    }

    private void readFromFile(String filename){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                this.initializeElements(tokens);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeElements(String[] tokens){
        if(tokens[0].equals("States")){
            this.states = this.initializeList(tokens);
        } else if(tokens[0].equals("InitialState")){
            this.initialState = tokens[2];
        } else if(tokens[0].equals("OutState")){
            this.outStates = this.initializeList(tokens);
        } else if(tokens[0].equals("Alphabet")){
            this.alphabet = this.initializeList(tokens);
        } else{
            this.transitions.add(new Transition(tokens[2], tokens[3], Arrays.asList(tokens).subList(4, tokens.length)));
        }
    }

    private List<String> initializeList(String[] tokens){
        return Arrays.asList(tokens).subList(2, tokens.length);
    }

    public void doAction(int action){
        if(action == 1){
            printStates();
        } else if(action == 2) {
            printAlphabet();
        } else if(action == 3){
            printTransitions();
        } else if(action == 4){
            System.out.println(this.initialState);
        } else if(action == 5){
            this.printOutStates();
        }
    }

    private void printStates(){
        for(String s: this.states){
            System.out.println(s);
        }
    }

    private void printAlphabet(){
        for(String s: this.alphabet){
            System.out.println(s);
        }
    }

    private void printOutStates(){
        for(String s: this.outStates){
            System.out.println(s);
        }
    }

    private void printTransitions(){
        for(Transition t: this.transitions){
            System.out.println(t.toString());
        }
    }

    public boolean isDFA(){
        for(Transition t: this.transitions){
            if(t.getTo().size() > 1)
                return false;
        }
        return true;
    }

    public boolean isAccepted(String seq){
        String currentState = this.initialState;
        for(int i=0; i<seq.length(); i++){
            String nextState = this.getNextTo(currentState, Character.toString(seq.charAt(i)));
            if(nextState.equals("no state found"))
                return false;
            currentState = nextState;
        }
        return this.outStates.contains(currentState);
    }

    public String getNextTo(String from, String value){
        for(Transition t: this.transitions){
            if(t.getFrom().equals(from) && t.getValue().equals(value)){
                if(t.getTo().size()==1){
                    return t.getTo().get(0);
                }
            }
        }
        return "no state found";
    }
}


