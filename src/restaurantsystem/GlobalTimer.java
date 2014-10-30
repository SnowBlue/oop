/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.time.Instant;
import java.util.Date;
/**
 *
 * @author Kenny
 */
public class GlobalTimer {
    public GlobalTimer(){}
    public static Date GetCurrentTime(){ return Date.from(Instant.EPOCH);}
}
