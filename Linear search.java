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