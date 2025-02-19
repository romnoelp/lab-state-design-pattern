class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Dispensing in progress. Please wait.");
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Cannot insert coins while dispensing.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing item...");
        machine.reduceInventory();
        machine.resetBalance();

        if (machine.getInventory() > 0) {
            machine.setState(new IdleState());
            System.out.println("Ready for next transaction.");
        } else {
            machine.setState(new OutOfOrderState());
            System.out.println("No more items available. Machine is now out of order.");
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now out of order.");
        machine.setState(new OutOfOrderState());
    }
}
