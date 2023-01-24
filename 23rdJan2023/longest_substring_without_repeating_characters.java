import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n<1)
        return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int i=0, j=0;
        int max = 0, count=0;
        while (j<n && i<n){
            char ch = s.charAt(i);
            if (hs.add(ch)){
                i++;
                count++;
            }
            else{
                max = max<count ? count : max;
                hs = new HashSet<Character>();
                j++;
                i = j;
                count = 0;
            }
        }
        max = max<count ? count : max;
        return max;
        
    }
}

public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println("The length of longest substring without repeating characters: "+sol.lengthOfLongestSubstring(str));
    }
}
