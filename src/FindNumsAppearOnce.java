/**
 * Created by Eakon on 2017/6/8.
 *
 * 数组中只出现一次的数字
 *
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<2) return ;
        int orResult = 0;
        int length=array.length;
        for(int i=0; i<length; i++){
            orResult ^= array[i];
        }
        int indexOf1InBits = findIndexOf1InBits(orResult);
        num1[0] = 0;
        num2[0] = 0;
        for(int i=0; i<length; i++){
            if(judgeTheIndexIs1(array[i],indexOf1InBits)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private int findIndexOf1InBits(int number){
        int index=0;
        while((number!=0)&&index<32){
            if((number&1)==1&&index<32){
                return index;
            }
            number >>= 1;
            index++;
        }
        return index;
    }

    private boolean judgeTheIndexIs1(int number, int indexOf1InBits){
        return ((number>>indexOf1InBits)&1)==1?true:false;
    }
}
