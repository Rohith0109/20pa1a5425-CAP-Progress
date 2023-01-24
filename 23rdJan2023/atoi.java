import java.util.*;

class Solution {
    public int myAtoi(String s) {
        int num = 0, i=0, sign=1, n=s.length();

        if (s.equals(""))
        return 0;

        while (i<n && s.charAt(i)==' ')
        i++;

        if (i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if (s.charAt(i)=='-')
            sign = -1;
            i++;
        }

        while (i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            System.out.println(i);
            char ch = s.charAt(i);
            if (num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && ch>'7')){
                if (sign == 1)
                return Integer.MAX_VALUE;
                else
                return Integer.MIN_VALUE;
            }
            num = (num*10)+(ch-'0');
            i++;
        }
        return sign*num;
    }
}

public class atoi{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Solution sol = new Solution();
        String str = scan.next();
        System.out.println(sol.myAtoi(str));
        scan.close();
    }
}