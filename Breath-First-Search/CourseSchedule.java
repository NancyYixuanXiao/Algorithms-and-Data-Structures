public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] prereqCount = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            prereqCount[pre[0]]++;
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new HashSet<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prereqCount[i] == 0) {
                count++;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (map.containsKey(curr)) {
                for (int adj : map.get(curr)) {
                    prereqCount[adj]--;
                    if (prereqCount[adj] == 0) {
                        count++;
                        queue.offer(adj);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
