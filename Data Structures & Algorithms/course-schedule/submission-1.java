class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //using topological sorting
        int[] inDegree=new int[numCourses];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            inDegree[preq[1]]++;
            list.get(preq[0]).add(preq[1]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int size=0;
        while(!q.isEmpty()){
            int node=q.poll();
            size++;
            for(int neighbor:list.get(node)){
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        if(size!=numCourses){
            return false;
        }
        return true;
    }
}
