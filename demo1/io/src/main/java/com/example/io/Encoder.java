package com.example.io;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//여기서 Component로 만들어버리면 Base64랑 Url 둘 다 Bean이 되었기 때문에 어떤 것을 써야 할지 모르게 된다.
//그래서 @Qualifier 어노테이션을 이용해서 어떤 것을 쓸 거라고 지정을 해줘야 한다.
public class Encoder{
    private IEncoder iEncoder;

    public Encoder(@Qualifier("urlEncoder") Base64Encoder iEncoder){ this.iEncoder=iEncoder;}
    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }
    public String encode(String message) { return iEncoder.encode(message);}
}
