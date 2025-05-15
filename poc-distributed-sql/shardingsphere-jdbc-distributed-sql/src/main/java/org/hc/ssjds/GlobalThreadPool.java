package org.hc.ssjds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GlobalThreadPool {

    private static ExecutorService executor;
    private static int corePoolSize = Runtime.getRuntime()
            .availableProcessors();

    private GlobalThreadPool() {
    }

    static {
        init();
    }

    synchronized public static void init() {
        if (null != executor) {
            executor.shutdownNow();
        }
        executor = new ThreadPoolExecutor(corePoolSize * 2, corePoolSize * 5,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(
                Integer.MAX_VALUE),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static ExecutorService getExecutor() {
        return executor;
    }

}
