/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.customer;

import java.util.Date;
import restaurantsystem.GlobalTimer;

/**
 *
 * @author Kenny
 */
public class Membership {
    public Membership(){}
    private String Name;
    private DiscountType Type;
    private double DiscountAmount;
    private Date Start;
    private Date Expiry;
    public enum DiscountType {
        Absolute, Percentage, None
    }
    public double GetDiscount(double orderAmount){
        if (Expiry.before(GlobalTimer.GetCurrentTime())) return 0;
        if (Type == DiscountType.Absolute) return DiscountAmount;
        else if (Type == DiscountType.Percentage) return orderAmount * DiscountAmount;
        else return 0;
    }
}
