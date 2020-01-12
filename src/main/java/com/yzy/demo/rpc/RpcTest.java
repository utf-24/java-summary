package com.yzy.demo.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author young
 * @date 2019/7/4 15:36
 */
public class RpcTest {
    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8089);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class,
                new InetSocketAddress("localhost",8089));
        System.out.println(echo.echo("are you ok?"));
    }
}
