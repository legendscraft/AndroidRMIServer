package Tasks;

import models.FruitModel;

public class UpdateFruitPrice {
    private boolean updateFruitPrice(int newPrice, int id){
        FruitModel fruitModel = new FruitModel();
        return fruitModel.updateFruitPrice(newPrice,id);
    }
}
