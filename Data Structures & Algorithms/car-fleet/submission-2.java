class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] time = new double[position.length][2];

        for(int i=0; i<position.length; i++){
            time[i][0] = position[i];
            time[i][1] = (double)(target - position[i])/(double)speed[i];
        }
        Arrays.sort(time, (a,b) -> Double.compare(b[0], a[0]));
        Stack<double[]> s = new Stack<>();

        for(double[] t: time){
            if(!s.isEmpty() && t[1] <= s.peek()[1]){
                continue;
            }else{
                s.push(new double[]{t[0], t[1]});
            }
        }
        return s.size();
    }
}
