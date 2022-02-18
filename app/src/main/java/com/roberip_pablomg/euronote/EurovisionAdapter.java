package com.roberip_pablomg.euronote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class EurovisionAdapter extends RecyclerView.Adapter<EurovisionAdapter.EurovisionViewHolder> {

    @NonNull
    @Override
    public EurovisionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_representative, parent, false);
        return new EurovisionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EurovisionViewHolder holder, int position) {
        Representative representative = representatives.get(position);
        holder.bind(representative);
    }

    @Override
    public int getItemCount() {
        return (representatives == null)? 0 : representatives.size();
    }

    public static interface onItemClickListener{
        public void onItemClick(View view, int country);
    }

    private ArrayList<Representative> representatives;
    private Context context;
    private onItemClickListener onItemClickListener;
    private ViewModel vm;

    public EurovisionAdapter (Context context){
        this.context = context;
    }

    public void setRepresentatives(ArrayList<Representative> representatives) {
        this.representatives = representatives;
        notifyDataSetChanged();
    }


    public void setVM(ViewModel vm){
        this.vm = vm;
    }

    public void setOnItemClickListener(EurovisionAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class EurovisionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvSongName;
        private TextView tvSingerName;
        private TextView tvPosition;
        private TextView tvPoints;
        private TextView tvCountry;
        private ImageView iv;
        private Button addToFaves;
        private Representative representativeShow;
        private View containerView;

        public EurovisionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSongName = itemView.findViewById(R.id.tv_songName);
            tvSingerName = itemView.findViewById(R.id.tv_singerName);
            tvPosition = itemView.findViewById(R.id.tv_position);
            tvPoints = itemView.findViewById(R.id.tv_points);
            tvCountry = itemView.findViewById(R.id.tv_country);
            iv = itemView.findViewById(R.id.iv);
            containerView = itemView.findViewById(R.id.containerView);
            addToFaves = itemView.findViewById(R.id.addToFaves);
            addToFaves.setOnClickListener(this);
            containerView.setOnClickListener(this);
            addToFaves.bringToFront();
        }

        public void bind(Representative representative)
        {
            representativeShow=representative;
            tvSongName.setText(representative.getSongName());
            tvSingerName.setText(representative.getSingerName());
            tvPosition.setText(representative.getPosition());
            tvPoints.setText(String.valueOf(representative.getPoints()));
            tvCountry.setText(context.getResources().getString(representative.getCountry()));
            iv.setImageResource(representative.getFlag());
            if(representative.getStars() != -1){
                if(vm instanceof FavesViewModel){
                    addToFaves.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_delete, 0, 0, 0);
                    addToFaves.setVisibility(View.VISIBLE);
                    System.out.println("borrar");
                }
                else{
                    System.out.println("hey");
                    addToFaves.setVisibility(View.INVISIBLE);
                }
            }
            else{
                addToFaves.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_faves, 0, 0, 0);
                addToFaves.setVisibility(View.VISIBLE);
            }
        }



        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.addToFaves){
                if (vm instanceof MainViewModel) {
                    ((MainViewModel) vm).updateRepresentative(representativeShow.setStars(0));
                    System.out.println("main");
                    notifyDataSetChanged();
                }
                else if (vm instanceof FirstSemifinalViewModel){
                    ((FirstSemifinalViewModel) vm).updateRepresentative(representativeShow.setStars(0));
                    System.out.println("first");
                    notifyDataSetChanged();
                }
                else if (vm instanceof SecondSemifinalViewModel){
                    ((SecondSemifinalViewModel) vm).updateRepresentative(representativeShow.setStars(0));
                    System.out.println("second");
                    notifyDataSetChanged();
                }
                else if (vm instanceof GrandFinalViewModel){
                    ((GrandFinalViewModel) vm).updateRepresentative(representativeShow.setStars(0));
                    System.out.println("final");
                    notifyDataSetChanged();
                }
                else if( vm instanceof FavesViewModel){
                    ((FavesViewModel) vm).updateRepresentative(representativeShow.setStars(-1));
                    notifyDataSetChanged();
                }
            }
            if ( onItemClickListener != null && v.getId()==R.id.containerView)
            {
                onItemClickListener.onItemClick(this.containerView, representativeShow.getCountry() );
            }
        }
    }
}
