package brush.algorithms4.library.watch;

/**
 * @author: lazecoding
 * @date: 2021/2/1 22:51
 * @description: 计时器
 */
public class StopWatch {

    private final long start;

    /**
     * Create a stopwatch object.
     */
    public StopWatch() {
        start = System.currentTimeMillis();
    }


    /**
     * Return elapsed time (in seconds) since this object was created.
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        StopWatch watcher = new StopWatch();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double time = watcher.elapsedTime();
        System.out.println(time+" ms");
    }

}

