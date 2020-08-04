import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        int MAX_K=60;
        ArrayList<double[]> klabel = new ArrayList<double[]>();

        for (int i = 1; i <= MAX_K; i++) {
//            System.out.println("*****K="+i+"*****");
            klabel.add(TestK_Label.testK_Label(i));
        }

        double[] all = new double[MAX_K];
        double[] l3 = new double[MAX_K];
        double[] l4 = new double[MAX_K];
        double[] l5 = new double[MAX_K];
        double[] l6 = new double[MAX_K];
        double[] l7 = new double[MAX_K];
        double[] l8 = new double[MAX_K];
        double[] l9 = new double[MAX_K];

        for (int i = 0; i < MAX_K; i++) {
            all[i] = klabel.get(i)[0];
            l3[i] = klabel.get(i)[1];
            l4[i] = klabel.get(i)[2];
            l5[i] = klabel.get(i)[3];
            l6[i] = klabel.get(i)[4];
            l7[i] = klabel.get(i)[5];
            l8[i] = klabel.get(i)[6];
            l9[i] = klabel.get(i)[7];
        }

//        for (int i = 0; i < MAX_K; i++) {
//            System.out.println(l5[i]);
//        }
    }
}
