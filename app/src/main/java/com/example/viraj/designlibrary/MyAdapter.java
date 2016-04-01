package com.example.viraj.designlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by viraj on 31/3/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {

    List<Name> nameList;

    public MyAdapter(List<Name> list) {
        this.nameList = list;
    }

    @Override
    public void onBindViewHolder(MyView holder, int i) {
        Name name = nameList.get(i);
        holder.text1.setText(name.first);
        holder.text2.setText(name.last);

    }

    @Override
    public MyView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview, viewGroup, false);

        return new MyView(itemView);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


    public static class MyView extends RecyclerView.ViewHolder {

        TextView text1;
        TextView text2;
        public MyView(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);

        }
    }

}
