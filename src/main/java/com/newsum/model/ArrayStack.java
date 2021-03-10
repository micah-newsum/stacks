package com.newsum.model;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
  private Object[] stack;
  private int top;

  public ArrayStack(int capacity) {
    this.stack = new Object[capacity];
  }

  @Override
  public T pop() {
    if (top == 0) {
      throw new EmptyStackException();
    }

    // some implementations choose to reduce size of array here below a certain threshold to conserve memory. However, doing so causes the pop operation to
    // have a time complexity of O(n)

    T t = (T) stack[--top];
    stack[top] = null;
    return t;
  }

  @Override
  public void push(T t) {
    // time complexity is O(n)
    if (top == stack.length) {
      Object[] tempArray = new Object[2 * stack.length];
      System.arraycopy(stack, 0, tempArray, 0, stack.length);
      stack = tempArray;
      tempArray = null;
    }

    stack[top] = t;
    top++;
  }

  @Override
  public T peek() {
    if (top == 0) {
      throw new EmptyStackException();
    }

    return (T) stack[top - 1];
  }

  @Override
  public String toString() {
    String s = "ArrayStack{";

    for (Object o : stack) {
      T t = (T) o;
      if (t != null) {
        s += t.toString()+", ";
      }
    }

    s += "}, top=" + top +
        '}';
    return s;
  }
}
