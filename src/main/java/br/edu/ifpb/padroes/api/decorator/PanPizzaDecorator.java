package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class PanPizzaDecorator extends PizzaDecoratorImp {
    public PanPizzaDecorator(PizzaDecorator pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public void orderPizza(Pizza pizza) {
        super.orderPizza(panPizza(pizza));
    }

    private Pizza panPizza(Pizza pizza) {
        Float totalPrice = pizza.getPrice();
        totalPrice *= 1.15f; // 15% increase
        pizza.setPrice(totalPrice);
        pizza.setName(pizza.getName() + " (pan pizza)");

        return pizza;
    }
}
