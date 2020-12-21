package rmi;

import com.google.gson.Gson;

import in.mrasif.rmiclientdemo.RMIInterface;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;
import models.Fruit;
import models.FruitModel;

import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

class FruitComputeEngine extends UnicastRemoteObject implements RMIInterface {

    public FruitComputeEngine() throws RemoteException {
        super();
        try {
            CallHandler callHandler = new CallHandler();
            callHandler.registerGlobal(RMIInterface.class, this);
            Server server = new Server();
            server.bind(AppConfig.SERVER_PORT, callHandler);
            server.addServerListener(new IServerListener() {

                @Override
                public void clientDisconnected(Socket socket) {
                    System.out.println("Client Disconnected: " + socket.getInetAddress());
                }

                @Override
                public void clientConnected(Socket socket) {
                    System.out.println("Client Connected: " + socket.getInetAddress());
                }
            });
            System.out.println("Server Listening");
        } catch (LipeRMIException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String helloTo(String name){
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    @Override
    public String addFruit(Integer fruitID, Integer fruitPrice){
        return "Fruit "+fruitID+" with Price "+fruitPrice+" has been added!";
    }

    @Override
    public String getAllFruits(){
        FruitModel fruitModel = new FruitModel();
        List<Fruit> fruits = fruitModel.findAllFruits();
        System.out.println("Found "+fruits.size()+ " Fruits");
        System.out.println("================================================");

        //
        Gson gson = new Gson();
        String json = gson.toJson(fruits);
        System.out.println(json);
        return json;
    }
}