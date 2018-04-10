package rmiya.com.evaluacion_n2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import rmiya.com.evaluacion_n2.R;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    EditText editText;
    EditText dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.buscarID);
        imageButton = findViewById(R.id.button_search);


        imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (editText.getText().length() == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "No se pudo hacer la busqueda", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        String param = editText.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), Search2Activity.class);
                        intent.putExtra("value", param);
                        startActivity(intent);
                    }
                }

            });
    }
}
