import java.util.Scanner;

public class DictionaryCommandLine {
    private DictionaryManagement dictionaryManagement;

    public DictionaryCommandLine(int capacity) {
        dictionaryManagement = new DictionaryManagement(capacity);
    }

    public void showMenu() {
        System.out.println("Welcome to My Application!");
        System.out.println("[0] Exit");
        System.out.println("[1] Add a word");
        System.out.println("[2] Remove a word");
        System.out.println("[3] Update a word");
        System.out.println("[4] Display all words");
        System.out.println("[5] Lookup a word");
        System.out.println("[6] Search for words");
        System.out.println("[7] Game");
        System.out.println("[8] Import words from a file");
        System.out.println("[9] Export words to a file");
    }

    public void dictionaryAdvanced() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Your action: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // Exit
                case 0:
                    System.out.println("Exiting the application.");
                    break;
                // Add a word
                case 1:
                    System.out.print("Enter the English word: ");
                    String word_target = scanner.nextLine();
                    System.out.print("Enter the Vietnamese explanation: ");
                    String word_explain = scanner.nextLine();
                    dictionaryManagement.addWord(word_target, word_explain);
                    break;
                //Remove a word
                case 2:
                    System.out.print("Enter the English word to remove: ");
                    String wordToRemove = scanner.nextLine();
                    dictionaryManagement.removeWord(wordToRemove);
                    break;
                // update a word
                case 3:
                    System.out.print("Enter the English word to update: ");
                    String wordToUpdate = scanner.nextLine();
                    System.out.print("Enter the new Vietnamese explanation: ");
                    String newExplanation = scanner.nextLine();
                    dictionaryManagement.updateWord(wordToUpdate, newExplanation);
                    break;
                // Display words
                case 4:
                    dictionaryManagement.dictionaryDisplayAllWords();
                    break;
                // Look up a word
                case 5:
                    System.out.print("Enter the English word to lookup: ");
                    String wordToLookup = scanner.nextLine();
                    dictionaryManagement.dictionaryLookup(wordToLookup);
                    break;
                // Search for a word
                case 6:
                    System.out.print("Enter the prefix to search: ");
                    String searchPrefix = scanner.nextLine();
                    dictionaryManagement.dictionarySearch(searchPrefix);
                    break;
                // Game (need an update!)
                case 7:
                    // Game
                    break;
                // Import data
                case 8:
                    System.out.print("Enter the filename to import from: ");
                    String importFileName = scanner.nextLine();
                    dictionaryManagement.insertFromFile(importFileName);
                    System.out.println("Imported data from " + importFileName);
                    break;
                // Export data
                case 9:
                    System.out.print("Enter the filename to export to: ");
                    String exportFileName = scanner.nextLine();
                    dictionaryManagement.dictionaryExportToFile(exportFileName);
                    System.out.println("Exported data to " + exportFileName);
                    break;
                default:
                    System.out.println("Action not supported.");
            }
        } while (choice != 0);
    }
}


