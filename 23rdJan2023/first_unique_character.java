import java.util.*;
import java.util.*;

public class first_unique_character{

    public int firstUniqueChar(String s){
        HashMap <Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        
        for (int i=0;i<s.length();i++){
            if (hm.get(s.charAt(i))==1){
                return i;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        first_unique_character obj = new first_unique_character();
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(obj.firstUniqueChar(str));
    }
}