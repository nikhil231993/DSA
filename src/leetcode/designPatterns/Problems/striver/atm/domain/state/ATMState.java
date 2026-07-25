package leetcode.designPatterns.Problems.striver.atm.domain.state;

import leetcode.designPatterns.Problems.striver.atm.domain.ATM;
import leetcode.designPatterns.Problems.striver.atm.domain.TransactionType;
import leetcode.designPatterns.Problems.striver.atm.domain.exception.InvalidATMOperationException;

public interface ATMState {
    void insertCard(ATM atm, String cardId) throws InvalidATMOperationException;

    void ejectCard(ATM atm) throws InvalidATMOperationException;

    void enterPin(ATM atm, String pin) throws InvalidATMOperationException;

    void selectTransaction(ATM atm, TransactionType type) throws InvalidATMOperationException;

    void processTransaction(ATM atm, long amount) throws InvalidATMOperationException;

    void endSession(ATM atm) throws InvalidATMOperationException;

    ATMState next(ATM atm);
}