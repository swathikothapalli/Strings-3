// Time Complexity : O(1) as the number of digits are limited.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class Solution {
    String[] group3suffix = {"", "Thousand", "Million", "Billion"};
    String[] uniques_0_19 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",          "Eighteen", "Nineteen"};
    String[] below_hundred = {"", "", "Twenty", "Thirty","Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int count = 0;
        String result = "";
        while(num>0)
        {
            if(num%1000 != 0)
                result = getWords(num%1000).trim() +" "+ group3suffix[count] + " " + result;
            num = num/1000;
            count++;
        }
        return result.trim();
    }
    private String getWords(int num)
    {
        if(num == 0)
            return "";
        if(num<20)
            return uniques_0_19[num%20] + " ";
        else if(num<100)
            return below_hundred[num/10] + " " + getWords(num%10);
        else
            return uniques_0_19[num/100] + " Hundred " + getWords(num%100);
    }
}
 