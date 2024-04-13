package com.salazarisaiahnoel.customs;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.customs.interfaces.SimpleListOnItemClick;
import com.salazarisaiahnoel.customs.interfaces.SimpleListOnItemLongClick;

import java.util.List;

public class SimpleList {

    Context context;
    List<String> data, subdata;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    SimpleListAdapter simpleListAdapter;
    int clickListener = 0;
    SimpleListOnItemClick onItemClickListener;
    SimpleListOnItemLongClick onItemLongClickListener;

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data){
        this.context = context;
        this.data = data;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 0;
        refresh();
    }

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data, SimpleListOnItemClick onItemClickListener){
        this.context = context;
        this.data = data;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 1;
        this.onItemClickListener = onItemClickListener;
        refresh();
    }

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data, SimpleListOnItemLongClick onItemLongClickListener){
        this.context = context;
        this.data = data;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 2;
        this.onItemLongClickListener = onItemLongClickListener;
        refresh();
    }

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data, SimpleListOnItemClick onItemClickListener, SimpleListOnItemLongClick onItemLongClickListener){
        this.context = context;
        this.data = data;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 3;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
        refresh();
    }

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data, List<String> subdata){
        this.context = context;
        this.data = data;
        this.subdata = subdata;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 0;
        refresh();
    }

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data, List<String> subdata, SimpleListOnItemClick onItemClickListener){
        this.context = context;
        this.data = data;
        this.subdata = subdata;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 1;
        this.onItemClickListener = onItemClickListener;
        refresh();
    }

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data, List<String> subdata, SimpleListOnItemLongClick onItemLongClickListener){
        this.context = context;
        this.data = data;
        this.subdata = subdata;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 2;
        this.onItemLongClickListener = onItemLongClickListener;
        refresh();
    }

    public SimpleList(Context context, RecyclerView recyclerView, List<String> data, List<String> subdata, SimpleListOnItemClick onItemClickListener, SimpleListOnItemLongClick onItemLongClickListener){
        this.context = context;
        this.data = data;
        this.subdata = subdata;
        this.recyclerView = recyclerView;
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        clickListener = 3;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
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
                    int paddingAll = simpleListAdapter.getItemPaddingAllSides();
                    int paddingLeft = simpleListAdapter.getItemPaddingLeft();
                    int paddingTop = simpleListAdapter.getItemPaddingTop();
                    int paddingRight = simpleListAdapter.getItemPaddingRight();
                    int paddingBottom = simpleListAdapter.getItemPaddingBottom();
                    boolean singlePadding = simpleListAdapter.getSinglePadding();
                    simpleListAdapter = new SimpleListAdapter(clickListener, data, onItemClickListener);
                    recyclerView.setAdapter(simpleListAdapter);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    simpleListAdapter = new SimpleListAdapter(clickListener, data, onItemClickListener);
                    recyclerView.setAdapter(simpleListAdapter);
                }
                break;
            case 2:
                try {
                    int paddingAll = simpleListAdapter.getItemPaddingAllSides();
                    int paddingLeft = simpleListAdapter.getItemPaddingLeft();
                    int paddingTop = simpleListAdapter.getItemPaddingTop();
                    int paddingRight = simpleListAdapter.getItemPaddingRight();
                    int paddingBottom = simpleListAdapter.getItemPaddingBottom();
                    boolean singlePadding = simpleListAdapter.getSinglePadding();
                    simpleListAdapter = new SimpleListAdapter(clickListener, data, onItemLongClickListener);
                    recyclerView.setAdapter(simpleListAdapter);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    simpleListAdapter = new SimpleListAdapter(clickListener, data, onItemLongClickListener);
                    recyclerView.setAdapter(simpleListAdapter);
                }
                break;
            case 3:
                try {
                    int paddingAll = simpleListAdapter.getItemPaddingAllSides();
                    int paddingLeft = simpleListAdapter.getItemPaddingLeft();
                    int paddingTop = simpleListAdapter.getItemPaddingTop();
                    int paddingRight = simpleListAdapter.getItemPaddingRight();
                    int paddingBottom = simpleListAdapter.getItemPaddingBottom();
                    boolean singlePadding = simpleListAdapter.getSinglePadding();
                    simpleListAdapter = new SimpleListAdapter(clickListener, data, onItemClickListener, onItemLongClickListener);
                    recyclerView.setAdapter(simpleListAdapter);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    simpleListAdapter = new SimpleListAdapter(clickListener, data, onItemClickListener, onItemLongClickListener);
                    recyclerView.setAdapter(simpleListAdapter);
                }
                break;
            default:
                try {
                    int paddingAll = simpleListAdapter.getItemPaddingAllSides();
                    int paddingLeft = simpleListAdapter.getItemPaddingLeft();
                    int paddingTop = simpleListAdapter.getItemPaddingTop();
                    int paddingRight = simpleListAdapter.getItemPaddingRight();
                    int paddingBottom = simpleListAdapter.getItemPaddingBottom();
                    boolean singlePadding = simpleListAdapter.getSinglePadding();
                    simpleListAdapter = new SimpleListAdapter(clickListener, data);
                    recyclerView.setAdapter(simpleListAdapter);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    simpleListAdapter = new SimpleListAdapter(clickListener, data);
                    recyclerView.setAdapter(simpleListAdapter);
                }
                break;
        }

    }

    public void setItemPadding(int allSides){
        simpleListAdapter.setItemPaddingAllSides(allSides);
    }

    public void setItemPadding(int left, int top, int right, int bottom){
        simpleListAdapter.setItemPadding(left, top, right, bottom);
    }
}

