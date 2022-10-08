package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener {


    Button Loginbtn;
    Button Registerbtn;
    TextView regisUsername;
    TextView regisEmail;
    TextView regisPassword;
    TextView regisPhone;
    Boolean unique;
    public static Database data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        Loginbtn = findViewById(R.id.registerLogin);
        Registerbtn = findViewById(R.id.registerRegister);

        Loginbtn.setOnClickListener(this);
        Registerbtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onClick(View view) {
        data = LoginScreen.database;
        regisEmail = findViewById(R.id.registerEmail);
        regisUsername = findViewById(R.id.registerUsername);
        regisPassword = findViewById(R.id.registerPassword);
        regisPhone = findViewById(R.id.registerPhone);

        if(view.getId()==R.id.registerLogin){
            RegisterPage.this.finish();
            //Intent intent = new Intent(this, LoginScreen.class);
            //startActivity(intent);

        }
        else if(view.getId()==R.id.registerRegister){
            boolean param = false;

            if(regisEmail.getText().toString().isEmpty()||regisUsername.getText().toString().isEmpty()||regisPassword.getText().toString().isEmpty()||regisPhone.getText().toString().isEmpty()){
                param = true;
                Toast errorToast = Toast.makeText(view.getContext(), "Please fill all form", Toast.LENGTH_LONG);
                errorToast.show();
//                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();


            }
//            Toast.makeText(getApplicationContext(),check,Toast.LENGTH_LONG).show();
            if(!param){
                boolean validation2 = true;
                String err="";
                if(!regisEmail.getText().toString().endsWith(".com")){
                    err="Email must end with '.com'";
                    validation2 = false;
//                    Toast errorToast = Toast.makeText(view.getContext(), "Email must end with '.com'", Toast.LENGTH_SHORT);
//                    errorToast.show();


                }
                if(regisUsername.getText().toString().length()<3||regisUsername.getText().toString().length()>20){
                    if(err.equals("")){
                        err=err+"Username must be filled between 3-20 character";
                    }
                    else{
                        err=err+"\nUsername must be filled between 3-20 character";
                    }

                    validation2 = false;
//                    Toast errorToast = Toast.makeText(view.getContext(), "Username must be filled between 3-20 characters", Toast.LENGTH_SHORT);
//                    errorToast.show();


                }


                String pass=regisPassword.getText().toString();

                String numRegex   = ".*[0-9].*";
                String alphaRegex = ".*[A-Z].*";

                /*
                if (s.matches(numRegex) && s.matches(alphaRegex)) {
                    System.out.println("Valid: " + input);
                }*/
                if (pass.toUpperCase().matches(numRegex) && pass.toUpperCase().matches(alphaRegex)) {

                }
                else {
                    validation2 = false;
                    if(err.equals("")){
                        err=err+"Password must contain atleast 1 character and 1 number";
                    }
                    else{
                        err=err+"\nPassword must contain atleast 1 character and 1 number";
                    }

//                    Toast errorToast = Toast.makeText(view.getContext(), "Password must contains at least 1 character and 1 number", Toast.LENGTH_SHORT);
//                    errorToast.show();
                    System.out.println("error");

                }

                if(err.equals("")){
                    String username=regisUsername.getText().toString();
                    String password=regisPassword.getText().toString();
                    String email=regisEmail.getText().toString();
                    String phone=regisPhone.getText().toString();



                    unique = data.checkUnique(email, username);
                    Log.v("unique", unique.toString());

                    if(unique.equals(true)){
                        System.out.println("true");
                        LoginScreen.database.addUser(email,password,phone,username, MainActivity.uI+1);

                        Toast.makeText(getApplicationContext(),"You have been registered",Toast.LENGTH_LONG).show();
                        MainActivity.uI++;
                        RegisterPage.this.finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Your email or username have been used",Toast.LENGTH_LONG).show();
                    }


                    /*
                    Database.Users validationUsername = new Database.Users();
                    for(String i : validationUsername.UserUsername){
                        if(!regisEmail.getText().toString().equals(validationUsername.UserEmailAddress)&&!regisUsername.getText().toString().equals(validationUsername.UserUsername)){



                            validationUsername.UserUsername.add(regisUsername.getText().toString());
                            validationUsername.UserEmailAddress.add(regisEmail.getText().toString());
                            validationUsername.UserPhoneNumber.add(regisPhone.getText().toString());
                            validationUsername.UserPassword.add(regisPassword.getText().toString());

                            Intent intent = new Intent(this, HomeScreen.class);
                            startActivity(intent);

                        }
                    }*/


                }
                else{
                    Toast errorToast = Toast.makeText(getApplicationContext(),err,Toast.LENGTH_LONG);
                    errorToast.show();
                }

            }

        }
    }
}