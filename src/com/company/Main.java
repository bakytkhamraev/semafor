package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static final int PASSENGERS_COUNT = 100;
    public static CountDownLatch LATCH;

    public static void main(String[] args) throws InterruptedException {

        Semaphore sem = new Semaphore(4);
        for (int i = 1; i <= 100; i++) {

            Passenger passenger = new Passenger(sem, i);
            passenger.start();
        }


        for (int i = 1; i <= PASSENGERS_COUNT; i++) {
            LATCH = new CountDownLatch(PASSENGERS_COUNT + 1);
            Bus bus = new Bus(i);
            bus.start();
            Thread.sleep(2000);

            try {
                while (LATCH.getCount() > 100) {
                    Thread.sleep(2000);
                }
            }
            catch (NullPointerException ex)
            {
            }
        }
    }
}