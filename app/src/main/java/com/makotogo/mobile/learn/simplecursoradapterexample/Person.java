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

import java.util.Date;

public class Person {

    public enum EyeColor {
        BLACK, BROWN, BLUE, GREEN, HAZEL, GOLD, UNKNOWN
    }

    public enum Gender {
        MALE, FEMALE, UNKNOWN
    }

    public Person(String lastName, String firstName, int age, EyeColor eyeColor, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.eyeColor = eyeColor;
        this.gender = gender;
    }

    //************************************
    //* D B - S P E C F I C    S T U F F *
    //************************************

    private Long mId;
    private Date mWhenCreated;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        this.mId = id;
    }

    public Date getWhenCreated() {
        return mWhenCreated;
    }

    public void setWhenCreated(Date whenCreated) {
        this.mWhenCreated = whenCreated;
    }

    //***********************
    //* A T T R I B U T E S *
    //***********************

    private String lastName;
    private String firstName;
    private int age;
    private EyeColor eyeColor;
    private Gender gender;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person [id=" + mId + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", height=" + ", eyeColor="
                + eyeColor
                + ", gender=" + gender + ", whenCreated = " + mWhenCreated + "]";
    }

}
