import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static HashtableGood<Integer, String> good = new HashtableGood<>();
    public static HashTableBad<Integer, String> bad = new HashTableBad<>();

    public static void main(String[] args) {
        String filePath = "src/female_names.txt";
        ArrayList<String> names = readTXT(filePath);

        System.out.println("Tempo de inserção HashTable 1: " + measureInsertionTime(names) + " Segundos");
        System.out.println(good.table.length);
        System.out.println("Colisões: " + good.getCollisions());

        System.out.println("Tempo de inserção HashTable 2: " + measureInsertionTime2(names) + " Segundos");
        System.out.println(bad.table.length);
        System.out.println("Colisões: " + bad.getCollisions());
    }

    public static double measureInsertionTime(ArrayList<String> names) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < names.size(); i++) {
            good.put(i, names.get(i));
        }

        long endTime = System.currentTimeMillis();

        return (double) (endTime - startTime) / 1000;
    }

    public static double measureInsertionTime2(ArrayList<String> names) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < names.size(); i++) {
            bad.put(i, names.get(i));
        }

        long endTime = System.currentTimeMillis();

        return (double) (endTime - startTime) / 1000;
    }

    public static ArrayList<String> readTXT(String filePath) {
        ArrayList<String> namesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                namesList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return namesList;
    }
}
