package Processor;

import Service.Logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by a_pan on 08.05.2016.
 */
public class LogItInvocationHandler implements InvocationHandler {
    private Object proxyObject;

    public LogItInvocationHandler(Object proxyObject) {
        this.proxyObject = proxyObject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Method mtd = proxyObject.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (mtd.isAnnotationPresent(LogIt.class)) {
            Logging.addLog(proxyObject.getClass().getSimpleName() + "." + mtd.getName());
        }

        return method.invoke(proxyObject, args);
    }
}
