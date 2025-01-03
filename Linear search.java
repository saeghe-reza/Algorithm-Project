import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.StrictMath.pow;

public class LinearAndBinarySearch{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //مسیر فایل رو انتخاب میکنیم
        String filePath = "C:\\Users\\hp\\Downloads\\usernames.txt";
        ArrayList<String> database = new ArrayList<>();
        //تعریف فایل ریدر برای خواندن فایل
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                database.add(line);
            }
            //اظافه کردن هر خط به لیست ارایه ی database
        } catch (IOException e) {
            e.printStackTrace();
        }
        //مرتب سازی
        Collections.sort(database);
        //گرفتن ورودی
        System.out.print("plz enter your desired name:");
        String target = in.nextLine();
        System.out.print("what are you want to use\n1.linear search:\n2.binary search\n3.hashAndBloomFilter:");
        switch (in.nextInt()) {
            case 1: {
            //جستجوی خطی
                //پیمایش تمام اعضا از ابتدا
                long start = System.nanoTime();
                for (int i = 0; i < database.size(); i++) {
                    if (database.get(i).equals(target)) {
                        long end = System.nanoTime();
                        System.out.println("phrase \"" + target + "\" in index " + database.indexOf(target) + " find.");
                        System.out.println("test time is :"+(end-start)/pow(10,4));
                        break;
                    }
                    if (i == database.size() - 1) {
                        long end2 = System.nanoTime();
                        System.out.println("phrase \"" + target + "\" not find.");
                        System.out.println("test time is :"+(end2-start)/pow(10,4));
                    }   
            }
            break;
            }
            case 2: {
                //جستجوی باینری
                long start = System.nanoTime();
                //ارجاع به تابع
                int resultIndex = binarySearch(database, target);
                if (resultIndex != -1) {
                    long end = System.nanoTime();
                    System.out.println("phrase \"" + target + "\" in index " + resultIndex + " find.");
                    System.out.println("test time is :"+(end-start)/pow(10,4));
                } else {
                    long end1 = System.nanoTime();
                    System.out.println("phrase \"" + target + "\" not find.");
                    System.out.println("test time is :"+(end1-start)/pow(10,4));
                }
                break;
            }
            case 3: {
                //جستجوی هش و بلوم فیلتر
                HashAndBloomFilter3.containsInBloomFilter(database,target);
                break;
            }
            default:
                System.out.println("YOUR ENTRY IS NOT CORRECT!!");
        }
}

 public static int binarySearch(ArrayList<String> database, String target) {
        //عضو سمت چپ(اولی)
        int left = 0;
        //عضو سمت راست اخری
        int right = database.size() - 1;
        //حلقه تا زمانی ادامه دارد که دو عنصر چپ و راست به هم برسند
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int comparison = target.compareTo(database.get(mid));

            if (comparison == 0) {
                //برگرداندن عنصر میانی
                return mid;
            }
            //مقایسه ورودی یا عنصر میانی
            if (comparison > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
    }
