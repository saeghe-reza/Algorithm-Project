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
             int inputHash1 = hash(entry, SEED1);
             int inputHash2 = hash(entry, SEED2);
            if (choice==3) {
            for (String phrase : phrases) {
                int hash1 = hash(phrase, SEED1);
                int hash2 = hash(phrase, SEED2);

                hashMap.put(hash1, phrase);

                bloomFilter.set(hash1);
                bloomFilter.set(hash2);
            }

            long start = System.nanoTime();
            if (bloomFilter.get(inputHash1) && bloomFilter.get(inputHash2)) {
                long end = System.nanoTime();
                System.out.println("Possibly in the list (Bloom Filter).");
                System.out.println("test time is :"+(end-start)/pow(10,4));

                
                if (hashMap.containsKey(inputHash1) && hashMap.get(inputHash1).equals(entry)) {
                    System.out.println("Definitely found in the list (HashMap).");
                } else {
                    System.out.println("False positive detected.");
                }
            } else {
                long end2 =System.nanoTime();
                System.out.println("Definitely not in the list.");
                System.out.println("test time is :"+(end2-start)/pow(10,4));
            }
        }

        else{
            for (String phrase : phrases) {
                int hash1 = hash(phrase, SEED1);

                hashMap.put(hash1, phrase);
            }
            long start1 = System.nanoTime();
            if (hashMap.containsKey(inputHash1) && hashMap.get(inputHash1).equals(entry)) {
                System.out.println("Definitely found in the list.");
            } else {
                System.out.println("Definitely not in the list.");
            }
            long end1 = System.nanoTime();
            System.out.println("test time is :"+(end1-start1)/pow(10,4));
        }
}        
        
}
