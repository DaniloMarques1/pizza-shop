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
import br.edu.ifpb.padroes.domain.adapter.DamenosAdapter;
import br.edu.ifpb.padroes.domain.adapter.PizzahotAdapter;

import java.util.ArrayList;
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
        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %f", totalPrice));
    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas()
    // TODO - public List<Pizza> getPizzas() {}

    public List<Pizza> getPizzas() {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        List<DamenosPizza> damenosPizzas = this.getPizzasDamenos();
        for (DamenosPizza damenosPizza: damenosPizzas) {
            pizzas.add(new DamenosAdapter(damenosPizza));
        }
        List<PizzaHotPizza> pizzasHot = this.getPizzasPizzaHot();
        for (PizzaHotPizza pizza: pizzasHot) {
            pizzas.add(new PizzahotAdapter(pizza));
        }

        return pizzas;
    }

    private List<DamenosPizza> getPizzasDamenos() {
        return damenosService.getPizzas();
    }

    private List<PizzaHotPizza> getPizzasPizzaHot() {
        return pizzaHotService.getPizzas();
    }

}
