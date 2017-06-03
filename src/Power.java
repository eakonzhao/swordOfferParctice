/**
 * Created by Eakon on 2017/5/30.
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Power {

    public static double Power(double base, int exponent) throws Exception {
        double result=1;
        boolean isNegative =false;
        int unSignedExponent=exponent;
        if(exponent<0){
            if(base==0) System.out.println("分母不能为零");
            unSignedExponent=-unSignedExponent;
            isNegative=true;
        }
        result=unSignedPower(base,unSignedExponent);
        return isNegative==false?result:1/result;
    }

    private static double unSignedPower(double base,int exponent){
        if(exponent==0) return 1;
        if(exponent==1) return base;

        double result = unSignedPower(base,exponent>>1);
        result *= result;
        if((exponent&1)==1){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        double result1 = Power(2,5);
        double result2 = Power(4,-2);
        //double result3 = Power(0,-2);
        double result4 = Power(5,0);
        double result5 = Power(0.2,2);
        System.out.println("Power(2,5):"+result1);
        System.out.println("Power(4,-2):"+result2);
       // System.out.println("Power(0,-2)"+result3);
        System.out.println("Power(5,0):"+result4);
        System.out.println("Power(0.2,2)"+result5);
    }
}
