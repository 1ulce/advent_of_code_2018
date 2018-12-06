import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        String filename = "/Users/shun/Code/small-tasks/adventofcode2018/day2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            String answer;
            List<String> lines = new ArrayList<String>();
            Integer n = 0;
            loop1:
            while((line = reader.readLine()) != null) {
              String[] line_id = line.split("");
              n += 1;
              for(String prev : lines){
                answer = "";
                Boolean flag = true;
                Boolean one_miss = false;
                String[] prev_id = prev.split("");
                loop2:
                for (int i = 0; i < prev.length(); i++){
                  if (!(line_id[i].equals(prev_id[i]))) {
                    if (one_miss == false) {
                      one_miss = true;
                    } else {
                      flag = false;
                      break loop2;
                    }
                  }else{
                    answer += line_id[i];
                  }
                }
                if (flag == true && prev != null){
                  System.out.println(answer);
                  break loop1;
                }
              }
              lines.add(line);
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