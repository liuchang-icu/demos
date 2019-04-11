package com.example.websocket_stomp.beans;

import java.io.Serializable;

/**
 * @Author:lc 1576406464@qq.com
 * @Date: 2018/6/13
 */
public class Message implements Serializable {
    public String fName;
    public String tName;
    public String content;
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
