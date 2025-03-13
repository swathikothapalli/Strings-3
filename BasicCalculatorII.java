// Time Complexity : O(n) where n is the no of charcaters in the given string.
// Space Complexity : Tail - O(1) Stack O(n) where n is the no of charcaters in the given string.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;

//Tail based solution
class Solution {
    public int calculate(String s) {
        int sum = 0;
        int tail = 0;
        int curr = 0;
        char lastSign = '+';
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
            {
                curr = curr*10 + c -'0';
            }
            if((!(Character.isDigit(c)) && !(c == ' '))|| i == s.length()-1)
            {
                if(lastSign == '+')
                {
                    sum += curr;
                    tail = curr;
                }else if(lastSign == '-')
                {
                    sum -= curr;
                    tail = -curr;
                }
                else if(lastSign == '*')
                {
                    sum = sum - tail + tail*curr;
                    tail = tail*curr;
                }
                else
                {
                    sum = sum - tail + tail/curr;
                    tail = tail/curr;
                }
                curr = 0;
                lastSign = c;
            }
        }
        return sum;
    }
}




//Stack based solution
class Solution1 {
    public int calculate(String s) {
        int curr = 0;
        char lastsign = '+';
        int sum = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                curr = curr*10 + c -'0';
            if((!Character.isDigit(c) && !(c == ' ')) || i == s.length()-1)
            {
                if(lastsign == '+')
                    stk.push(curr);
                else if(lastsign == '-')
                    stk.push(-curr);
                else if(lastsign == '*')
                    stk.push(stk.pop() * curr);
                else
                    stk.push(stk.pop() / curr);
                
                curr = 0;
                lastsign = c;
            }
        }

        while(!stk.isEmpty())
            sum = sum + stk.pop();

        return sum;
    }
}