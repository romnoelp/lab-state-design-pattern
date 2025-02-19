public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(2);

//      Normal purchase
        machine.selectItem();
        machine.insertCoin(5);
        machine.insertCoin(5);
        machine.dispenseItem();

//      Another set of purchase
        machine.selectItem();
        machine.insertCoin(10);
        machine.dispenseItem();

//      Trying to purchse when inventory is empty
        machine.selectItem();
        machine.insertCoin(10);
        machine.dispenseItem();

//      Out of order
        machine.setOutOfOrder();
        machine.selectItem();
        machine.insertCoin(10);
        machine.dispenseItem();
    }
}
