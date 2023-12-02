package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringCalculator sc = new StringCalculator();

        String inp;
        Scanner scan = new Scanner(System.in);

        while (true) {
            try{
                System.out.print("""
                ----------
                enter numbers divided by ',' or '\\n'.
                to set a custom delimiter use this template: //[delimiter]\\n[numbers] (e.g.: //*\\n1,2\\n3*4).
                to quit enter q:\s""");

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