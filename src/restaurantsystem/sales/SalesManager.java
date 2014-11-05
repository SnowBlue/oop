/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.sales;

import java.util.*;

import restaurantsystem.sales.Report.*;
import restaurantsystem.sales.report.FullSalesReport;
import restaurantsystem.sales.report.ReportPeriodType;
/**
 *
 * @author Kenny
 */

//NOTE TO DHRUV. 4 FUNCTIONS TO COMPLETE
public class SalesManager {
	private static int OrderNumberTracker = 1;
    public SalesManager(){
    	CurrentOrders = new ArrayList<Order>();
    }
    private List<Order> CurrentOrders;
    public Order CreateOrder(int tableNum){
        Order newOrder = new Order(OrderNumberTracker++);
        CurrentOrders.add(newOrder);
        EditOrder(newOrder.GetOrderId());
        return newOrder;
    }
    public void EditOrder(int orderId){
    	Order orderToEdit = GetOrderById(orderId);
    	ManageOrderAction action = GetMenuAction();
    	if (action == ManageOrderAction.Exit) return;
    	if (action == ManageOrderAction.ViewItems) ViewMenuItems(orderToEdit);
    	if (action == ManageOrderAction.AddItem) AddMenuItem(orderToEdit);
    	if (action == ManageOrderAction.RemoveItem) RemoveMenuItem(orderToEdit);
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
                Invoice invoice = order.GetInvoice(null);
                InvoicePrinter invoicePrinter = new InvoicePrinter();
                invoicePrinter.Print(invoice);
                StoreInvoice(invoice);
                return;
            }
        }
        System.out.print("Invalid order id");
    }
    //Dhruv
    public FullSalesReport CreateSalesReport(Date start, Date end, ReportPeriodType periodType){
        return new FullSalesReport();
    }
    //Dhruv
    private void StoreInvoice(Invoice invoice){}
    //Dhruv
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
	private Order GetOrderById(int orderId) {
		for (Order order : CurrentOrders){
            if (order.GetOrderId() == orderId) return order;
        }
        throw new Exception("Invalid order id");
	}
	private ManageOrderAction GetMenuAction(){
		int choice = 0;
		while (choice != 4){
			System.out.print("Select an action: \n" +
							"1. Add menu item\n"+
							"2. Remove menu item\n"+
							"3. View current menu items\n" +
							"4. Done\n");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice){
			case 1:
				return ManageOrderAction.AddItem;
			case 2:
				return ManageOrderAction.RemoveItem;
			case 3:
				return ManageOrderAction.ViewItems;
			case 4:
				return ManageOrderAction.Exit;
			}
		}
	}
	//Dhruv you want to do this too?
	private void RemoveMenuItem(Order order){
		//remove...
	}
	//Dhruv you want to do this too?
	private void AddMenuItem(Order order){
		Food selectedItem = new Food();
			//SelectMenuItem();
		
	}
	private void ViewMenuItems(Order order){
		for (LineItem lineItem : order.GetItems())
			lineItem.PrintItem();
	}
	enum ManageOrderAction{ AddItem, RemoveItem, ViewItems, Exit }
}
