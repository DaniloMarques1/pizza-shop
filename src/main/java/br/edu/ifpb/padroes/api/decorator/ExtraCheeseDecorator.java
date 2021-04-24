package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class ExtraCheeseDecorator extends PizzaDecoratorImp {
    public ExtraCheeseDecorator(Pizza pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public Float getPrice() {
        return extraCheese(super.getPrice());
    }

    @Override
    public String getName() {
        return super.getName() + " (extra cheese)";
    }

    private Float extraCheese(Float price) {
        price *= 1.10f; // 10% increase
        return price;
    }
}
