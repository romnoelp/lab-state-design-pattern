![image](https://github.com/user-attachments/assets/68283a74-3bc6-48f3-9ab6-f880deac334a)


# Vending Machine State Management

## Problem Statement

A vending machine needs to manage different states, including **"Idle"**, **"ItemSelected"**, **"Dispensing"**, and **"OutOfOrder"**. Each state has specific rules and restrictions regarding allowed operations, and the vending machine has associated attributes like item inventory and balance.

## Requirements

### Idle State:
- Allow item selection.
- Disallow dispensing items and inserting coins.

### ItemSelected State:
- Allow inserting coins and dispensing items.
- Disallow item selection.

### Dispensing State:
- Allow no operations.
- Automatically transition back to the **"Idle"** state after dispensing is complete.

### OutOfOrder State:
- Disallow all operations.

## Current System

The system currently relies on conditional statements within the `VendingMachine` class to check the machine state and determine valid actions. This approach becomes cumbersome and error-prone as the number of states and their associated logic grows.

## Implementing the State Pattern

To improve code maintainability and flexibility, we will implement the **State Pattern**.

### Define VendingMachine States:
Create separate classes representing different machine states:
- `IdleState`
- `ItemSelectedState`
- `DispensingState`
- `OutOfOrderState`

### Implement State Interface:
Define an interface `VendingMachineState` with methods for common actions:
- `selectItem()`
- `insertCoin()`
- `dispenseItem()`
- `setOutOfOrder()`

### Implement State Behaviors:
Each concrete state class implements the `VendingMachineState` interface, providing specific behavior for its respective state.
- **IdleState**: Allows item selection.
- **ItemSelectedState**: Allows inserting coins and dispensing items.
- **DispensingState**: Allows no operations and transitions back to "Idle" after completion.
- **OutOfOrderState**: Disallows all operations.

### Update VendingMachine Class:
- Include attributes for item inventory and balance.
- Remove state-specific logic from the `VendingMachine` class.
- Introduce a reference to the current `VendingMachineState` object.
- Delegate actions like `selectItem()`, `insertCoin()`, `dispenseItem()`, and `setOutOfOrder()` to the current state object through its corresponding methods.
