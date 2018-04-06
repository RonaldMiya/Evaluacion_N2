package rmiya.com.evaluacion_n2.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import rmiya.com.evaluacion_n2.R;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageButton, imageButton1, imageButton2, imageButton3, imageButton4;
    String  info    = "",
            name    = "",
            addres  = "",
            phone   = "",
            url     = "",
            email   = "",
            logo    = ""
                    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            info    = extra.getString("info");
            name    = extra.getString("name");
            addres  = extra.getString("address");
            phone   = extra.getString("phone");
            url     = extra.getString("link");
            email   = extra.getString("email");
            logo    = extra.getString("info");
        }

        TextView text = findViewById(R.id.description);
        text.setText(info);

        TextView textView = findViewById(R.id.addres_company);
        textView.setText(addres);

        TextView textView2 = findViewById(R.id.phone_company);
        textView2.setText(phone);

        TextView textView3 = findViewById(R.id.nombre_company);
        textView3.setText(name);

        TextView textView4 = findViewById(R.id.name_company);
        textView4.setText(name);



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

                break;

            case R.id.imageButton5:
                redirectCALL();
        }
    }

    public  void redirectEmail(){

//        Intent intent = new Intent(Intent.ACTION_SEND);
//        startActivity(Intent.createChooser(intent, "Elija"));
//        Intent mailClient = new Intent(Intent.ACTION_VIEW);
//        mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
//        startActivity(mailClient);




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
        intent.putExtra(Intent.EXTRA_TEXT, "El mejor blog de android http://javaheros.blogspot.pe/");
        startActivity(Intent.createChooser(intent, "Share with"));
    }

    public void redirectCALL () {
        String phoneNo = "phone";

        String dial = "tel:" + phoneNo;
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
    }

}
