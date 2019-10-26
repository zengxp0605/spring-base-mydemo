package com.stan.test;

import com.stan.dao.UserDao;
import com.stan.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest {
    public static void main(String[] args) {
        baseTest();

        System.out.println("========================");

        beanXmlTest();
    }

    // 使用xml配置bean,spring实现IOC
    public static void beanXmlTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.sayHello();
    }

    // 不使用Spring的bean,传统方式调用
    public static void baseTest(){
        HelloService helloService = new HelloService();
        helloService.setMyNickName("Zouzou");

        UserDao userDao = new UserDao();
        userDao.setName("XiaoLi");
        // 手动注入依赖
        helloService.setUserDao(userDao);

        helloService.sayHello();
    }
}
