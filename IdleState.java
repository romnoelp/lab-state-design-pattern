class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        if (machine.getInventory() > 0) {
            System.out.println("Item selected. Please insert coins.");
            machine.setState(new ItemSelectedState());
        } else {
            System.out.println("No items left! Switching to OutOfOrder state.");
            machine.setState(new OutOfOrderState());
        }
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("You must select an item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("No item selected.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now out of order.");
        machine.setState(new OutOfOrderState());
    }
}
