package br.edu.ifpb.padroes.api.damenos.proxy;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;

import java.util.ArrayList;
import java.util.List;

// TODO - implementar proxy de cache para evitar leitura do json a cada chamada do método
public class DamenosServiceProxy implements DamenosService {
    private DamenosServiceImpl damenosService;
    private List<DamenosPizza> pizzasCache = new ArrayList<>();

    public DamenosServiceProxy(DamenosServiceImpl damenosService) {
        this.damenosService = damenosService;
    }

    @Override
    public List<DamenosPizza> getPizzas() {
        if (pizzasCache.isEmpty()) {
            this.pizzasCache = damenosService.getPizzas();
        }

        return this.pizzasCache;
    }
}
