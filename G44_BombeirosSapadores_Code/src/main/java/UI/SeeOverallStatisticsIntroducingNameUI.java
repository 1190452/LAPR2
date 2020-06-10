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
public class SeeOverallStatisticsIntroducingNameUI {
    private WatchStatisticsUI ws;
    private WatchStatisticsController wsc;
    public void associarParentUI(WatchStatisticsUI ws) {
        this.ws = ws;
        wsc = this.ws.getController();
    }
    
}
