package com.newsum.model;

import java.util.LinkedList;

/**
 * The JDK does not provide a link list backed Stack implementation.
 */
public class LinkedListStack<T> implements Stack<T>{
  private LinkedList<T> stack;

  public LinkedListStack(){
    this.stack = new LinkedList<T>();
  }

  @Override
  public void push(T t) {
    stack.push(t);
  }

  @Override
  public T pop() {
    return stack.pop();
  }

  @Override
  public T peek() {
    return stack.peek();
  }

  @Override
  public String toString() {
    String s = "";
    for (T t : stack){
      s += t.toString();
    }
    return s;
  }
}
