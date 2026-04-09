class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] preq: prerequisites){
            int u = preq[0];
            int v = preq[1];
            inDegree[u]++;
            list.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int k = 0;
        int size = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            size++;
            res[k++] = node;
            for(int neigh: list.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        if(size!=numCourses) return new int[]{};
        return res;
    }
}
