class CQueue {
    private Stack<Integer> items = new Stack<>();

    private Stack <Integer> temp = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        this.items.push(value);
    }

    public int deleteHead() {
        if (items.empty()) {
            return -1;
        }
        while(items.size() > 1) {
            temp.push(items.pop());
        }
        int result =  items.pop();
        while(!temp.empty()) {
            items.push(temp.pop());
        }
        return result;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */