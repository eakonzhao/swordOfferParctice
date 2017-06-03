import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Eakon on 2017/6/3.
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class PermutationString {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str!=null && str.length()>0){
            Permutation(str.toCharArray(),0,result);
            Collections.sort(result);
        }
        return result;
    }


    private void Permutation(char[] letterArray,int letterIndex, ArrayList<String> list){
        if(letterArray==null || letterArray.length ==0) return ;
        if(letterIndex==letterArray.length-1){
            if(list.contains(String.valueOf(letterArray))) return;
            list.add(String.valueOf(letterArray));
        }else{
            for(int i=letterIndex; i<letterArray.length; i++){
                char temp = letterArray[i];
                letterArray[i] = letterArray[letterIndex];
                letterArray[letterIndex] = temp;

                Permutation(letterArray,letterIndex,list);

                temp = letterArray[i];
                letterArray[i] = letterArray[letterIndex];
                letterArray[letterIndex] = temp;
            }
        }
    }
}