class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.SimpleListHolder>{
    List<String> data, subdata;
    int itemPaddingAllSides = 0, itemPaddingLeft = 0, itemPaddingTop = 0, itemPaddingRight = 0, itemPaddingBottom = 0;
    boolean singlePadding = false;
    boolean hasSubdata = false;

    int clickListener = 0;

    SimpleListOnItemClick onItemClickListener;
    SimpleListOnItemLongClick onItemLongClickListener;

    public SimpleListAdapter(int clickListener, List<String> data){
        this.data = data;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, List<String> subdata){
        this.data = data;
        this.subdata = subdata;
        this.clickListener = clickListener;
        hasSubdata = true;
    }

    public int getItemPaddingAllSides(){
        return itemPaddingAllSides;
    }
    public int getItemPaddingLeft(){
        return itemPaddingLeft;
    }
    public int getItemPaddingTop(){
        return itemPaddingTop;
    }
    public int getItemPaddingRight(){
        return itemPaddingRight;
    }
    public int getItemPaddingBottom(){
        return itemPaddingBottom;
    }
    public boolean getSinglePadding(){
        return singlePadding;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListOnItemClick onItemClickListener){
        this.data = data;
        this.onItemClickListener = onItemClickListener;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListOnItemLongClick onItemLongClickListener){
        this.data = data;
        this.onItemLongClickListener = onItemLongClickListener;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListOnItemClick onItemClickListener, SimpleListOnItemLongClick onItemLongClickListener){
        this.data = data;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, List<String> subdata, SimpleListOnItemClick onItemClickListener){
        this.data = data;
        this.subdata = subdata;
        this.onItemClickListener = onItemClickListener;
        this.clickListener = clickListener;
        hasSubdata = true;
    }

    public SimpleListAdapter(int clickListener, List<String> data, List<String> subdata, SimpleListOnItemLongClick onItemLongClickListener){
        this.data = data;
        this.subdata = subdata;
        this.onItemLongClickListener = onItemLongClickListener;
        this.clickListener = clickListener;
        hasSubdata = true;
    }

    public SimpleListAdapter(int clickListener, List<String> data, List<String> subdata, SimpleListOnItemClick onItemClickListener, SimpleListOnItemLongClick onItemLongClickListener){
        this.data = data;
        this.subdata = subdata;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
        this.clickListener = clickListener;
        hasSubdata = true;
    }

    public void setItemPaddingAllSides(int allSides){
        singlePadding = true;
        itemPaddingAllSides = allSides;
    }

