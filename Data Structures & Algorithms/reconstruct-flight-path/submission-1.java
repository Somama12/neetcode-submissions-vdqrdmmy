

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        // DFS from JFK
        dfs("JFK");
        return result;
    }

    private void dfs(String airport) {
        PriorityQueue<String> pq = graph.get(airport);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll()); // always pick smallest destination
        }
        result.addFirst(airport); // add after visiting all edges
    }
}
