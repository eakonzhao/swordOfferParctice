import java.util.Stack;

/**
 * Created by Eakon on 2017/6/2.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 在该栈中，调用min,push及pop的时间复杂度都是O(1)
 */
public class StackContainsMinFunction {

    Stack<Integer> stackValue = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();
    public void push(int node){
        stackValue.push(node);
        if(stackMin.isEmpty() || node<top()){
            stackMin.push(node);
        }else {
            stackMin.push(top());
        }
    }

    public void pop(){
        if(!stackValue.isEmpty()){
            if(stackMin.peek()==top()){
                stackMin.pop();
            }
            stackValue.pop();
        }
    }

    public int top(){
        if(!stackMin.isEmpty()){
            return stackMin.peek();
        }
        return (Integer)null;
    }

    public int min(){
        if(!stackValue.isEmpty() && !stackMin.isEmpty()){
            return top();
        }
        return (Integer)null;
    }
}
