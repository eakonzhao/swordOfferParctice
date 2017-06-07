/**
 * Created by Eakon on 2017/6/7.
 *
 * 数组在排序数组中出现的次数
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        if(array!=null||array.length!=0){
            int length = array.length;
            int firstIndexOfK = getFirstIndexOfK(array,k,0,length-1);
            int lastIndexOfK = getLastIndexOfK(array,k,0,length-1);
            if(firstIndexOfK>-1&&lastIndexOfK>-1){
                count = (lastIndexOfK-firstIndexOfK)+1;
            }
        }
        return count;
    }

    private int getFirstIndexOfK(int[]array, int k, int start, int end){
        if(start>end) return -1;
        int mid=(start+end)>>1;
        if(array[mid]==k){
            if((mid>0&&array[mid-1]!=k)||mid==0){
                return mid;
            }else{
                end=mid-1;
            }
        }else if(array[mid]>k){
            end=mid-1;
        }else if(array[mid]<k){
            start=mid+1;
        }
        return getFirstIndexOfK(array,k,start,end);
    }

    private int getLastIndexOfK(int[]array, int k, int start, int end){
        if(start>end) return -1;
        int mid=(start+end)>>1;
        if(array[mid]==k){
            if((mid<array.length-1&&array[mid+1]!=k)||mid==array.length-1){
                return mid;
            }else{
                start=mid+1;
            }
        }else if(array[mid]>k){
            end=mid-1;
        }else if(array[mid]<k){
            start=mid+1;
        }
        return getLastIndexOfK(array,k,start,end);
    }
}
