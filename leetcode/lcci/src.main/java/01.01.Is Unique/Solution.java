package src.main.java._0101;
public class Solution {
     public static void main(String[] args) {
         Solution s = new Solution();
         boolean isUnique = s.isUnique("abc");
         System.out.println(isUnique);
     }
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}