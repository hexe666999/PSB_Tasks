package com.company;

import java.util.Date;

public class LogObject {
    Date date = new Date();
    String name;
    String host;
    String apiFunction;
    int messageByte;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApiFunction() {
        return apiFunction;
    }

    public void setApiFunction(String apiFunction) {
        this.apiFunction = apiFunction;
    }

    public int getMessageByte() {
        return messageByte;
    }

    public void setMessageByte(int messageByte) {
        this.messageByte = messageByte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
