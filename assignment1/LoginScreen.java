package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    Button registerText;
    public static Integer index;
    public static Database database;
    public static User usr;
    Boolean param;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        database = MainActivity.database;
        setContentView(R.layout.activity_loginscreen);

        loginButton = findViewById(R.id.buttonLogin);
        registerText = findViewById(R.id.register);

        loginButton.setOnClickListener(this);
        registerText.setOnClickListener(this);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        username.setText("user1.com");
        password.setText("user1");

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }

    @Override
    public void onClick(View view) {

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        if(view.getId()==R.id.register) {
            Intent intent = new Intent(this, RegisterPage.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.buttonLogin){

            String usernameText = username.getText().toString();
            String passwordText = password.getText().toString();

            if(usernameText.isEmpty()&&passwordText.isEmpty()){
                Toast errorToast = Toast.makeText(view.getContext(), "Please fill email and password", Toast.LENGTH_LONG);
                errorToast.show();
            }
            else if(usernameText.isEmpty()){
                Toast errorToast = Toast.makeText(view.getContext(), "Please fill email", Toast.LENGTH_LONG);
                errorToast.show();
            }
            else if(passwordText.isEmpty()){
                Toast errorToast = Toast.makeText(view.getContext(), "Please fill Password", Toast.LENGTH_LONG);
                errorToast.show();
            }
            else{

//                usr=database.checklogin(usernameText,passwordText);


//                index = database.getIndex(usernameText,passwordText);

                if (!Database.checklogin(usernameText,passwordText))
                {

                    Toast.makeText(getApplicationContext(),"Your Email or Password is wrong",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(LoginScreen.this,HomeScreen.class));
                }
                /*
                Database.Users validation = new Database.Users();
                for(String i : validation.UserEmailAddress){
                    if(usernameText.equals(validation.UserEmailAddress)&&passwordText.equals(validation.UserPassword)){
                        Intent intent = new Intent(this, HomeScreen.class);
                        startActivity(intent);
                        break;
                    }
                }*/
            }



        }


    }
}