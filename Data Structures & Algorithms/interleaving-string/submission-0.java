class Solution {
    Map<String, Boolean> map;
    public boolean isInterleave(String s1, String s2, String s3) {
        map=new HashMap<>();
        return dp(s1, s2, s3, 0,0,0);
    }
    public boolean dp(String s1, String s2, String s3, int i, int j, int k){
        if(k==s3.length()){
            return i==s1.length() && j==s2.length();
        }

        String key=i+","+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
            if(dp(s1,s2,s3,i+1, j, k+1)){
                map.put(key,true);
                return true;
            }
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
            if(dp(s1,s2,s3,i, j+1, k+1)){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;

    }
}