package leetcode.designPatterns.structural.adapter.example2Shrayansh;

import leetcode.designPatterns.structural.adapter.example2Shrayansh.Adaptee.WeightMachineForBabies;
import leetcode.designPatterns.structural.adapter.example2Shrayansh.Adapter.WeightMachineAdapter;
import leetcode.designPatterns.structural.adapter.example2Shrayansh.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}

