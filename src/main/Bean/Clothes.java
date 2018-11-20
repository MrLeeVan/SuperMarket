package main.Bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Leevan
 * @Date： 2018/8/17 11:44
 */
@Data
public class Clothes implements Serializable {
    private String id;   //商品编号
    private String brand;  // 品牌
    private String style;  //款式
    private String color;   //颜色
    private String size;    //尺码
    private int num;     //库存
    private float price;  //单价
    private String description;  //商品描述
/*

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
*/

    //默认构造方法
    public Clothes(){

}

    public Clothes(String id, String brand, String style, String color, String size, int num, float price, String description) {
        this.id = id;
        this.brand = brand;
        this.style = style;
        this.color = color;
        this.size = size;
        this.num = num;
        this.price = price;
        this.description = description;
    }
}
