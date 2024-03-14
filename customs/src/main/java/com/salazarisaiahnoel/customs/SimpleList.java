package com.salazarisaiahnoel.customs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.customs.interfaces.SimpleListOnItemClick;
import com.salazarisaiahnoel.customs.interfaces.SimpleListOnItemLongClick;

import java.util.List;

public class SimpleList {

    Context context;
    List<String> data;
    RecyclerView rv;
    LinearLayoutManager llm;
    SimpleListAdapter sla;
    int clickListener = 0;
    SimpleListOnItemClick listener;
    SimpleListOnItemLongClick listenerLong;

    public SimpleList(Context context, RecyclerView rv, List<String> data){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 0;
        refresh();
    }

    public SimpleList(Context context, RecyclerView rv, List<String> data, SimpleListOnItemClick listener){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 1;
        this.listener = listener;
        refresh();
    }

    public SimpleList(Context context, RecyclerView rv, List<String> data, SimpleListOnItemLongClick listenerLong){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 2;
        this.listenerLong = listenerLong;
        refresh();
    }

    public SimpleList(Context context, RecyclerView rv, List<String> data, SimpleListOnItemClick listener, SimpleListOnItemLongClick listenerLong){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 3;
        this.listener = listener;
        this.listenerLong = listenerLong;
        refresh();
    }

    public void addItem(String a){
        data.add(a);
        refresh();
    }

    public void removeItem(int position){
        data.remove(position);
        refresh();
    }

    public void removeStartItem(){
        data.remove(0);
        refresh();
    }

    public void removeEndItem(){
        data.remove(data.size() - 1);
        refresh();
    }

    public List<String> getData(){
        return data;
    }

    void refresh(){
        switch (clickListener){
            case 1:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data, listener);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data, listener);
                    rv.setAdapter(sla);
                }
                break;
            case 2:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data, listenerLong);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data, listenerLong);
                    rv.setAdapter(sla);
                }
                break;
            case 3:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data, listener, listenerLong);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data, listener, listenerLong);
                    rv.setAdapter(sla);
                }
                break;
            default:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data);
                    rv.setAdapter(sla);
                }
                break;
        }

    }

    public void setItemPadding(int value){
        sla.setItemPadding(value);
    }

    public void setItemPadding(int value1, int value2, int value3, int value4){
        sla.setItemPadding(value1, value2, value3, value4);
    }
}

class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.SimpleListHolder>{
    List<String> data;
    int itemPadding = 0, itemPadding1 = 0, itemPadding2 = 0, itemPadding3 = 0, itemPadding4 = 0;
    boolean singlePadding = false;

    int clickListener = 0;

    SimpleListOnItemClick listener;
    SimpleListOnItemLongClick listenerLong;

    public SimpleListAdapter(int clickListener, List<String> data){
        this.data = data;
        this.clickListener = clickListener;
    }

    public int getItemPadding(){
        return itemPadding;
    }
    public int getItemPadding1(){
        return itemPadding1;
    }
    public int getItemPadding2(){
        return itemPadding2;
    }
    public int getItemPadding3(){
        return itemPadding3;
    }
    public int getItemPadding4(){
        return itemPadding4;
    }
    public boolean getSinglePadding(){
        return singlePadding;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListOnItemClick listener){
        this.data = data;
        this.listener = listener;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListOnItemLongClick listenerLong){
        this.data = data;
        this.listenerLong = listenerLong;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListOnItemClick listener, SimpleListOnItemLongClick listenerLong){
        this.data = data;
        this.listener = listener;
        this.listenerLong = listenerLong;
        this.clickListener = clickListener;
    }

    public void setItemPadding(int value){
        singlePadding = true;
        itemPadding = value;
    }

    public void setItemPadding(int value1, int value2, int value3, int value4){
        singlePadding = false;
        itemPadding1 = value1;
        itemPadding2 = value2;
        itemPadding3 = value3;
        itemPadding4 = value4;
    }

    @NonNull
    @Override
    public SimpleListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item, parent, false);
        SimpleListHolder slh = new SimpleListHolder(v);
        switch (clickListener){
            case 1:
                slh = new SimpleListHolder(v, listener);
                break;
            case 2:
                slh = new SimpleListHolder(v, listenerLong);
                break;
            case 3:
                slh = new SimpleListHolder(v, listener, listenerLong);
                break;
        }
        float scale = parent.getContext().getResources().getDisplayMetrics().density;
        if (singlePadding){
            slh.button.setPadding((int) (itemPadding * scale + 0.5f), (int) (itemPadding * scale + 0.5f), (int) (itemPadding * scale + 0.5f), (int) (itemPadding * scale + 0.5f));
        } else {
            slh.button.setPadding((int) (itemPadding1 * scale + 0.5f), (int) (itemPadding2 * scale + 0.5f), (int) (itemPadding3 * scale + 0.5f), (int) (itemPadding4 * scale + 0.5f));
        }
        return slh;
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleListHolder holder, int position) {
        holder.button.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SimpleListHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        Button button;
        SimpleListOnItemClick listener;
        SimpleListOnItemLongClick listenerLong;

        public SimpleListHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            itemView.setOnClickListener(null);
            itemView.setOnLongClickListener(null);
        }

        public SimpleListHolder(@NonNull View itemView, SimpleListOnItemClick listener) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        public SimpleListHolder(@NonNull View itemView, SimpleListOnItemLongClick listenerLong) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            this.listenerLong = listenerLong;

            itemView.setOnLongClickListener(this);
        }

        public SimpleListHolder(@NonNull View itemView, SimpleListOnItemClick listener, SimpleListOnItemLongClick listenerLong) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            this.listener = listener;
            this.listenerLong = listenerLong;

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            listenerLong.onItemLongClick(getAdapterPosition());
            return true;
        }
    }
}