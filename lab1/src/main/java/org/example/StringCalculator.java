package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator{
    public int add(String numbers){
        int res = 0;
        if (numbers.isEmpty()){
            return res;
        }

        String patt = "^//.\\\\n";

        Pattern p = Pattern.compile(patt);
        Matcher m = p.matcher(numbers);

        if (m.find()) {
            char del = numbers.charAt(2);
            int end = m.end();
            numbers = numbers.substring(end);
            numbers = numbers.replace(del,',');
        }

        numbers = numbers.replaceAll("\\\\n",",");
        String[] num_array = numbers.split(",");

        if (numbers.endsWith(",")){
            throw new IllegalArgumentException("incorrect input");
        }

        for (String num : num_array){
            try{
                res += Integer.parseInt(num);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException(String.format("'%s' is not an integer",num));
            }
        }
        return res;
    }
}