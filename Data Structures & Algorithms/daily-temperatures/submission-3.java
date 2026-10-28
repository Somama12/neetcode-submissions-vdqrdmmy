class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && s.peek()[0] < temperatures[i]){
                int index = s.peek()[1];
                int diff = i - index;
                res[index] = diff;
                s.pop();
            }
            s.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
