/**
 * Created by Eakon on 2017/5/29.
 * 替换空格
 * "We Are Happy"==>>"We%20Are%20Happy"
 */
public class ReplaceSpace {

    private static String replaceSpace(StringBuffer target){
        int oldLength = target.length();
        int spaceCount=0;
        for(int i=0; i<oldLength; i++){
            if(target.charAt(i)==' ') spaceCount++;
        }
        int newLength=oldLength+2*spaceCount;
        target.setLength(newLength);
        oldLength--;
        newLength--;
        while(oldLength>=0 && newLength>=0){
            if(target.charAt(oldLength) == ' '){
                target.setCharAt(newLength--,'0');
                target.setCharAt(newLength--,'2');
                target.setCharAt(newLength--,'%');
            }else {
              target.setCharAt(newLength--,target.charAt(oldLength));
            }
            oldLength--;
        }
        return target.toString();
    }

    public static void main(String[] args) {
      StringBuffer h1 = new StringBuffer("We Are Happy");
      String h2 = replaceSpace(h1);
        System.out.println(h2);
    }
}
