package com.hfad.ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hfad.ticket.model.Order;
import com.hfad.ticket.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list=findViewById(R.id.orders_list);

        List<String> ticketsTitle=new ArrayList<>();
        for(Ticket c: MainActivity.fullTicketList){
            if (Order.items.contains(c.getId()))
                ticketsTitle.add(c.getTitle());
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ticketsTitle));

    }
}