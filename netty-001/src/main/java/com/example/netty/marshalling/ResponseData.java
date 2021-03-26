package com.example.netty.marshalling;

import lombok.Data;

import java.io.Serializable;

/**
 * @author eddie.lee
 * @ProjectName netty-demo
 * @Package com.example.netty.marshalling
 * @ClassName ResponseData
 * @description
 * @date created in 2021-03-26 15:53
 * @modified by
 */
@Data
public class ResponseData implements Serializable {

    private static final long serialVersionUID = -90000071L;

    private String id;

    private String name;

    private String responseMessage;

}
