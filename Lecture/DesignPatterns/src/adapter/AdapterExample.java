package adapter;

interface PaymentProcessor {
    void processPayment(String customerName, double amount);
}

class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(String customerName, double amount) {
        System.out.println("Processing PayPal payment for " + customerName + " of $" + amount);
    }
}

class StripePaymentProcessor {
    public void payWithStripe(String email, double amountInDollars) {
        System.out.println("Processing Stripe payment for " + email + " of $" + amountInDollars);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripePaymentProcessor stripeProcessor;

    public StripeAdapter(StripePaymentProcessor stripeProcessor) {
        this.stripeProcessor = stripeProcessor;
    }

    @Override
    public void processPayment(String customerName, double amount) {
        stripeProcessor.payWithStripe(customerName, amount);
    }
}

class ECommerceSystem {
    private PaymentProcessor paymentProcessor;

    public ECommerceSystem(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(String customerName, double amount) {
        paymentProcessor.processPayment(customerName, amount);
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        ECommerceSystem ecommerceSystem1 = new ECommerceSystem(paypalProcessor);
        ecommerceSystem1.checkout("john@example.com", 99.99);

        StripePaymentProcessor stripeProcessor = new StripePaymentProcessor();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeProcessor);
        ECommerceSystem ecommerceSystem2 = new ECommerceSystem(stripeAdapter);
        ecommerceSystem2.checkout("jane@example.com", 149.99);
    }
}
