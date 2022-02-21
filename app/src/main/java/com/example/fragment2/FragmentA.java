package com.example.fragment2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class FragmentA extends Fragment {

    EditText textoA;
    Button enviar;


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("clave2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String textoRetorno = bundle.getString("text2");

                textoA.setText(textoRetorno);

            }
        });




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textoA = view.findViewById(R.id.et_texto_a);
        enviar = view.findViewById(R.id.botonEnviar);


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!textoA.getText().toString().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("text",textoA.getText().toString().trim());
                    getParentFragmentManager().setFragmentResult("clave",bundle);

                } else {
                    Toast.makeText(getContext(), "favor ingresar campo en el fragment A", Toast.LENGTH_LONG).show();
                }

            }


        });
    }




}