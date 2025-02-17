// Interfaccia PaymentStrategy
public interface PaymentStrategy {
    void pay(double amount);
}

// Implementazione di PaymentStrategy per il pagamento con carta di credito
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagamento di " + amount + " effettuato con carta di credito.");
    }
}

// Implementazione di PaymentStrategy per il pagamento tramite PayPal
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagamento di " + amount + " effettuato tramite PayPal.");
    }
}

// Implementazione di PaymentStrategy per il pagamento tramite bonifico bancario
public class BankTransferPayment implements PaymentStrategy {
    private String bankAccount;

    public BankTransferPayment(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagamento di " + amount + " effettuato tramite bonifico bancario.");
    }
}

// Classe ShoppingCart che utilizza una PaymentStrategy
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Classe Main per testare l'applicazione
public class Main {
    public static void main(String[] args) {
        // Creazione di un pagamento con carta di credito
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "Mario Rossi");
        ShoppingCart cart1 = new ShoppingCart(creditCardPayment);
        cart1.checkout(100.0);

        // Creazione di un pagamento tramite PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("mario.rossi@example.com");
        ShoppingCart cart2 = new ShoppingCart(payPalPayment);
        cart2.checkout(200.0);

        // Creazione di un pagamento tramite bonifico bancario
        PaymentStrategy bankTransferPayment = new BankTransferPayment("IT60X0542811101000000123456");
        ShoppingCart cart3 = new ShoppingCart(bankTransferPayment);
        cart3.checkout(300.0);
    }
}

