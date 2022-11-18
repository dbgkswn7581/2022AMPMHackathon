package com.example.dropfood.mainscr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class Ranking extends Fragment{
    public Ranking(){
    }

    private ListView list;
    String[] mTitle = {"food1","food2","food3","food4","food5"};
    String[] mCount = {"00번","00번","00번","00번","00번"};
    String[] mNumber = {"4th","5th","6th","7th","8th"};
    int[] images = {R.drawable.ic_ranking,R.drawable.ic_ranking,R.drawable.ic_ranking,R.drawable.ic_ranking,R.drawable.ic_ranking};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_ranking, container, false);

        list = root.findViewById(R.id.listview_list);

        MyAdapter adapter = new MyAdapter(getContext(), mTitle, mCount, mNumber, images);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String[] rTitle;
        String[] rCount;
        String[] rNumber;
        int[] rImgs;

        MyAdapter(Context c, String[] title, String[] count, String[] number, int[] imgs){
            super(c, R.layout.listview_item, R.id.listitem_title, title);
            this.context = c;
            this.rTitle = title;
            this.rCount = count;
            this.rNumber = number;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview_item, parent, false);

            ImageView images = row.findViewById(R.id.listitem_image);
            TextView myTitle = row.findViewById(R.id.listitem_title);
            TextView myCount = row.findViewById(R.id.listitem_count);
            TextView myNumber = row.findViewById(R.id.listitem_number);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myCount.setText(rCount[position]);
            myNumber.setText(rNumber[position]);

            return row;
        }
    }


}