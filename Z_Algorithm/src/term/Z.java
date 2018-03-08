package term;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Sudipta Banik on 10-07-2017.
 */
class Z {
    static TreeSet<Integer> Matcher(String Text, String Pattern) {
        return Matcher('$', Text, Pattern);
    }

    static TreeSet<Integer> Matcher(char specialChar, String Text, String Pattern){
        StringBuilder sb = new StringBuilder(Pattern);
        sb.append(specialChar).append(Text);
        int[] Z_Array = new int[Pattern.length()+Text.length()+1];
        int left = 0 , right = 0;
        Z_Array[0] = 0;
        for(int k=1;k<sb.length();k++){
            if(k > right){
                left = right = k;
                while (right < sb.length() && sb.charAt(right) == sb.charAt(right - left)){
                    right++;
                }
                Z_Array[k] = right - left;
                right--;
            }else{
                //comparing inside the box;
                int k1 = k - left;
                if(Z_Array[k1] < right - k +1){
                    Z_Array[k] = Z_Array[k1];
                }else{
                    left = k;
                    while (right < sb.length() && sb.charAt(right) == sb.charAt(right - left)){
                        right++;
                    }
                    Z_Array[k] = right - left;
                    right--;
                }
            }
        }
        TreeSet<Integer> indexes = new TreeSet<>();
        int PatternLength = Pattern.length();
        for(int i = 0;i <Z_Array.length;i++){
            if(Z_Array[i] == PatternLength)indexes.add(i - PatternLength - 1);
        }
        return indexes;
    }
}
