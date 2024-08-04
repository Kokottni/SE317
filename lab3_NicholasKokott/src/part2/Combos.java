package part2;

import java.util.ArrayList;
import java.util.List;

public class Combos {

    public static List<String> twoLetterCombos() {
        List<String> combos = new ArrayList<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char c1 : alphabet) {
            for (char c2 : alphabet) {
                combos.add("" + c1 + c2);
            }
        }

        return combos;
    }
    
    public static List<String> threeLetterCombos() {
        List<String> combos = new ArrayList<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char c1 : alphabet) {
            for (char c2 : alphabet) {
                for (char c3 : alphabet) {
                    combos.add("" + c1 + c2 + c3);
                }
            }
        }

        return combos;
    }
	
    
    public static List<String> xLetterCombos(int length) {
        List<String> combos = new ArrayList<>();
        comboMaker("", length, combos);
        return combos;
    }

    private static void comboMaker(String prefix, int length, List<String> combinations) {
        if (length == 0) {
            combinations.add(prefix);
            return;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            comboMaker(prefix + c, length - 1, combinations);
        }
    }
}
