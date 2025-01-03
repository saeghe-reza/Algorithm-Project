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



                long start = System.nanoTime();

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



 public static int binarySearch(ArrayList<String> database, String target) {
       
        int left = 0;
        
        int right = database.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int comparison = target.compareTo(database.get(mid));

            if (comparison == 0) {
                
                return mid;
            }
            
            if (comparison > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }