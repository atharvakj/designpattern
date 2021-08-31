package com.company.creational;

import java.util.Arrays;
import java.util.List;

public class BuilderPattern {

    public static void main(String[] args) {
        Director director = new Director();
        SpaceShip lightFastSpaceShip = director.createLightFastSpaceShip();
        System.out.println(lightFastSpaceShip);
    }
}

class SpaceShip {
    String name;
    Integer power;
    Long timeVelocity;
    List<Integer> jumpVector;

    @Override
    public String toString() {
        return name + " " + power + " " + timeVelocity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setTimeVelocity(Long timeVelocity) {
        this.timeVelocity = timeVelocity;
    }

    public void setJumpVector(List<Integer> jumpVector) {
        this.jumpVector = jumpVector;
    }
}

interface Builder {
    void setSpaceShipName(String name);

    void setEnginePower(Integer power);

    void setTimeVelocity(Long timeVelocity);

    void setJumpVector(List<Integer> jumpVector);

    SpaceShip getSpaceShip();
}

class SpaceShipBuilder implements Builder {
    private SpaceShip ship;

    SpaceShipBuilder() {
        this.ship = new SpaceShip();
    }

    @Override
    public void setSpaceShipName(String name) {
        ship.setName(name);
    }

    @Override
    public void setEnginePower(Integer power) {
        ship.setPower(power);
    }

    @Override
    public void setTimeVelocity(Long timeVelocity) {
        ship.setTimeVelocity(timeVelocity);
    }

    @Override
    public void setJumpVector(List<Integer> jumpVector) {
        ship.setJumpVector(jumpVector);
    }

    @Override
    public SpaceShip getSpaceShip() {
        SpaceShip ship = this.ship;
        this.ship = new SpaceShip();
        return ship;
    }
}

class Director {

    SpaceShip createLightFastSpaceShip() {
        SpaceShipBuilder spaceShipBuilder = new SpaceShipBuilder();
        spaceShipBuilder.setSpaceShipName("Fast");
        spaceShipBuilder.setEnginePower(100);
        spaceShipBuilder.setTimeVelocity(33L);
        spaceShipBuilder.setJumpVector(Arrays.asList(33, 4, 3, 2));
        return spaceShipBuilder.getSpaceShip();
    }
}