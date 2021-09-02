package com.company.creational;

// for creation of family of distinct yet related objects.
// follows single responsibility principle.
// follows open-closed principle.
// code can become more complicated since a lot of interfaces and classes have been introduced.
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        Manufacturer modernManufacturer = new Manufacturer(new ModernFurnitureFactory());
        Manufacturer victorianManufacturer= new Manufacturer(new VictorianFurnitureFactory());

        modernManufacturer.build();
        victorianManufacturer.build();

        modernManufacturer.testProducts();
        victorianManufacturer.testProducts();
    }
}

class Manufacturer {
    FurnitureFactory factory;
    private Chair chair;
    private Sofa sofa;

    public Manufacturer(FurnitureFactory factory) {
        this.factory = factory;
    }

    void build(){
        chair = factory.createChair();
        sofa = factory.createSofa();
    }

    void testProducts() {
        chair.sitOn();
        sofa.sleepOn();
    }
}
interface FurnitureFactory{
    Sofa createSofa();
    Chair createChair();
}

class VictorianFurnitureFactory implements FurnitureFactory{

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
}

class ModernFurnitureFactory implements FurnitureFactory{

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}
interface Chair {
    void sitOn();
}

class VictorianChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("You are now sitting on an Victorian chair");
    }
}

class ModernChair implements Chair{

    @Override
    public void sitOn() {
        System.out.println("You are now sitting on an Modern chai");
    }
}

interface Sofa{
    void sleepOn();
}

class VictorianSofa implements Sofa{

    @Override
    public void sleepOn() {
        System.out.println("You are sleeping on an Victorian Sofa");
    }
}

class ModernSofa implements Sofa{

    @Override
    public void sleepOn() {
        System.out.println("You are sleeping on a Modern sofa");
    }
}