import java.util.Arrays;

class VectorOp {
    public static double distance(double[] vec1, double[] vec2) {
        double d=0;
        for (int i = 0; i < vec1.length; ++i) {
            d += Math.pow(vec1[i] - vec2[i], 2);
        }

        return Math.sqrt(d);
    }

    public static double[] multiply(double[] vec, double factor) {
        double[] vec_p = Arrays.copyOf(vec, vec.length);
        for (int i = 0; i < vec.length; ++i) {
            vec_p[i] *= factor;
        }

        return vec_p;
    }

    public static double[] add(double[] vec1, double[] vec2) {
        double[] vec_p = Arrays.copyOf(vec1, vec1.length);
        for (int i = 0; i < vec1.length; ++i) {
            vec_p[i] += vec2[i];
        }

        return vec_p;
    }
}