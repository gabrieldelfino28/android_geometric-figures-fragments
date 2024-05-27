package br.edu.fateczl.geometrycalculator.control;

import br.edu.fateczl.geometrycalculator.model.Circulo;
import br.edu.fateczl.geometrycalculator.model.Retangulo;

public class CirculoController implements IGeometriaController<Circulo> {
    /**
     * <h2>Fórmulas Círculo</h2>
     * Area = pi * r²<br>
     * Perímetro = 2 * pi * r
     * */
    @Override
    public float getArea(Circulo circulo) {
        return (float) (PI * Math.pow(circulo.getRaio(), 2));
    }

    @Override
    public float getPerimetro(Circulo circulo) {
        return 2 * PI * circulo.getRaio();
    }
}
