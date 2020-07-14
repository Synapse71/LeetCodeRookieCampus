class Foo {
    private volatile int counter;
    private final Object lock = new Object();

    public Foo() {
        synchronized (lock) {
            counter = 0;
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            counter = 1;
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (counter != 1) {
                lock.wait();
            }
            counter=2;
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (counter != 2) {
                lock.wait();
            }
            counter = 3;
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            lock.notifyAll();
        }
    }
}