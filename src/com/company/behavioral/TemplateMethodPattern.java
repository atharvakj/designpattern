package com.company.behavioral;
// To be used when you want create a template for some kind of
// algorithm and want to delegate some of the specific steps to the
// subclass.
// might violate Liskov-Substitution principle.
public class TemplateMethodPattern {
    public static void main(String[] args) {
        new ModernRealEstateDeveloper().developHouse();
        new SpanishRealEstateDeveloper().developHouse();
    }
}

abstract class RealEstateDeveloper{

    // develop house is the template method.
     void developHouse(){
         addWalls();
         addRoof();
         addParking();
     }

    private void addParking() {
        System.out.println("Parking has been added");
    }

    protected abstract void addRoof();

    protected abstract void addWalls();
}

class SpanishRealEstateDeveloper extends RealEstateDeveloper{

    @Override
    protected void addRoof() {
        System.out.println("Spanish Roof has been added");
    }

    @Override
    protected void addWalls() {
        System.out.println("Walls have been added");
    }
}

class ModernRealEstateDeveloper extends RealEstateDeveloper{

    @Override
    protected void addRoof() {
        System.out.println("Modern roof has been added");
    }

    @Override
    protected void addWalls() {
        System.out.println("Modern walls have been added");
    }
}
