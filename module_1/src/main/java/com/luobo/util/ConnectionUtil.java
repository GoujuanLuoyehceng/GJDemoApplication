package com.luobo.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {
    public static Connection connection;
    public static Connection getConnection() throws IOException, TimeoutException {
        if(connection!=null){
            return connection;
        }
        synchronized (ConnectionUtil.class){
            if(connection==null){
                ConnectionFactory factory = new ConnectionFactory();
                //设置服务地址
                factory.setHost("192.168.1.103");
                //端口
                factory.setPort(5672);
                //设置账号信息，用户名、密码、vhost
                factory.setVirtualHost("/kavito");//设置虚拟机，一个mq服务可以设置多个虚拟机，每个虚拟机就相当于一个独立的mq
                factory.setUsername("kavito");
                factory.setPassword("123456");
                // 通过工厂获取连接
                connection = factory.newConnection();
            }
        }
        return connection;
    }
}
