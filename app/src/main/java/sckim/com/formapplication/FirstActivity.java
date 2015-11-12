package sckim.com.formapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    //1. Define Components
    EditText name, age, country, university, course;
    Button btn_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //2. Refer the IDs for components
        name = (EditText)findViewById(R.id.txt_name);
        age = (EditText)findViewById(R.id.txt_age);
        country = (EditText) findViewById(R.id.txt_country);
        university = (EditText)findViewById(R.id.txt_university);
        course = (EditText)findViewById(R.id.txt_course);

        btn_submit = (Button)findViewById(R.id.btn_submit);

        //3. Set OnClickListener for the submit Button
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //Get Inputs from all EditText into String
                String info_name = name.getText().toString();
                String info_age = age.getText().toString();
                String info_country = country.getText().toString();
                String info_university = university.getText().toString();
                String info_course = course.getText().toString();

                //Bundle is like a package containing lots of items to be delivered, and can be delivered to another activity using Intent
                Bundle extras = new Bundle();
                extras.putString("name", info_name);
                extras.putString("age", info_age);
                extras.putString("country", info_country);
                extras.putString("university", info_university);
                extras.putString("course", info_course);
                intent.putExtras(extras);
                //Deliver the Intent along with the bundle
                startActivity(intent);
            }
        });

    }

}
