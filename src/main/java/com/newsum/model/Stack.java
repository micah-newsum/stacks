package com.newsum.model;

public interface Stack<T>{
  T pop();

  void push(T t);

  T peek();
}
