package com.example.dropfood.mainscr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
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
import com.example.dropfood.mainscr.community.GroupChat;

public class Commnuity extends Fragment{
    public Commnuity(){
    }

    private ListView list;
    String[] mTitle = {"Group1","Group2","Group3","Group4","Group5","Group1","Group2","Group3","Group4","Group5"};
    String[] mChat = {"chat","chat","chat","chat","chat","chat","chat","chat","chat","chat"};
    int[] images = {R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group,R.drawable.commnuity_group};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_commnuity, container, false);

        list = root.findViewById(R.id.listview_chatlist);

        Commnuity.MyAdapter adapter = new Commnuity.MyAdapter(getContext(), mTitle, mChat, images);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), GroupChat.class);
                startActivity(intent);
            }
        });

        return root;
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        String[] rChat;
        int[] rImgs;

        MyAdapter(Context c, String[] title, String[] chat, int[] imgs){
            super(c, R.layout.listview_chatting, R.id.listitem_title, title);
            this.context = c;
            this.rTitle = title;
            this.rChat = chat;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview_chatting, parent, false);

            ImageView images = row.findViewById(R.id.listitem_groupimg);
            TextView myTitle = row.findViewById(R.id.listitem_title);
            TextView myChat = row.findViewById(R.id.listitem_chat);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myChat.setText(rChat[position]);

            return row;
        }
    }


}