class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("An item is already selected. Insert coins to continue.");
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        machine.addBalance(amount);
        System.out.println("Inserted " + amount + " coins. Current balance: " + machine.getBalance());

        if (machine.getBalance() >= machine.getItemPrice()) {
            System.out.println("Sufficient balance. Dispensing item...");
            machine.setState(new DispensingState());
            machine.dispenseItem();
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Insert sufficient coins first.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now out of order.");
        machine.setState(new OutOfOrderState());
    }
}
