/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.sales;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Kenny
 */
public class Invoice {
    public Invoice(){}
    public int OrderId;
    public Date OrderCompletedTime;
    public double ServiceCharge;
    public double GST;
    public double Discount;
    public double ItemTotal;
    public double Total;
    public List<LineItem> Items;
}
