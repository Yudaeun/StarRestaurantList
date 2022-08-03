package com.example.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@SpringBootApplication
public class IoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IoApplication.class, args);
    }

    ApplicationContext context=ApplicationContextProvider.getContext();

    //Base64Encoder base64Encoder=context.getBean(Base64Encoder.class);
    //UrlEncoder urlEncoder=context.getBean(UrlEncoder.class);

    //Encoder encoder=new Encoder(base64Encoder);
    //Encoder encoder=context.getBean(Encoder.class);
    Encoder encoder=context.getBean("Base64Encode",Encoder.class);
    String url="www.naver.com/books/it?page=10&size=20&name=spring-boot";

    String result=encoder.encode(url);
    System.out.println(result) //Base64 인코딩한 결과

    //encoder.setIEncoder(urlEncoder);
    //result=encoder.encode(url);
    //System.out.println(result); //url 인코딩한 결과

    //new를 이용해 만들었던 Encoder를 컴포넌트로 만들어서 스프링이 객체로 관리할 수 있게 했기 때문에
    //제어의 역전이 일어났다. 이를 IOC라고 한다.
@Configuration //한 개의 클래스에서 여러 개의 Bean을 등록한다.
        //직접 Bean을 만드는 방법
    class AppConfig{
        @Bean("base64Encode")
        public Encoder encoder(Base64Encoder base64Encoder){
            return new Encoder(base64Encoder);
        }
        @Bean("UrlEncode")
        public Encoder encoder(UrlEncoder urlEncoder){
            return new Encoder(urlEncoder);
        }
    }

}
