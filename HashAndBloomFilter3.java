import java.util.ArrayList;
import java.util.HashMap;


public class HashAndBloomFilter3 {

    private static int SIZE = 1000 ; 
    private static final int SEED1 = 31; 
    private static final int SEED2 = 37; 


    public static int hash(String item, int seed) {
        int hash = 0;
        for (char c : item.toCharArray()) {
            hash = (seed * hash + c) % SIZE;
        }
        return Math.abs(hash);
    }

public static void containsInBloomFilter(ArrayList<String> phrases,String entry,int choice) {

        
        HashMap<Integer, String> hashMap = new HashMap<>();
    
            BitSet bloomFilter = new BitSet(SIZE);

            for (String phrase : phrases) {
                int hash1 = hash(phrase, SEED1);
                int hash2 = hash(phrase, SEED2);

                hashMap.put(hash1, phrase);

                bloomFilter.set(hash1);
                bloomFilter.set(hash2);
            }
            
        
}