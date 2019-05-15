package com.example.springMvc.beanRigest;



import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomizeBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("calculateService".equals(beanName)) {
            //打印当前堆栈
           // Utils.printTrack("do postProcess before initialization");
            CalculateService calculateService = (CalculateService)bean;
            //修改calculateService实例的成员变量serviceDesc的值
            calculateService.setServiceDesc("desc from " + this.getClass().getSimpleName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("calculateService".equals(beanName)) {
            //打印当前堆栈
           // Utils.printTrack("do postProcess after initialization");
        }
        return bean;
    }
}

