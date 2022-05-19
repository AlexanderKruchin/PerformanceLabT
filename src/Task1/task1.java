package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] delim = (reader.readLine()).split(" ");
        reader.close();
        int n = Integer.parseInt(delim[0]);
        int m = Integer.parseInt(delim[1]);

        if (n==m){
            System.out.println("Это бесконечный цикл. Перезапустите пожалуйста приложение.");
            System.exit(1);
        }

        if (m==1){
            for (int i = 1;i<=n;i++){
                System.out.print(i);
            }
            System.exit(1);
        }

        int[] ints = new int[n];
        int[] forCopyInts = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i + 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(ints[0]);
            for (int i = 0; i < ints.length; i++) {
                forCopyInts[i] = ints[(m - 1 + i) % ints.length];
            }
            ints = copy(forCopyInts);
        } while (ints[m - 1] != 1);
        stringBuilder.append(ints[0]);
        System.out.print(stringBuilder);

    }

    private static int[] copy(int[] mas) {
        return Arrays.copyOf(mas, mas.length);
    }

}
