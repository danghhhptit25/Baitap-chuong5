abstract class PaymentMethod {
    protected String paymentType;
    protected String methodName;

    public PaymentMethod(String paymentType, String methodName) {
        this.paymentType = paymentType;
        this.methodName = methodName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getMethodName() {
        return methodName;
    }

    public abstract void pay(double amount);
}

class CreditCardPayment extends PaymentMethod {
    public CreditCardPayment() {
        super("Không dùng tiền mặt", "thẻ tín dụng");
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Thanh toán %,.0f bằng %s.%n", amount, this.methodName);
    }
}

class PayPalPayment extends PaymentMethod {
    public PayPalPayment() {
        super("Không dùng tiền mặt", "PayPal");
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Thanh toán %,.0f qua %s.%n", amount, this.methodName);
    }
}

class CashPayment extends PaymentMethod {
    public CashPayment() {
        super("Trực tiếp", "tiền mặt");
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Thanh toán %,.0f bằng %s.%n", amount, this.methodName);
    }
}

class MoMoPayment extends PaymentMethod {
    public MoMoPayment() {
        super("Không dùng tiền mặt", "MoMo");
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Thanh toán %,.0f qua %s.%n", amount, this.methodName);
    }
}

class Order {
    private String customerName;
    private double amount;
    private PaymentMethod paymentMethod; // Phụ thuộc vào abstraction

    public Order(String customerName, double amount, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void checkout() {
        System.out.println("Khách hàng: " + customerName);
        paymentMethod.pay(amount);
        System.out.println(); // Dòng trống ngăn cách các đơn hàng
    }
}

public class bai03 {
    public static void main(String[] args) {
        Order order1 = new Order("An", 200000, new CreditCardPayment());
        Order order2 = new Order("Bình", 150000, new PayPalPayment());
        Order order3 = new Order("Chi", 100000, new CashPayment());
        Order order4 = new Order("Dũng", 300000, new MoMoPayment());

        order1.checkout();
        order2.checkout();
        order3.checkout();
        order4.checkout();
    }
}