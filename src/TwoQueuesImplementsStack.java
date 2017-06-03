import java.util.LinkedList;

/**
 * Created by Eakon on 2017/5/30.
 * 两个队列实现一个栈
 */
public class TwoQueuesImplementsStack{
    private LinkedList<Integer> queue1 = new LinkedList<>();
    private LinkedList<Integer> queue2 = new LinkedList<>();
   /* public  void push(int node){
      while(!queue2.isEmpty()){
          queue1.addLast(queue2.removeFirst());
      }
      queue1.addLast(node);
    }

    public int pop(){
       if(queue1.isEmpty()){
           while(queue2.size()!=1){
               queue1.addLast(queue2.removeFirst());
           }
           return queue2.removeFirst();
       }else{
           while(queue1.size()!=1){
               queue2.addLast(queue1.removeFirst());
           }
           return queue2.removeFirst();
       }
    }*/
   /*public void push(int node) {
       //两个栈都为空时，优先考虑queue1
       if (queue1.isEmpty()&&queue2.isEmpty()) {
           queue1.add(node);
           return;
       }

       //如果queue1为空，queue2有元素，直接放入queue2
       if (queue1.isEmpty()) {
           queue2.add(node);
           return;
       }

       if (queue2.isEmpty()) {
           queue1.add(node);
           return;
       }

   }

    public int pop() {
        //两个栈都为空时，没有元素可以弹出
        if (queue1.isEmpty()&&queue2.isEmpty()) {
            try {
                throw new Exception("stack is empty");
            } catch (Exception e) {
            }
        }
        //如果queue1为空，queue2有元素， 将queue2的元素依次放入queue1中，直到最后一个元素，我们弹出。
        if (queue1.isEmpty()) {
            while (queue2.size()>1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        if (queue2.isEmpty()) {
            while (queue1.size()>1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }

        return (Integer) null;
    }*/

    public void push(int node){
        if(queue1.isEmpty()&&queue2.isEmpty()){
            queue1.addLast(node);
        }else if(queue1.isEmpty()){
            queue2.addLast(node);
        }else if(queue2.isEmpty()){
            queue1.addLast(node);
        }
    }

    public int pop(){
        if(queue1.isEmpty()&&queue2.isEmpty()){
            try{
                throw new Exception("The stack is Empty!");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.addLast(queue2.removeFirst());
            }
            return queue2.removeFirst();
        }else if(queue2.isEmpty()){
            while(queue1.size()>1){
                queue2.addLast(queue1.removeFirst());
            }
            return queue1.removeFirst();
        }
        return (Integer)null;
    }

    public boolean isEmpty(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        TwoQueuesImplementsStack stack = new TwoQueuesImplementsStack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            System.out.println("****************************");
            while(!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }
    }
