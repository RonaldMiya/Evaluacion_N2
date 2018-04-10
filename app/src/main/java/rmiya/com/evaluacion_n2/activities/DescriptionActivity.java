package rmiya.com.evaluacion_n2.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import rmiya.com.evaluacion_n2.R;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageButton, imageButton1, imageButton2, imageButton3, imageButton4;
    String  info, name, address, phone, url, email, logo;
    ImageView imageView;
    Bundle extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        captureValues();

        replaceInfo();

        loadImage(logo);

        imageButton = findViewById(R.id.imageButton1);
        imageButton.setOnClickListener(this);
        imageButton1 = findViewById(R.id.imageButton2);
        imageButton1.setOnClickListener(this);
        imageButton2 = findViewById(R.id.imageButton3);
        imageButton2.setOnClickListener(this);
        imageButton3 = findViewById(R.id.imageButton4);
        imageButton3.setOnClickListener(this);
        imageButton4 = findViewById(R.id.imageButton5);
        imageButton4.setOnClickListener(this);

    }

    public void captureValues() {

        extra = getIntent().getExtras();
        if (extra != null) {
            info    = extra.getString("info");
            name    = extra.getString("name");
            address  = extra.getString("address");
            phone   = extra.getString("phone");
            url     = extra.getString("link");
            email   = extra.getString("email");
            logo    = extra.getString("logo");
        }

    }

    public void replaceInfo() {

        TextView text = findViewById(R.id.description);
        text.setText(info);

        TextView textView = findViewById(R.id.addres_company);
        textView.setText(address);

        TextView textView2 = findViewById(R.id.phone_company);
        textView2.setText(String.valueOf(phone));

        TextView textView3 = findViewById(R.id.nombre_company);
        textView3.setText(name);

        TextView textView4 = findViewById(R.id.name_company);
        textView4.setText(name);
    }

    public void loadImage(String image) {

        imageView = findViewById(R.id.logo_company);

        switch (image){
            case "comp1":
                imageView.setImageResource(R.drawable.comp1);
                break;
            case "comp2":
                imageView.setImageResource(R.drawable.comp2);
                break;
            case "comp3":
                imageView.setImageResource(R.drawable.comp3);
                break;
            case "comp4":
                imageView.setImageResource(R.drawable.comp4);
                break;
            case "comp5":
                imageView.setImageResource(R.drawable.comp5);
                break;
            case "comp6":
                imageView.setImageResource(R.drawable.comp6);
                break;
            case "comp7":
                imageView.setImageResource(R.drawable.comp7);
                break;
            case "comp8":
                imageView.setImageResource(R.drawable.comp8);
                break;
            case "comp9":
                imageView.setImageResource(R.drawable.comp9);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        eventProcess(v.getId());
    }

    public void eventProcess(int option){

        switch (option) {
            case R.id.imageButton1:
                redirectURL();
                break;

            case R.id.imageButton2:
                redirectEmail();
                break;

            case R.id.imageButton3:
                redirectSMS();
                break;

            case R.id.imageButton4:
                redirectSHARE();
                break;

            case R.id.imageButton5:
                redirectCALL();
        }
    }

    public  void redirectEmail(){

        String[] TO = {email};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Tu mensaje..");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(DescriptionActivity.this,
                    "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
        }
    }

    public  void redirectURL(){

        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    public  void redirectSMS(){

        String message = "";
        String phoneNo = "phone";

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo));
        smsIntent.putExtra("sms_body", message);
        startActivity(smsIntent);

    }

    public void redirectSHARE() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Share with"));
    }

    public void redirectCALL () {
        String phoneNo = "phone";
        String dial = "tel:" + phoneNo;
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
    }

}