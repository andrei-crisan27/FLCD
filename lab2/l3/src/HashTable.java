import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private List<List<String>> table;
    private int size;

    public HashTable(int size){
        this.size = size;
        this.table = new ArrayList<>();
        for(int i = 0; i < size; i++){
            this.table.add(new ArrayList<>());
        }
    }

    public int getSize(){
        return size;
    }

    public boolean containsTerm(String term){
        return this.findPosition(term) != null;
    }

    private int hash(String key){
        int sumOfAsciiCodes = 0;
        char[] key_characters = key.toCharArray();
        for(char c: key_characters){
            sumOfAsciiCodes += c;
        }
        return sumOfAsciiCodes % size;
    }

    public boolean add(String term){
        if(containsTerm(term)){
            return false;
        }
        int pos = hash(term);
        List<String> elems = this.table.get(pos);
        elems.add(term);
        return true;
    }

    public String findByKey(Pair key){
        if(this.table.size() <= key.getMainArrayPosition() || this.table.get(key.getMainArrayPosition()).size() <= key.getSecondaryArrayPosition()){
            throw new IndexOutOfBoundsException("Invalid position");
        }

        return this.table.get(key.getMainArrayPosition()).get(key.getSecondaryArrayPosition());
    }

    public Pair findPosition(String term){
        int pos = hash(term);
        if(!table.get(pos).isEmpty()){
            List<String> elems = this.table.get(pos);
            for(int i = 0; i < elems.size(); i++){
                if(elems.get(i).equals(term)){
                    return new Pair(pos, i);
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return table.toString();
    }
}