import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
             check(line);
        }
    }
    
    public static void check(String str){
        String parts[] = str.split(";");
        String checkType = parts[0];
        String checkOperation = parts[1];
        String info = parts[2];
        
       // System.out.println(checkType);
        // m method , c class , v variable
        if("S".equals(checkType))
        {
            //1st we split the strings when a uppercase is found using Character
            List<Integer> indexList = new ArrayList<Integer>(); 
            for(int i = 0; i < info.length(); i++)
            {
                if(Character.isUpperCase(info.charAt(i)))
                {
                    indexList.add(i);
                }
            }
            String splitString = "";
            if(indexList.size() == 1){
                splitString = info.substring(0,indexList.get(0)) + " " + info.substring(indexList.get(0),info.length()).toLowerCase();
            }else{
                for(int i = 0; i < indexList.size();i++)
                {
                    if(i+1 == indexList.size())
                    {
                        splitString = splitString + ";" + info.substring(indexList.get(i),info.length());
                    }else{
                        splitString = splitString + ";" + info.substring(indexList.get(i),indexList.get(i+1));        
                    }
                }
            }

   
             if("V".equals(checkOperation))
            {
                String splittedStringArray[] = splitString.split(";");
                String variable= "";
                if(splittedStringArray.length == 1 ) 
                {
                    variable = info.substring(0,indexList.get(0)) + " " + info.substring(indexList.get(0),info.length()).toLowerCase(); 
                }else{
                    String method = "";
                    for (int i = 0; i < splittedStringArray.length; i++ )
                    {
                        variable = variable + splittedStringArray[i].toLowerCase()+ " ";
                    }
                    
                }
                System.out.println(variable);
            }
            //we split the strings
            if("M".equals(checkOperation))
            {
                String splittedStringArray[] = splitString.split(";");
                String method = "";
                if(splittedStringArray.length == 1 ) 
                {
                    method = info.substring(0,indexList.get(0)) + " " + info.substring(indexList.get(0),info.length() - 2 ).toLowerCase();
                   
                }else{
                    for (int i = 0; i < splittedStringArray.length; i++ )
                    {
                        method = method + splittedStringArray[i].toLowerCase() + " ";
                    }
                    
                }    
                System.out.println(method);      
            }
            if("C".equals(checkOperation))
            {
                String splittedStringArray[] = splitString.split(";");
                String strClass = "";
                for (int i = 0; i < splittedStringArray.length; i++ )
                {
                    strClass = strClass + splittedStringArray[i].toLowerCase()+ " ";
                }
                
                System.out.println(strClass.substring(1,strClass.length()));
            }      
        }
        if("C".equals(checkType))
        {
            //combine  1st remove white space in string
            String splittedInfo[] = info.split(" ");
            if("M".equals(checkOperation))
            {
                String method = "";
                for(int i = 0; i < splittedInfo.length;i++)
                {
                    if(i != 0)
                    {
                       String firstLetterCaps = splittedInfo[i].substring(0, 1);
                       int lengthString = splittedInfo[i].length();
                       String restInfo = splittedInfo[i].substring(1,lengthString);
                       
                       method = method +  firstLetterCaps.toUpperCase() + restInfo;
                    }else
                    {
                        method = splittedInfo[i].toLowerCase(); 
                    }
                    
                }
                System.out.println(method + "()");
            }
            if("C".equals(checkOperation))
            {
                String strClass = "";
                for(int i = 0; i < splittedInfo.length;i++)
                {
                    String firstLetterCaps = splittedInfo[i].substring(0, 1);
                    int lengthString = splittedInfo[i].length();
                    String restInfo = splittedInfo[i].substring(1,lengthString);
                    strClass = strClass +  firstLetterCaps.toUpperCase() + restInfo;
                }
                System.out.println(strClass);
            }
            if("V".equals(checkOperation))
            {
               String method = "";
                for(int i = 0; i < splittedInfo.length;i++)
                {
                    if(i != 0)
                    {
                       String firstLetterCaps = splittedInfo[i].substring(0, 1);
                       int lengthString = splittedInfo[i].length();
                       String restInfo = splittedInfo[i].substring(1,lengthString);
                       
                       method = method +  firstLetterCaps.toUpperCase() + restInfo;
                    }else
                    {
                        method = splittedInfo[i].toLowerCase(); 
                    }
                    
                }
                System.out.println(method);
            }
        }
    }
}
