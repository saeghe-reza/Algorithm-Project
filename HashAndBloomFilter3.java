import java.util.ArrayList;
import java.util.HashMap;


public class HashAndBloomFilter3 {

    private static int SIZE ; 
    private static final int SEED1 = 31; 
    private static final int SEED2 = 37; 


    public static int hash(String item, int seed) {
        int hash = 0;
        for (char c : item.toCharArray()) {
            hash = (seed * hash + c) % SIZE;
        }
        return Math.abs(hash);
    }