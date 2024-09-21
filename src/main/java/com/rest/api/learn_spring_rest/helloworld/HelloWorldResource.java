package com.rest.api.learn_spring_rest.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller //you need to map this app to view
@RestController //It is the combination of Controller and Response body annotations
public class HelloWorldResource {

    @RequestMapping("/hello-world")
//    @ResponseBody //We're using @RestController annotation instead of this
    public String getInfo() {
        return "Hey man!";
    }

    @RequestMapping("/hello-world-bean")
//    @ResponseBody //We're using @RestController annotation instead of this
    public HelloWorldBean getInfoBean() {
        return new HelloWorldBean("Hey man!");
    }

    @RequestMapping("/hello-world-path/{name}")
    public HelloWorldBean getInfopath(@PathVariable String name) {
        return new HelloWorldBean("Hey " + name + "!, Welcome Home :)");
    }
}
