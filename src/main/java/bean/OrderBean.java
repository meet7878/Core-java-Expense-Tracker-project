package bean;

public class OrderBean {
 int orderId;
 int userId;
 int amount;
 String paymentMode,paymentStaus,orderStatus;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getPaymentMode() {
	return paymentMode;
}
public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
}
public String getPaymentStaus() {
	return paymentStaus;
}
public void setPaymentStaus(String paymentStaus) {
	this.paymentStaus = paymentStaus;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
 
 
}
