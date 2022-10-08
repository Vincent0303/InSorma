package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static User usr;
    public static Product pdc;
    TextView intro;
    TextView empty;
    Integer index;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //usr = new User("","","","");

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


//        intro.setText(usr.UserEmailAddress);
    }


//    ArrayList<User> daftarUser;
    ProductAdapter ua;
    RecyclerView rv;
    ArrayList<Product> daftarProduct;
    Database database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

        database=LoginScreen.database;
        intro = (TextView) v.findViewById(R.id.introView); //
        intro.setText("Hi "+LoginScreen.usr.UserUsername);
        System.out.println("abc");

//        Log.v("UserID", LoginScreen.usr.UserID.toString());


//        daftarUser=new ArrayList<>();
        daftarProduct = new ArrayList<>();
        rv=v.findViewById(R.id.recyclerView);
        int b = 0;
        empty = (TextView) v.findViewById(R.id.empty);
        //for (Product i : database.dataProduct)
        for (int i=0;i<database.dataProduct.size();i++)
        {

//            Product pdc=new Product("Test"+i,4.8F,100000,"dsad", "");
            daftarProduct.add(database.dataProduct.get(i));
            b++;
        }
        //User.UserUsername
        if(b==0){

            empty.setText("There is no furniture available");

        }

        ua=new ProductAdapter(R.layout.list_product, daftarProduct, getActivity(), new OnClick() {
            @Override
            public void onclick(int pos) {
                DetailProductActivity.product=daftarProduct.get(pos);
                Intent it=new Intent(getActivity(),DetailProductActivity.class);
                startActivity(it);

                //Toast.makeText(getActivity(),daftarUser.get(pos).UserEmailAddress,Toast.LENGTH_LONG).show();
            }
        });
        rv.setAdapter(ua);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        try {

        }
        catch (Exception ex)
        {

        }
        return v;
    }

//    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
//        private String[] localDataSet;
//
//
//    }
}