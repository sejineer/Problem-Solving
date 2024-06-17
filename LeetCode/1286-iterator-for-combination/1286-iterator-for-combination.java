import java.util.*;

class CombinationIterator {
    
    int combinationLength, idx;
    String characters;
    List<String> combination;
    int[] arr;
    boolean[] isUsed;

    public CombinationIterator(String characters, int combinationLength) {
        this.isUsed = new boolean[characters.length()];
        this.arr = new int[characters.length()];
        this.combinationLength = combinationLength;
        this.idx = 0;
        this.characters = characters;
        combination = new ArrayList<>();
        func(0, 0);
    }
    
    public String next() {
        return combination.get(idx++);
    }
    
    public boolean hasNext() {
        return !(idx >= combination.size());
    }
    
    private void func(int k, int idx) {
        if(k == combinationLength) {
            String s = "";
            for(int i = 0; i < combinationLength; i++) {
                s += characters.charAt(arr[i]);
            }
            combination.add(s);
        }
        for(int i = idx; i < characters.length(); i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */