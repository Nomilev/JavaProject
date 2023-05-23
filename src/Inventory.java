import java.util.ArrayList;
public class Inventory {
      ArrayList<Medicine> medicinesArray = new ArrayList();

      //add medicines
      public void addMedicine(Medicine _medicine) throws MedicineAlreadyExistException, InterruptedException {
            for (Medicine medicine : medicinesArray)
                  if (medicine.getMedicineName().equals(_medicine.getMedicineName()))
                  {
                       throw new MedicineAlreadyExistException(_medicine);
                  }
            medicinesArray.add(_medicine);
      }

      //search Medicine By Name
      public Medicine searchMedicineByName(String _medicineName) throws MedicineDoesNotExistException, InterruptedException {
            Medicine medicineFound = null;
            boolean flag = false;
            for (Medicine medicine : medicinesArray) {
                  if (medicine.getMedicineName().equalsIgnoreCase(_medicineName)) {
                        medicineFound = medicine;
                        flag =true;
                  }
            }
            if(!flag)
                  throw new MedicineDoesNotExistException(_medicineName);
            return medicineFound;

      }

      //search Medicine By Type
      public ArrayList searchMedicineByType(Medicine.TypeMedicine _medicineType) {

            ArrayList<Medicine> medicineTypeArray = new ArrayList();
            for (Medicine medicine : medicinesArray) {
                  if (medicine.typeMedicine.equals(_medicineType)) {
                        medicineTypeArray.add(medicine);
                  }

            }
            return medicineTypeArray;
      }
      //get Medicines InStock
      public ArrayList medicineInStock() {
            ArrayList<Medicine> medicineInStockArray = new ArrayList();
            for (Medicine medicine : medicinesArray) {
                  if (medicine.inStock()) {
                        medicineInStockArray.add(medicine);
                  }

            }
            return medicineInStockArray;
      }
}

