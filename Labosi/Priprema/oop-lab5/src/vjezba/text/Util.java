package vjezba.text;

import java.util.*;

class Util {

    public static List<String> readText(String text) {

        List<String> list = new ArrayList<>();

        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            words[i] = words[i].replaceAll("[\\W]", "");
            list.add(words[i]);
        }
        return list;
    }

    public static Set<String> notInDictionary(List<String> wordsInText, Set<String> dictionary) {
        Set<String> notInDic = new TreeSet<>();

        for (String word : wordsInText) {
            if (!dictionary.contains(word)) {
                notInDic.add(word);
            }
        }
        return notInDic;
    }

    public static void main(String[] args) {

        String text = "All that is a miracle, it prints all words from that " +
                "sentence that are not in the dictionary.";
        String[] dictionary = new String[] {
                "a", "the", "in", "from", "not", "is", "are", "this", "that"
        };
        List<String> list = Arrays.asList(dictionary);
        Set<String> set = new HashSet<>(list);

        System.out.println(readText(text));
        System.out.println(notInDictionary(readText(text), set));

//        System.out.println(readText(""));
//        System.out.println(notInDictionary(readText(""), set));

    }
}
