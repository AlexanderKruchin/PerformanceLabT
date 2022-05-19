package Task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);

        ArrayList<Integer>list = new ArrayList<>();

        while (scanner.hasNextLine()){
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        fileReader.close();

        Collections.sort(list);

        int median;

        if (list.size()%2==0){
            median = (list.get(list.size()/2)+ list.get(list.size()/2-1))/2;
        }else
            median = list.get(list.size()/2);

        int count = 0;
        int scar;

        for (int i =0;i<list.size();i++){
            scar= list.get(i);
            if (scar<median){
                count=count+(median-scar);
            }
            if (scar>median){
                count=count+(scar-median);
            }
        }
        System.out.println(count);
    }
}
