package in.fivedegree.netclanclone.Fragments;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.fivedegree.netclanclone.R;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {

    ArrayList<model> data;
    Context context;
    public adapter(ArrayList<model> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.single_item_layout, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.get().load(data.get(position).getImageUrl()).placeholder(R.drawable.dp_placeholder).into(holder.dpIv);
        holder.nameTv.setText(data.get(position).Name);
        holder.cityTv.setText(data.get(position).location + "|" + data.get(position).designation);
        holder.rangeTv.setText("Within " + data.get(position).range);
        holder.progressIndicator.setProgress(Integer.parseInt(data.get(position).pf_completion));
        holder.bioTv.setText(data.get(position).bio);
        holder.bio2Tv.setText(data.get(position).bio2);
        holder.inviteBtn.setOnClickListener(v -> {
            Snackbar.make( v, "Invite " + data.get(position).Name, Snackbar.LENGTH_LONG)
                    .setBackgroundTint(context.getColor(R.color.blue_001))
                    .setTextColor(context.getColor(R.color.white_001))
                    .show();
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        public ImageView dpIv;
        public TextView nameTv, cityTv, rangeTv, bioTv, bio2Tv;
        public LinearProgressIndicator progressIndicator;
        public LinearLayout inviteBtn;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            dpIv = itemView.findViewById(R.id.dp_Iv);
            nameTv = itemView.findViewById(R.id.name_tv);
            cityTv = itemView.findViewById(R.id.city_tv);
            rangeTv = itemView.findViewById(R.id.range_tv);
            bioTv = itemView.findViewById(R.id.bio_tv);
            bio2Tv = itemView.findViewById(R.id.bio2_tv);
            progressIndicator = itemView.findViewById(R.id.layout_progress);
            inviteBtn = itemView.findViewById(R.id.invite_btn);
        }
    }
}