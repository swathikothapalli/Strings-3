// Time Complexity : O(n) where n is the no of charcaters in the given string.
// Space Complexity : Stack O(n) where n is the no of charcaters in the given string.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
class Solution {
    public int calculate(String s) {
        int curr = 0;
        char lastsign = '+';
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
                curr = curr * 10 + c -'0';
            if(c == '(')
            {
                if(lastsign == '+')
                    stk.push(1);
                else if(lastsign == '-')
                    stk.push(-1);
                stk.push(999999);
                
                lastsign = '+';
            }
            else if(c == ')')
            {
                if(lastsign == '+')
                    stk.push(curr);
                else if(lastsign == '-')
                    stk.push(-curr);
                int tempsum = 0;
                while(!stk.isEmpty() && stk.peek() != 999999)
                    tempsum += stk.pop();
                if(!stk.isEmpty())
                {
                    stk.pop();
                    tempsum = tempsum * (stk.isEmpty() ? 1 : stk.pop());
                }
                stk.push(tempsum);
                
                curr = 0;
                lastsign = '+';
            }
            else if((!Character.isDigit(c) && c != ' ') || i == s.length()-1)
            {
                if(lastsign == '+')
                    stk.push(curr);
                else if(lastsign == '-')
                    stk.push(-curr);
                curr = 0;
                lastsign = c;
            }
        }
        int sum = 0;
        while(!stk.isEmpty())
            sum += stk.pop();
        return sum;

    }
}

