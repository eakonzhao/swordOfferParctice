/**
 * Created by Eakon on 2017/6/5.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 *
 * 时间复杂度 O(logn)
 * csdn最优解:http://blog.csdn.net/yi_afly/article/details/52012593
 */
public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n<1) return 0;
        int count=0;
        int weight=0;
        int round=n;
        int base=1;
        while(round>0){
            weight=round%10;
            round /= 10;
            count += round*base;
            if(weight==1){
                count += (n%base)+1;
            }else if(weight>1){
                count += base;
            }
            base *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = NumberOf1Between1AndN_Solution(13);
        System.out.println(count);
    }
}
