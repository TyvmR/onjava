package geetime.concurrency;

import cn.hutool.core.map.MapUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class App {

    public static void main(String[] args) throws InterruptedException {

        HashMap<Integer, Integer> objectObjectHashMap = MapUtil.newHashMap();
        Collection<Integer> values = objectObjectHashMap.values();
//        Optional<Integer> max = values.stream().max().get();
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            Thread thread = Thread.currentThread();
            boolean interrupted = thread.isInterrupted();
            System.out.println("interrupted status is: " + interrupted);
            System.out.println(name  + " sleep before ");
            try {

                Thread.sleep(20000L);

            } catch (InterruptedException e) {

                e.printStackTrace();

                System.out.println("interrupted status is: " + thread.isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println("interrupted status is: " + thread.isInterrupted());

            }
            System.out.println(name  + " sleep after ");
        };

        Thread t1  = new Thread(runnable);

        t1.start();

        Thread thread = new Thread(() -> {
            System.out.println("start interept");
            t1.interrupt();
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();

        System.out.println("main ------ running");
        thread.join();


    }
}
