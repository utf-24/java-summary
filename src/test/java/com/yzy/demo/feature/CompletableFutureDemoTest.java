package com.yzy.demo.feature;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CompletableFutureDemoTest {

    ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "customer-executor-" + count++);
        }
    });

    @Test
    public void thenAcceptExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message")
                .thenAccept(s -> result.append(s));
        assertTrue("Result was empty", result.toString().equals("thenAccept message"));
    }

    @Test
    public void thenAcceptAsyncExample() throws InterruptedException {
        StringBuilder result = new StringBuilder();
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("thenAcceptAsync message")
                .thenAcceptAsync(s -> result.append(s));
        cf.join();
        assertTrue("Result was empty", result.length() > 0);
    }

    @Test
    public void thenApplyAsyncTest() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message")
                .thenApplyAsync(s -> {
                    assertTrue(Thread.currentThread().isDaemon());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.toUpperCase();
                });
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
    }

    @Test
    public void thenApplyAsyncWithExecutorsTest() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message")
                .thenApplyAsync(s -> {
                    System.out.println(Thread.currentThread().getName());
                    assertTrue(Thread.currentThread().getName().startsWith("customer-executor-"));
                    assertFalse(Thread.currentThread().isDaemon());
                    return s.toUpperCase();
                }, executor);
        assertNull(cf.getNow(null));
        assertEquals("MESSAGE", cf.join());
    }

    @Test
    public void ApplyAsyncHandleExceptionTest() {
        CompletableFuture<Integer> cf = CompletableFuture.completedFuture(1)
                .thenApplyAsync(i -> {
                    return i / 0;
                });
        CompletableFuture<String> exceptionHandler = cf.handle((s, th) -> {
            System.out.println("s: " + s);
            System.out.println("th: " + th);
            return th != null ? "calculation cancel" : "";
        });
        cf.completeExceptionally(new RuntimeException("completed Exceptionally"));
        try {
            cf.join();
            fail("exception not throw");
        } catch (CompletionException e) {
            System.out.println("e:" + e.getCause().getMessage());
        }

        assertEquals("calculation cancel", exceptionHandler.join());
    }

    @Test
    public void NoExceptionHandlingTest() throws InterruptedException {
        System.out.println("--running completableFuture--");
        CompletableFuture<Void> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("--running task--");
                    return 1 / 0;
                })
                .thenApply(input -> {
                    System.out.println("multiply by 2");
                    return input * 2;
                })
                .thenAccept(System.out::println);

        Thread.sleep(3000);
        System.out.println("--checking exception--");
        boolean b = completableFuture.isCompletedExceptionally();
        System.out.println("completed Exceptionally: " + b);
        System.out.println("calling join");
        completableFuture.join();
    }

    @Test
    public void ExceptionHandlingTest() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> cf = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("running task");
                    return 10 / 0;
                })
                .thenApply(input -> input * 2)
                .exceptionally(exception -> {
                    System.err.println("exception: " + exception);
                    return 1;
                });
        Thread.sleep(3000);
        System.out.println("--checking exception--");
        System.out.println("completedExceptionally? " + cf.isCompletedExceptionally());
        System.out.println("--getting result--");
        System.out.println(cf.get());

    }

    @Test
    public void RunAfterBothTest() {
        String original = "message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original)
                .thenApply(String::toUpperCase)
                .runAfterBoth(CompletableFuture.completedFuture(original)
                        .thenApply(String::toLowerCase), () -> result.append("done"));
        System.out.println(result);

    }

    @Test
    public void ConsumeAfterBothTest() {
        String original = "message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original)
                .thenApply(s -> {
                    System.out.println("enter task1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("finish task1");
                    return s.toUpperCase();
                })
                .thenAcceptBoth(CompletableFuture.completedFuture(original)
                        .thenApply(s -> {
                            System.out.println("enter task2");
                            System.out.println("finish task2");
                            return s.toLowerCase();
                        }), (s1, s2) -> result.append(s1 + s2));
        System.out.println(result);
    }

    @Test
    public void combineTest() {
        String original = "message";
        CompletableFuture cf = CompletableFuture.completedFuture(original)
                .thenApply(s -> {
                    System.out.println("enter task1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("leave task1");
                    return s.toUpperCase();
                })
                .thenCombine(CompletableFuture.completedFuture(original)
                                .thenApply(s -> {
                                    System.out.println("enter task2");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("leave task2");
                                    return s.toLowerCase();
                                }),
                        (s1, s2) -> s1 + s2);
        System.out.println(cf.getNow("-1"));
    }

    @Test
    public void anyofTest() throws ExecutionException, InterruptedException {
        StringBuilder reslut = new StringBuilder();
        List messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture> futures = (List<CompletableFuture>) messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg)
                        .thenApplyAsync(s -> s.toString()))
                .collect(Collectors.toList());
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((res, th) -> {
                    futures.forEach(f -> System.out.println(f.getNow("-1")));
                    System.out.println("res: " + res);
                    System.out.println("th: " + th);
                });
        System.out.println(futures);
        System.out.println();
        futures.get(0).get();
    }

    @Test
    public void allOfTest() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("start task1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish task1");
            return 100;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("start task2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish task2");
            return 200;
        });

        CompletableFuture future = CompletableFuture.allOf(future1,future2)
                .whenComplete((res,th)->{
                    System.out.println("res: "+res);
                    System.out.println("th: " +th);
                });
        System.out.println("result: "+ future.getNow(-1));
    }

    public static Integer task1() throws InterruptedException {
        System.out.println("[task1] start..");
        Thread.sleep(2000);
        System.out.println("[task1] finish..");
        return 100;
    }

    public Boolean callTask() throws InterruptedException {
        System.out.println("[callTask] start..");
        CompletableFuture<Boolean> cf = CompletableFuture.supplyAsync(() -> {
            try {
                task1();
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }).whenComplete((res,th)->{
            System.out.println("cf finish: res =" +res);
            System.out.println("cf th =" +th);
        });
        System.out.println("[callTask] do st async..");
        cf.join();
        boolean result = cf.getNow(false);
        System.out.println("[callTask] result: "+ result);
        System.out.println("[callTask] finish..");
        return result;
    }


    @Test
    public void testFutureStage() throws InterruptedException {
        System.out.println("[testFutureStage] start call..");
        boolean result = callTask();
        System.out.println("[testFutureStage] do sth async..");
        System.out.println("[testFutureStage] finish call.. result =" +result);
    }

}