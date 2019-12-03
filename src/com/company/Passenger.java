package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;



public class Passenger extends Thread {

    Semaphore sem;
    int id;

    public Passenger(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    @Override
    public void run() {

        try {
            sem.acquire();
            System.out.println("Пассажир " + id + " обслуживается на кассе и приобрел свой билет");
            sleep(2000);

            System.out.println("Пассажир " + id + " выходит из кассы");
            sem.release();
            sleep(2000);
        }
        catch (InterruptedException ie)
        {
        }
        catch (IllegalMonitorStateException ex)
        {
        }
    }
}