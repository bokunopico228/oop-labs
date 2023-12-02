package org.example;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;

public class StringCalculator{
    public int add(String numbers){
        int res = 0;
        if (numbers.isEmpty()){
            return res;
        }

        String patt = "^//.\\\\n";
        Pattern p = Pattern.compile(patt);
        Matcher m = p.matcher(numbers);

        String patt2 = "^//(\\Q[\\E.+])+\\\\n";
        Pattern p2 = Pattern.compile(patt2);
        Matcher m2 = p2.matcher(numbers);

        if (m.find()){
            char del = numbers.charAt(2);
            numbers = numbers.substring(m.end());
            numbers = numbers.replace(del,',');

        }else if (m2.find()){
            int a = numbers.indexOf("]\\n");
            String[] dels = numbers.substring(3, a).split("]\\[");
            numbers = numbers.substring(m2.end());

            Arrays.sort(dels, Comparator.comparingInt(String::length).reversed());
//            System.out.println(Arrays.toString(dels));
            for (String del : dels){
                numbers = numbers.replace(del,",");
            }
        }

        numbers = numbers.replaceAll("\\\\n",",");
        String[] num_array = numbers.split(",");

        if (numbers.endsWith(",")){
            throw new IllegalArgumentException("incorrect input");
        }

        String negNums = "";

        for (String num : num_array){
            try{
                if (Integer.parseInt(num)>1000){
                    res += 0;
                } else{
                    res += Integer.parseInt(num);
                }
                if (Integer.parseInt(num)<0){
                    negNums = negNums.concat(num+" ");
                }
            } catch (NumberFormatException e){
                if (!negNums.isEmpty()){
                    throw new IllegalArgumentException(String.format("negatives not allowed. found negative numbers: "+negNums+
                            "\n'%s' is not an integer",num));
                }
                throw new IllegalArgumentException(String.format("'%s' is not an integer",num));
            }
        }
        if (!negNums.isEmpty()){
            throw new IllegalArgumentException("negatives not allowed. found negative numbers: "+negNums);
        }
        return res;
    }
}