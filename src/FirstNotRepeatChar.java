/**
 * Created by Eakon on 2017/6/6.
 *
 * 第一个只出现一次的字符
 *
 * 在一个字符串(1<=字符串长度<=10000，
 * 全部由大写字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置
 */

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatChar {
    public static int FirstNotRepeatingChar(String str) {
        if(str!=null||str.length()!=0) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (charMap.get(str.charAt(i)) != null) charMap.put(str.charAt(i), charMap.get(str.charAt(i)) + 1);
                else charMap.put(str.charAt(i), 1);
            }
            for (int i = 0; i < str.length(); i++) {
                if (charMap.get(str.charAt(i)) == 1) return i;
            }
        }
        return -1;
    }
}
