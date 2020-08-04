import java.util.ArrayList;
import java.util.Arrays;

public class Ball {
    Instance inst;
    double[] c;
    double r;
    ArrayList<Integer> points;

    //根据points来求球心和半径
    public Ball(ArrayList<Integer> points,Instance inst) {
        this.inst = inst;
        this.points = points;
        Center center = new Center(inst);
        this.c = center.center(points);
        this.r = center.farthestDis(c,points);
    }

    public Ball(Instance inst) {
        this.inst = inst;
    }

    /**
     * 求最远点
     *
     * @param p 已知点
     * @return 点集合points中离已知点最远的第一个点
     */
    public int max_farest(int p) {
        double max = -Double.MAX_VALUE;
        ArrayList<Integer> vals = new ArrayList<Integer>();//记录了所有最远点pp
        for (int i = 0; i < points.size(); i++) {
            int pp = points.get(i);
            if (inst.c[p][pp] == max) {
                vals.add(pp);
            } else if (inst.c[p][pp] > max) {
                vals.clear();
                vals.add(pp);
                max = inst.c[p][pp];
            }
        }
//        System.out.println(vals);
        return vals.get(0);
    }


    /**
     * 球中所有点分配到离p1、p2点更近的一个上
     *
     * @param p1
     * @param p2
     * @return 分配后形成的两个子集
     */
    public ArrayList<ArrayList<Integer>> sep(int p1, int p2) {
        ArrayList<Integer> set1 = new ArrayList<Integer>();
        ArrayList<Integer> set2 = new ArrayList<Integer>();
        for (int i = 0; i < points.size(); i++) {
            int p = points.get(i);
            if (inst.c[p1][p] <= inst.c[p2][p]) {
                set1.add(p);
            }else{
                set2.add(p);
            }
        }
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        sets.add(set1);
        sets.add(set2);
        return sets;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "c=" + Arrays.toString(c) +
                ", r=" + r +
                ", points=" + points +
                '}';
    }

    public Ball copy() {
        Ball b = new Ball(inst);
        b.r = this.r;
        b.c = new double[11];
        for (int i = 0; i < c.length; i++) {
            b.c[i] = c[i];
        }
        b.points = new ArrayList<Integer>();
        for (int i = 0; i < points.size(); i++) {
            b.points.add(points.get(i));
        }
        return b;
    }
}
