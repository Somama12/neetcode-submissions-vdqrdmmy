class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int k = 0; 
        int i = 0; 

        while (i < n) {
            char ch = chars[i];
            int j = i;

            // Count total occurrences of ch
            while (j < n && chars[j] == ch) {
                j++;
            }
            int len = j - i;

           
            chars[k++] = ch;

            // Write count if more than 1
            if (len > 1) {
                String cnt = Integer.toString(len);
                for (char c : cnt.toCharArray()) {
                    chars[k++] = c;
                }
            }

            i = j;
        }

        return k;
    }
}
