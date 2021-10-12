package stack.and.queue;


import stack.and.queue.Generics.Stack;

public class ValidateBrackets {
  public ValidateBrackets() {
  }

  public boolean validBrackets(String str) {
    Stack<Character> stack = new Stack<>();
    if (str.length() == 0) {
      System.out.println("Empty String");
      return false;
    }
    for (int i = 0; i < str.length(); i++) {
      try {
        if ((str.charAt(i) == '(') || (str.charAt(i) == '{') || (str.charAt(i) == '[')) {
          stack.push(str.charAt(i));
        } else if ((str.charAt(i) == ')') && (stack.peek() == '(')) {
          System.out.println(stack.pop());
        } else if ((str.charAt(i) == '}') && (stack.peek() == '{')) {
          System.out.println(stack.pop());
        } else if ((str.charAt(i) == ']') && (stack.peek() == '[')) {
          System.out.println(stack.pop());
        }
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    }
    return stack.isEmpty();
  }
}
