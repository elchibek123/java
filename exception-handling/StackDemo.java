class StackOverFlow extends Exception {
    @Override
    public String toString() {
        return "Stack is full";
    }
}

class StackUnderFlow extends Exception {
    @Override
    public String toString() {
        return "Stack is empty";
    }
}

class Stack {
    private int size;
    private int top = -1;
    private int S[];

    public Stack(int sz) {
        size = sz;
        S = new int[sz];
    }

    public void push(int x) throws StackOverFlow {
        if (top == size - 1) {
            throw new StackOverFlow();
        }
        top++;
        S[top] = x;
    }

    public int pop() throws StackUnderFlow {
        int x = -1;

        if(top == -1)
            throw new StackUnderFlow();
        x = S[top];
        top--;
        return x;
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack st = new Stack(5);

        try {
            st.push(43);
            System.out.println(st.pop());
            System.out.println(st.pop());

        } catch (StackOverFlow e) {
            System.out.println(e);
        } catch (StackUnderFlow e) {
            System.out.println(e);
        }
    }
}