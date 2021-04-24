package br.edu.ifpb.padroes.api.decorator;

import br.edu.ifpb.padroes.domain.Pizza;

public class PanPizzaDecorator extends PizzaDecoratorImp {
    public PanPizzaDecorator(Pizza pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public Float getPrice() {
        return panPizza(super.getPrice());
    }

    @Override
    public String getName() {
        return super.getName() + " (pan pizza)";
    }

    private Float panPizza(Float price) {
        price *= 1.15f; // 15% increase
        return price;
    }
}
