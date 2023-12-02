package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();

        String inp;
        Scanner scan = new Scanner(System.in);

        while (true) {
            try{
                System.out.print("enter numbers divided by ',' or q to quit: ");
                inp = scan.nextLine();
                if (inp.equals("q")) {
                    break;
                }
                int res = sc.add(inp);
                System.out.println("result: " + res);

            } catch (Exception e) {
                System.out.println("something went wrong: " + e.getMessage());
            }
        }
        scan.close();
    }
}