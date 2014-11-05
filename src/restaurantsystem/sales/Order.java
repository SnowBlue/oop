/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.sales;

import java.util.*;
import restaurantsystem.customer.*;

/**
 *
 * @author Kenny
 */
public class Order {
    public Order(int orderId){
    	this.OrderId = orderId;
        Items = new ArrayList<LineItem>();
    }
    private int OrderId;
    private Table OrderTable;
    private List<LineItem> Items;
    private double ServiceChargeRate = 0.1;
    private double GSTRate = 0.07;
    private Date StartTime;
    public void AddItem(LineItem item){Items.add(item);}
    public int GetOrderId(){return OrderId;}
    public Invoice GetInvoice(Membership membership){
        double itemTotal = CalculateItemTotal();
        double serviceCharge = GetServiceCharge(itemTotal);
        double total = itemTotal + serviceCharge;
        double discount = GetDiscount(total, membership);
        total -= discount;
        double gst = GetGST(total);
        Invoice summary = new Invoice();
        summary.GST = gst;
        summary.Discount = discount;
        summary.ItemTotal = itemTotal;
        summary.Items = Items;
        summary.ServiceCharge = serviceCharge;
        summary.Total = total;
        summary.OrderId = OrderId;
        summary.OrderCompletedTime = new Date();
        return summary;
    }
    public int GetTableNumber(){ return OrderTable.Id;}
    public List<LineItem> GetItems(){ return Items; }
    private double GetOrderTotal(Membership membership){
        double itemTotal = CalculateItemTotal();
        double serviceCharge = GetServiceCharge(itemTotal);
        double total = itemTotal + serviceCharge;
        double discount = GetDiscount(total, membership);
        total -= discount;
        double gst = GetGST(total);
        return total;
    }
    private double GetServiceCharge(double total){
        return total * ServiceChargeRate;
    }
    private double GetGST(double total){
        return total * GSTRate;
    }
    private double GetDiscount(double itemTotal, Membership membership){
    	if (membership == null) return 0;
        return membership.GetDiscount(itemTotal);
    }
    private double CalculateItemTotal(){
        double total = 0;
        for (LineItem item : Items) total += item.GetTotalPrice();
        return total;
    }
}
