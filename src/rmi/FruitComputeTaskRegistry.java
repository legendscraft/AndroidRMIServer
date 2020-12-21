package rmi;

import java.rmi.RemoteException;

public class FruitComputeTaskRegistry {
    public static void main(String[] args) throws RemoteException {
        FruitComputeEngine fruitComputeEngine = new FruitComputeEngine();
    }
}
