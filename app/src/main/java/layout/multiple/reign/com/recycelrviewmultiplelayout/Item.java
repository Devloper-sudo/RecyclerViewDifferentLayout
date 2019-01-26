package layout.multiple.reign.com.recycelrviewmultiplelayout;

/**
 * Created by Abhishek on 1/26/2019.
 */

public class Item {


    public  enum ItemType{

        One_Item,two_item;
    }


    public Item(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    private String name;
    private ItemType  type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
