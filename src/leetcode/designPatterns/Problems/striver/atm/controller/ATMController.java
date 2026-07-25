package leetcode.designPatterns.Problems.striver.atm.controller;

import leetcode.designPatterns.Problems.striver.atm.domain.CashDrawer;
import leetcode.designPatterns.Problems.striver.atm.service.ATMService;

public class ATMController {
    private ATMService atmService;

    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    public void takeOffline(String atmId) {
        atmService.takeOffline(atmId);
    }

    public void bringOnline(String atmId) {
        atmService.bringOnline(atmId);
    }

    public CashDrawer auditCash(String atmId) {
        return atmService.auditCash(atmId);
    }
}
