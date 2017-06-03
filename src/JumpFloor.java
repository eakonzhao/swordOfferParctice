/**
 * Created by Eakon on 2017/5/30.
 */
public class JumpFloor {
    public int JumpFloor(int n){
        if(n==1||n==2){
            return n;
        }
        int pre=2;
        int prePre=1;
        int result=0;
        for(int i=3; i<=n; i++){
            result = pre+prePre;
            prePre=pre;
            pre=result;
        }
        return result;
    }
}
