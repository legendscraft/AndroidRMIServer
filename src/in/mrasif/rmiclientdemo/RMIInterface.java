package in.mrasif.rmiclientdemo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import models.Fruit;

public interface RMIInterface extends Remote {
    public String helloTo(String name) throws RemoteException;

    public String addFruit(Integer fruitID,Integer fruitPrice) throws RemoteException;

    public String getAllFruits() throws RemoteException;
}
