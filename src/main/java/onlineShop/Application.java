package onlineShop;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import onlineShop.log.PaymentAction;

public class Application {
    public static void main(String[] args) {
    	ApplicationContext container = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PaymentAction paymentAction = (PaymentAction) container.getBean("paymentAction");
        paymentAction.pay(new BigDecimal(2)); 
     }
}


