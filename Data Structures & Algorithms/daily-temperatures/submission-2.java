class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> s = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, 0);

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && s.peek()[0] < temperatures[i]){
               int index = s.peek()[1];
               int days = i - index;
               res[index] = days;
               s.pop();
            }
            s.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
