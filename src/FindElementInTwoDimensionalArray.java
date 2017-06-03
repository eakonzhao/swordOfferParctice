import java.util.Scanner;

/**
 * Created by Eakon on 2017/5/28.
 * 二维数组中的查找
 */
public class FindElementInTwoDimensionalArray {

   private static int[][] array = {
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}
    };

   private static boolean Find(int target, int[][] array){
       boolean flag = false;
        int rows = array.length-1;//行
        int columns = 0;//列
       while( rows>=0 && columns<array[0].length){
            if(array[rows][columns]==target){
                flag=true;break;
            }
            else if(array[rows][columns]<target) columns++;
            else rows--;
       }
       return flag;
   }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int target = scanner.nextInt();
            boolean result = Find(target,array);
            System.out.println(result);
        }
    }
}
