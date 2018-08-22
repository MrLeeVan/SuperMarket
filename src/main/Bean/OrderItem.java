package main.Bean;

import java.io.Serializable;

/**
 * @Author Leevan
 * @Date： 2018/8/17 11:46
 */

//子订单：单个商品
public class OrderItem implements Serializable {
    private int itemId;
    private Clothes clothes;
    private int shoppingNum;
    private float sum;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
//默认构造方法
    public OrderItem(){

    }
    public OrderItem(int itemId, Clothes clothes, int shoppingNum, float sum) {
        this.itemId = itemId;
        this.clothes = clothes;
        this.shoppingNum = shoppingNum;
        this.sum = sum;
    }
}
