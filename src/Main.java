import java.util.ArrayList;

public class Main {
    static Inventory  medicineInventory = new Inventory();
    public static void main(String[] args)  {

        //define inventory

        ArrayList<Medicine> medicineType;
        ArrayList<Medicine> medicineInStock;
        boolean flag = false;


        // create 3 medicines of each types
        try {
            Pills pills1 = new Pills("Norofen", "Rafa", "rafa.medicines@rafa.co.il", 4.5, 0,
                    2027, Medicine.TypeMedicine.PILLS, 40);
            Pills pills2 = new Pills("Advil", "Teva", "teva@gmail.com", 28, 50,
                    2023, Medicine.TypeMedicine.PILLS, 220);
            Pills pills3 = new Pills("Coldex", "Pfizer", "Pfizer@gmail.com", 35,
                    100, 2025, Medicine.TypeMedicine.PILLS, 30);

            Syrup syrup1 = new Syrup("Promethazine", "CTS", "CTS@cts.co.il", 12.5, 50,
                    2028, Medicine.TypeMedicine.SYRUP, 110);
            Syrup syrup2 = new Syrup("Herbalis", "floris", "floris@org.co.il", 55, 15,
                    2030, Medicine.TypeMedicine.SYRUP, 150);
            Syrup syrup3 = new Syrup("FERRIPEL-3", "Dexcel", "info@dexcel.com", 23, 200,
                    2029, Medicine.TypeMedicine.SYRUP, 110);

            Inhaler inhaler1 = new Inhaler("Symbicort", "Mediline", "webmaster@mediline.co.il", 38.99, 1,
                    2022, Medicine.TypeMedicine.INHALER, 10);
            Inhaler inhaler2 = new Inhaler("Ventolin", "Novo Nordisk", "novoNordisk@novo.co.il", 66, 9,
                    2021, Medicine.TypeMedicine.INHALER, 6);
            Inhaler inhaler3 = new Inhaler("Atrovent", "MSD", "msd123@msd.com", 22.99, 10,
                    2032, Medicine.TypeMedicine.INHALER, 2);

        //Adding new medicines to the inventory

            System.out.println("----Adding new medicines to the inventory----");

            medicineInventory.addMedicine(pills1);
            medicineInventory.addMedicine(pills2);
            medicineInventory.addMedicine(pills3);

            medicineInventory.addMedicine(syrup1);
            medicineInventory.addMedicine(syrup2);
            medicineInventory.addMedicine(syrup3);

            medicineInventory.addMedicine(inhaler1);
            medicineInventory.addMedicine(inhaler2);
            medicineInventory.addMedicine(inhaler3);


        } catch (MedicineAlreadyExistException |InvalidEmailAddressException  e) {
            flag = true;
            e.printStackTrace();
        } catch (Exception e) {
            flag = true;
            e.printStackTrace();
            System.out.println("some error occurred while adding a medicine to inventory");
        }
        if(!flag)
            System.out.println("The medicines were added successfully\n");
        System.out.println();

        // Adding an existing medicine to inventory
        System.out.println("----Adding an existing medicine to inventory----");
        try {
            Inhaler inhaler4 = new Inhaler("Symbicort", "Mediline", "webmaster@mediline.co.il", 38.99, 1,
                    2022, Medicine.TypeMedicine.INHALER, 10);
            medicineInventory.addMedicine(inhaler4);
        } catch (MedicineAlreadyExistException e) {
            e.printStackTrace();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some error occurred while adding a medicine to inventory");
        }
        //Search for an existing medicine by name
        System.out.println("----Search for an existing medicine by name----");
        searchByNameMain("advil");

        //Search for a non-existing medicine by name
        System.out.println("----Search for a non-existing medicine by name----");
        searchByNameMain("akamol");

        //search medicine by type
        //syrup
        medicineType = medicineInventory.searchMedicineByType(Medicine.TypeMedicine.SYRUP);
        System.out.println(medicineType.size() + " syrup type medicines were found in the search:");
        System.out.println("------------------------------------------------");
        printMain(medicineType);
        //pills
        medicineType = medicineInventory.searchMedicineByType(Medicine.TypeMedicine.PILLS);
        System.out.println( medicineType.size() + " pills type medicines were found in the search:");
        System.out.println("------------------------------------------------");
        printMain(medicineType);
        //inhaler
        medicineType = medicineInventory.searchMedicineByType(Medicine.TypeMedicine.INHALER);
        System.out.println(medicineType.size() + " inhaler type medicines were found in the search:");
        System.out.println("------------------------------------------------");
        printMain(medicineType);

        //medicine in stock
        System.out.println();
        medicineInStock = medicineInventory.medicineInStock();
        System.out.println("----"+medicineInStock.size() + " medicines in stock----");
        printMain(medicineInStock);

        //adding a medicine with an incorrect e-mail
       try{
           System.out.println();
           System.out.println("----Adding a medicine with an incorrect e-mail----");
           Pills pills5 = new Pills("akamol", "Rafa", "akamolr@afacoil", 4.5, 0,
                2027, Medicine.TypeMedicine.PILLS, 40);
        }catch (InvalidEmailAddressException e) {
           e.printStackTrace();

       }
    }

    //searching medicine by name
    public static void searchByNameMain(String nameMedicine){
        Medicine medicine;
        try {
            medicine = medicineInventory.searchMedicineByName(nameMedicine);
            System.out.println("Medicine name:   " +  medicine.getMedicineName());
            System.out.println("Total inventory: "+medicine.totalInventory()+'\n');
        } catch (MedicineDoesNotExistException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some error occurred while searching for a non-existing medicine\n");
        }
    }

    public static void printMain(ArrayList<Medicine> arr){
        for (Medicine stock : arr) {
            System.out.println(stock.toString());
        }
        System.out.println();
    }


}
