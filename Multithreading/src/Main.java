import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

//    public static int factorial(int n) {
//        int result = 1;
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        for(int i=1;i<=n;i++) {
//            result *= i;
//        }
//
//        return result;
//    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //        long startTime = System.currentTimeMillis();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        for(int i=1;i<10;i++) {
//            int finalI = i;
//            executorService.submit(() -> System.out.println(factorial(finalI)));
//        }
//
//        executorService.shutdown();
//        executorService.awaitTermination(100, TimeUnit.SECONDS);

//        Thread[] threads = new Thread[9];
//        for(int i=0;i<9;i++) {
//            int finalI = i;
//            threads[i] = new Thread(() -> {
//                System.out.println(factorial(finalI));
//            });
//            threads[i].start();
//        }
//
//        for(Thread thread : threads) {
//            thread.join();
//        }

//        System.out.println("Time taken : " + (System.currentTimeMillis() - startTime));

//        Runnable runnable = () -> "Hello"; use when you don't have to return anything
//        Callable<String> callable = () -> "Hello"; // use when you have to return something
//
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<?> future = executorService.submit(callable);
//
//        if(future.isDone()) {
//            System.out.println(future.get());
//        }
//
//        System.out.println(future.get()); // get method waits for task to complete
//        executorService.shutdown();
//        System.out.println(executorService.isTerminated());
//
//        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
//
//        Callable callable1 = () -> 1;
//        Callable callable2 = () -> 2;
//        Callable callable3 = () -> 3;
//
//        List<Callable<Integer>> callableList = Arrays.asList(callable1,callable2,callable3);
//
//        List<Future<Integer>> futures = executorService1.invokeAll(callableList, 1, TimeUnit.SECONDS);
//        Integer i = executorService1.invokeAny(callableList);
//
//        for(Future<Integer> f : futures) {
//            System.out.println(f.get());
//        }
//
//        executorService1.shutdown();

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Hello"), 5, 5, TimeUnit.SECONDS);
//
//        scheduledExecutorService.schedule(() -> {
//            System.out.println("Initializing Shut Down...");
//            scheduledExecutorService.shutdown();
//        }, 20, TimeUnit.SECONDS);

        // CompletableFuture -> Used to achieve asynchronous programming in multithreaded environment

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(100);
//                System.out.println("Thread");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "ok";
//        });
//
//        completableFuture.get();
//        System.out.println("Main");

        Runnable runnable = ()-> System.out.println("Hello");

        Thread thread = new Thread(()-> System.out.println("Hello"));
        thread.start();
    }
}