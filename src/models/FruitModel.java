package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FruitModel {

    public List<Fruit> findAllFruits(){
        List<Fruit> fruits = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = ConnectToDB.getConnection()
                    .prepareStatement("SELECT * FROM fruits");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Fruit fruit = new Fruit(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("price"));
//                fruit.setId(resultSet.getInt("id"));
//                fruit.setName(resultSet.getString("name"));
//                fruit.setPrice(resultSet.getInt("price"));
                fruits.add(fruit);
            }
        }catch (Exception e){
            fruits = null;
        }
        return fruits;
    }

    public Fruit findFruitById(int id){
        Fruit fruit = null;
        try{
            PreparedStatement preparedStatement = ConnectToDB.getConnection()
                    .prepareStatement("SELECT * FROM fruits WHERE id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                fruit = new Fruit(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("price"));
//                fruit.setId(resultSet.getInt("id"));
//                fruit.setName(resultSet.getString("name"));
//                fruit.setPrice(resultSet.getInt("price"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return fruit;
    }

    public boolean updateFruitPrice(int newPrice, int id){
        boolean result = true;
        try{
            PreparedStatement preparedStatement = ConnectToDB.getConnection()
                    .prepareStatement("UPDATE fruits SET price = ? WHERE id = ?");
            preparedStatement.setInt(1,newPrice);
            preparedStatement.setInt(2,id);
            result = preparedStatement.executeUpdate() > 0;

        }catch (Exception e){
            e.printStackTrace();
            result = true;
        }
        return result;
    }
}
