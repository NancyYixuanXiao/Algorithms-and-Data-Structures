public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] prereqCount = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new HashSet<>());
            }
            if (map.get(pre[1]).add(pre[0])) {
                prereqCount[pre[0]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (prereqCount[i] == 0) {
                res[count] = i;
                count++;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (map.containsKey(curr)) {
                for (int course : map.get(curr)) {
                    prereqCount[course]--;
                    if (prereqCount[course] == 0) {
                        res[count] = course;
                        count++;
                        queue.offer(course);
                    }
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}
