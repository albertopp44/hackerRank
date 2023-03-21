import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        List<Integer> records = new ArrayList<Integer>();
        records.add(scores.get(0)); //index 0 stores max value we initlize at 0
        records.add(scores.get(0)); //index 1 stores min value we initialize it at 0
        List<Integer> minMax = new ArrayList<Integer>();
        minMax.add(0);
        minMax.add(0);
        for(int i = 0; i < scores.size(); i++){
            System.out.println("score " + scores.get(i));
            System.out.println("max " + records.get(0));
            System.out.println("min " + records.get(1)); 
            if(records.get(0) < scores.get(i)){
                records.set(0,scores.get(i));
                minMax.set(0,minMax.get(0) + 1);
            } 
            if(records.get(1) > scores.get(i)){
                records.set(1,scores.get(i));
                 minMax.set(1,minMax.get(1) + 1);
            } 
            
            System.out.println("after max " + records.get(0));
            System.out.println("after min " + records.get(1)); 
        
        }
        
        return minMax;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
