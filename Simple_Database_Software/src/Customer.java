public class Customer {
    private String Name;
    private String Surname;
    private int ID;
    private Item Link;

    public Customer() {
        this.Link = null;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setLink(Item link) {
        Link = link;
    }

    public Item getLink() {
        return Link;
    }

    @Override
    public String toString() {
        String retstr = "Name " + Name;
        retstr = retstr + " Surname " + Surname;
        retstr = retstr + " ID " + ID;
        return retstr;
    }


}
