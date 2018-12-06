import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        String filename = "/Users/shun/Code/small-tasks/adventofcode2018/day1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
            reader.mark(8196);// 最初にマーク
            String line;
            Integer answer = 0;
            List<Integer> answers = new ArrayList<Integer>();
            Boolean flag = false;
            Integer n = 0;
            while(flag == false) {
              while((line = reader.readLine()) != null) {
                //System.out.println(line);
                answer += Integer.parseInt(line);
                if(answers.contains(answer)) {
                  System.out.println(answer);
                  flag = true;
                  break;
                }
                n += 1;
                answers.add(answer);
              }
              reader.reset();
            }
        } catch (FileNotFoundException e){ 
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e){ 
            e.printStackTrace();
            System.exit(-1);
        }
    }   
}