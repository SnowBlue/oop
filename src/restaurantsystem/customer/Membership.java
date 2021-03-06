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
    private Date Start;
    private Date Expiry;
    public enum DiscountType {
        Basic, Regular, VIP
    }
    private double GetDiscountPercentage(DiscountType discountType){
    	switch (discountType){
    	case Basic:
    		return 0.1;
    	case Regular:
    		return 0.2;
    	case VIP:
    		return 0.3;
    	}
    	return 0;
    	
    }
    public double GetDiscount(double orderAmount){
        if (Expiry.before(GlobalTimer.GetCurrentTime())) return 0;
        return GetDiscountPercentage(Type) * orderAmount;
    }
}
