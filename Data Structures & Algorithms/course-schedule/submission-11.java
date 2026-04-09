class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] preq: prerequisites){
            int u= preq[0];
            int v = preq[1];
            inDegree[v]++;
            list.get(u).add(v);
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int size = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            size++;
            for(int neig: list.get(node)){
                inDegree[neig]--;
                if(inDegree[neig]==0){
                    q.offer(neig);
                }
            }
        }
        return size==numCourses;
    }
}
