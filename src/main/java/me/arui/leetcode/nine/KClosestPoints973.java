package me.arui.leetcode.nine;

import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPoints973 {

    public int[][] kClosest(int[][] points, int K) {
        if (K == points.length) return points;
        PriorityQueue<Point> queue = new PriorityQueue<>(K);
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            queue.add(new Point(i, dist(point)));
        }
        int[][] result = new int[K][2];
        int i = 0;
        while (i < K) {
            Point point = queue.poll();
            result[i] = points[point.index];
            i++;
        }
        return result;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public class Point implements Comparable<Point> {
        Integer index = 0;
        Integer distance = 0;

        Point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return this.distance.compareTo(o.distance);
        }
    }

    public static void test(int[][] points, int K) {
        KClosestPoints973 test = new KClosestPoints973();
        int[][] result = test.kClosest(points, K);
        System.out.println("执行结果：");
        for (int i = 0; i < result.length; i++) {
            int[] point = result[i];
            System.out.print("[" + point[0] + "," + point[1] + "] ");
        }
    }

    public static void main(String[] args) {
        test(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    }
}
