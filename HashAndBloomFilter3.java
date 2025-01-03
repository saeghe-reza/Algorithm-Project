import java.util.ArrayList;
import java.util.HashMap;
import java.util.BitSet;
import static java.lang.StrictMath.pow;

public class HashAndBloomFilter3 {

    private static int SIZE ; // اندازه بلوم فیلتر
    private static final int SEED1 = 31; // مقدار اول برای تابع هش
    private static final int SEED2 = 37; // مقدار دوم برای تابع هش

    // متد هش
    public static int hash(String item, int seed) {
        int hash = 0;
        for (char c : item.toCharArray()) {
            hash = (seed * hash + c) % SIZE;
        }
        return Math.abs(hash);
    }

public static void containsInBloomFilter(ArrayList<String> phrases,String entry,int choice) {
        // ساخت هش‌مپ برای ذخیره عبارات و هش‌هایشان
        HashMap<Integer, String> hashMap = new HashMap<>();
        // محاسبات
        double p = 0.000001;
        SIZE = (int) Math.ceil(-phrases.size() * Math.log(p) / (Math.pow(Math.log(2), 2)));

            BitSet bloomFilter = new BitSet(SIZE);
             int inputHash1 = hash(entry, SEED1);
             int inputHash2 = hash(entry, SEED2);
             // افزودن عبارات به هش‌مپ و بلوم فیلتر
            if (choice==3) {
                // ساخت بلوم فیلتر
            for (String phrase : phrases) {
                int hash1 = hash(phrase, SEED1);
                int hash2 = hash(phrase, SEED2);
                // ذخیره در هش‌مپ
                hashMap.put(hash1, phrase);
                // تنظیم بیت‌ها در بلوم فیلتر
                bloomFilter.set(hash1);
                bloomFilter.set(hash2);
            }
            // جستجو در بلوم فیلتر
            long start = System.nanoTime();
            if (bloomFilter.get(inputHash1) && bloomFilter.get(inputHash2)) {
                long end = System.nanoTime();
                System.out.println("Possibly in the list (Bloom Filter).");
                System.out.println("test time is :"+(end-start)/pow(10,4));

                // جستجو در هش‌مپ
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
                // ذخیره در هش‌مپ
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
