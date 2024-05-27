package br.edu.fateczl.geometrycalculator.control;

import br.edu.fateczl.geometrycalculator.model.Circulo;

public class CirculoFactory implements IFiguraFactory<Circulo> {

    public  CirculoFactory() {
        super();
    }
    @Override
    public Circulo createFigura(float base, float altura, float raio) {
        Circulo c = new Circulo();
        c.setRaio(raio);
        return c;
    }
}
