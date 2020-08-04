import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Instance {
    double[][] f;//f[0-10][]
    double[][] c;

    int[] y;//y
    double[][] X;//X[0-4898][]
//4898
    public Instance(String path, int user_count) throws FileNotFoundException {
        Scanner cin = new Scanner(new BufferedReader(new FileReader(path)));
        cin.nextLine();
        f = new double[11][user_count];
        y = new int[user_count];

        for (int i = 0; i < user_count; i++) {
            String line = cin.nextLine();
            String[] subs = line.split(";");
            for (int j = 0; j < 11; j++) {
                this.f[j][i] = Double.parseDouble(subs[j]);
            }
            this.y[i] = Integer.parseInt(subs[11]);
        }
        cin.close();

        X = new double[user_count][11];
        for (int i = 0; i < user_count; i++) {
            double[] a = new double[11];
            for (int j = 0; j < 11; j++) {
                a[j] = f[j][i];
            }
            X[i] = a;
        }

        this.c = new double[user_count][user_count];
        for (int i = 0; i < user_count-1; i++) {
            for (int j = i+1; j < user_count; j++) {
                double sum = 0;
                for (int k = 0; k < 11; k++) {
                    sum += Math.pow(f[k][i]-f[k][j],2);
                }
                c[j][i] = c[i][j] = Math.sqrt(sum);
            }
        }
        for (int i = 0; i < user_count; i++) {
            for (int j = 0; j < user_count; j++) {
                if (i==j){
                    continue;
                }
                if(c[i][j]==0){
                    c[i][j] += 0.000001;
                }
            }
        }
    }

    public void print_instance() {
        for (int i = 0; i < this.X.length; i++) {
            System.out.println("record "+(i)+": lable="+(y[i]));
            for (int j = 0; j < X[i].length; j++) {
                System.out.print(X[i][j]+", ");
            }
            System.out.println();
        }
    }

    public void print_instance(int flag) {
        for (int i = 0; i < this.X.length; i++) {
            System.out.println("record "+(i)+": lable="+(y[i]));
            for (int j = 0; j < X[i].length; j++) {
                System.out.print(X[i][j]+", ");
            }
            System.out.println();
        }

        if (flag==1){
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    System.out.println("i="+i+", j="+j+", d="+c[i][j]+", ");
                }
            }
        }
    }




}
