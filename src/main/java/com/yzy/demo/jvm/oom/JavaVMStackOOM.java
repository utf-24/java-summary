package com.yzy.demo.jvm.oom;

/**
 * VM Args：-Xss2M（这时候不妨设置大些） set thread stack size
 * hotspot虚拟机不支持内存动态拓展，在windows系统下该程序不会产生OOM，而是会导致系统死机
 * @author young
 * @date 2019/6/6 11:14
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while(true){

        }
    }
    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
