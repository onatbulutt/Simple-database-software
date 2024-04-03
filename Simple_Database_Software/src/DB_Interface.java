public interface DB_Interface {

    public void addCustomer(Customer newCustomer);
    public void listItems(int ID);
    public Customer getNewCustomer(String Name, String Surname, int ID);
    public void addNewItem (Integer ID, String ItemName, String Date, float Price);
    public Float getTotalTradeofCustomer(int ID);
    public Float getTotalTrade();
    public void readFromFile(String path);
    public Customer search_Customer(int ID);

}
