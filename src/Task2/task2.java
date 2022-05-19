package Task2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] delim = (reader.readLine()).split(" ");
        reader.close();

        String filePath1 = delim[0];
        String filePath2 = delim[1];

        FileReader fileReader1 = new FileReader(filePath1);
        Scanner scanner1 = new Scanner(fileReader1);

        ArrayList<String> list = new ArrayList<>();
        while (scanner1.hasNextLine()){
            list.add(scanner1.nextLine());
        }
        fileReader1.close();
        String[] coordinatesCenter = list.get(0).split(" ");

        float x = Float.parseFloat(coordinatesCenter[0]);
        float y = Float.parseFloat(coordinatesCenter[1]);
        float radius = Float.parseFloat(list.get(1));


        FileReader file2Reader = new FileReader(filePath2);
        Scanner scanner2 = new Scanner(file2Reader);
        ArrayList<String> list2 = new ArrayList<>();

        while (scanner2.hasNextLine()){
            String[]ss = scanner2.nextLine().split(" ");

            list2.add(ss[0]);
            list2.add(ss[1]);
        }
        file2Reader.close();

         for (int i = 0;i<list2.size();i+=2){
             float a = Float.parseFloat(list2.get(i));
             float b = Float.parseFloat(list2.get(i+1));

             if (((x - a) * (x - a) + (y - b) * (y - b)) == radius * radius) {
                 System.out.println(0);
             }
             else if (((x - a) * (x - a) + (y - b) * (y - b)) < radius * radius) {
                 System.out.println(1);
             }
             else System.out.println(2);
         }
        }
    }
