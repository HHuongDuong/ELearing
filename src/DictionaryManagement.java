import java.io.*;
import java.util.ArrayList;

public class DictionaryManagement {
    private Dictionary dictionary;

    public DictionaryManagement(int capacity) {
        dictionary = new Dictionary(capacity);
    }

    public void insertFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String word_target = parts[0];
                    String word_explain = parts[1];
                    dictionary.insertWord(word_target, word_explain);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addWord(String word_target, String word_explain) {
        dictionary.insertWord(word_target, word_explain);
    }

    // Remove a word
    public void removeWord(String word_target) {
        ArrayList<Word> words = dictionary.getWords();
        int indexToRemove = -1;
    
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWordTarget().equalsIgnoreCase(word_target)) {
                indexToRemove = i;
                break;
            }
        }
    
        if (indexToRemove != -1) {
            words.remove(indexToRemove);
            System.out.println("Removed the word: " + word_target);
        } else {
            System.out.println("Word not found: " + word_target);
        }
    }
    
    // Update a word
    public void updateWord(String word_target, String newWord_explain) {
       ArrayList<Word> words = dictionary.getWords();
        boolean updated = false;
    
        for (Word word : words) {
            if (word.getWordTarget().equalsIgnoreCase(word_target)) {
                word.setWordExplain(newWord_explain);
                System.out.println("Updated word: " + word_target);
                updated = true;
                break;
            }
        }
    
        if (!updated) {
            System.out.println("Word not found: " + word_target);
        }
        }

    // Implement exporting data to a file
    public void dictionaryExportToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        for (Word word : dictionary.getWords()) {
            writer.write(word.getWordTarget() + "\t" + word.getWordExplain());
            writer.newLine();
        }
            System.out.println("Exported data to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to export data to " + fileName);
        }
    }

    public ArrayList<Word> searchWords(String prefix) {
        ArrayList<Word> searchResults = new ArrayList<>();
        for (Word word : dictionary.getWords()) {
            if (word.getWordTarget().startsWith(prefix)) {
                searchResults.add(word);
            }
        }
        return searchResults;
    }
}


