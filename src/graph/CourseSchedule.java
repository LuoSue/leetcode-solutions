package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rj
 * @className CourseSchedule
 * @description leetcode 207. 课程表
 * @date 2025/3/21 10:32
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建入度数组和邻接表
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0], prerequisite = pre[1];
            adjList.get(prerequisite).add(course);  // 记录依赖关系
            inDegree[course]++;  // 计算入度
        }

        // 初始化队列，添加所有入度为 0 的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录已完成课程数量
        int completedCourses = 0;

        // 拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            // 遍历当前课程的所有依赖项
            for (int nextCourse : adjList.get(course)) {
                inDegree[nextCourse]--;  // 依赖它的课程入度减 1
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return completedCourses == numCourses;  // 是否能完成所有课程
    }
}
