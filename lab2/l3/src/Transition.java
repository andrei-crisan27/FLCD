import java.util.List;

public class Transition {
    private String from;
    private String value;
    private List<String> to;

    public Transition(String from, String value, List<String> to){
        this.from = from;
        this.value = value;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getValue() {
        return value;
    }

    public List<String> getTo() {
        return to;
    }

    public void setFrom(String from) { this.from = from; }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String s: to){
            sb.append(s + " ");
        }
        return "From: " + this.from + ", Value: " + this.value + ", To: " + sb.toString();
    }
}
