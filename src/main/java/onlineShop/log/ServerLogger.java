package onlineShop.log;

import org.springframework.stereotype.Component;

@Component(value = "serverLogger") // a Spring bean, let Spring to initialize the object and put into container
public class ServerLogger implements Logger {
    public void log(String info) {
        System.out.println("server log = " + info);
    }
}
