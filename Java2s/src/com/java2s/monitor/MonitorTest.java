package com.java2s.monitor;

import javax.management.monitor.Monitor;

public class MonitorTest extends Monitor {
    public static void main(String[] args) {
        Monitor monitor = new MonitorTest();
        System.out.println(monitor.isActive());
    }

    @Override
    public void start() {
        System.out.println("Monitor started");
    }

    @Override
    public void stop() {
        System.out.println("Monitor stopped");
    }
}
