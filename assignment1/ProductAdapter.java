package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    public int selected=-1;
    private int listItemLayout;
    private ArrayList<Product> itemList;
    public Context context;
    public OnClick oc;

    public ProductAdapter(int layoutId, ArrayList<Product> itemList, Context context, OnClick onClick) {
        listItemLayout = layoutId;
        this.itemList=itemList;
        this.context=context;
        this.oc = onClick;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ProductAdapter.ViewHolder myViewHolder = new ProductAdapter.ViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductAdapter.ViewHolder holder, int position) {
        try
        {
            Product ob=itemList.get(position);



            holder.tvProductName.setText(ob.ProductName);
            holder.tvProductPrice.setText("Rp." + ob.ProductPrice.toString());
            holder.tvProductImage.setImageResource(ob.ProductImage);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvProductName;
        public TextView tvProductPrice;
        public ImageView tvProductImage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            tvProductName=(TextView) itemView.findViewById(R.id.tvProductName);
            tvProductPrice=(TextView) itemView.findViewById(R.id.tvProductPrice);
            tvProductImage = (ImageView) itemView.findViewById(R.id.imagecard);

        }
        @Override
        public void onClick(View view) {
            int pos=getLayoutPosition();
            selected=pos;
            oc.onclick(selected);

            //th.notifyDataSetChanged();
            //fr.call(pos);
            //Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
        }
    }
}
