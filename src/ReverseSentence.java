/**
 * Created by Eakon on 2017/6/8.
 *
 * 翻转单词顺序
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，
 * 你能帮助他么？
 */
public class ReverseSentence {
    public  String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder(str);
        if(str!=null){
            Reverse(sb,0,sb.length()-1);
            int begin=0,end=0;
            while(begin<=end&&end<sb.length()){
                if(sb.charAt(end)!=' '&&end!=sb.length()-1){
                    end++;
                }else{
                    if(end<sb.length()-1){
                        Reverse(sb,begin,end-1);
                        begin=end+1;
                        end=end+1;
                    }else{
                      Reverse(sb,begin,end);
                      break;
                    }
                }
            }
        }
        return sb.toString();
    }

    private  void Reverse(StringBuilder sb,int begin,int end){
        while(begin<end){
            char temp = sb.charAt(begin);
            sb.setCharAt(begin++,sb.charAt(end));
            sb.setCharAt(end--,temp);
        }
    }
}
