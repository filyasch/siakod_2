import java.util.ArrayList;
import java.util.List;

// Класс, представляющий пиццу
class Pizza {
    private String dough; // Тесто
    private String sauce; // Соус
    private List<String> toppings; // Ингредиенты начинки

    public Pizza() {
        toppings = new ArrayList<>();
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void printPizza() {
        System.out.println("Пицца с тестом: " + dough);
        System.out.println("Соус: " + sauce);
        System.out.println("Ингредиенты начинки: ");
        for (String topping : toppings) {
            System.out.println("- " + topping);
        }
        System.out.println();
    }
}

// Интерфейс для строителя пиццы
interface PizzaBuilder {
    void buildDough();

    void buildSauce();

    void buildToppings();

    Pizza getPizza();
}

// Строитель для пиццы Маргарита
class MargheritaPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public MargheritaPizzaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("бездрожжевое тесто");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("томатный соус");
    }

    @Override
    public void buildToppings() {
        pizza.addTopping("сыр Моцарелла");
        pizza.addTopping("базилик");
        pizza.addTopping("помидоры");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

// Строитель для пиццы Диабло
class DiabloPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public DiabloPizzaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("дрожжевое тесто");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("томатный соус");
    }

    @Override
    public void buildToppings() {
        pizza.addTopping("сыр Моцарелла");
        pizza.addTopping("шампиньоны");
        pizza.addTopping("чили");
        pizza.addTopping("паприка");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

// Директор, который управляет процессом сборки пиццы
class PizzaDirector {
    public Pizza constructPizza(PizzaBuilder builder) {
        builder.buildDough();
        builder.buildSauce();
        builder.buildToppings();
        return builder.getPizza();
    }
}

public class PizzaBuilderExample {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        // Собираем пиццу Маргарита
        PizzaBuilder margheritaBuilder = new MargheritaPizzaBuilder();
        Pizza margheritaPizza = director.constructPizza(margheritaBuilder);
        System.out.println("Пицца Маргарита:");
        margheritaPizza.printPizza();

        // Собираем пиццу Диабло
        PizzaBuilder diabloBuilder = new DiabloPizzaBuilder();
        Pizza diabloPizza = director.constructPizza(diabloBuilder);
        System.out.println("Пицца Диабло:");
        diabloPizza.printPizza();
    }
}
