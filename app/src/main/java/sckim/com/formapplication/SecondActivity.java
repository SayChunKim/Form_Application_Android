package sckim.com.formapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button btn_confirm, btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //1. Get previous Intent containing Bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //2. Get the values via the 'keys' which are identical to FirstActivity's extras.putString
        String message_1 = bundle.getString("name");
        String message_2 = bundle.getString("age");
        String message_3 = intent.getStringExtra("country");
        String message_4 = intent.getStringExtra("university");
        String message_5 = intent.getStringExtra("course");


        //3. Refer ID of components without being defined and add text directly with messages retrieved from Bundle
        ((TextView) findViewById(R.id.info_name)).setText("Name: " + message_1);
        ((TextView) findViewById(R.id.info_age)).setText("Age: " + message_2);
        ((TextView) findViewById(R.id.info_country)).setText("Country: "+ message_3);
        ((TextView) findViewById(R.id.info_university)).setText("University: " + message_4);
        ((TextView) findViewById(R.id.info_course)).setText("Course: " + message_5);

        //4. Set OnItemClickListener for Button Confirm + Back
        btn_confirm = (Button)findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"Data Added. Awesome !",Toast.LENGTH_SHORT).show();
            }
        });
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  //Intent was good try but it will just create another activity on top of another, instead back to previous
//                Intent back = new Intent(getApplicationContext(), FirstActivity.class);
//                startActivity(back);

                //finish() method is stopping current SecondActivity and navigates back to previous FirstActivity
                finish();
            }
        });

    }
}
