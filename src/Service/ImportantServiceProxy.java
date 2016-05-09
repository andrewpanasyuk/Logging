package Service;

import Processor.EnableLogging;
import Processor.LogItInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * Created by a_pan on 08.05.2016.
 */
public class ImportantServiceProxy {


    public static Object getNewProxyObject(Object proxied, Class<?> interfase) {

        if (proxied.getClass().isAnnotationPresent(EnableLogging.class)) {
            Object proxy = Proxy.newProxyInstance(LogItInvocationHandler.class.getClassLoader(),
                    new Class[]{interfase},
                    new LogItInvocationHandler(proxied));
            return proxy;
        }
        return proxied;

    }
}
