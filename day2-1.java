import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        String filename = "/Users/shun/Code/small-tasks/adventofcode2018/day2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            Integer second = 0;
            Integer third = 0;
            while((line = reader.readLine()) != null) {
              HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
              //System.out.println(line);
              String[] array = line.split("");
              Arrays.stream(array).forEach(chara -> {
                Integer n = hashmap.get(chara);
                if(n == null){
                  hashmap.put(chara, 1);
                } else {
                  hashmap.put(chara, n+1);
                }
              });
              second += hashmap.values().contains(2) ? 1 : 0;
              third += hashmap.values().contains(3) ? 1 : 0;
            }
            System.out.println(second * third);
        } catch (FileNotFoundException e){ 
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e){ 
            e.printStackTrace();
            System.exit(-1);
        }
    }   
}