public class Dictionary {
    private Word[] words;
    private int wordCount;

    public Dictionary(int capacity) {
        words = new Word[capacity];
        wordCount = 0;
    }

    public void insertWord(Word word) {
        if (wordCount < words.length) {
            words[wordCount] = word;
            wordCount++;
        } else {
            System.out.println("The dictionary is full!");
        }
    }

    public void showAllWords() {
        System.out.println("No | English | Vietnamese");
        for (int i = 0; i < wordCount; i++) {
            System.out.printf("%d | %s\n", i + 1, words[i]);
        }
    }
}
