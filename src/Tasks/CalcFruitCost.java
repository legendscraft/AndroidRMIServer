package Tasks;

import models.Fruit;
import models.FruitModel;

public class CalcFruitCost {
    private int fruitCost(int id){
        FruitModel fruitModel = new FruitModel();
        Fruit fruit = fruitModel.findFruitById(id);
        return fruit.getPrice();
    }
}
