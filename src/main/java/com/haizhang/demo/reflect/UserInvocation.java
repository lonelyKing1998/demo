package com.haizhang.demo.reflect;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class UserInvocation implements InvocationHandler  {

    private Object target;

    public void setUserService(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName()+" ____ "+method.getName()+" _____ "+ Arrays.toString(args));
        Object result = method.invoke(target, args);
        System.out.println("调用结束，结果是"+result);
        return result;
    }
    

}
