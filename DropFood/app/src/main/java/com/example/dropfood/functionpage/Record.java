package com.example.dropfood.functionpage;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dropfood.R;
import com.example.dropfood.mainscr.Commnuity;

public class Record extends AppCompatActivity {

    private ListView list;
    String[] mTitle = {"Group1","Group2","Group3","Group4","Group5","Group1","Group2","Group3","Group4","Group5"};
    String[] mRestaurant = {"chat","chat","chat","chat","chat","chat","chat","chat","chat","chat"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        list = findViewById(R.id.listview_record);

        Record.MyAdapter adapter = new Record.MyAdapter(getApplicationContext(), mTitle, mRestaurant);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        String[] rRestaurant;

        MyAdapter(Context c, String[] title, String[] restaurant){
            super(c, R.layout.listview_chatting, R.id.listitem_title, title);
            this.context = c;
            this.rTitle = title;
            this.rRestaurant = restaurant;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview_record, parent, false);

            TextView myTitle = row.findViewById(R.id.listitem_title);
            TextView myRestaurant = row.findViewById(R.id.listitem_restaurant);

            myTitle.setText(rTitle[position]);
            myRestaurant.setText(rRestaurant[position]);

            return row;
        }
    }
}