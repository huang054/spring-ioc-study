package com.example.springMvc.Event;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Description : 自定义的系统广播监听器，接收所有类型的消息
 * @Author : zq2599@gmail.com
 * @Date : 2018-08-15 14:53
 */
@Service
public class AllEventListener implements ApplicationListener<ApplicationEvent>{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //为了便于了解调用栈，在日志中打印当前堆栈
        System.out.println("监听消息");
        System.out.println("onApplicationEvent : " + event);
    }
}
