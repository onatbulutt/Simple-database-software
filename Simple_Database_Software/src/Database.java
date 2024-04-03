import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Database implements DB_Interface {

    private final Customer[] customers = new Customer[100];
    private int index=0;

    @Override
    public void addCustomer(Customer newCustomer)
    {
        // add desired customer to customers array and increase size of the array
        customers[index] = newCustomer;
        index++;
    }

    @Override
    public void listItems(int ID)
    {
        boolean customerFound = false;
        for (Customer customer : customers)
        {
            if (customer != null && customer.getID() == ID) //situation that the customer is not empty and has the desired id
            {
                // print customer information
                customerFound = true;
                System.out.println(customer.getName() + " " + customer.getSurname() + " " + customer.getID() + " Item List :");
                // print from customer's first to last product
                Item currentItem = customer.getLink();
                while (currentItem != null)
                {
                    System.out.println(currentItem.getItemName() + " " + currentItem.getDate() + " " + currentItem.getPrice());
                    currentItem = currentItem.getLink();
                }
                break;
            }
        }
        if (!customerFound) //if customer is not available, send massage
        {
            System.out.println("Customer not found.");
        }
    }

    @Override
    public Customer getNewCustomer(String Name, String Surname, int ID)
    {
        //create new Customer object and set desired Customer parameters to the object and return it
        Customer customer = new Customer();
        customer.setName(Name);
        customer.setSurname(Surname);
        customer.setID(ID);
        return customer;
    }

    @Override
    public void addNewItem(Integer ID, String ItemName, String Date, float Price)
    {
        boolean customerFound = false;
        for (Customer customer : customers)
        {
            if (customer != null && customer.getID() == ID) //situation that the customer is not empty and has the desired id
            {
                customerFound = true;
                // create new Item object and set desired Item parameters in the object
                Item currentItem = new Item();
                currentItem.setItemName(ItemName);
                currentItem.setDate(Date);
                currentItem.setPrice(Price);
                if (customer.getLink() == null) //if customer have not any item,add created item to the customer
                {
                    customer.setLink(currentItem);
                }
                else if (customer.getLink() != null) //if customer have any item, add created item to the beginning
                {
                    currentItem.setLink(customer.getLink());
                    customer.setLink(currentItem);
                }
            }
        }
        if (!customerFound) //if customer is not available, send massage
        {
            System.out.println("Customer not found.");
        }
    }

    @Override
    public Float getTotalTradeofCustomer(int ID)
    {
        float totalPrice = 0;
        boolean customerFound = false;
        for (Customer customer : customers)
        {
            if (customer != null && customer.getID() == ID) //situation that the customer is not empty and has the desired id
            {
                customerFound = true;
                // scan from the customer's first to the last item and collect their prices
                Item currentItem = customer.getLink();
                while (currentItem != null)
                {
                    totalPrice += currentItem.getPrice();
                    currentItem = currentItem.getLink();
                }
            }
        }
        if (!customerFound) //if customer is not available, send massage
        {
            System.out.println("Customer not found.");
        }
        return totalPrice;
    }

    @Override
    public Float getTotalTrade()
    {
        float totalPrice = 0;
        for (Customer customer : customers)
        {
            if (customer != null) //situation that the customer is not empty
            {
                //scan all customer's items and collect their prices
                Item currentItem = customer.getLink();
                while (currentItem != null)
                {
                    totalPrice += currentItem.getPrice();
                    currentItem = currentItem.getLink();
                }
            }
        }
        return totalPrice;
    }

    @Override
    public void readFromFile(String path)
    {
        // create bufferedreader and make the file ready for reading
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path)))
        {
            String line;
            String name;
            String surname;
            int id;
            int id2;
            String itemname;
            String date;
            float price;
            while ((line = bufferedReader.readLine()) != null) //read until all the lines to be read are finished
            {
                String[] data1 = line.split("\\s+"); //Create an array containing the fragments obtained by splitting a text named line over whitespace characters
                if (Character.isLetter(data1[0].charAt(0))) // situation that the line starts with a letter
                {
                    // the array has 3 data according to the read file.
                    name = data1[0];
                    surname = data1[1];
                    id = Integer.parseInt(data1[2]);
                    // create new Customer object and set read parameters to the object
                    Customer customer = new Customer();
                    customer.setID(id);
                    customer.setName(name);
                    customer.setSurname(surname);
                    // add the object to the customers array
                    customers[index] = customer;
                    index++;
                }
                if (Character.isDigit(data1[0].charAt(0))) // situation that the line starts with a number
                {
                    // the array has 4 data according to the read file.
                    id2 = Integer.parseInt(data1[0]);
                    itemname = data1[1];
                    date = data1[2];
                    price = Float.parseFloat(data1[3]);
                    // create new Item object and set read parameters to the object
                    Item currentitem = new Item();
                    currentitem.setItemName(itemname);
                    currentitem.setDate(date);
                    currentitem.setPrice(price);
                    for (Customer customer : customers)
                    {
                        if (customer != null && customer.getID() == id2) //situation that the customer is not empty and has the read id
                        {
                            if (customer.getLink() == null) //if customer have not any item,add created item to the customer
                            {
                                customer.setLink(currentitem);
                            }
                            else if (customer.getLink() != null) //if customer have any item, add created item to the beginning
                            {
                                currentitem.setLink(customer.getLink());
                                customer.setLink(currentitem);
                            }
                        }
                    }
                }
            }
            System.out.println("The content of file has been read");
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        } catch (IOException e)
        {
            System.out.println("Error");
        }
    }
    @Override
    public Customer search_Customer(int ID)
    {
        boolean customerFound = false;
        for (Customer customer : customers)
        {
            if (customer != null && customer.getID() == ID) //situation that the customer is not empty and has the desired id
            {
                customerFound = true;
                // return found customer
                return customer;
            }
        }
        if (!customerFound) //if customer is not available, send massage
        {
            System.out.println("Customer not found.");
        }
        return null;
    }

}
