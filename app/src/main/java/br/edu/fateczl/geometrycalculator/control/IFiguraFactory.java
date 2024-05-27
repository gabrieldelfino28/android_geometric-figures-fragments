package br.edu.fateczl.geometrycalculator.control;

public interface IFiguraFactory<T> {
    T createFigura(float base, float altura, float raio);
}
