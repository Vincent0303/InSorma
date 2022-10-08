package com.example.assignment1;

import static com.example.assignment1.Database.dataTransaksi;

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
 * Use the {@link TransactionHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionHistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public TransactionHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransactionHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TransactionHistoryFragment newInstance(String param1, String param2) {
        TransactionHistoryFragment fragment = new TransactionHistoryFragment();
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


    }

    HistoryAdapter ua;
    RecyclerView rv;
    ArrayList<Transaksi> daftarTransaction = new ArrayList<>();
    Database database;
    TextView empty;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_transaction_history, container, false);
        database = LoginScreen.database;

//        daftarTransaction = new ArrayList<>();
        rv = v.findViewById(R.id.recyclerViewHistory);
        empty = (TextView) v.findViewById(R.id.tranEmp);
//        for (Transaksi i : database.dataTransaksi)
//        {
//            daftarTransaction.add(i);
//        }

        Log.v("data tran", Integer.toString(dataTransaksi.size()));
        Log.v("data tran", ".");
        rcy();

        if(daftarTransaction.isEmpty()){
            empty.setText("There is no furniture available");
            rv.setVisibility(View.GONE);
        }
        else{

            rv.setVisibility(View.VISIBLE);
            empty.setText("History");
        }





        ua=new HistoryAdapter(R.layout.list_history, daftarTransaction, getActivity());

        rv.setAdapter(ua);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));



        try {

        }
        catch (Exception ex)
        {

        }


//        Log.v("test",daftarTransaction.get(0).getQuantity().toString());

        return v;
    }

    public void rcy(){
//        daftarTransaction = new ArrayList<>();
        Integer tempo;
        for(int i=0; i<Database.dataTransaksi.size();i++){
            Log.v("datatran", "test");
//            Log.v("data tran", Database.dataTransaksi.get(i).getUser().getUserID().toString());
//            Log.v("datatran", Database.dataTransaksi.get(0).TransactionID.toString());
            Log.v("datatran", dataTransaksi.get(0).user.UserUsername);
            tempo = dataTransaksi.get(i).user.UserID;
//            Log.v("datatran", tempo.toString());
//            Log.v("datatemp", Integer.toString(res));
            if(tempo.equals(LoginScreen.usr.UserID)){


                daftarTransaction.add(Database.dataTransaksi.get(i));
            }

        }

    }
}