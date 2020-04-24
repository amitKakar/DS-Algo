package Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Longest subsequence where every character appears at-least k times
public class Problem1 {
    // Driver code
    static public void main(String[] args) {
        String str = "geeksforgeeks";
        int k = 2;
        longestSubseqWithK(str, k);

    }

    private static void longestSubseqWithK(String str, int k) {

        if(null == str)
        {
            return;
        }
        int len = str.length();
        // we can also use a character array here but then it will take extra space.
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i <len; i++)
        {
            char temp = str.charAt(i);
            if(map.size() == 0 || !map.containsKey(temp))
            {
                map.put(temp,1);
            }
            else
            {
                int count = map.get(temp);
                map.put(temp,count+1);
            }
        }
        for(int i=0; i <len; i++)
        {
            if(map.get(str.charAt(i))>=k)
            {
                System.out.print(str.charAt(i));
            }
        }
    }
}
