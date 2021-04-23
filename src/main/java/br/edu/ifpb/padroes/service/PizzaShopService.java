package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosServiceProxy;
import br.edu.ifpb.padroes.api.decorator.*;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotServiceProxy;
import br.edu.ifpb.padroes.domain.Pizza;

import java.util.List;

public class PizzaShopService {

    private DamenosService damenosService;
    private PizzaHotService pizzaHotService;

    public PizzaShopService() {
        // TODO - alterar criação de instância para chamar para o Proxy de Cache
        damenosService = new DamenosServiceProxy(new DamenosServiceImpl());
        pizzaHotService = new PizzaHotServiceProxy(new PizzaHotServiceImpl());
    }

    // TODO - implementar decorator para não precisar atributos da pizza como parâmetros no método
    public void orderPizza(Pizza pizza) {
        // Isso poderia/deveria esta no cliente? (Main)
        PizzaDecoratorImp pizzaDecorator = new DiscountCuponDecorator(
                new ExtraCheeseDecorator(
                        new PanPizzaDecorator(
                                new StuffedCrustDecorator(
                                        new PizzaDecoratorImp(new PizzaShop())
                                )
                        )
                )
        );

        pizzaDecorator.orderPizza(pizza);
    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    // TODO - public List<Pizza> getPizzas() {}

    public List<DamenosPizza> getPizzasDamenos() {
        return damenosService.getPizzas();
    }

    public List<PizzaHotPizza> getPizzasPizzaHot() {
        return pizzaHotService.getPizzas();
    }

}
