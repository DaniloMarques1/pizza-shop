package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class PizzaShop implements PizzaDecorator {
    @Override
    public void orderPizza(Pizza pizza) {
        System.out.printf("New order for = %s\n", pizza.getName());
        System.out.printf("Total price = %f\n", pizza.getPrice());
    }
}
