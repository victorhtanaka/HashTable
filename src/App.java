import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static HashtableGood<Integer, String> good = new HashtableGood<>();
    public static HashTableBad<Integer, String> bad = new HashTableBad<>();

    public static void main(String[] args) {
        String filePath = "female_names.txt";
        String[] names = readTXT(filePath);

        System.out.println("Tempo de inserção HashTable 1: " + measureInsertionTime(names) + " Segundos");
//        System.out.println("Tempo de inserção HashTable 2: " + measureInsertionTime(names));

    }

    public static double measureInsertionTime(String[] names) {
        HashtableGood<Integer, String> hashtable = new HashtableGood<>();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < names.length; i++) {
            hashtable.put(i, names[i]);
        }

        long endTime = System.currentTimeMillis();

        double timeInMillis = endTime - startTime;

        return timeInMillis;
    }


    public static void initalChargeGood(String[] names) {
        for (int i = 0; i < names.length; i++) {
            good.put(i, names[i]);
        }
    }

    public static void initalChargeBad(String[] names) {
        for (int i = 0; i < names.length; i++) {
            bad.put(i, names[i]);
        }
    }

    public static String[] readTXT(String filePath) {
        ArrayList<String> namesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                namesList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return namesList.toArray(new String[0]);
    }
}
