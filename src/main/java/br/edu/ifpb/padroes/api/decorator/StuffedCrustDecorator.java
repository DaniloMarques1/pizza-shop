package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class StuffedCrustDecorator extends PizzaDecoratorImp {
    public StuffedCrustDecorator(PizzaDecorator pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public void orderPizza(Pizza pizza) {
        super.orderPizza(pizza);
    }

    private Pizza stuffedCrust(Pizza pizza) {
        Float totalPrice = pizza.getPrice();
        totalPrice = totalPrice + ( totalPrice * 1.20f); // 20% increase
        pizza.setPrice(totalPrice);
        pizza.setName(pizza.getName() + " (stuffed crust)");

        return pizza;
    }
}
