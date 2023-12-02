package org.example;

public class StringCalculator{
    public int add(String numbers){
        int res = 0;
        if (numbers.isEmpty()){
            return res;
        }
        String[] num_array = numbers.split(",");
        if (num_array.length > 2 || numbers.endsWith(",")){
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