package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{


    public int selected=-1;
    private int listItemLayout;
    private ArrayList<Transaksi> itemList;
    public Context context;
    public OnClick oc;
    public HistoryAdapter(int layoutId, ArrayList<Transaksi> itemList, Context context) {
        listItemLayout = layoutId;
        this.itemList=itemList;
        this.context=context;
        this.oc=oc;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        HistoryAdapter.ViewHolder myViewHolder = new HistoryAdapter.ViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {

        try
        {
            Transaksi ob=itemList.get(listPosition);

            holder.totalPrice = ob.Quantity*ob.product.ProductPrice;
            holder.dateFormat = new SimpleDateFormat("dd-mm-yyyy");

            holder.historyName.setText(ob.product.ProductName);
            holder.historyQuantity.setText("Quantity : " + ob.Quantity.toString());
            holder.historyPrice.setText("Rp. " + holder.totalPrice.toString());
            holder.transactionID.setText("IIS" + ob.TransactionID.toString());
            holder.transactionDate.setText("Order Date: " + holder.dateFormat.format(ob.TransactionDate));
            holder.DetailProductImage.setImageResource(ob.product.ProductImage);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView historyName;
        public TextView historyPrice;
        public TextView historyQuantity;
        public Integer totalPrice;
        public TextView transactionID;
        public TextView transactionDate;
        public DateFormat dateFormat;
        public ImageView DetailProductImage;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            historyName=(TextView) itemView.findViewById(R.id.HistoryName);
            historyPrice=(TextView) itemView.findViewById(R.id.historyTotalPrice);
            historyQuantity=(TextView) itemView.findViewById(R.id.historyQuantity);
            transactionID=(TextView) itemView.findViewById(R.id.tranID);
            transactionDate=(TextView) itemView.findViewById(R.id.historyDate);
            DetailProductImage=(ImageView) itemView.findViewById(R.id.imageHistory);

        }
        @Override
        public void onClick(View view) {
            int pos=getLayoutPosition();
            selected=pos;
//            oc.onclick(selected);
            //th.notifyDataSetChanged();
            //fr.call(pos);
            //Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
        }
    }
}
