package org.bongiorno.codility.zalando.test3;


import java.time.Duration;
import java.time.LocalTime;

public class Solution {

    public int solution(String enterTime, String leaveTime) {
        enterTime = String.format("%5s",enterTime).replace(' ','0');
        leaveTime = String.format("%5s",leaveTime).replace(' ','0');
        Duration timeInGarage = Duration.between(LocalTime.parse(enterTime), LocalTime.parse(leaveTime));

        if(timeInGarage.equals(Duration.ZERO))
            return 0;

        long hrsInGarage = timeInGarage.toHours();
        return (int) (2 + 3 + ((hrsInGarage -1) * 4) + (timeInGarage.minusHours(hrsInGarage).compareTo(Duration.ZERO) > 0 ? 4 : 0));

    }


}
