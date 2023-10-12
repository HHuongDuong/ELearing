public class DictionaryCommandLine {
    private Dictionary dictionary;
    private DictionaryManagement dictionaryManagement;

    public DictionaryCommandLine() {
        dictionary = new Dictionary(100); // Initial capacity of the dictionary
        dictionaryManagement = new DictionaryManagement();
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline(dictionary);
        dictionary.showAllWords();
    }
}

