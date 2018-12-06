import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        String filename = "/Users/shun/Code/small-tasks/adventofcode2018/day1.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            Integer answer = 0;
            while((line = in.readLine()) != null) {
              //System.out.println(line);
              answer += Integer.parseInt(line);
              
            }
            System.out.println(answer);
        } catch (FileNotFoundException e){ 
            e.printStackTrace();
            System.exit(-1); // 0 以外は異常終了
        } catch (IOException e){ 
            e.printStackTrace();
            System.exit(-1);
        }
    }   
}