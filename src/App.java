import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static HashtableGood<Integer, String> good = new HashtableGood<>();
    public static HashTableBad<Integer, String> bad = new HashTableBad<>();

    public static void main(String[] args) {
        String filePath = "src/female_names.txt";
        ArrayList<String> names = readTXT(filePath);

        System.out.println("Tempo de inserção HashTable 1: " + measureInsertionTime(names) + " Nanosegundos");
        System.out.println("Colisões: " + good.getCollisions());

        System.out.println("Tempo de inserção HashTable 2: " + measureInsertionTime2(names) + " Nanosegundos");
        System.out.println("Colisões: " + bad.getCollisions());

        System.out.println("Tempo de recuperação HashTable 1: " + getRetrieveTime() + " Nanosegundos");
        System.out.println("Tempo de recuperação HashTable 2: " + getRetrieveTime2() + " Nanosegundos");
    }

    public static long measureInsertionTime(ArrayList<String> names) {
        long startTime = System.nanoTime();

        for (int i = 0; i < names.size(); i++) {
            good.put(i, names.get(i));
        }

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static long measureInsertionTime2(ArrayList<String> names) {
        long startTime = System.nanoTime();

        for (int i = 0; i < names.size(); i++) {
            bad.put(i, names.get(i));
        }

        long endTime = System.nanoTime();

        return endTime - startTime;
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

    public static long getRetrieveTime() {
        long startTime = System.nanoTime();
        good.get(10);
        good.get(3657);
        good.get(157);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long getRetrieveTime2() {
        long startTime = System.nanoTime();
        bad.get(10);
        bad.get(3657);
        bad.get(157);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
