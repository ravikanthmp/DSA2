package DSA.practise.dp;

import DSA.practise.dp.memoization.GridTraveller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridTravellerTest {

    @Test
    public void testGridTraveller(){
        GridTraveller gridTraveller = new GridTraveller(2, 3);
        Assertions.assertEquals(gridTraveller.numberOfWays(), 3);

        gridTraveller = new GridTraveller(3, 2);
        Assertions.assertEquals(gridTraveller.numberOfWays(), 3);

        gridTraveller = new GridTraveller(3, 3);
        Assertions.assertEquals(gridTraveller.numberOfWays(), 6);

        gridTraveller = new GridTraveller(18, 18);
        Assertions.assertEquals(gridTraveller.numberOfWays(), 2333606220l);

    }
}