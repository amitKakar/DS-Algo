package Stacks;
// Infix to Postfix
import java.util.Stack;

public class Problem2 {
    // A utility function to return precedence of a given operator 
    // Higher returned value means higher precedence 
    static int prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    
    // Driver method
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) {
        String result ="";
        if(null == exp || exp == "")
        {
            return result;
        }

        int len = exp.length();
        Stack<Character> s = new Stack<Character>();
        for(int i=0 ; i<len; i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            }

            else if (c == '(') {
                s.push(c);
            }

            else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    result += s.pop();
                }
                s.pop();
            }

            else {
                while(!s.isEmpty() && prec(c) <= prec(s.peek()))
                {
                    result += s.pop();
                }
                s.push(c);
            }
        }

        while(!s.isEmpty())
        {
            result += s.pop();
        }


        return result;
    }
}
