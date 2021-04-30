import java.util.*;

public class Program {

    static public void main(String[] argv) {
        String str1 = "wugfucbqioc265e6jowesuiqpwo bqicuwn";
        String str2 = "JBJKB@jb1bkjbcwoq37yfb2iqb";

        Map<Character, Integer> map1 = StringAnalysis.countSymbols(str1);
        Map<Character, Integer> map2 = StringAnalysis.countSymbols(str2);
        TreeSet<Character> symbolsBoth = new TreeSet<>();
        TreeSet<Character> symbolsFirst = new TreeSet<>();
        TreeSet<Character> symbolsFirstorSecond = new TreeSet<>();

        System.out.println(map1);
        System.out.println(map2);

        for (Map.Entry<Character, Integer> item : map1.entrySet()) {
            if (map2.containsKey(item.getKey()))
                symbolsBoth.add(item.getKey());
        }

        System.out.println(symbolsBoth);
        System.out.println(symbolsBoth.descendingSet());

        for (Map.Entry<Character, Integer> item : map1.entrySet()) {
            if (!map2.containsKey(item.getKey()))
                symbolsFirst.add(item.getKey());
        }

        System.out.println(symbolsFirst);
        System.out.println(symbolsFirst.descendingSet());

        for (Map.Entry<Character, Integer> item : map1.entrySet()) {
            symbolsFirstorSecond.add(item.getKey());
        }

        for (Map.Entry<Character, Integer> item : map2.entrySet()) {
            symbolsFirstorSecond.add(item.getKey());
        }

        System.out.println(symbolsFirstorSecond);
        System.out.println(symbolsFirstorSecond.descendingSet());

    }
}
