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
import br.edu.fateczl.geometrycalculator.model.Circulo;

public class CirculoFragment extends Fragment {
    private View view;

    private Circulo circulo;
    private IFiguraFactory<Circulo> Factory;
    private IGeometriaController<Circulo> Op;

    private EditText inRaio;
    private TextView outArea;
    private TextView outPerim;

    public CirculoFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_circulo, container, false);

        inRaio = view.findViewById(R.id.inRaio);
        outArea = view.findViewById(R.id.outArea);
        outPerim = view.findViewById(R.id.outPerimetro);

        Button btnArea = view.findViewById(R.id.btnArea);
        Button btnPerimetro = view.findViewById(R.id.btnPerimetro);

        btnArea.setOnClickListener(area -> {
            try {
                calcArea();
            }catch (Exception e) {
                Toast.makeText(view.getContext(), R.string.err, Toast.LENGTH_LONG).show();
            }
        });

        btnPerimetro.setOnClickListener(perimetro -> {
            try {
                calcPerimetro();
            }catch (Exception e) {
                Toast.makeText(view.getContext(), R.string.err, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private void calcPerimetro() {
        Factory = new CirculoFactory();
        Op = new CirculoController();

        float raio = Float.parseFloat(inRaio.getText().toString());

        circulo = Factory.createFigura(0,0,raio);

        String output = String.format(getString(R.string.out_perim), Op.getPerimetro(circulo));
        outPerim.setText(output);
        clearFields();
    }

    private void calcArea() {
        Factory = new CirculoFactory();
        Op = new CirculoController();

        float raio = Float.parseFloat(inRaio.getText().toString());

        circulo = Factory.createFigura(0,0,raio);

        String output = String.format(getString(R.string.out_area), Op.getArea(circulo));
        outArea.setText(output);
        clearFields();
    }

    private void clearFields() {
        inRaio.setText("");
    }
}