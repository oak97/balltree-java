
class Node {
    //    int value;
    Ball ball;
    Node left;
    Node right;

    Node(Ball ball) {
        this.ball = ball.copy();
        right = null;
        left = null;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "ball=" + ball +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}