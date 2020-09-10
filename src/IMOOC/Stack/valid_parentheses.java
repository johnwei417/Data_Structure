package IMOOC.Stack;
import java.util.Stack;

/**
 * honglinwei created on 3/26/20 inside the package - IMOOC.Stack
 */
public class valid_parentheses {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 != 0){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println( (new valid_parentheses()).isValid(("[](){}")));

    }
}
