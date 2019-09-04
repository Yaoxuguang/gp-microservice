package com.yao.microservice.xmg.phaseone.springboot.mvc.rest.converter;

import com.yao.microservice.xmg.phaseone.springboot.mvc.rest.domian.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 自定义媒体类型处理类
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/9/4 14:50
 */
public class PropertiesPersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {
    public PropertiesPersonHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = inputMessage.getBody();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(inputStream,getDefaultCharset()));
        Person person = new Person();
        person.setUsername(properties.getProperty("person.username"));
        person.setPassword(properties.getProperty("person.password"));
        return person;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = outputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("person.username",person.getUsername());
        properties.setProperty("person.password",person.getPassword());
        properties.store(new OutputStreamWriter(outputStream,getDefaultCharset()),"Written by web server");
    }
}
