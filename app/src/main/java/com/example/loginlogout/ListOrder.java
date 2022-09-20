package com.example.loginlogout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListOrder extends AppCompatActivity {
    ListView listViewCocktail ;
    ArrayList<Cocktail> arrCocktail;
    CocktailAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);
        listViewCocktail = findViewById(R.id.listOrder);
        arrCocktail = new ArrayList<>();
        arrCocktail.add(new Cocktail("Ruou so 1" , "This is infomation" , 99 , R.drawable.p1));
        arrCocktail.add(new Cocktail("Ruou so 2" , "This is infomation" , 99 , R.drawable.p2));
        arrCocktail.add(new Cocktail("Ruou so 3" , "This is infomation" , 99 , R.drawable.p3));
        arrCocktail.add(new Cocktail("Ruou so 4" , "This is infomation" , 99 , R.drawable.p4));
        arrCocktail.add(new Cocktail("Ruou so 5" , "This is infomation" , 99 , R.drawable.p5));
        adapter = new CocktailAdapter(this , R.layout.row_order , arrCocktail);
        listViewCocktail.setAdapter(adapter);

        listViewCocktail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cocktail cocktail = arrCocktail.get(i);
                Intent intent = new Intent();
                intent.setClass(ListOrder.this , detail_cocktail.class);
                intent.putExtra("dataCocktail",cocktail);
                startActivity(intent);
            }
        });
        listViewCocktail.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alerdialog = new AlertDialog.Builder(ListOrder.this);
                alerdialog.setTitle("Thong bao");
                alerdialog.setMessage("Ban co muon xoa khong");
                alerdialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ih) {
                        arrCocktail.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });
                alerdialog.setNegativeButton("khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ih) {
                    }
                });
                alerdialog.show();
                return false;
            }
        });
    }
}