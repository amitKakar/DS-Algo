package Strings;
// Pangram Checking
public class Problem3 {

    // Driver Code
    public static void main(String[] args)
    {
        String str = "The quick brown fox jumps over the lazy dog";

        if (checkPangram(str) == true)
            System.out.print(str + " is a pangram.");
        else
            System.out.print(str + " is not a pangram.");
    }

    private static boolean checkPangram(String str) {
        if(null == str)
        {
            return false;
        }
        int len = str.length();
        boolean[] result = new boolean[26];

        for(int i = 0; i < len; i++)
        {
            char curr = str.charAt(i);
            if(curr >= 'a' && curr <='z')
            {
                result[curr-'a'] = true;
            }
            else if(curr >= 'A' && curr <='Z')
            {
                result[curr-'A'] = true;
            }
        }

        for(int i=0; i < result.length; i++)
        {
            if(!result[i])
            {
                return false;
            }
        }

        return true;
    }
}
