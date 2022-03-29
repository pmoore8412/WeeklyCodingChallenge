package com.weekly.codingchallenge.weekofmarch28th2022;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* 100 Lockers Problem
 * The 100 Lockers problem is a math challenge for January 2017
 * The challenge is as follows: There are 100 lockers lined up in a hallway numbered 1 to 100
 * one the first pass all 100 lockers are opened, on the second pass every other locker is closed 
 * on the third pass and on every nth (n being equal to the pass number e.g. 3) 
 * locker is toggled depending on it's state (open or closed) 
 * The question is how many lockers are left open after 100 passes
 * This rest controller finds out the total times the lockers were opened, 
 * the number of lockers left opened after 100 passes, 
 * and the lockers that are opened and returns a String with each result
 * Results can be seen at http://localhost:8080/getLockerCount once you have cloned or downloaded the package from github */

@RestController
public class ChallengeController {

    @GetMapping("/getLockerCount")
    public String getTotalLockersOpened() {

        long openCount = 0;
        long openLocker = 0;
        ArrayList<Boolean> isOpen = new ArrayList<>(); //ArrayList of lockers true = open, false = closed
        ArrayList<Integer> openLockers = new ArrayList<>(); //ArrayList of open lockers

        // load lockers
        for(int i = 0; i <= 100; i++)

            isOpen.add(false);
            

        // algorithm to run through the 100 lockers
        for(int j = 1; j <= 100; j++)

            for(int k = 1; k <= 100; k++) {

                if(k % j == 0)

                    if(isOpen.get(k) == true)

                        isOpen.set(k, false);

                    else {

                        isOpen.set(k, true); 
                        openCount += 1;

                    }

            }

        // pass to check the number of open lockers
        for(int l = 1; l <= 100; l++)

            if(isOpen.get(l) == true)

                openLocker += 1;

        // pass to get the locker numbers that are open
        for(int h = 1; h <= 100; h++) {

            if(isOpen.get(h) == true)

                openLockers.add(h);

        }

        

        String totalOpened = "Total lockers openend: " + openCount;
        String numberOpen = "Total nuber of lockers open: " + openLocker;
        String lockersOpen = "The lockers that are open are as follows: " + openLockers.toString();

        return totalOpened + ";   " + numberOpen + ";   " + lockersOpen;

    }
    
}