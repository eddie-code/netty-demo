package com.example.netty.marshalling;

import lombok.Data;

import java.io.Serializable;

/**
 * @author eddie.lee
 * @ProjectName netty-demo
 * @Package com.example.netty.marshalling
 * @ClassName RequestData
 * @description 请求对象
 * @date created in 2021-03-26 15:51
 * @modified by
 */
@Data
public class RequestData implements Serializable {

    private static final long serialVersionUID = -7022524411862438L;

    private String id;

    private String name;

    private String requestMessage;

    private byte[] attachment;

}
