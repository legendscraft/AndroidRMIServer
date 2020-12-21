package Tasks;

import models.FruitModel;

public class AddFruitPrice {
    private boolean AddFruitPrice(int newPrice, int id){
        FruitModel fruitModel = new FruitModel();
        return fruitModel.updateFruitPrice(newPrice,id);
    }
}
