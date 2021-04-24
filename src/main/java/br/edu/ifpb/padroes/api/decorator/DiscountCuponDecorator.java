package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class DiscountCuponDecorator extends PizzaDecoratorImp {
    public DiscountCuponDecorator(PizzaDecorator pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public void orderPizza(Pizza pizza) {
        super.orderPizza(discountCupon(pizza));
    }

    private Pizza discountCupon(Pizza pizza) {
        Float totalPrice = pizza.getPrice();
        totalPrice *= 0.75f; // 25% discount
        pizza.setPrice(totalPrice);

        return pizza;
    }
}
