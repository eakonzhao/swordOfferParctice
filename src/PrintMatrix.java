import java.util.ArrayList;

/**
 * Created by Eakon on 2017/6/1.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    ArrayList<Integer> list = new ArrayList<>();
    public static void printMatrix(int [][] matrix) {
        if(matrix==null || matrix.length==0){
            return ;
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        int start=0;
        while(rows>start*2 && columns>start*2){
            printMatrixInClockWise(matrix,rows,columns,start);
            start++;
        }
       // return list;
    }

    private static void printMatrixInClockWise(int[][] matrix,int rows,int columns,int start){
        int endX=columns-start-1;
        int endY=rows-start-1;

        //从左到右打印一行
        for(int i=start; i<=endX; i++){
           // list.add(matrix[start][i]);
            System.out.print(matrix[start][i]+" ");
        }

        //从上到下打印一行
       if(start < endY){
            for(int i=start+1; i<=endY; i++){
             //  list.add(matrix[i][endX]);
                System.out.print(matrix[i][endX]+" ");
            }
       }

        //从右往左打印一行
        if(start<endX && start<endY){
        for(int i=endX-1; i>=start; i--){
               // list.add(matrix[endY][i]);
                System.out.print(matrix[endY][i]+" ");
            }
       }

        //从下往上打印一行
        if(start<endX && start<endY){
            for(int i=endY-1; i>=start+1; i--){
                //list.add(matrix[i][start]);
                System.out.print(matrix[i][start]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] array={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[][] array2={{1,2,3,4,5}};
        int[][] array3={
                {1},{2},{3},{4}
        };
        int[][] array4={};
        int[][] array5={{6}};
        printMatrix(array);
        System.out.println();
        printMatrix(array2);
        System.out.println();
        printMatrix(array3);
        System.out.println();
        printMatrix(array4);
        printMatrix(array5);
    }
}
