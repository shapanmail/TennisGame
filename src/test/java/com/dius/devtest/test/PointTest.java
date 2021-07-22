package com.dius.devtest.test;



import com.dius.devtest.Point;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PointTest {



    @Test
    public void getNextPoint() {
        Point p = Point.THIRTY;
        assertThat(p.toString()).isEqualTo("30");

        p.next();
        assertThat(p.next()).isEqualTo(Point.FORTY);
    }

}
