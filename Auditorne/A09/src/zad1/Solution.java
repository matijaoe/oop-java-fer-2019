package zad1;

import java.util.*;

class Solution {

    public static void main(String[] args) {

        String[] strings = new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("Input: " + strings);

        System.out.println("Output:\n[");
        List<List<String>> list = groupAnagrams(strings);
        list.forEach(l -> System.out.println("\t" + l));
        System.out.println("]");
    }


    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for (int i = 0; i < strs.length; i++) {

            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(strs[i]);
        }

        map.values().forEach(l -> {
            list.add(l);
            Collections.sort(l);

        });

        return list;
    }
}