class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        int[] inDegree=new int[numCourses];

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
                q.offer(i);
            }
        }

        int[] res=new int[numCourses];
        int k=0;
        while(!q.isEmpty()){
            int node=q.poll();
            res[numCourses - k- 1]=node;
            k++;
            for(int neighbor: list.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    q.offer(neighbor);
                }
            }
        }

        if(k!=numCourses){
            return new int[0];
        }
        return res;
    }
}
