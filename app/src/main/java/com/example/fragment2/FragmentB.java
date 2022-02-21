package com.example.fragment2;

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
import android.widget.TextView;
import android.widget.Toast;


public class FragmentB extends Fragment {

    EditText textoB;
    Button enviar;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("clave", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String textoRetorno = bundle.getString("text");

                textoB.setText(textoRetorno);

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textoB = view.findViewById(R.id.et_texto_b);
        enviar = view.findViewById(R.id.botonEnviarB);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!textoB.getText().toString().isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("text2",textoB.getText().toString().trim());
                    getParentFragmentManager().setFragmentResult("clave2",bundle);

                } else {
                    Toast.makeText(getContext(), "favor ingresar campo en el fragment B", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}