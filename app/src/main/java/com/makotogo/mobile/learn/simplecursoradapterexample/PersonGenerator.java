/*
 *  Copyright 2016 Makoto Consulting Group, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.makotogo.mobile.learn.simplecursoradapterexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sperry on 11/23/16.
 */

public class PersonGenerator {
    private static final int AGE_MAX = 50;

    private static Random rng = new Random(System.currentTimeMillis());

    /**
     * Create a bunch of random employees. No jokes, people.
     *
     * @param numberOfPeopleToCreate
     *
     * @return
     */
    public static List<Person> createPeople(int numberOfPeopleToCreate) {
        List<Person> ret = new ArrayList<>();
        for (int index = 0; index < numberOfPeopleToCreate; index++) {
            ret.add(new Person(generateRandomLastName(), generateRandomFirstName(), generateRandomAge(), generateRandomEyeColor(), generateRandomGender()));
        }
        return ret;
    }

    public static Person createPerson() {
        return new Person(generateRandomLastName(), generateRandomFirstName(), generateRandomAge(), generateRandomEyeColor(), generateRandomGender());
    }
    /**
     * Warm up the random number generator. Call it a random
     * number of times. Inception? You bet.
     */
    private static void warmupRandomNumberGenerator() {
        // Run through a few before returning the number
        int randomNumberOfWarmups = rng.nextInt(10);
        for (int aa = 0; aa < randomNumberOfWarmups; aa++) {
            rng.nextInt();
        }
    }

    /**
     * Generate and return a random number, just like
     * it says. What? You trust Javadoc more than a method
     * signature?
     *
     * @param bound
     *          The upper bound on the RNG
     *
     * @return The next int between zero (incl) and the bound (excl)
     */
    private static int generateRandomNumber(int bound) {
        warmupRandomNumberGenerator();
        return rng.nextInt(bound);
    }

    /**
     * Generates a random name. D&D style. That's right. I'm a geek
     * and proud of it.
     *
     * @return
     */
    private static String generateRandomName() {
        String prefix = NAME_PREFIX[generateRandomNumber(NAME_PREFIX.length)];
        String suffix = NAME_SUFFIX[generateRandomNumber(NAME_SUFFIX.length)];

        return prefix + suffix;
    }

    private static String generateRandomLastName() {
        String suffix = NAME_SUFFIX[generateRandomNumber(NAME_SUFFIX.length)];
        return suffix;
    }

    private static String generateRandomFirstName() {
        String prefix = NAME_PREFIX[generateRandomNumber(NAME_PREFIX.length)];
        return prefix;
    }

    /**
     * Generates a random age between 1 and AGE_MAX.
     *
     * @return
     */
    private static int generateRandomAge() {
        return generateRandomNumber(AGE_MAX) + 1;
    }

    /**
     * Generate a random Gender from the enum of the same name.
     * Like the kind you see on YouTube.
     * Okay, not like that at all.
     *
     * @return
     */
    private static Gender generateRandomGender() {
        Gender[] genders = Gender.values();

        int randomIndex = generateRandomNumber(genders.length * 1000) / 1000;

        return genders[randomIndex];
    }

    /**
     * Generate a random EyeColor from the enum of the same name.
     * Coincidence? Um, no.
     *
     * @return
     */
    private static EyeColor generateRandomEyeColor() {
        EyeColor[] eyeColors = EyeColor.values();

        int randomIndex = generateRandomNumber(eyeColors.length * 1000) / 1000;

        return eyeColors[randomIndex];
    }

    /**
     * Generate a random (String) number that looks (sort of) like a TIN.
     * Shouldn't that be stannous, you ask? No, not that kind of tin.
     *
     * @return
     */
    private static String generateRandomTin() {

        int upperBound = 999999999;
        int lowerBound = 100000000;

        int randomNumber = generateRandomNumber(upperBound - lowerBound) + lowerBound;

        return Integer.toString(randomNumber);
    }

    /**
     * Generate a random (String) number that looks like some kind of Employee
     * number. Yes, this is totally contrived. Welcome to demo software.
     *
     * @return
     */
    private static String generateRandomEmployeeNumber() {
        int upperBound = 999;
        int lowerBound = 100;

        int randomNumber = generateRandomNumber(upperBound - lowerBound) + lowerBound;

        return Integer.toString(randomNumber);
    }

    private static final String[] NAME_PREFIX = {
            "Anon",
            "Bazog",
            "Con",
            "Daon",
            "Engan",
            "Fan",
            "Grale",
            "Hor",
            "Ix",
            "Jaxl",
            "Kath",
            "Lane",
            "Mord",
            "Naen",
            "Oon",
            "Ptal",
            "Tindale",
            "Ugzor",
            "Vahland",
            "Wragdhen",
            "Xntlh",
            "Yagnag",
            "Zhangth"
    };

    private static final String[] NAME_SUFFIX = {
            "Ag",
            "Bog",
            "Cain",
            "Doan",
            "Erg",
            "Fon",
            "Gor",
            "Heg",
            "In",
            "Jar",
            "Kol",
            "Lar",
            "Mog",
            "Nag",
            "Oon",
            "Ptal",
            "Quon",
            "Rag",
            "Sar",
            "Thag",
            "Uxl",
            "Verd",
            "Wrog",
            "Xlott",
            "Yogrl",
            "Zelx"
    };

}
