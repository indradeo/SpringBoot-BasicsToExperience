package in.dev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		
		PaymentUtil payment= context.getBean(PaymentUtil.class);
		
		payment.startPayment();
	
	}

}
