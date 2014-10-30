/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.sales.Report;

import java.util.Date;

/**
 *
 * @author Kenny
 */
public class PeriodReport {
    public PeriodReport(){}
    public ReportPeriodType Type;
    public Date Start;
    public Date End;
    public int NumOrders;
    public double TotalItemRevenue;
    public double TotalDiscounts;
    public double NetRevenue;
    
}
