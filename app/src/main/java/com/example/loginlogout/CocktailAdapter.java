package com.example.loginlogout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CocktailAdapter extends BaseAdapter {
    private Context context ;
    private int layout ;
    private List<Cocktail> cocktailList ;
    public CocktailAdapter(Context context , int layout ,List<Cocktail> cocktailList ){
        this.context = context ;
        this.layout = layout ;
        this.cocktailList = cocktailList ;
    }

    @Override
    public int getCount() {
        return cocktailList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout , null);

        TextView title = view.findViewById(R.id.order_title);
        TextView information = view.findViewById(R.id.information);
        TextView price = view.findViewById(R.id.price);
        ImageView image = view.findViewById(R.id.img_order);

        Cocktail cocktail = cocktailList.get(i);

        title.setText(cocktail.getTitle());
        information.setText(cocktail.getInformation());
        price.setText(Double.toString(cocktail.getPrice()));
        image.setImageResource(cocktail.getImage());

        return view;
    }
}
