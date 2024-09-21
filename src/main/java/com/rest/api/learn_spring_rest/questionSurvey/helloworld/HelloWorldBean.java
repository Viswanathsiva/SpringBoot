package com.rest.api.learn_spring_rest.questionSurvey.helloworld;

public class HelloWorldBean {
    public HelloWorldBean(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
