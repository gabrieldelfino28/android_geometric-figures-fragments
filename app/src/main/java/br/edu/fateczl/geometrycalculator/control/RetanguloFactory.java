package br.edu.fateczl.geometrycalculator.control;

import br.edu.fateczl.geometrycalculator.model.Retangulo;

public class RetanguloFactory implements IFiguraFactory<Retangulo>{
    public RetanguloFactory() {
        super();
    }

    @Override
    public Retangulo createFigura(float base, float altura, float raio) {
        Retangulo retangulo = new Retangulo();
        retangulo.setBase(base);
        retangulo.setAltura(altura);

        return retangulo;
    }
}
