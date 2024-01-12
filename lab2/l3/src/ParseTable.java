import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ParseTable {
    private Map<MyPair<String, String>, MyPair<String, List<String>>> table = new HashMap<>();

    public void put(MyPair<String, String> key, MyPair<String, List<String>> value) {
        table.put(key, value);
    }

    public MyPair<String, String> getKey(String nonTerminal, String element) {
        return this.table.keySet()
                .stream()
                .filter(pair -> pair.getKey().equals(nonTerminal) && pair.getValue().equals(element))
                .findFirst()
                .orElse(null);  // or handle the case when no match is found
    }


    public MyPair<String, List<String>> get(MyPair<String, String> key) {
        for (Map.Entry<MyPair<String, String>, MyPair<String, List<String>>> entry : table.entrySet()) {
            if (entry.getValue() != null) {
                MyPair<String, String> currentKey = entry.getKey();
                MyPair<String, List<String>> currentValue = entry.getValue();

                if (currentKey.getKey().equals(key.getKey()) && currentKey.getValue().equals(key.getValue())) {
                    return currentValue;
                }
            }
        }

        return null;
    }

    public boolean containsKey(MyPair<String, String> key) {
        boolean result = false;
        for (MyPair<String, String> currentKey : table.keySet()) {
            if (currentKey.getKey().equals(key.getKey()) && currentKey.getValue().equals(key.getValue())) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<MyPair<String, String>, MyPair<String, List<String>>> entry : table.entrySet()) {
            if (entry.getValue() != null) {
                MyPair<String, String> key = entry.getKey();
                MyPair<String, List<String>> value = entry.getValue();

                sb.append("M[").append(key.getKey()).append(",").append(key.getValue()).append("] = ")
                        .append(value.getKey()).append(" --> ").append(value.getValue()).append("\n");
            }
        }

        return sb.toString();
    }

}

