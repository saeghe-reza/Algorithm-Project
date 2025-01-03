public class LinearAndBinarySearch{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        String filePath = "C:\\Users\\hp\\Downloads\\usernames.txt";
        ArrayList<String> database = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                database.add(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        Collections.sort(database);
        
        System.out.print("plz enter your desired name:");
        String target = in.nextLine();
        System.out.print("what are you want to use\n1.linear search:\n2.binary search\n3.hashAndBloomFilter:");
        
               
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