class FooBar {
    private int n;
    Semaphore foo_lock, bar_lock;
    
    public FooBar(int n) {
        this.n = n;
        foo_lock = new Semaphore(1);
        bar_lock = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo_lock.acquire();
            printFoo.run();
            bar_lock.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar_lock.acquire();
            printBar.run();
            foo_lock.release();
        }
    }
}