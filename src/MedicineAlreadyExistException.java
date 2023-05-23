public class MedicineAlreadyExistException extends Exception {

    public MedicineAlreadyExistException(Medicine medicineExist) throws InterruptedException {
        super("\nErroe:: the medicine '"+ medicineExist.getMedicineName() +"' already exist in the inventory");
        Thread.sleep(2000);
    }
}
