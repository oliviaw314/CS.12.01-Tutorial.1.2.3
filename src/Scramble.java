import java.util.List;

public class Scramble {

    public static String scrambleWord(String word) {
        StringBuilder scrambledWord = new StringBuilder(word);
        for (int i=0; i<scrambledWord.length()-1; i++) {
            if (scrambledWord.charAt(i)=='A' && scrambledWord.charAt(i+1)!='A') {
                char temp = scrambledWord.charAt(i);
                scrambledWord.setCharAt(i, scrambledWord.charAt(i+1));
                scrambledWord.setCharAt(i+1, temp);
                i++;
                // make sure these two chars are not used in future swaps
                // don't increase char by 2 only increase char by 1 because the for loop alr increases char by 1
            }
        }
        return scrambledWord.toString();
    }

    /*
    Original: ABRACADABRA
              012345678910
    MINE:     BARCA
    Expected :BARCADABARA
Actual   :BARCAADBARA
          012345678910
     */

    public static void scrambleOrRemove(List<String> wordList) {
        for (int i=0; i<wordList.size(); i++) {
            if (scrambleWord(wordList.get(i)).equals(wordList.get(i))) {
                wordList.remove(wordList.get(i));
                i--;
                // because size of word list decreases by 1
            }
            else {
                wordList.set(i, scrambleWord(wordList.get(i)));
            }
        }
    }
}
