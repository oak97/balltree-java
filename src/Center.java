import java.util.ArrayList;

class Center {
    Instance inst;

    public Center(Instance inst) {
        this.inst = inst;
    }

    public double[] center(ArrayList<Integer> points) {
        int MAX_TIMES = 1000;
        double[] c = inst.X[points.get(0)];
        for (int i = 0; i < MAX_TIMES; ++i) {
            c = VectorOp.add(
                VectorOp.multiply(c, ((double)i) / (i + 1)),
                VectorOp.multiply(inst.X[farthestPoint(c, points)], ((double)1) / (i + 1)));
        }
        return c;
    }

    public int farthestPoint(double[] p, ArrayList<Integer> points) {
        double max = Double.MIN_VALUE;
        int pp = 0;
        for (int i = 0; i < points.size(); ++i) {
            double d = VectorOp.distance(p, inst.X[points.get(i)]);
            if (d > max) {
                max = d;
                pp = points.get(i);
            }
        }
        return pp;
    }

    public double farthestDis(double[] p, ArrayList<Integer> points) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < points.size(); ++i) {
            double d = VectorOp.distance(p, inst.X[points.get(i)]);
            if (d > max) {
                max = d;
            }
        }
        return max;
    }
}