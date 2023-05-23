public abstract class Medicine {

    //data members
    private String medicineName;
    private String companyName;
    private String companyEmail;
    private double price;
    private int quantity;
    private int expirationYear;
    TypeMedicine typeMedicine;
    public enum TypeMedicine{
        PILLS,
        SYRUP,
        INHALER
    }
    //functions
    //public abstract String toString();
    //public abstract void totalInventory();


    @Override
    public String toString() {
        return  "medicineName='" + medicineName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expirationYear=" + expirationYear +
                ", typeMedicine=" + typeMedicine ;
    }
    public abstract int totalInventory();


    public boolean inStock(){
        if(quantity>0)
            return true;
         else return false;
    }

    //constructor
    public Medicine(){

    }
    public Medicine(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, TypeMedicine typeMedicine) throws InvalidEmailAddressException {
        setMedicineName(medicineName);
        setCompanyName(companyName);
        setCompanyEmail(companyEmail);
        setPrice(price);
        setQuantity(quantity);
        setExpirationYear(expirationYear);
        setTypeMedicine(typeMedicine);
    }

    //setters

    public void setMedicineName(String medicineName) {
        medicineName=medicineName.toUpperCase();
        this.medicineName = medicineName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    //Validation companyEmail
    public void setCompanyEmail(String companyEmail) throws InvalidEmailAddressException{
        boolean flag = true;

        if(companyEmail.contains("@")) {
            if (companyEmail.charAt(0) == '@' || companyEmail.endsWith("@")) {
                flag = false;
                throw new InvalidEmailAddressException(companyEmail,"The @ cannot appear first or last");
                //System.out.println("The @ cannot appear first or last");

            }
            if (flag) {
                if (companyEmail.lastIndexOf("@") < companyEmail.lastIndexOf("."))
                    this.companyEmail = companyEmail;
                else
                    throw new InvalidEmailAddressException(companyEmail,"missing . after @");
                    //System.out.println("missing . after @");
            }
        }
        else
        throw new InvalidEmailAddressException(companyEmail,"missing the @ character");
        //else System.out.println("missing the @ character");
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public void setTypeMedicine(TypeMedicine typeMedicine) {
        this.typeMedicine = typeMedicine;
    }

    //getters

    public String getMedicineName() {
        return medicineName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public TypeMedicine getTypeMedicine() {
        return typeMedicine;
    }
}
