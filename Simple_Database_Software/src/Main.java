public class Main {
    public static void main(String[] args) {
        Database MyDataBase = new Database();
        Customer DummyCustomer = new Customer();
        MyDataBase.readFromFile("C:\\Users\\onatb\\OneDrive\\Masaüstü\\MyData.txt"); // You can change the path of the text file.
        Float exps= MyDataBase.getTotalTradeofCustomer(13456);
        System.out.println(MyDataBase.search_Customer(13456)+" Total Expense : "+exps);
        System.out.println("The Total Trade : "+MyDataBase.getTotalTrade());
        MyDataBase.listItems(13456);
        Customer newc = new Customer();
        newc= MyDataBase.getNewCustomer("Ali","Veli",4950); // Create new costumer in database
        MyDataBase.addCustomer(newc);
        MyDataBase.addNewItem(4950,"Karburator","Monday",145.8f); // Add new item for existed customer.
        MyDataBase.addNewItem(4950,"Laptop","Tuesday",2340); // Add new item for existed customer.
        System.out.println("The total trade : "+MyDataBase.getTotalTrade());
        MyDataBase.listItems(4950);

    }
}