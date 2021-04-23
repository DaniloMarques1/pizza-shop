package br.edu.ifpb.padroes.domain;

public class PizzaShopPizza implements Pizza {

    private String name;
    private Float price;

    public PizzaShopPizza(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Float getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
