package temple.edu;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.PasswordAuthentication;

public class FormActivity extends AppCompatActivity {
    EditText Name;
    EditText Email;
    EditText Password;
    EditText PasswordCon;
    Button btnSave;
    TextView Greeting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.UserName);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        PasswordCon = findViewById(R.id.PasswordCon);
        btnSave = findViewById(R.id.Save);
        Greeting = findViewById(R.id.Greeting);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "One or more of the fields are empty, please fill out all fields";
                CharSequence passwordError =  "Your Passwords do not match";
                int duration = Toast.LENGTH_SHORT;

                if (Name.getText().toString().equals("")||
                        Email.getText().toString().equals("") ||
                        Password.getText().toString().equals("")||
                        PasswordCon.getText().toString().equals("")){
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if(Password.getText() != PasswordCon.getText()){
                        Toast passErr = Toast.makeText(context, passwordError, duration);
                        passErr.show();
                    }else {
                        String Display = "Welcome " + Name.getText().toString() + " to the SignUpForm App";
                        Greeting.setText(Display);
                    }
                }
            }
        });
        //

    }
}
