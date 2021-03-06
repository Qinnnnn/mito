package de.tum.bgu.msm.modules.travelTimeBudget;

import de.tum.bgu.msm.data.Purpose;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AverageBudgetPerPurposeTest {

    @Before
    public void cleanUpBudgets() {
        Purpose.clearBudgets();
    }

    @Test
    public void test() {
        for(Purpose purpose: Purpose.values()) {
            Assert.assertEquals(0., purpose.getAverageBudgetPerHousehold(), 0.);
            purpose.addAndUpdateBudget(0);
            Assert.assertEquals(0., purpose.getAverageBudgetPerHousehold(), 0.);
        }

        for(Purpose purpose: Purpose.values()) {
            purpose.addAndUpdateBudget(10);
            Assert.assertEquals(5, purpose.getAverageBudgetPerHousehold(), 0.);
        }
    }
}
