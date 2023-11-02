import java.util.Scanner;

public class Word {
    private String word_target; // từ vựng tiếng Anh
    private String word_explain; // giải nghĩa tiếng Việt

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public String getWordTarget() {
        return word_target;
    }

    public String getWordExplain() {
        return word_explain;
    }

    public String toString() {
        return String.format("%s | %s", word_target, word_explain);
    }

    public void enter(Scanner scanner) {
        scanner = new Scanner(System.in);
        scanner.nextLine();
        word_target = scanner.nextLine();
        scanner.nextLine();
        word_explain = scanner.nextLine();
    }
}
