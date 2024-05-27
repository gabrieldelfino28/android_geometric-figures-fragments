package br.edu.fateczl.geometrycalculator.control;

import br.edu.fateczl.geometrycalculator.model.Retangulo;

public class RetanguloController implements IGeometriaController<Retangulo> {
    /**
     * <h2>Fórmulas Retângulo</h2>
     * Area = b * h <br>
     * Perímetro = 2 * (b + h)
     * */
    @Override
    public float getArea(Retangulo retangulo) {
        return retangulo.getBase() * retangulo.getAltura();
    }

    @Override
    public float getPerimetro(Retangulo retangulo) {
        return 2 * (retangulo.getBase() + retangulo.getAltura());
    }
}
