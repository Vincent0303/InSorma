package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.Date;


public class DetailProductActivity extends AppCompatActivity implements View.OnClickListener {
    public static Product product;
    public static User user;
    Database database;
    TextView productName;
    TextView productPrice;
    TextView productDetail;
    Button buy;
    TextView quantity;
    String dQuantity;
    Date currDate = new Date();
    ImageView Imagedetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        database = LoginScreen.database;
        productName = findViewById(R.id.ProductDetailName);
        productPrice = findViewById(R.id.ProductDetailPrice);
        productDetail = findViewById(R.id.descriptionDetail);
//
        Imagedetail = findViewById(R.id.detailimage);
        productName.setText(product.ProductName);
        productPrice.setText("Rp." + product.ProductPrice.toString());
        productDetail.setText(product.ProductDescription);
        Imagedetail.setImageResource(product.ProductImage);

        buy = findViewById(R.id.buyFurniture);
        buy.setOnClickListener(this);




//
//        TextView tvProductName=(TextView)findViewById(R.id.tvProductName);
//        TextView tvProductPrice=(TextView)findViewById(R.id.tvProductPrice);
//
//        tvProductName.setText(product.ProductName);
//        tvProductPrice.setText(product.ProductPrice.toString());


    }
//    public void onClick(View view) {
//        quantity = findViewById(R.id.detailQuantity);
//        dQuantity = quantity.getText().toString();
//        if(dQuantity==null){
//            Toast.makeText(getApplicationContext(),"Please fill the quantity amount",Toast.LENGTH_LONG).show();
//        }
//        else{
//            Toast.makeText(getApplicationContext(),"succes",Toast.LENGTH_LONG).show();
//        }
//    }


    @Override
    public void onClick(View view) {
        quantity = findViewById(R.id.detailQuantity);
        dQuantity = quantity.getText().toString();
        Integer iQuantity;

        if(view.getId() == R.id.buyFurniture){

            if(dQuantity.equals("")){
                Toast.makeText(view.getContext(), "Please fill the quantity amount",Toast.LENGTH_LONG).show();

            }
            else{
                iQuantity = Integer.parseInt(dQuantity);
                if(iQuantity<1){
                    Toast.makeText(view.getContext(), "Please fill quantity more than 1", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"succes",Toast.LENGTH_LONG).show();
//                System.out.println("test1");

                    database.addTransaction( LoginScreen.usr,product, database.dataTransaksi.size()+1, iQuantity, currDate);
                    System.out.println(iQuantity);
                    finish();

                }

            }

        }

    }
}