    public void setItemPadding(int left, int top, int right, int bottom){
        singlePadding = false;
        itemPaddingLeft = left;
        itemPaddingTop = top;
        itemPaddingRight = right;
        itemPaddingBottom = bottom;
    }

    @NonNull
    @Override
    public SimpleListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item, parent, false);
        SimpleListHolder simpleListHolder = new SimpleListHolder(view);
        switch (clickListener){
            case 1:
                simpleListHolder = new SimpleListHolder(view, onItemClickListener);
                break;
            case 2:
                simpleListHolder = new SimpleListHolder(view, onItemLongClickListener);
                break;
            case 3:
                simpleListHolder = new SimpleListHolder(view, onItemClickListener, onItemLongClickListener);
                break;
        }
        float scale = parent.getContext().getResources().getDisplayMetrics().density;
        if (singlePadding){
            if (!hasSubdata){
                simpleListHolder.button.setPadding((int) (itemPaddingAllSides * scale + 0.5f), (int) (itemPaddingAllSides * scale + 0.5f), (int) (itemPaddingAllSides * scale + 0.5f), (int) (itemPaddingAllSides * scale + 0.5f));
            } else {
                simpleListHolder.constraintLayout.setPadding((int) (itemPaddingAllSides * scale + 0.5f), (int) (itemPaddingAllSides * scale + 0.5f), (int) (itemPaddingAllSides * scale + 0.5f), (int) (itemPaddingAllSides * scale + 0.5f));
            }
        } else {
            if (!hasSubdata){
                simpleListHolder.button.setPadding((int) (itemPaddingLeft * scale + 0.5f), (int) (itemPaddingTop * scale + 0.5f), (int) (itemPaddingRight * scale + 0.5f), (int) (itemPaddingBottom * scale + 0.5f));
            } else {
                simpleListHolder.constraintLayout.setPadding((int) (itemPaddingLeft * scale + 0.5f), (int) (itemPaddingTop * scale + 0.5f), (int) (itemPaddingRight * scale + 0.5f), (int) (itemPaddingBottom * scale + 0.5f));
            }
        }
        return simpleListHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleListHolder holder, int position) {
        if (!hasSubdata){
            holder.button.setText(data.get(position));
        } else {
            holder.t1.setText(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SimpleListHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        Button button;
        ConstraintLayout constraintLayout;
        TextView t1, t2;
        SimpleListOnItemClick onItemClickListener;
        SimpleListOnItemLongClick onItemLongClickListener;

        public SimpleListHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);
            constraintLayout = itemView.findViewById(R.id.simple_list_item_id_subtext);
            t1 = itemView.findViewById(R.id.textView);
            t2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(null);
            itemView.setOnLongClickListener(null);
        }

        public SimpleListHolder(@NonNull View itemView, SimpleListOnItemClick onItemClickListener) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);
            constraintLayout = itemView.findViewById(R.id.simple_list_item_id_subtext);
            t1 = itemView.findViewById(R.id.textView);
            t2 = itemView.findViewById(R.id.textView2);

            this.onItemClickListener = onItemClickListener;

            itemView.setOnClickListener(this);
        }

        public SimpleListHolder(@NonNull View itemView, SimpleListOnItemLongClick onItemLongClickListener) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);
            constraintLayout = itemView.findViewById(R.id.simple_list_item_id_subtext);
            t1 = itemView.findViewById(R.id.textView);
            t2 = itemView.findViewById(R.id.textView2);

            this.onItemLongClickListener = onItemLongClickListener;

            itemView.setOnLongClickListener(this);
        }

        public SimpleListHolder(@NonNull View itemView, SimpleListOnItemClick onItemClickListener, SimpleListOnItemLongClick onItemLongClickListener) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);
            constraintLayout = itemView.findViewById(R.id.simple_list_item_id_subtext);
            t1 = itemView.findViewById(R.id.textView);
            t2 = itemView.findViewById(R.id.textView2);

            this.onItemClickListener = onItemClickListener;
            this.onItemLongClickListener = onItemLongClickListener;

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            onItemLongClickListener.onItemLongClick(getAdapterPosition());
            return true;
        }
    }
}