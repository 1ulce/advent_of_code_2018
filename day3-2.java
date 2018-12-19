import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        String filename = "/Users/shun/Code/small-tasks/adventofcode2018/day3.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
          List<Integer> unique_claims = new ArrayList<Integer>();
          List<Integer> claim_contents = new ArrayList<Integer>();
          String line;
          List<String> fabric = new ArrayList<String>();
          for(int i = 0; i < 1000; i++){
            String repeated = new String(new char[1000]).replace("\0", ".");
            fabric.add(repeated);
          }
          //System.out.println(fabric);
          //System.out.println(fabric.get(0));
          Integer line_num = 1;
          while((line = reader.readLine()) != null) {
            String[] claim = line.split(" ");
            Integer left = Integer.parseInt(claim[2].split(",")[0]);
            String st_top = claim[2].split(",")[1];
            Integer top = Integer.parseInt(st_top.substring(0, st_top.length()-1));
            Integer width = Integer.parseInt(claim[3].split("x")[0]);
            Integer height = Integer.parseInt(claim[3].split("x")[1]);
            //System.out.println("left:"+left+"top:"+top+"width:"+width+"height:"+height);
            Boolean flag = true;
            for (int j = 0; j < height; j++){
              String change = fabric.get(top+j);
              char[] array_line = change.toCharArray();
              for (int i = 0 ; i < array_line.length ; i++) {
                  if (left<=i && i<left+width) {
                    if (array_line[i] == ".".charAt(0)) {
                      array_line[i] = "O".charAt(0);
                    } else {
                      flag = false;
                      if (array_line[i] == "O".charAt(0)) {
                        array_line[i] = "X".charAt(0);
                      }
                    }
                  }
              }
              change = String.valueOf(array_line);
              fabric.set(top+j, change);
            }
            if (flag) {
              unique_claims.add(line_num);
              claim_contents.add(left);
              claim_contents.add(top);
              claim_contents.add(width);
              claim_contents.add(height);
            }
            line_num += 1;
          }

          for (int count = 0; count < unique_claims.size(); count++) {
            Integer left = claim_contents.get(0 + count*4);
            Integer top = claim_contents.get(1 + count*4);
            Integer width = claim_contents.get(2 + count*4);
            Integer height = claim_contents.get(3 + count*4);

            Boolean flag = true;
            for (int j = 0; j < height; j++){
              String change = fabric.get(top+j);
              char[] array_line = change.toCharArray();
              for (int i = 0 ; i < array_line.length ; i++) {
                if (left<=i && i<left+width) {
                  if (array_line[i] == "O".charAt(0)) {
                  } else {
                    flag = false;
                  }
                }
              }
            }
            if (flag) {
              System.out.println(unique_claims.get(count));
            }
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