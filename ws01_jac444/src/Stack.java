// Name:  Tracy Nguyen
// Student ID: 127270171
// Email:  tnguyen157@myseneca.ca
// Date of completion: Jan 2019
//
// I confirm that the content of this file was created by me,
// with exception of the parts provided to me by my professor

public class Stack {
    private int top;
    private char[] arr;

    // pop() returns the element at the "top" of the stack
    // and removes it
    public char pop() {
        // Decrement top to simulate removal of character
        return arr[top--];
    }

    // Push(element) will push the element onto the stack
    // and return that element (Pushes from right to left <<)
    public void push(String str) {
        // Take out whitespace before storing in array
        str = str.replaceAll("\\s", "");

        this.arr = new char[str.length()];
        this.arr = str.toCharArray();

        top = str.length() - 1;

        return;
    }

    // Stack is empty if "top" reached the end of string
    public boolean empty() {
        return (top == -1);
    }

}
