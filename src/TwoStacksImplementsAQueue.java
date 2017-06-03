import java.util.Stack;

/**
 * Created by Eakon on 2017/5/30.
 * 两个栈实现一个队列
 */
public class TwoStacksImplementsAQueue {
    Stack<Integer> stack1 = new Stack<>();//push
    Stack<Integer> stack2 = new Stack<>();//pop
    public void push(int node){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop(){
       while(!stack1.isEmpty()){
           stack2.push(stack1.pop());
       }
        return stack2.pop();
    }
}
