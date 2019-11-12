package model;

public class Contacts {
    private String Name;
    private String Number;
    private int image;

    public Contacts(String name, String number, int image) {
        Name = name;
        Number = number;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
