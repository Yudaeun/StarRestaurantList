package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        String url="www.naver.con/books/it?page=10&size=20&name=spring-boot";
        //Base 64 encoding
        Encoder encoder=new Encoder(new UrlEncoder()); //DI적용. 외부에서 사용하는 객체를 주입함
        String result=encoder.encode(url);
        System.out.println(result);

        }

}
