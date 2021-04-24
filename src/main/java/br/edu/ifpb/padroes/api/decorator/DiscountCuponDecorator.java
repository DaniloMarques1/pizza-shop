package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class DiscountCuponDecorator extends PizzaDecoratorImp {
    public DiscountCuponDecorator(Pizza pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public Float getPrice() {
        return discountCupon(super.getPrice());
    }

    private Float discountCupon(Float price) {
        price *= 0.75f; // 25% discount
        return price;
    }
}
