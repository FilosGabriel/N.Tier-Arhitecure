package com.filos.application.helpers.random;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomGenerator {

    public int generateInteger(int min, int max) {
        return new Random().nextInt(min, max);
    }
}
