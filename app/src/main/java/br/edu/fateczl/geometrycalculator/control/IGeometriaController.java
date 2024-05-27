package br.edu.fateczl.geometrycalculator.control;

public interface IGeometriaController<T> {
    static final float PI = 3.14f;
    float getArea(T t);
    float getPerimetro(T t);

}
