/**
 * Created by Eakon on 2017/6/13.
 *
 * 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMovingCount {
    public int movingCount(int threshold,int rows,int cols){
        if(threshold<0) return 0;
        boolean[][] dp = new boolean[rows][cols];
        dp[0][0] = true;
        //初始化第0列
        for(int i=1; i<rows; i++){
            if(dp[i-1][0]&&canReach(threshold,i,0)){
                dp[i][0]=true;
            }else{
                dp[i][0]=false;
            }
        }
        //初始化第0行
        for(int i=1; i<cols; i++){
            if(dp[0][i-1]&&canReach(threshold,0,i)){
                dp[0][i]=true;
            }else{
                dp[0][i]=false;
            }
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if( (dp[i-1][j]&&canReach(threshold,i,j)) || (dp[i][j-1]&&canReach(threshold,i,j))){
                    dp[i][j]=true;
                }else{
                    dp[i][j]=false;
                }
            }
        }
        int count=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(dp[i][j]) count++;
            }
        }
        return count;
    }

    private boolean canReach(int threshold,int x,int y){
        int sum=0;
        while(x>0){
            sum+=x%10;
            x/=10;
        }
        while(y>0){
            sum+=y%10;
            y/=10;
        }
        return sum<=threshold?true:false;
    }
}
