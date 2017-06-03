/**
 * Created by Eakon on 2017/5/29.
 */
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("eakon");
        int length = stringBuffer.length();
        System.out.println(length);
        System.out.println(stringBuffer.charAt(length-1));
    }
}
