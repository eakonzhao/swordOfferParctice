/**
 * Created by Eakon on 2017/6/9.
 *
 * 把字符串换成整数
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 *
 * 输入一个字符串,包括数字字母符号,可以为空
 *
 * 输出描述:
 *
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 输入例子:
 * +2147483647
 * 1a33
 *
 * 输出例子：
 * 2147483647
 * 0
 */
public class StrToInt {
    public static int StrToInt(String str){
        if(str==null||str.length()==0) return 0;
        boolean negative=false;
        int limit=-Integer.MAX_VALUE;
        int result=0;
        int index=0;
        int digit;
        if(str.charAt(index)<'0'){
            if(str.charAt(index)=='-'){
                negative=true;
                limit=Integer.MIN_VALUE;
            }else if(str.charAt(index)!='+'){
                return 0;
            }
            if(str.length()==1){
                return 0;
            }
            index++;
        }
        int multMin=limit/10;
        while(index<str.length()){
            digit=Character.digit(str.charAt(index++),10);
            if(digit<0||digit>9) return 0;
            if(result<multMin) return 0;
            result *= 10;
            if(result<limit+digit){
                return 0;
            }
            result -= digit;
        }
        return negative?result:-result;
    }
}
