package com.company.creational;

import java.util.Arrays;
import java.util.List;

public class BlochBuilderPattern {
    public static void main(String[] args) {
        System.out.println(new SubmarineDirector().createLightFastSpaceShip());
    }
}

class Submarine {
    String name;
    Integer power;
    Long timeVelocity;
    List<Integer> jumpVector;

    public Submarine(SubmarineBuilder submarineBuilder) {
        this.name = submarineBuilder.name;
        this.power = submarineBuilder.power;
        this.timeVelocity = submarineBuilder.timeVelocity;
        this.jumpVector = submarineBuilder.jumpVector;
    }

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

    static class SubmarineBuilder {
        private Submarine submarine;
        private String name;
        private Integer power;
        private Long timeVelocity;
        private List<Integer> jumpVector;

        SubmarineBuilder() {
        }

        public SubmarineBuilder setSpaceShipName(String name) {
            this.name=name;
            return this;
        }

        public SubmarineBuilder setEnginePower(Integer power) {
            this.power = power;
            return this;
        }

        public SubmarineBuilder setTimeVelocity(Long timeVelocity) {
            this.timeVelocity = timeVelocity;
            return this;
        }

        public SubmarineBuilder setJumpVector(List<Integer> jumpVector) {
            this.jumpVector = jumpVector;
            return this;
        }

        public Submarine buildSubmarine() {
            this.submarine = new Submarine(this);
            return submarine;
        }
    }
}



class SubmarineDirector {

    Submarine createLightFastSpaceShip() {
        return new Submarine.SubmarineBuilder().
                setSpaceShipName("Fast").
                setEnginePower(100).
                setTimeVelocity(33L).
                setJumpVector(Arrays.asList(33, 4, 3, 2)).buildSubmarine();
    }
}