import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>();

        System.out.println(stack.empty());

        stack.push("firstItem");
        stack.push("secondItem");
        stack.push("thirdItem");
        stack.push("fourthItem");
        stack.push("fifthItem");

        String newStr = stack.pop();

        String newPeek = stack.peek();

        System.out.println(stack);
        System.out.println(newStr);
        System.out.println(newPeek);
        System.out.println(stack.search("firstItem"));
    }
}