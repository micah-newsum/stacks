package com.newsum;

import com.newsum.model.ArrayStack;
import com.newsum.model.Employee;
import com.newsum.model.LinkedListStack;
import com.newsum.model.Stack;

public class Application {
  public static void main(String[] args) {
    arrayStackClient();

    printResult("Racecar");
    printResult("Did I, I did?");
    printResult("Micah");
    printResult("Hannah");
  }

  public static void arrayStackClient(){
    Stack<Employee> stack = new ArrayStack<>(2);
    stack.push(new Employee("John","Doe",1));
    stack.push(new Employee("Jane","Doe",2));
    stack.push(new Employee("Bill","Smith",1));

    // after pushes
    System.out.println(stack);

    System.out.println("Peeked: "+stack.peek());

    // after peek
    System.out.println(stack);
    System.out.println("Popped: "+stack.pop());

    // after pop
    System.out.println(stack);
  }

  /**
   * Time complexity is O(n)
   * @param input
   * @return
   */
  public static boolean isPalidrome(String input){
    if (input == null){
      throw new IllegalArgumentException();
    }

    String rawText = input.replaceAll("[^a-zA-Z ]", "").replace(" ","").toLowerCase();
    String reverseText = "";

    Stack<Character> stack = new LinkedListStack<>();

    for (int i = 0; i < rawText.length(); i++){
      stack.push(rawText.charAt(i));
    }

    for (int i = 0; i < rawText.length(); i++){
      reverseText += stack.pop();
    }

    return (rawText.equals(reverseText));
  }

  public static void printResult(String input){
    System.out.printf(isPalidrome(input) ? "'%s' is a palindrome\n" : "'%s' is not a palindrome\n",input);
  }
}
