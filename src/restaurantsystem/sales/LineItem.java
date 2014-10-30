/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.sales;

/**
 *
 * @author Kenny
 */
public class LineItem {
    public LineItem(){}
    private int Quantity;
    private MenuObject Item;
    public String GetName(){
        return Item.Name;
    }
    public int GetQuantity(){
        return Quantity;
    }
    public double GetTotalPrice(){
        return Quantity * Item.GetPrice();
    }
}
