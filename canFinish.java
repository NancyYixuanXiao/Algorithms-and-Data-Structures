package leetCodeJava;

import java.util.*;

public class canFinish {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] prereqCount = new int [numCourses];
        Map<Integer, Set<Integer>> prereq = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            prereqCount[prerequisites[i][0]]++;
            if (!prereq.containsKey(prerequisites[i][1])) {
                prereq.put(prerequisites[i][1], new HashSet<Integer>());
            } 
            prereq.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        System.out.println(prereq);
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < prereqCount.length; i++) {
            if (prereqCount[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        System.out.println(count);
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (prereq.containsKey(course)) {
                for (int pre : prereq.get(course)) {
                    prereqCount[pre]--;
                    if (prereqCount[pre] == 0) {
                    	queue.add(pre);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        return count == numCourses;
    }
}