package pw.quickbin.main.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactory {

    public final int CORE_POOL_SIZE = 1;
    public final int MAXIMUM_POOL_SIZE = Integer.MAX_VALUE;
    public final int KEEP_ALIVE_TIME = 120;
    public final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public final ExecutorService executorService = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, new SynchronousQueue<>());

}
