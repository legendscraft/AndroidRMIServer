package com.example.mysecondapp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import models.Fruit;

public interface RMIInterface extends Remote {
    public String helloTo(String name) throws RemoteException;

    public String addFruit(Integer fruitID,Integer fruitPrice) throws RemoteException;

    public String getAllFruits() throws RemoteException;

    public String getAllFruitsWithoutPrice() throws RemoteException;

    public String getAllFruitsWithPrice() throws RemoteException;

    public boolean updateFruitPrice(int price,int id) throws RemoteException;

    public boolean addFruitPrice(int price,int id) throws RemoteException;

    public boolean deleteFruitPrice(int id) throws RemoteException;
}
