import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        SortedMap<String, Integer> dictionary = new TreeMap<>(Comparator.naturalOrder());
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the path to the source file: ");
        String path1 = in.nextLine();
        File in_file = new File(path1);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(in_file));
            int symbol;
            while ((symbol = reader.read()) != -1) {
                if (dictionary.containsKey(String.valueOf((char) symbol))) {
                    int tmp = dictionary.get(String.valueOf((char) symbol)) + 1;
                    dictionary.put(String.valueOf((char) symbol), tmp);
                } else {
                    dictionary.put(String.valueOf((char) symbol), 1);
                }
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File " + path1 + "is not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.out.println("I/O error.");
            System.exit(-1);
        }
        System.out.print("Enter the path to the file you want to get the result: ");
        String path2 = in.nextLine();
        in.close();
        File out_file = new File(path2);
        try {
            FileWriter reader2 = new FileWriter(out_file);
            for (String key : dictionary.keySet()) {
                reader2.write(key + " = " + dictionary.get(key) + '\n');
            }
            reader2.close();
        } catch (IOException ex) {
            System.out.println("I/O error.");
            System.exit(-1);
        }
    }
}
