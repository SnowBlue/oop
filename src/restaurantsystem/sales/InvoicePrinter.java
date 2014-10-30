/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.sales;

import java.util.*;
/**
 *
 * @author Kenny
 */
public class InvoicePrinter {
    public InvoicePrinter(){}
    public void Print(Invoice summary){
        PrintLine();
        System.out.print("Order id: " + summary.OrderId);
        PrintLine();
        PrintLineItems(summary.Items);
        PrintLine();
        System.out.print("Item total: " + summary.ItemTotal);
        System.out.print("\nSvc charge(10%): +" + summary.ServiceCharge);
        System.out.print("\nDiscount: -" + summary.Discount);
        System.out.print("\nGST: " + summary.GST);
        PrintLine();
        System.out.print("Total: " + summary.Total);
        PrintLine();
    }
    
    private void PrintLine(){
        System.out.print("-------------------------------\n");
    }
    private void PrintLineItems(List<LineItem> items){
        for (LineItem lineItem : items){
            System.out.print(lineItem.GetName() + " x" + lineItem.GetQuantity() + ": " + lineItem.GetTotalPrice());
        }
    }
}
