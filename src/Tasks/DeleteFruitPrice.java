package Tasks;

import models.FruitModel;

public class DeleteFruitPrice {
    private boolean deleteFruitPrice(int id){
        FruitModel fruitModel = new FruitModel();
        return fruitModel.updateFruitPrice(0,id);
    }
}
