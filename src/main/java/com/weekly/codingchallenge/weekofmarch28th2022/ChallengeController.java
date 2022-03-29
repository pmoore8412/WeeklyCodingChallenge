package com.weekly.codingchallenge.weekofmarch28th2022;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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