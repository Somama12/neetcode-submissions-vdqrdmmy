class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> map = new HashMap<>();

      for(String w : words){
        for(char ch : w.toCharArray()){
            map.putIfAbsent(ch, new HashSet<>());
        }
      }

      for(int i=0; i<words.length-1; i++){
        String w1 = words[i];
        String w2 = words[i+1];

        int min = Math.min(w1.length(), w2.length());

        if( w1.length() > w2.length() && w1.startsWith(w2)) return "";

        for(int j=0; j<min; j++){
            if(w1.charAt(j)!=w2.charAt(j)){
                map.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
      }
        int n = map.size();

        boolean[] visited = new boolean[26];
        boolean[] stack = new boolean[26];
        Stack<Character> topo = new Stack<>();

        for(char ch : map.keySet()){
            if(!visited[ch - 'a']){
                if( dfs(ch, map , visited, stack, topo)){
                    return "";
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!topo.isEmpty()){
            ans.append(topo.pop());
        }
        return ans.toString();
    }

    public boolean dfs(Character ch, Map<Character, Set<Character>> map, boolean[] visited, boolean[] stack, Stack<Character> topo){
        visited[ch - 'a'] = true;
        stack[ch - 'a'] = true;

        for(char neigh : map.get(ch)){
            if(!visited[neigh-'a']){
                if(dfs(neigh, map, visited, stack, topo)){
                    return true;
                }
            }else if(stack[neigh - 'a']){
                return true;
            }
        }
        stack[ch - 'a'] = false;
        topo.push(ch);
        return false;
    }
}
