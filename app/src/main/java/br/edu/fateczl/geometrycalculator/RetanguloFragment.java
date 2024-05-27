package br.edu.fateczl.geometrycalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.fateczl.geometrycalculator.control.CirculoController;
import br.edu.fateczl.geometrycalculator.control.CirculoFactory;
import br.edu.fateczl.geometrycalculator.control.IFiguraFactory;
import br.edu.fateczl.geometrycalculator.control.IGeometriaController;
import br.edu.fateczl.geometrycalculator.control.RetanguloController;
import br.edu.fateczl.geometrycalculator.control.RetanguloFactory;
import br.edu.fateczl.geometrycalculator.model.Circulo;
import br.edu.fateczl.geometrycalculator.model.Retangulo;

public class RetanguloFragment extends Fragment {

    private View view;

    private Retangulo retangulo;
    private IFiguraFactory<Retangulo> Factory;
    private IGeometriaController<Retangulo> Op;

    private EditText inBase;
    private EditText inAltura;
    private TextView outArea;
    private TextView outPerim;

    public RetanguloFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_retangulo, container, false);

        inBase = view.findViewById(R.id.inBase);
        inAltura = view.findViewById(R.id.inAltura);

        outArea = view.findViewById(R.id.outAreaRet);
        outPerim = view.findViewById(R.id.outPerimetroRet);

        Button btnArea = view.findViewById(R.id.btnAreaRet);
        Button btnPerimetro = view.findViewById(R.id.btnPerimetroRet);

        btnArea.setOnClickListener(area -> {
            try {
                calcArea();
            } catch (Exception e) {
                Toast.makeText(view.getContext(), R.string.err, Toast.LENGTH_LONG).show();
            }
        });

        btnPerimetro.setOnClickListener(perimetro -> {
            try {
                calcPerimetro();
            } catch (Exception e) {
                Toast.makeText(view.getContext(), R.string.err, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
    private void calcPerimetro() {
        Factory = new RetanguloFactory();
        Op = new RetanguloController();

        float base = Float.parseFloat(inBase.getText().toString());
        float altura = Float.parseFloat(inAltura.getText().toString());

        retangulo = Factory.createFigura(base, altura, 0);

        String output = String.format(getString(R.string.out_perim), Op.getPerimetro(retangulo));
        outPerim.setText(output);
        clearFields();
    }

    private void calcArea() {
        Factory = new RetanguloFactory();
        Op = new RetanguloController();

        float base = Float.parseFloat(inBase.getText().toString());
        float altura = Float.parseFloat(inAltura.getText().toString());
        retangulo = Factory.createFigura(base, altura, 0f);

        String output = String.format(getString(R.string.out_area), Op.getArea(retangulo));
        outArea.setText(output);
        clearFields();
    }

    private void clearFields() {
        inBase.setText("");
        inAltura.setText("");
    }
}