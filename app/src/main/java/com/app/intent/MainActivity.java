package com.app.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {


        switch (view.getId()){
            case R.id.btnIraActiityDos:{

                //Se utiliza un intent explicito para enviar datos y abrir otra actividad
                // En este ejemplo vamos a navegar desde la actividad actual (this) a la actividad dos (Main2ActivityTow.class)
                //
                Intent miIntent =  new Intent(this, Main2ActivityTow.class);

                //Utilizamos Un Bundle para enviar un texto de la actividad uno a la dos

                Bundle miBundle = new Bundle();

                //se utiliza el metodo putString para enviar un contenido, este contenido es enviado con una estructura clave valor
                //como se muestra en el siguiente codigo la clave es texto y el valor es la otra cadena

                miBundle.putString("texto", "El contenido del txt");

                //en este linea de codigo utilizando el metodo putExtras de objeto intent enviamos el objeto de tipo bundle creado anterior mente

                miIntent.putExtras(miBundle);


                miIntent.setData(Uri.parse("holaa"));
                startService(miIntent);
                startActivity(miIntent);

                //para verificar si los datos enviados podemos abrir la actividad2 y ahi esta la siguiente parte del codigo
                break;
            }

            case R.id.btnCompartir:{

                //En este codigo hacemos las programamcion de un itent Implicito
                //cuando el usuario clicke en el btn compartir el sistema abre un panel con todas las aplicaciones disponibles
                Intent miintenrCompartir = new Intent();
                miintenrCompartir.setAction(Intent.ACTION_SEND);
                miintenrCompartir.putExtra(Intent.EXTRA_TEXT,"Este el mensaje a compartir");
                miintenrCompartir.setType("text/plain");

                //validamos si hay aplicaciones disponibles para abrir 
                if(miintenrCompartir.resolveActivity(getPackageManager()) !=null){
                    startActivity(miintenrCompartir);
                }

                break;
            }

        }

    }
}
