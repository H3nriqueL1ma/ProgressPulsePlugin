package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads;

import java.util.concurrent.ExecutorService;

public interface VirtualThreadManager {
    default ExecutorService newPoolExecutor(int threadsNumber) {
        return null;
    }
    default ExecutorService newSingleExecutor() {
        return null;
    }
}
