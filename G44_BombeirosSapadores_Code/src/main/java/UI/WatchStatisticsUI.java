/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.WatchStatisticsController;

/**
 *
 * @author tiagopereira
 */
public class WatchStatisticsUI {
    private WatchStatisticsController wsc;
    
    public WatchStatisticsUI(){
        wsc.getOverallStatistics();
    }
}
