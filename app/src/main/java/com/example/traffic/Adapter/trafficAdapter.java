package com.example.traffic.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.traffic.Modules.Traffic;
import com.example.traffic.R;

import java.util.ArrayList;

public class trafficAdapter extends RecyclerView.Adapter<trafficAdapter.viewholder> {

    ArrayList<Traffic> traffic;

    public trafficAdapter(ArrayList<Traffic> traffic) {
        this.traffic = traffic;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.traffic,viewGroup,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {


        viewholder.traficcplace.setText(traffic.get(i).getTrafficSignName());
        viewholder.traficDescriprtion.setText(traffic.get(i).getTrafficSignDescription());




        Bitmap imageBitmap = BitmapFactory.decodeResource(viewholder.itemView.getResources(),viewholder.itemView.getResources().getIdentifier(traffic.get(i).getTrafficSignImage(), "drawable", viewholder.itemView.getContext().getPackageName()));

        if (imageBitmap != null){
            Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, 100, 100, false);

            viewholder.imageView.setImageBitmap(resizedBitmap);
        }


    }

    @Override
    public int getItemCount() {
        return traffic.size();
    }


    class viewholder extends RecyclerView.ViewHolder{
        TextView traficcplace;
        TextView traficDescriprtion;
        ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            traficcplace=itemView.findViewById(R.id.Traffic_sig_name);
            traficDescriprtion=itemView.findViewById(R.id.Traffic_sig_Description);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }


    public void changeData(ArrayList<Traffic> traffic){


        this.traffic=traffic;
        notifyDataSetChanged();

    }


}
