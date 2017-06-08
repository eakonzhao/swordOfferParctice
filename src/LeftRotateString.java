/**
 * Created by Eakon on 2017/6/8.
 * 左旋转字符串
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        StringBuilder sb = new StringBuilder(str);
        if(str!=null&&str.length()!=0){
            int start1 = 0;
            int end1 = n-1;
            int start2 = n;
            int end2 = sb.length()-1;
            Reverse(sb,start1,end1);
            Reverse(sb,start2,end2);
            Reverse(sb,0,sb.length()-1);
        }
        return sb.toString();
    }

    private void Reverse(StringBuilder sb,int start,int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,temp);
        }
    }
}
