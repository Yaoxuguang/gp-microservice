package com.yao.microservice.xmg.phaseone.springboot.mvc.rest.controller;

import com.yao.microservice.xmg.phaseone.springboot.mvc.rest.domian.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/9/4 10:33
 */
@RestController
@RequestMapping("/rest")
public class RestTestController {
    @GetMapping(value = "/getPerson",produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(){
        Person person = new Person();
        person.setUsername("yao");
        person.setPassword("123ali");
        return person;
    }

    @GetMapping(value = "/testPropertiesPerson",produces = "application/properties+person")
    public Person testPropertiesPerson(){
        Person person = new Person();
        person.setUsername("中国");
        person.setPassword("19491001");
        return person;
    }

    @PostMapping(value = "/testJson2PropertiesPerson",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/properties+person")
    public Person testJson2PropertiesPerson(@RequestBody Person person){
        return person;
    }

    @PostMapping(value = "/testPropertiesPerson2Xml",
            consumes = "application/properties+person",
            produces = MediaType.APPLICATION_XML_VALUE)
    public Person testPropertiesPerson2Xml(@RequestBody Person person){
        return person;
    }

}
