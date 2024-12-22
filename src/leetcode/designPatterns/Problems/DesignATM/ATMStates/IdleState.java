package leetcode.designPatterns.Problems.DesignATM.ATMStates;

import leetcode.designPatterns.Problems.DesignATM.ATM;
import leetcode.designPatterns.Problems.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
