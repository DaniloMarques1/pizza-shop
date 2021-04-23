package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class PizzaDecoratorImp implements PizzaDecorator {
    private PizzaDecorator wrappe;

    public PizzaDecoratorImp(PizzaDecorator pizzaDecorator) {
        this.wrappe = pizzaDecorator;
    }

    @Override
    public void orderPizza(Pizza pizza) {
        wrappe.orderPizza(pizza);
    }
}
