package com.phonepe.models;

import com.phonepe.exceptions.InvalidOverNumberException;

import java.util.ArrayList;
import java.util.List;

public class Over extends Auditable{

    List<Ball> balls = new ArrayList<>();

    public void addBalls(Ball ball){
        balls.add(ball);
    }

    public void validateOverNumbers(int totalOvers) throws InvalidOverNumberException {
        if(totalOvers<=0)
            throw new InvalidOverNumberException("Over cannot be less than zero");
    }
}
