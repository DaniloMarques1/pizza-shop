package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class ExtraCheeseDecorator extends PizzaDecoratorImp {
    public ExtraCheeseDecorator(PizzaDecorator pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public void orderPizza(Pizza pizza) {
        super.orderPizza(extraCheese(pizza));
    }

    private Pizza extraCheese(Pizza pizza) {
        Float totalPrice = pizza.getPrice();
        totalPrice = totalPrice + (totalPrice * 1.10f); // 10% increase
        pizza.setPrice(totalPrice);
        pizza.setName(pizza.getName() + " (extra cheese)");
        return pizza;
    }
}
