package in.dev;

public class PaymentUtil {
	
	CreditCard creditCard;
	
//	public PaymentUtil() {
//		// TODO Auto-generated constructor stub
//	}
	
	public PaymentUtil(CreditCard creditCard) {
		this.creditCard=creditCard;
	}
	
//	public void setCreditCard(CreditCard creditCard) {
//		this.creditCard=creditCard;
//	}
	
	public void startPayment() {
		creditCard.doPayment();
	}
}
