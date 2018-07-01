package com.example.david.prevdrawer;

/**
 * Created by david on 11/06/2018.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import static com.example.david.prevdrawer.R.*;



public class Menu1 extends Fragment implements AdapterView.OnItemSelectedListener {

  
    String estado = "";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,  @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(layout.fragment_menu_1, container, false);


        List<String> categories = new ArrayList<String>();
        categories.add("SP");categories.add("SC");categories.add("PR");categories.add("RS");categories.add("MG");
        categories.add("RJ");categories.add("ES");categories.add("MS");categories.add("MT");categories.add("GO");
        categories.add("TO");categories.add("DF");categories.add("BA");categories.add("SE");categories.add("AL");
        categories.add("PE");categories.add("PB");categories.add("RN");categories.add("CE");categories.add("PI");
        categories.add("MA");categories.add("PA");categories.add("RO");categories.add("AP");categories.add("AM");
        categories.add("RR");categories.add("AC");

        Spinner spinner = (Spinner) view.findViewById(id.spinner);
        Button button = (Button) view.findViewById(id.buttonSearch);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                MainActivity main = new MainActivity();
                main.estado = estado;
                try {
                    main.buscar(view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        estado = item;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
        public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);


            //you can set the title for your toolbar here for different fragments different titles
            getActivity().setTitle("Menu 1");
        }



}

