/**
 * Created by Eakon on 2017/5/30.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {


    /*public static void reOrderArray(int[] array){
        if(array == null || array.length == 0){
            return ;
        }
        int j = 0,i =0;
        while(i<array.length){
            while(i<array.length && !isEven(array[i])){
                i++;
            }
            j = i+1;
            while(j<array.length && isEven(array[j])){
                j++;
            }
            if(j<array.length){
                int tmp = array[j];
                for(int k = j-1;k>=i;k--){
                    array[k+1] = array[k];
                }
                array[i] = tmp;
            }else{
                return ;
            }
        }
    }*/

   public static void reOrderArray(int[] array){
       if(array==null || array.length==0){
           return ;
       }
       int length=array.length;
       int evenIndex=0,oddIndex=0;
       while(evenIndex<length){
           while(evenIndex<length && isOdd(array[evenIndex])) evenIndex++;
           oddIndex=evenIndex+1;
           while(oddIndex<length && !isOdd(array[oddIndex])) oddIndex++;

           if(oddIndex<length){
               int temp = array[oddIndex];
               for(int k=oddIndex-1; k>=evenIndex; k--){
                   array[k+1]=array[k];
               }
               array[evenIndex]=temp;
           }else{
               return ;
           }
       }
   }


    private static boolean isEven(int num){
        return ((num&1)==0)?true:false;
    }

    /*public static void reOrderArray(int[] array){
        if(array==null||array.length==0){
            return ;
        }
        int left=0;
        int right=array.length-1;
        while(left<right){
            while(left<right && isOdd(array[left])) left++;
            while(left<right && !isOdd(array[right])) right--;
            if(left<right) swap(array,left,right);
        }
    }*/


    private static boolean isOdd(int target){
        return (target&1)==1?true:false;
    }

    private static  void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private static void printArray(String desc,int[] array){
        System.out.printf(desc+": ");
        for(int i=0; i<array.length; i++){
            System.out.printf(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array = {2,10,4,5,9,6,3,2,5,8,7};
        printArray("before reOrder",array);
        reOrderArray(array);
        printArray("after reOrder",array);
    }


}
