package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.decorator.*;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;
import br.edu.ifpb.padroes.service.PizzaShopService;

public class Main {

    public static void main(String[] args) {

        PizzaShopService pizzaShopService = new PizzaShopService();

        System.out.println("Pizzas - menu");

        // TODO - implementar adapter para juntar as pizzas da PizzaHot e Damenos em um único conjunto
//        for (PizzaHotPizza pizza : pizzaShopService.getPizzasPizzaHot()) {
//            System.out.println(String.format("%s - %.2f", pizza.getTopping(), pizza.getPrice()));
//        }
//        for (DamenosPizza pizza : pizzaShopService.getPizzasDamenos()) {
//            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getCost()));
//        }

        for (Pizza pizza: pizzaShopService.getPizzas()) {
            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getPrice()));
        }

        Pizza pizza = new PizzaShopPizza("pepperoni", 55.0f);

        // TODO - implementar padrão decorator para só precisar passar o objeto pizza

        PizzaDecoratorImp pizzaDecorator = new DiscountCuponDecorator(
                new ExtraCheeseDecorator(
                        new PanPizzaDecorator(
                                new StuffedCrustDecorator(
                                        new PizzaDecoratorImp(pizza)
                                )
                        )
                )
        );

        pizzaShopService.orderPizza(pizzaDecorator);

    }

}
