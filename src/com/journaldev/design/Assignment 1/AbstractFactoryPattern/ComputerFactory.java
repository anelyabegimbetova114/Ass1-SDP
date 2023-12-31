package com.journaldev.design.AbstractFactoryPattern;
public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}