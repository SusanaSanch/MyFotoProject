package femxa.cam.edu.myfotoproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sp = getSharedPreferences("gustos_fotos", Context.MODE_PRIVATE);

        Boolean foto0 = sp.getBoolean("0", false);
        Boolean foto1 = sp.getBoolean("1", false);
        Boolean foto2 = sp.getBoolean("2", false);

        TextView textView = (TextView) findViewById(R.id.mitexto);

        if(foto0 && foto1 && foto2)
        {
            textView.setText("Te han gustado todas las fotos");
        }
        else if (!foto0 && !foto1 && !foto2)
        {
            textView.setText("No te ha gustado ninguna foto");
        }
        else
        {
            if(foto0)
            {
               textView.setText("Te ha gustado la foto nº1");
            }

            if(foto1)
            {
                textView.setText("Te ha gustado la foto nº2");
            }

            if(foto2)
            {
                textView.setText("Te ha gustado la foto nº3");
            }

            if(foto0 && foto1)
            {
                textView.setText("Te han gustado las fotos nº1 y 2");
            }

            if(foto0 && foto2)
            {
                textView.setText("Te han gustado las fotos nº1 y 3");
            }

            if(foto1 && foto2)
            {
                textView.setText("Te han gustado las fotos nº2 y 3");
            }

        }


    }
}
