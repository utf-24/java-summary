package com.yzy.demo.rpc;

/**
 * @author young
 * @date 2019/7/4 14:48
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping!=null? ping+ "--> i'm ok.":"i'm ok.";
    }
}
