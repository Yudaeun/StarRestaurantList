package com.example.io;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext context;
    //set메서드를 통해 주입받은 applicationcontext를 static 변수에 할당한다.
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }//ApplicationContext를 만들 때, set메서드를 통해 applicationContext를 주입해준다.(스프링이)
    public static ApplicationContext getContext(){
        return context;
    }
}
