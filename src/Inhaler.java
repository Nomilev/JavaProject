public class Inhaler extends Medicine{

    //data members
    private int amountOfClick;
    //function
    @Override
    public String toString() {
        return super.toString()  + ", amountOfClick=" + amountOfClick ;
    }

    public int totalInventory() {
        return getQuantity()*amountOfClick;
    }

    //constructor
    public Inhaler() {

    }

    public Inhaler(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, TypeMedicine typeMedicine, int amountOfClick )throws InvalidEmailAddressException {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, typeMedicine);
        setAmountOfClick(amountOfClick );
    }
    //setters
    public void setAmountOfClick (int amountOfClick ) {
        this.amountOfClick  = amountOfClick ;
    }
    //getters
    public int getAmountOfClick () {
        return amountOfClick ;
    }
}
