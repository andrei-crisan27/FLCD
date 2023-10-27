public class SymbolTable {

    private int size;
    private HashTable hashTable;

    public SymbolTable(int size){
        hashTable = new HashTable(size);
    }

    public HashTable getHashTable(){
        return hashTable;
    }

    public boolean add(String term){
        return hashTable.add(term);
    }

    public String findByPos(Pair pos){
        return hashTable.findByKey(pos);
    }

    public int getSize(){
        return hashTable.getSize();
    }

    public Pair findPositionOfTerm(String term){
        return hashTable.findPosition(term);
    }

    public boolean containsTerm(String term){
        return hashTable.containsTerm(term);
    }
}