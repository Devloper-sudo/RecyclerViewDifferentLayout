package layout.multiple.reign.com.recycelrviewmultiplelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList<Item> itemList = new ArrayList<Item>();

        ItemAdapter itemArrayAdapter = new ItemAdapter(itemList);
        recyclerView = (RecyclerView) findViewById(R.id.recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

        // Populating list items
        for(int i=0; i<4; i++) {
            if (i%2 == 0) {
                itemList.add(new Item("Item " + i, Item.ItemType.One_Item));
            } else {
                itemList.add(new Item("Item " + i, Item.ItemType.two_item));
            }
        }
    }
}
