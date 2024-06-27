import java.util.*;

public class WordLadderLengthOfTransformation {
    public static void main(String[] args) {
        String startWord = "toon";
        String targetWord = "plea";
        // Sequence : TOON – POON – POIN – POIE – PLIE – PLEE – PLEA
        System.out.println("Length of transformation : " + getLadderLength(startWord, targetWord, List.of("poon", "plee", "same", "poie", "plea", "plie", "poin")));
    }

    private static int getLadderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair_3> queue = new LinkedList<>();
        queue.add(new Pair_3(beginWord, 1));
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!queue.isEmpty()) {
            String word = queue.peek().word;
            int transformationNumber = queue.peek().transformationNumber;
            queue.poll();
            if(word.equals(endWord)) {
                return transformationNumber;
            }
            for(int i=0;i<word.length();i++) {
                for(char ch = 'a'; ch <= 'z';ch++) {
                    char[] temp = word.toCharArray();
                    temp[i] = ch;
                    String newWord = new String(temp);
                    if(set.contains(newWord)) {
                        set.remove(newWord);
                        queue.add(new Pair_3(newWord, transformationNumber + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair_3 {
    String word;
    int transformationNumber;

    public Pair_3(String word, int transformationNumber) {
        this.word = word;
        this.transformationNumber = transformationNumber;
    }
}
