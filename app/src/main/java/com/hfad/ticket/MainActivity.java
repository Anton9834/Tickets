package com.hfad.ticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hfad.ticket.adapter.CategoryAdapter;
import com.hfad.ticket.adapter.TicketAdapter;
import com.hfad.ticket.model.Category;
import com.hfad.ticket.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler,ticketRecycler;
    CategoryAdapter categoryAdapter;
    TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList=new ArrayList<>();
        categoryList.add(new Category(1,"Спорт"));
        categoryList.add(new Category(2,"Коцерты"));
        categoryList.add(new Category(3,"Кино"));

        setCategoryRecycler(categoryList);

        List<Ticket> ticketList=new ArrayList<>();
        ticketList.add(new Ticket(1,"sport_1","Соревнования по\nбаскетболу","29 декабря","#00AA72"));
        ticketList.add(new Ticket(2,"sport_2","Соревнования по\nнастольному теннису","28 декабря","#c6c6c6"));
        ticketList.add(new Ticket(3,"concert_1","Новогодний\nконцерт","31 декабря","#dc4c38"));
        ticketList.add(new Ticket(4,"concert_2","Drum\nShow","30 декабря","#81746e"));
        ticketList.add(new Ticket(5,"movie","Фильм\n","1 января","#939293"));
        setTicketRecycler(ticketList);
    }

    private void setTicketRecycler(List<Ticket> ticketList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        ticketRecycler=findViewById(R.id.ticketRecycler);
        ticketRecycler.setLayoutManager(layoutManager);

        ticketAdapter=new TicketAdapter(this,ticketList);
        ticketRecycler.setAdapter(ticketAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler=findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter=new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}