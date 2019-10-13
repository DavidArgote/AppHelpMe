package com.hackmusk.apphelpme.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackmusk.apphelpme.R;

import java.util.ArrayList;

public class AdapterListPublic extends RecyclerView.Adapter<AdapterListPublic.Holder> {

    private Context context;
    private ArrayList<Publication> list;

    public AdapterListPublic(Context context, ArrayList<Publication> list) {
        this.context = context;
        this.list = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_public, parent, false);
        Holder holder = new Holder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fillAllViews(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvName, tvDirection;
        private ImageView ivImage, btnCall, btnMenssage;

        public Holder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDateItem);
            tvName = itemView.findViewById(R.id.tvNameUserItem);
            tvDirection = itemView.findViewById(R.id.tvDireccionItem);

            ivImage = itemView.findViewById(R.id.ivImageItem);
            btnCall = itemView.findViewById(R.id.ivCallItem);
            btnCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri number = Uri.parse("tel:3162924315");
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                    context.startActivity(callIntent);
                }
            });

            btnMenssage = itemView.findViewById(R.id.ivMenssageItem);
            btnMenssage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","argote.2075@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Me intereza ayudar");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Estoy interezado.");
                    context.startActivity(Intent.createChooser(emailIntent, "Send email.    .."));
                }
            });

        }

        public void fillAllViews(Publication publication) {

            tvDate.setText(publication.getDate());
            tvName.setText(publication.getIdUser());
            tvDirection.setText(publication.getDirection());

            if (publication.getUrlPhoto() != null) {

                Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(publication.getUrlPhoto()), 160, 120, true);
                ivImage.setImageBitmap(bitmap);

            } else {
                ivImage.setImageResource(R.drawable.logo_solo_mini);
            }

        }

    }
}
