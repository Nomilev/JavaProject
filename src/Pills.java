public class Pills extends Medicine {

    //data member
     private int numOfPillsInBox;
     //functions


    @Override
    public String toString() {
        return super.toString()  + ", numOfPillsInBox=" + numOfPillsInBox ;
    }

    @Override
    public int totalInventory() {
        return getQuantity()*numOfPillsInBox;
    }

    //constructor
    public Pills() {
    }

    public Pills(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, TypeMedicine typeMedicine, int numOfPillsInBox)throws InvalidEmailAddressException {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, typeMedicine);
        setNumOfPillsInBox(numOfPillsInBox);
    }

    //setter
    public void setNumOfPillsInBox(int numOfPillsInBox) {
        this.numOfPillsInBox = numOfPillsInBox;
    }
    //getter
    public int getNumOfPillsInBox() {
        return numOfPillsInBox;
    }
}
