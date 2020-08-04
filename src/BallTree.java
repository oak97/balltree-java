import java.util.ArrayList;

//int表示Point序号
public class BallTree {
    Instance inst;
    Node root;

    public BallTree(Instance inst) {
        this.inst = inst;
    }

    /**
     * construct_balltree，LP欧氏距离p=2
     * @param D 标准化过的数据点集合，球内的点
     * @return
     */
    public Node construct_balltree(ArrayList<Integer> D){
        if (D.size()==0){
            return null;
        }
        if (D.size()==1){
            return new Node(new Ball(D,inst));
        }
        Ball ball = new Ball(D,inst);//TODO: 给你一组数据点，就可以得到球的信息，球心、半径
//        double c = ball.r;
        double[] p = ball.c;
        Center center = new Center(inst);
        int p1 = center.farthestPoint(p,D);
        int p2 = ball.max_farest(p1);
        ArrayList<ArrayList<Integer>> sets = ball.sep(p1,p2);
        ArrayList<Integer> L = sets.get(0);
        ArrayList<Integer> R = sets.get(1);

        Node B = new Node(ball);
        B.left = construct_balltree(L);
        B.right = construct_balltree(R);
        return B;
    }


    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}