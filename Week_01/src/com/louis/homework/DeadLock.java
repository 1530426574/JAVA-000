package src.com.louis.homework;

public class DeadLock extends Thread {
        private String first;
        private String second;

        public DeadLock(String name, String first, String second) {
            super(name);
            this.first = first;
            this.second = second;
        }

        @Override
        public void run() {
            synchronized (first) {
                System.out.println(this.getName() + " get lock: " + first);
                try {
                    Thread.sleep(1000);
                    synchronized (second) {
                        System.out.println(this.getName() + " get lock: " + second);
                    }
                } catch (InterruptedException e) {

                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            String lockA = "LockA";
            String lockB = "LockB";

            DeadLock t1 = new DeadLock("Thread1", lockA, lockB);
            DeadLock t2 = new DeadLock("Thread2", lockB, lockA);

            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
    }

