package org.example.chapter26;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountingStream {


    static class CountTask implements Callable<Integer> {
        private int  i ;


        public CountTask(int i){
            this.i = i;
        }


        @Override
        public Integer call() throws Exception {

            return 1;
        }
    }



    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        IntStream.range(0,10).parallel().mapToObj(CountTask::new).map(countTask -> {
            try {
                return countTask.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).reduce(0,Integer::sum);
    }
}
