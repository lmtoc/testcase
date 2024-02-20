package lcr;

import java.util.Stack;

/**
 * 2024/2/5
 * lamic
 **/
public class LCR036 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        for(String token:tokens){
            switch(token){
                case "+":
                    if(stack.size()<2){
                        return 0;
                    }
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    if(stack.size()<2){
                        return 0;
                    }
                    stack.push(-stack.pop()+stack.pop());
                    break;
                case "*":
                    if(stack.size()<2){
                        return 0;
                    }
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    if(stack.size()<2){
                        return 0;
                    }
                    stack.push((1/stack.pop())*stack.pop());
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        LCR036 lcr036 = new LCR036();
        System.out.println(lcr036.evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
