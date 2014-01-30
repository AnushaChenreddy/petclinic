import java.util.Scanner;
import java.io.*;

public class FooBarBaz {
    static final String output_path = "C:\\Users\\Anusha\\Desktop\\Spring_2014\\Studio\\CourseWork\\foobarbaz.txt";
    static FileWriter fw;

    public static void main(String args[]) throws Exception {
        fw = new FileWriter(output_path, false);
        while (true) {
            String out = foobar();
            if (out.equals("0")) {
                break;
            }
            System.out.println(out);
            writeFile(out);
        }

    }

    // Method to write some text content on to a file.
    public static void writeFile(String input) {
        try {
            fw = new FileWriter(output_path, true);
            fw.write(input + "\n");
            fw.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // This method takes input at runtime and returns appropriate stmt.
    // Takes any valid integer without any specific upper bound.
    public static String foobar() {
        Scanner scan = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Please enter an integer. Enter 0 to stop:");
                int num = scan.nextInt();
                if (num == 0) {
                    return "0";
                }
                if (num % 3 == 0 && num % 5 == 0) {
                    return "Foo Bar";
                }
                else if (num % 5 == 0) {
                    return "Bar";
                }
                else if (num % 3 == 0) {
                    return "Foo";
                }
                else if (num % 7 == 0) {
                    return "Baz";
                }
                else {
                    return num + "";
                }
            }
        }
        catch (Exception e) {
            return "Invalid Input";
        }

    }
}