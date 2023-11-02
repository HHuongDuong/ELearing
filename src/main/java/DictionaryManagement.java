import java.util.Scanner;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryManagement {
    public void insertFromCommandline(Dictionary dictionary) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words to add: ");
        int numWords = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter English word: ");
            String word_target = scanner.nextLine();

            System.out.print("Enter meaning in Vietnamese: ");
            String word_explain = scanner.nextLine();

            Word word = new Word(word_target, word_explain);
            dictionary.insertWord(word);
        }
    }

    public void importFromCSV(String csvFilePath, Dictionary dictionary) {
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                String word_target = line[0];
                String word_explain = line[2];

                Word word = new Word(word_target, word_explain);
                dictionary.insertWord(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
