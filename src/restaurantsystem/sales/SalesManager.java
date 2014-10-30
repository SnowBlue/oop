/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.sales;

import java.util.*;
import restaurantsystem.sales.Report.*;
/**
 *
 * @author Kenny
 */
public class SalesManager {
    public SalesManager(){}
    private List<Order> CurrentOrders;
    public Order CreateOrder(int tableNum){
        Order newOrder = new Order();
        CurrentOrders.add(newOrder);
        return new Order();
    }
    public void ViewCurrentOrders(){
        for (Order order : CurrentOrders){
            System.out.print("Table: " + order.GetTableNumber() + ",Order: " + order.GetOrderId() + "\n");
        }
    }
    public void DeleteOrder(int orderId){
        for (Order order : CurrentOrders){
            if (order.GetOrderId() == orderId) {
                CurrentOrders.remove(order);
                System.out.print("Successfully removed.\n");
                return;
            }
        }
        System.out.print("Invalid order id\n");
    }
    public void CompleteOrder(int orderId){
        for (Order order : CurrentOrders){
            if (order.GetOrderId() == orderId) {
                Invoice invoice = order.GetInvoice();
                InvoicePrinter invoicePrinter = new InvoicePrinter();
                invoicePrinter.Print(invoice);
                StoreInvoice(invoice);
                return;
            }
        }
        System.out.print("Invalid order id");
    }
    public FullSalesReport CreateSalesReport(Date start, Date end, ReportPeriodType periodType){
        return new FullSalesReport();
    }
    private void StoreInvoice(Invoice invoice){}
    private List<Invoice> GetStoredInvoice(){ return new ArrayList<Invoice>(); }
    private List<Invoice> GetInvoiceByDate(Date start, Date end){
        List<Invoice> retVal = new ArrayList<Invoice>();
        for (Invoice invoice : GetStoredInvoice())
        {
            if (invoice.OrderCompletedTime.after(start) && invoice.OrderCompletedTime.before(end))
                retVal.add(invoice);
        }
        return retVal;
    }
}
