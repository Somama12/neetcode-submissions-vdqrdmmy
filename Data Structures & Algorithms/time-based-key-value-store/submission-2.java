class TimeMap {
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(value, timestamp);
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(p);
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        //[{a:1}, {b:3}, {c:4}, {d:6}]

        if (list == null) {
            return "";
        }
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);

            if (timestamp == p.timeStamp) {
                return p.value;
            } else if (p.timeStamp > timestamp) {
                if (i > 0) {
                    return list.get(i - 1).value;
                }
                return "";
            }
        }

        return list.get(list.size() - 1).value;
    }

    public class Pair {
        String value;
        int timeStamp;

        public Pair(String val, int time) {
            this.value = val;
            this.timeStamp = time;
        }
    }
}
