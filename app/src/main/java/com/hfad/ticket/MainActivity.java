package com.hfad.ticket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hfad.ticket.adapter.CategoryAdapter;
import com.hfad.ticket.adapter.TicketAdapter;
import com.hfad.ticket.model.Category;
import com.hfad.ticket.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler,ticketRecycler;
    CategoryAdapter categoryAdapter;
    static TicketAdapter ticketAdapter;
    static List<Ticket> ticketList=new ArrayList<>();
    static List<Ticket> fullTicketList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList=new ArrayList<>();
        categoryList.add(new Category(1,"Спорт"));
        categoryList.add(new Category(2,"Концерты"));
        categoryList.add(new Category(3,"Кино"));
        categoryList.add(new Category(4,"Прочее"));

        setCategoryRecycler(categoryList);

        ticketList.add(new Ticket(1,"sport_1","Соревнования по\nбаскетболу","29 декабря","#00AA72","Приглашаем на соревнования по баскетболу",1));
        ticketList.add(new Ticket(2,"sport_2","Соревнования по\nнастольному теннису","28 декабря","#c6c6c6","Приглашаем на соревнования по настольному теннису",1));
        ticketList.add(new Ticket(3,"concert_1","Новогодний\nконцерт","31 декабря","#dc4c38","Приглашаем на новогодний концерт",2));
        ticketList.add(new Ticket(4,"concert_2","Drum\nShow","30 декабря","#81746e","Приглашаем на Drum Show",2));
        ticketList.add(new Ticket(5,"movie","Фильм\n","1 января","#939293","",3));

        fullTicketList.addAll(ticketList);

        setTicketRecycler(ticketList);
    }

    public void openShoppingCart(View view){
        Intent intent=new Intent(this,OrderPage.class);
        startActivity(intent);
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

    public  static void showTicketsByCategory(int category){

        ticketList.clear();
        ticketList.addAll(fullTicketList);

        List<Ticket> filterTickets=new ArrayList<>();

        for(Ticket c: ticketList){
            if(c.getCategory()==category)
                filterTickets.add(c);
        }
        ticketList.clear();
        ticketList.addAll(filterTickets);

        ticketAdapter.notifyDataSetChanged();
    }
}