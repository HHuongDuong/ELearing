public class DictionaryCommandline {
    private Dictionary dictionary;
    private DictionaryManagement dictionaryManagement;

    public DictionaryCommandline() {
        dictionary = new Dictionary(100); // Initial capacity of the dictionary
        dictionaryManagement = new DictionaryManagement();
    }

    public void dictionaryBasic() {
        dictionaryManagement.importFromCSV("resourses/englishDictionary.csv", dictionary); // Replace with the correct file path
        dictionaryManagement.insertFromCommandline(dictionary);
        dictionary.showAllWords();
    }
}
