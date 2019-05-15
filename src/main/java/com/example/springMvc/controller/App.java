package com.example.springMvc.controller;

public class App {
    public final static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public void setThreadLocal(String value){
        threadLocal.set(value);
    }
    public String getThreadLocal(){
        return threadLocal.get();
    }
    public static void main(String[] args) {
        System.out.println("hello");
        App app = new App();
       app.setThreadLocal("hello");
       App app1 = new App();
       System.out.println(app.getThreadLocal());
        System.out.println(app1.getThreadLocal());
        new Thread(() -> {
            System.out.println(app1.getThreadLocal());
        }).start();

    }
}
