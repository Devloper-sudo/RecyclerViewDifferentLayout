package layout.multiple.reign.com.recycelrviewmultiplelayout;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abhishek on 1/26/2019.
 */

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private List<Item> itemList = null;


    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;

        Log.e("ItemAdapter: ", "itemAdapter");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("ItemAdapter: ", "onCreateViewHolder");
        View view = null;
        if (viewType == TYPE_ONE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items, parent, false);
            return new OneHolder(view);
        } else if (viewType == TYPE_TWO) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_two, parent, false);
            return new TwoHolder(view);
        } else {
            throw new RuntimeException("Exception");
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("ItemAdapter: ", "onBindViewHolder");


        switch (holder.getItemViewType()) {
            case TYPE_ONE:
                if (holder instanceof OneHolder) {
                    OneHolder oneHolder = (OneHolder) holder;
                    initLayoutOne(oneHolder, position);
                }
                break;

            case TYPE_TWO:
                if (holder instanceof OneHolder) {
                    TwoHolder twoHolder = (TwoHolder) holder;
                    initLayoutTwo(twoHolder, position);
                }

                break;
        }
    }

    private void initLayoutOne(OneHolder holder, int pos) {
        holder.textView.setText("Hello");

    }

    private void initLayoutTwo(TwoHolder holder, int pos) {
        holder.textView.setText("World");
    }


    @Override
    public int getItemCount() {
        Log.e("ItemAdapter: ", "getItemCount");
        return itemList == null ? 0 : itemList.size();
    }


    @Override
    public int getItemViewType(int position) {
        Log.e("ItemAdapter: ", "getItemViewType");
        Item item = itemList.get(position);
        if (item.getType() == Item.ItemType.One_Item) {
            return TYPE_ONE;
        } else if (item.getType() == Item.ItemType.two_item) {
            return TYPE_TWO;
        } else {
            return -1;
        }
    }

    static class OneHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public OneHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }

    static class TwoHolder extends RecyclerView.ViewHolder {

        public Button textView;

        public TwoHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.btn);
        }
    }

}
