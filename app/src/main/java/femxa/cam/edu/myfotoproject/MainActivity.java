package femxa.cam.edu.myfotoproject;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int[] array_pics =
                    {R.drawable.ic_puar2,
                    R.drawable.felix,
                    R.drawable.ozi};
    private int cont_imagen;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MIMENSAJE", "Entró en onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MIMENSAJE", "Entró en onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("Contador", cont_imagen);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        Log.d("MIMENSAJE", "Entró en onCreate");

        if(bundle == null)
        {
            Log.d("MIMENSAJE", "bundle vacío");
        }
        else
        {
            Log.d("MIMENSAJE", "bundle con cosas");
            cont_imagen = bundle.getInt("Contador");
        }

        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        ImageView imagen = (ImageView) findViewById(R.id.imagen);
        imagen.setImageResource(array_pics[cont_imagen]);
        Log.d("MIMENSAJE", "Seteada la foto inicial");

        Button botonsi = (Button) findViewById(R.id.botonsi);

        botonsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MIMENSAJE", "ha pulsado botón si");
                String mensaje = getResources().getString(R.string.mensajesimegusta);
                Toast toast = Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG);
                toast.show();

                ImageView imagen = (ImageView) findViewById(R.id.imagen);

                SharedPreferences sp = getSharedPreferences("gustos_fotos", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean(String.valueOf(cont_imagen), true);
                edit.commit();

                Log.d("MIMENSAJE", "foto número: " + String.valueOf(cont_imagen) + " " + String.valueOf(sp.getBoolean(String.valueOf(cont_imagen),false)));


                if (cont_imagen == 2)
                {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

                cont_imagen ++;

                if(cont_imagen <= 2)
                {
                    imagen.setImageResource(array_pics[cont_imagen]);
                }
                else
                {
                    cont_imagen = 0;
                    imagen.setImageResource(array_pics[cont_imagen]);
                }


            }
        });

        Button botonno = (Button) findViewById(R.id.botonno);
        botonno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MIMENSAJE", "Ha pulsado el botón no");
                String mensaje = getResources().getString(R.string.mensajenomegusta);
                Toast toast = Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG);
                toast.show();
                ImageView imagen = (ImageView) findViewById(R.id.imagen);

                SharedPreferences sp = getSharedPreferences("gustos_fotos", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean(String.valueOf(cont_imagen), false);
                edit.commit();

                Log.d("MIMENSAJE", "foto número: " + String.valueOf(cont_imagen) + " " + String.valueOf(sp.getBoolean(String.valueOf(cont_imagen),false)));

                if (cont_imagen == 2)
                {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

                cont_imagen ++;

                if(cont_imagen <= 2)
                {
                    imagen.setImageResource(array_pics[cont_imagen]);
                }
                else
                {
                    cont_imagen = 0;
                    imagen.setImageResource(array_pics[cont_imagen]);
                }


            }
        });


    }
}
