package com.hfad.ticket.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.ticket.R;
import com.hfad.ticket.TicketPage;
import com.hfad.ticket.model.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    Context context;
    List<Ticket> tickets;

    public TicketAdapter(Context context, List<Ticket> tickets) {
        this.context = context;
        this.tickets = tickets;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ticketItems= LayoutInflater.from(context).inflate(R.layout.ticket_item,parent, false);
        return new TicketAdapter.TicketViewHolder(ticketItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.TicketViewHolder holder, int position) {
        holder.ticketBg.setCardBackgroundColor(Color.parseColor(tickets.get(position).getColor()));

        int imageId=context.getResources().getIdentifier("ic_" + tickets.get(position).getImg(),"drawable",context.getPackageName());
        holder.ticketImage.setImageResource(imageId);
        holder.ticketTitle.setText(tickets.get(position).getTitle());
        holder.ticketDate.setText(tickets.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, TicketPage.class);

                intent.putExtra("ticketBg",Color.parseColor(tickets.get(position).getColor()));
                intent.putExtra("ticketImage",imageId);
                intent.putExtra("ticketTitle",tickets.get(position).getTitle());
                intent.putExtra("ticketDate",tickets.get(position).getDate());
                intent.putExtra("ticketText",tickets.get(position).getText());
                intent.putExtra("ticketId",tickets.get(position).getId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()

    {
        return tickets.size();
    }

    public static final class TicketViewHolder extends RecyclerView.ViewHolder{

        CardView ticketBg;
        ImageView ticketImage;
        TextView ticketTitle, ticketDate;

        public TicketViewHolder(@NonNull View itemView)
        {
            super(itemView);

            ticketBg=itemView.findViewById(R.id.ticketBg);
            ticketImage=itemView.findViewById(R.id.ticketImage);
            ticketTitle=itemView.findViewById(R.id.ticketTitle);
            ticketDate=itemView.findViewById(R.id.ticketDate);
        }
    }
}
