// Name:  Tracy Nguyen
// Student ID: 127270171
// Email:  tnguyen157@myseneca.ca
// Date of completion: Jan 2019
//
// I confirm that the content of this file was created by me,
// with exception of the parts provided to me by my professor

import java.lang.String;

public class Palindrome {

    public static void main(String[] args) {
        // Check if there are any command line arguments
        if (args.length > 0) {
            for (String str : args) {
                // Create new object every time to reuse reference. Unreferenced objects will be collected by JVM
                Stack stkObj = new Stack();
                StringBuilder strReversed = new StringBuilder();

                stkObj.push(str);

                // Copy string in reverse order
                while (!stkObj.empty()) {
                    strReversed.append(stkObj.pop());
                }

                // Compare reversed string to string
                // ignoring whitespaces and cases
                if(str.replaceAll("\\s", "").equalsIgnoreCase(strReversed.toString())){
                    System.out.println(str + " is a palindrome!");
                }
                else {
                    System.out.println(str + " is not a palindrome!");
                }
            }
        }
    }
}


