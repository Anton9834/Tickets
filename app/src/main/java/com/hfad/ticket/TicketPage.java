package com.hfad.ticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.ticket.model.Order;

public class TicketPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_page);

        ConstraintLayout ticketBg=findViewById(R.id.ticketPageBg);
        ImageView ticketImage=findViewById(R.id.ticketPageImage);
        TextView ticketTitle=findViewById(R.id.ticketPageTitle);
        TextView ticketDate=findViewById(R.id.ticketPageDate);
        TextView ticketText=findViewById(R.id.ticketPageText);

        ticketBg.setBackgroundColor(getIntent().getIntExtra("ticketBg",0));
        ticketImage.setImageResource(getIntent().getIntExtra("ticketImage",0));
        ticketTitle.setText(getIntent().getStringExtra("ticketTitle"));
        ticketDate.setText(getIntent().getStringExtra("ticketDate"));
        ticketText.setText(getIntent().getStringExtra("ticketText"));

    }

    public void addToCart(View view){
        int item_id=getIntent().getIntExtra("ticketId",0);
        Order.items.add(item_id);
        Toast.makeText(this,"Добавлено!", Toast.LENGTH_LONG).show();
    }
}