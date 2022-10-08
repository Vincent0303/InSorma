package com.example.assignment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static User usr;
//    Button change;
//    Button Delete;
//    Button LogOut;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//        usr = new User("","","","");

    }

    Button save;
    Button delete;
    Button log;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView intro = (TextView) v.findViewById(R.id.profileIntro);
        intro.setText(LoginScreen.usr.UserUsername);
        TextView ProfiEmail = (TextView) v.findViewById(R.id.ProfileEmail);
        ProfiEmail.setText(LoginScreen.usr.UserEmailAddress);
        TextView ProfiPhone = (TextView) v.findViewById(R.id.ProfilePhone);
        ProfiPhone.setText(LoginScreen.usr.UserPhoneNumber);
        TextView intro1 = (TextView) v.findViewById(R.id.profileIntro1);
        intro1.setText(LoginScreen.usr.UserUsername);
        TextView intro2 = (TextView) v.findViewById(R.id.Emailheader);
        intro2.setText(LoginScreen.usr.UserEmailAddress);

        save = (Button) v.findViewById(R.id.editProfile);
        delete = (Button) v.findViewById(R.id.deleteProfile);
        log = (Button) v.findViewById(R.id.logOut);
        save.setOnClickListener(this);
        delete.setOnClickListener(this);
        log.setOnClickListener(this);

        return v;


    }

    Database database;
    User user;

    @Override
    public void onClick(View view) {
        TextView savet;
        TextView deletet;
        TextView logt;
//        EditText newUsername;
//        EditText newEmailAddress;
//        EditText newPhone;
//        public ArrayList<User> newData;

        switch (view.getId()) {

            case R.id.editProfile:
                Boolean unique;
                TextInputLayout newUsername;
                TextInputLayout newEmailAddress;
                TextInputLayout newPhone;
                newUsername = (TextInputLayout) getView().findViewById(R.id.newUsername);
                newEmailAddress = (TextInputLayout) getView().findViewById(R.id.newEmail);
                newPhone = (TextInputLayout) getView().findViewById(R.id.newPhone);

//                Log.v("savechange", "hereedit");
//                newEmailAddress = (TextInputEditText) view.findViewById(R.id.ProfileEmail);
//                newPhone = (TextInputEditText) view.findViewById(R.id.ProfilePhone);

//                LoginScreen.usr.UserUsername.set(getId(),newUsername.getText().toString());
                String text = newUsername.getEditText().getText().toString().trim();
                String emailNew = newEmailAddress.getEditText().getText().toString().trim();
                String phoneNew = newPhone.getEditText().getText().toString().trim();
                Log.v("param", text);

//                unique = database.checkUnique(emailNew, text);
                unique = Database.checkUni(emailNew,text, LoginScreen.usr.UserID);
                Log.v("param", unique.toString());
//                newData = new ArrayList<>();
//                newData =

//                user = new User(LoginScreen.usr.UserID, emailNew, text, LoginScreen.usr.UserPassword, phoneNew);

//                Database.dataUser.set(LoginScreen.usr.UserID, new User(LoginScreen.usr.UserID, emailNew, text, LoginScreen.usr.UserPassword, phoneNew));
//                    database.data
//                Log.v("savechange", text);
//                Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
//                newUsername.setText("halo");

//                    database.setDataUser(LoginScreen.database.getIndex(LoginScreen.usr.UserEmailAddress, LoginScreen.usr.UserPassword), text, emailNew, phoneNew);
//
//                Log.v("param", LoginScreen.database.getIndex(LoginScreen.usr.UserEmailAddress, LoginScreen.usr.UserPassword).toString());
//                    Database.dataUser.set(LoginScreen.usr.UserID-1, new User(LoginScreen.usr.UserID, text, emailNew, phoneNew));

                if(unique){
                    String error = "";

                    if(!emailNew.endsWith(".com")){
                        error = "Your email must end with .com";
                    }
                    if(text.length()<3||text.length()>20){
                        if(error.equals("")){
                            error = error + "Your username must atleast 3 characters lenght and max 20 characters lenght";
                        }
                        else{
                            error = error + "\nYour username must atleast 3 characters lenght and max 20 characters lenght";
                        }

                    }
                    if(error.equals("")){
                        try {
                            Log.v("param" , error);
                            Toast.makeText(getContext(),"Change Success",Toast.LENGTH_LONG).show();
                            LoginScreen.database.setDataUser(LoginScreen.usr.UserID , text, emailNew, phoneNew);

                        }
                        catch (Exception ex) {
                            String message = ex.getMessage();
                            System.out.println("abc");
                        }
                    }
                    else{
                        Toast.makeText(getContext(),error,Toast.LENGTH_LONG).show();
                    }




                }

//                LoginScreen.database.dataUser.set(getId(),user);
//                Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
//                Toast.makeText(getActivity(), "log out", Toast.LENGTH_LONG).show();
                break;
            case R.id.deleteProfile:
//                Boolean param = false;
//                param =database.remove(LoginScreen.usr.UserEmailAddress, LoginScreen.usr.UserPassword);
//                if(param.equals(false)){
                Toast.makeText(getActivity(), "Success delete account", Toast.LENGTH_LONG).show();
                //Database.dataUser.remove(LoginScreen.usr.UserID-1);
                int index=LoginScreen.database.getIndex(LoginScreen.usr.UserEmailAddress, LoginScreen.usr.UserPassword);
                System.out.println("index "+index);
                LoginScreen.database.dataUser.remove(index);
                //Log.v("param", LoginScreen.database.getIndex(LoginScreen.usr.UserEmailAddress, LoginScreen.usr.UserPassword).toString());
                //Log.v("param", LoginScreen.usr.UserID.toString());
                LoginScreen.usr = null;
//              Log.v("param", LoginScreen.usr.UserID.toString());
                getActivity().finish();
                // remove
                break;
            case R.id.logOut:
//                this.getSupportFragmentManager().beginTransaction().remove(ProfileFragment).commit();
//                getActivity().getFragmentManager().popBackStack();
//                Toast.makeText(getActivity(), "log out", Toast.LENGTH_LONG).show();
                getActivity().finish();
                break;

        }

//        if(getView() == save){
//
//
//        }
//        else if(getView() == delete){
//
//        }
//        else if(getView() == view.findViewById(R.id.logOut)){
//            System.out.println("here log");
//            getActivity().getFragmentManager().popBackStack();
//        }
    }
}