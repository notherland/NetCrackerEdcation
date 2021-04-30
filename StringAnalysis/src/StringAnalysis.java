import java.util.HashMap;
import java.util.Map;

public class StringAnalysis {
    static public Map<Character, Integer> countSymbols(String str){
        Map<Character, Integer> ccount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (!ccount.containsKey(str.charAt(i)))
                count = 0;
            else
                count = count + ccount.get(str.charAt(i));
            ccount.put(str.charAt(i), count + 1);
        }

        return ccount;
    }


}
