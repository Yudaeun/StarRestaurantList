package com.example.io;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component("base64Encoder") //컴포넌트에 이름을 붙여주는 것도 가능하다.
public class Base64Encoder {
    public String encode(String message){return Base64.getEncoder().encodeToString(message.getBytes());}
}
