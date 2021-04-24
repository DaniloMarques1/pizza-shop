package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class StuffedCrustDecorator extends PizzaDecoratorImp {
    public StuffedCrustDecorator(Pizza pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public Float getPrice() {
        return stuffedCrust(super.getPrice());
    }

    @Override
    public String getName() {
        return super.getName() + " (stuffed crust)";
    }

    private Float stuffedCrust(Float price) {
        price *= 1.20f; // 20% increase
        return price;
    }
}
