package org.example.chapter26;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Time;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.*;

public class ParallelPrime {

    public static final int SZ = 100_000_000;
    // 甚至连这样都可以运行：
    // public static final int SZ = 1_000_000_000;
    public static final long CHECK = (long)SZ * ((long)SZ + 1)/2; // 高斯公式

    public static boolean isPrime(long n){

        boolean result = rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);

        return result;
    }


    public static boolean gsGs(LongSupplier operation){

        long result = operation.getAsLong();

        return false;
    }


    public static void main(String[] args) {

        //
        StopWatch started = StopWatch.createStarted();
        List<String> collect = iterate(2, i -> i + 1)
//                .parallel()
                .filter(ParallelPrime::isPrime)
                .limit(100000)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        started.stop();

        System.out.println(started.getTime(TimeUnit.MILLISECONDS));
        started.reset();
        try {
            Files.write(Paths.get("primes.txt"), collect, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //高斯公式
        started.start();
        Runnable runnable = () -> rangeClosed(0, SZ).sum();
        runnable.run();
        started.stop();
        System.out.println(started.getTime(TimeUnit.MILLISECONDS));
        started.reset();


        //高斯公式
        started.start();
        Runnable runnableParallel = () -> rangeClosed(0, SZ).parallel().sum();
        runnableParallel.run();
        started.stop();
        System.out.println(started.getTime(TimeUnit.MILLISECONDS));
        started.reset();


        started.start();
        Runnable runnableIter = () ->
                LongStream.iterate(0, i -> i + 1)
                        .limit(SZ+1).sum();
        runnableIter.run();
        started.stop();
        System.out.println(started.getTime(TimeUnit.MILLISECONDS));
        started.reset();



        started.start();
        Runnable runnableIterParaller = () ->
                LongStream.iterate(0, i -> i + 1).parallel()
                        .limit(SZ+1).sum();
        runnableIter.run();
        started.stop();
        System.out.println(started.getTime(TimeUnit.MILLISECONDS));
        started.reset();
    }
}
