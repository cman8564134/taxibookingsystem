package com.motional.cthye.taxibookingsystem;

import com.motional.cthye.taxibookingsystem.model.BookingTest;
import com.motional.cthye.taxibookingsystem.model.CarTest;
import com.motional.cthye.taxibookingsystem.model.WorldTest;
import com.motional.cthye.taxibookingsystem.util.DistanceUtilTest;
import com.motional.cthye.taxibookingsystem.util.VehicleFactoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DistanceUtilTest.class,
        VehicleFactoryTest.class,
        WorldTest.class,
        CarTest.class,
        BookingTest.class
})
@SpringBootTest
public class TaxiBookingApplicationUnitTest {
}
