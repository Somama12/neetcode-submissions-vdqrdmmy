

class Solution {
    public String foreignDictionary(String[] words) {
        // adjacency list
        HashMap<Character, Set<Character>> adj = new HashMap<>();

        // collect all unique chars
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        // build edges
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int min = Math.min(w1.length(), w2.length());

            // invalid case: prefix problem
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < min; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        boolean[] visited = new boolean[26]; // permanent mark
        boolean[] inStack = new boolean[26]; // recursion stack
        Stack<Character> topo = new Stack<>();

        for (char c : adj.keySet()) {
            if (!visited[c - 'a']) {
                if (dfs(c, adj, visited, inStack, topo)) {
                    return ""; // cycle
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!topo.isEmpty()) sb.append(topo.pop());
        return sb.toString();
    }

    // returns true if cycle
    private boolean dfs(char u,
                        HashMap<Character, Set<Character>> adj,
                        boolean[] visited,
                        boolean[] inStack,
                        Stack<Character> topo) {
        visited[u - 'a'] = true;
        inStack[u - 'a'] = true;

        for (char v : adj.get(u)) {
            if (!visited[v - 'a']) {
                if (dfs(v, adj, visited, inStack, topo)) return true;
            } else if (inStack[v - 'a']) {
                return true; // back edge → cycle
            }
        }

        inStack[u - 'a'] = false;
        topo.push(u);
        return false;
    }
}
