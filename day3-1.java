import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        String filename = "/Users/shun/Code/small-tasks/adventofcode2018/day3.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            List<String> fabric = new ArrayList<String>();
            for(int i = 0; i < 1000; i++){
              String repeated = new String(new char[1000]).replace("\0", ".");
              fabric.add(repeated);
            }
            //System.out.println(fabric);
            //System.out.println(fabric.get(0));
            //Integer line_num = 1;
            while((line = reader.readLine()) != null) {
              String[] claim = line.split(" ");
              Integer left = Integer.parseInt(claim[2].split(",")[0]);
              String st_top = claim[2].split(",")[1];
              Integer top = Integer.parseInt(st_top.substring(0, st_top.length()-1));
              Integer width = Integer.parseInt(claim[3].split("x")[0]);
              Integer height = Integer.parseInt(claim[3].split("x")[1]);
              //System.out.println("left:"+left+"top:"+top+"width:"+width+"height:"+height);
              for (int j = 0; j < height; j++){
                String change = fabric.get(top+j);
                char[] array_line = change.toCharArray();
                for (int i = 0 ; i < array_line.length ; i++) {
                    //System.out.print(array_line[i] + " ");
                    if (left<=i && i<left+width) {
                      if (array_line[i] == ".".charAt(0)) {
                        array_line[i] = "O".charAt(0);
                      } else {
                        array_line[i] = "X".charAt(0);
                      }
                    }
                }
                change = String.valueOf(array_line);
                fabric.set(top+j, change);
              }
              //line_num += 1;
            }
            System.out.println(fabric);
            String answer = String.join("", fabric);
            int count = 0;
            for(char x: answer.toCharArray()){
              if(x == "X".charAt(0)){
                count++;
              }
            }
            System.out.println(count);

        } catch (FileNotFoundException e){ 
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e){ 
            e.printStackTrace();
            System.exit(-1);
        }
    }   
}