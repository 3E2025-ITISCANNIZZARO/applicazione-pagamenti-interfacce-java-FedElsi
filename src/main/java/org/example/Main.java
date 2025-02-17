import java.util.ArrayList;
import java.util.List;

// Interfaccia PaymentStrategy
interface PaymentStrategy {
    void pay(double amount);
}

// Implementazione del pagamento tramite carta di credito
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " pagato con carta di credito.");
    }
}

// Implementazione del pagamento tramite PayPal
class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " pagato tramite PayPal.");
    }
}

// Implementazione del pagamento tramite bonifico bancario
class BankTransferPayment implements PaymentStrategy {
    private String bankAccountNumber;
    private String bankName;

    public BankTransferPayment(String bankAccountNumber, String bankName) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " pagato tramite bonifico bancario.");
    }
}

// Classe Item
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Classe ShoppingCart
class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void pay(PaymentStrategy paymentMethod) {
        double amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

// Classe Main per testare l'applicazione
public class Main {
    public static void main(String[] args) {
        // Creazione degli articoli
        Item item1 = new Item("Laptop", 1000);
        Item item2 = new Item("Smartphone", 500);

        // Creazione del carrello
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item1);
        cart.addItem(item2);

        // Selezione del metodo di pagamento
        PaymentStrategy paymentMethod = new CreditCardPayment("1234-5678-9876-5432", "Mario Rossi", "12/25", "123");

        // Esecuzione del pagamento
        cart.pay(paymentMethod);
    }
}

