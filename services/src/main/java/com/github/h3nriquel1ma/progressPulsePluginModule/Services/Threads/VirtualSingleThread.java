package com.github.h3nriquel1ma.progressPulsePluginModule.Services.Threads;

import com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Threads.VirtualThreadManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualSingleThread implements VirtualThreadManager {

    @Override
    public ExecutorService newSingleExecutor() {
        return Executors.newSingleThreadExecutor();
    }
}
