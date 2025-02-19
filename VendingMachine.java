class VendingMachine {
    private VendingMachineState state;
    private int inventory;
    private int balance;
    private final int itemPrice = 10; // Example price

    public VendingMachine(int inventory) {
        this.inventory = inventory;
        this.balance = 0;
        this.state = new IdleState();
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void selectItem() {
        state.selectItem(this);
    }

    public void insertCoin(int amount) {
        state.insertCoin(this, amount);
    }

    public void dispenseItem() {
        state.dispenseItem(this);
    }

    public void setOutOfOrder() {
        state.setOutOfOrder(this);
    }

    public int getInventory() {
        return inventory;
    }

    public void reduceInventory() {
        if (inventory > 0) {
            inventory--;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public void resetBalance() {
        balance = 0;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}
