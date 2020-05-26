class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> temp = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (temp.empty()) {
            temp.push(x);
        } else {
            if (x <= temp.peek()) {
                temp.push(x);
            }
        }
    }

    public void pop() {
        if (stack.pop().equals(temp.peek())) {
            temp.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return temp.peek();
    }
}