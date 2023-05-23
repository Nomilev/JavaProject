public class Syrup extends Medicine {
    //data member
    private int bottleContent;


    //functions
    @Override
    public String toString() {
        return super.toString()  + ", bottleContent=" + bottleContent ;
    }


    public int totalInventory() {

        return getQuantity()*bottleContent;
    }

    //constructor
    public Syrup() {
    }

    public Syrup(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, TypeMedicine typeMedicine, int bottleContent)throws InvalidEmailAddressException {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, typeMedicine);
        setBottleContent(bottleContent);
    }

    //setter
    public void setBottleContent(int bottleContent) {
        this.bottleContent = bottleContent;
    }
    //getter
    public int getBottleContent() {
        return bottleContent;
    }
}

