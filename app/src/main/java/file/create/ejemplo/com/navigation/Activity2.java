package file.create.ejemplo.com.navigation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.Date;

public class Activity2 extends AppCompatActivity {

    Button createq, BConfig;

    TextView textTXT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_2);


        BConfig = findViewById(R.id.BConfig);
        BConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });


        createq = (Button) findViewById(R.id.createq);// asigno a la variable create (de tipo botton) al elemento Button del layout

        textTXT = (TextView) findViewById(R.id.textoTXT);// /Contenido del  archivo/ tenga presente que lo que está después del  R.id es el id del elemento del layout
        // textRuta = (TextView) findViewById(R.id.textoRUTA);// muestra la ruta de almacenamiento del archivo




        createq.setOnClickListener(new View.OnClickListener() {// METODO PARA CREAR EL ARCHIVO EN UNA CARPETA
            @Override
            public void onClick(View view) {

                Date c = Calendar.getInstance().getTime();

                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss(dd-MM-yyyy)");
                String archivo = df.format(c)+".txt";

                //String archivo ="Miarchivo.txt";
                createq.setBackgroundColor(Color.GREEN);

                FileOutputStream fileOutputStream = null;

               // File myDirectoty1 =  new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Resistividades_APPET");


                File myDirectoty1 =  new File(Environment.getExternalStorageDirectory(),"Resistividades");


                // myDirectoty1.mkdir();
                File file = new File(myDirectoty1, archivo);

                Context context = getApplicationContext();

                String ruta ="Archivo guardado en: "+myDirectoty1.getName()+"/"+archivo;

                //String ruta = myDirectoty1.getAbsolutePath()+"/"+archivo;
                //  textRuta.setText(ruta);// Imprime la ruta del almacenamiento  del archivo

                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, ruta, duration);
                toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);// CHANGE POSITION OF TOAST
                toast.show();

                try {

                    FileOutputStream os = fileOutputStream = new FileOutputStream(file);
                    String data ="HOLA MUNDO";
                    textTXT.setText(data);
                    os.write(data.getBytes());
                    os.close();
                } catch ( Exception e) {// Con exception  se maneja cualquier excepción
                    e.printStackTrace();
                }
            }
        });

    }


    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}
