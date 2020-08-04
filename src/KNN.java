import java.util.Collections;
import java.util.PriorityQueue;

public class KNN {
    PriorityQueue<Integer> Q = new PriorityQueue<Integer>(Collections.reverseOrder());
    double maxMinDistance = Double.MAX_VALUE;

    public int[] knnSearch(int t, int k, BallTree tree) {
        knnSearchRecur(t, k, tree.root);
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = Q.poll();
        }
        return result;
    }


    private void knnSearchRecur(int t, int k, Node node) {
        Ball ball = node.ball;
        double[][] points = ball.inst.X;

        if (VectorOp.distance(points[t], ball.c) - ball.r >= maxMinDistance) {
            return;
        } else if (node.left == null && node.right == null) {
            for (int i : ball.points) {
                if (VectorOp.distance(points[t], points[i]) < maxMinDistance) {
                    Q.add(i);

                    if (Q.size() > k) {
                        Q.poll();
                        maxMinDistance = VectorOp.distance(points[t], points[Q.peek()]);
                    }
                }
            }
        } else {
            double leftDistance = VectorOp.distance(points[t], node.left.ball.c);
            double rightDistance = VectorOp.distance(points[t], node.right.ball.c);

            if (leftDistance < rightDistance) {
                knnSearchRecur(t, k, node.left);
                knnSearchRecur(t, k, node.right);
            } else {
                knnSearchRecur(t, k, node.right);
                knnSearchRecur(t, k, node.left);
            }
        }
    }
}
