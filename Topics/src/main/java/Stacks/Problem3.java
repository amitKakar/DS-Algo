package Stacks;
// Check for balanced parentheses in an expression
import java.util.Stack;

public class Problem3 {


    /* UTILITY FUNCTIONS */
    /*driver program to test above functions*/
    public static void main(String[] args)
    {
        char exp[] = {'{','(',')','}','[',']'};
        if (areParenthesisBalanced(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

    private static boolean areParenthesisBalanced(char[] exp)
    {
        if(null == exp)
        {
            return true;
        }

        int len = exp.length;
        if(len == 0)
        {
            return true;
        }
        Stack<Character> s = new Stack<Character>();
        for(int i=0; i<len; i++)
        {
            if(exp[i]== '(' || exp[i]== '{' || exp[i]== '[')
            {
                s.push(exp[i]);
            }

            else if(exp[i]== ')' || exp[i]== '}' || exp[i]== ']')
            {
                if(!s.isEmpty())
                {
                    if(checkIfMatchingBracket(s.peek(),exp[i]))
                    {
                        s.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }

        if(s.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean checkIfMatchingBracket(Character top, char curr) {

        if(curr == ')' && top =='(')
        {
            return true;
        }
        else if(curr == ']' && top =='[')
        {
            return true;
        }
        else if(curr == '}' && top =='{')
        {
            return true;
        }
        return false;
    }
}
