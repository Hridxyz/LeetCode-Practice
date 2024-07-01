import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public MyStack() {
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    
    public void push(int x) {
        if(!q1.isEmpty()){
            q1.add(x);
        }
        else {
            q2.add(x);
        }
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        int top = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
            return top;
        }else{
            while(!q2.isEmpty()){
                top = q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
            return top;
        }
    }
    
    public int top() {
        if(empty()){
            return -1;
        }
        int top = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
            }
            return top;
        }else{
            while(!q2.isEmpty()){
                top = q2.remove();
                q1.add(top);
            }
            return top;
        }
    }
    
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */