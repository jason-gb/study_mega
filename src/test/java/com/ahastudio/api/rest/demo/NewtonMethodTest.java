package com.ahastudio.api.rest.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;

public class NewtonMethodTest {
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.######");
    private NewtonMethod sut;

    @BeforeEach
//최초 시작 시 진행함
    void setUp() {
        sut = new NewtonMethod();
    }//void로 다른데서 생성 불가한 상태에서 새로운 NewtonMethod를 생성하고 다른걸 시작
    //sut = system under test

    @Test
    void sqrt() {
        assertThat(decimalFormat.format(sut.sqrt(2))).isEqualTo("1.414216");
        assertThat(decimalFormat.format(sut.sqrt(3))).isEqualTo("1.732051");
        assertThat(decimalFormat.format(sut.sqrt(4))).isEqualTo("2");
    }

    @Test
    void sqrtIter() {
        assertThat(decimalFormat.format(sut.sqrtIter(1, 2))).isEqualTo("1.414216");
        assertThat(decimalFormat.format(sut.sqrtIter(1, 3))).isEqualTo("1.732051");
        assertThat(decimalFormat.format(sut.sqrtIter(1, 4))).isEqualTo("2");
    }

    @Test
    @DisplayName("goodEnough method는 guess가 제곱근과 비슷하면 true를 리턴한다.")
    void goodEnough() {
        assertThat(sut.goodEnough(2, 4)).isTrue();
        assertThat(sut.goodEnough(1, 2)).isFalse();

        assertThat(sut.goodEnough(1.9999999, 4)).isTrue();
    }

    @Test
    void improve() {
        assertThat(decimalFormat.format(sut.improve(1, 2))).isEqualTo("1.5");
        assertThat(decimalFormat.format(sut.improve(1.5, 2))).isEqualTo("1.416667");
        assertThat(decimalFormat.format(sut.improve(1.416667, 2))).isEqualTo("1.414216");
    }

    @Test
    void average() {
        assertThat(decimalFormat.format(sut.average(1, 2))).isEqualTo("1.5");

        //극한테스트
        assertThat(decimalFormat.format(sut.average(-Double.MAX_VALUE, Double.MAX_VALUE))).isEqualTo("0");
    }
}
