package com.jiajia.proxy;

import org.junit.Test;

public class TestProxy {
    @Test
   public void test(){
       Human human = new SuperMan();
       Human proxyInstance = (Human)MyProxyFactory.produceProxyInstance(human);
       System.out.println(proxyInstance.getBelief());
       proxyInstance.eat("ЕЈИв");
   }
}
