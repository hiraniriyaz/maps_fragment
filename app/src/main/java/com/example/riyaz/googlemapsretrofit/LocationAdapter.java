package com.example.riyaz.googlemapsretrofit;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

/**
 * Created by Riyaz on 8/1/2017.
 */


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MainViewHolder> {

    String formatted_address[];
    public LocationAdapter( String formatted_address[]){
        this.formatted_address = formatted_address;
    }
    @Override
    public LocationAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        MainViewHolder mainViewHolder= new MainViewHolder(view);

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(LocationAdapter.MainViewHolder holder, int position) {
        holder.tx_formatted_address.setText(formatted_address[position]);
     }

    @Override
    public int getItemCount() {
        return formatted_address.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView  tx_formatted_address;


        public MainViewHolder(View view){
            super(view);
            tx_formatted_address = (TextView)view.findViewById(R.id.formatted_address);
        }
    }

}
