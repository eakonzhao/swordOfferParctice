/**
 * Created by Eakon on 2017/6/10.
 *
 * 字符流中第一个不重复的字符
 *
 *题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */

public class FindTheFirstNoRepeatChar {
    int[] charArray = new int[256];
    StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        if(charArray[ch]==0){
            charArray[ch]=1;
        }else{
            charArray[ch]=-1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] resultArray=sb.toString().toCharArray();
                for(char c:resultArray){
                    if(charArray[c]==1){
                        return c;
                    }
                }
                return '#';
    }
}
