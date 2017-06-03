/**
 * Created by Eakon on 2017/5/30.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array){
        if(array==null || array.length==0){
            return 0;
        }
        int left=0;
        int right=array.length-1;
        int mid=0;
        while(right-left!=1){
            mid=(left+right)/2;
            if(array[left]<array[right]){
                return array[left];
            }
            if(array[left]==array[right] && array[left]==array[mid]){
                return minNumberInRotateArray(array,left,right);
            }
            if(array[left]<=array[mid]){
                left=mid;
            }else{
                right=mid;
            }
        }
        return array[right];
    }

    private static int minNumberInRotateArray(int[] array,int left,int right){
        int min = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] array1 = {2,2,2,1,2};
        int[] array2 = {1,2,3,4,5};
        int[] array3 = {3,4,5,2};
        System.out.println("min in array1:"+minNumberInRotateArray(array1));
        System.out.println("min in array2:"+minNumberInRotateArray(array2));
        System.out.println("min in array3:"+minNumberInRotateArray(array3));
    }
}
