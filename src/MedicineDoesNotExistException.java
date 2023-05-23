public class MedicineDoesNotExistException extends Exception {

    public MedicineDoesNotExistException(String medicineExist) throws InterruptedException {
        super("\nErroe:: the '"+ medicineExist +"' medicine doesn't exist in the inventory");
        Thread.sleep(1000);
    }

}
