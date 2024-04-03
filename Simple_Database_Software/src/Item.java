public class Item {
    String ItemName;
    String Date;
    float Price;
    Item Link;

    public Item() {
        this.Link = null;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public void setLink(Item link) {
        Link = link;
    }

    public float getPrice() {
        return Price;
    }

    public Item getLink() {
        return Link;
    }

    public String getDate() {
        return Date;
    }

    public String getItemName() {
        return ItemName;
    }
}