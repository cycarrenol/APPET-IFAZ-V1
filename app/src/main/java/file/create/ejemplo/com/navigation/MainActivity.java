package file.create.ejemplo.com.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
     EditText ETSeparacion;
     Spinner espiner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        ETSeparacion = findViewById(R.id.ETSeparacion);
        Spinner spinner = (Spinner) findViewById(R.id.spin);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });





    }

            public void openActivity2(){
                Intent intent = new Intent(this,Activity2.class);
                startActivity(intent);
            }


}
