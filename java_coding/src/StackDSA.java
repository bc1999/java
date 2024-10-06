
public class StackDSA {
    char[] stack;
    int top;
    int capacity;

    public StackDSA(int capacity) {
        this.capacity = capacity;
        this.stack = new char[capacity];
        this.top = -1;
    }

    public void push(char element) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = element;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        }
        return stack[top--];
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}


