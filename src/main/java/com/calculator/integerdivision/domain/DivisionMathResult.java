package com.calculator.integerdivision.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DivisionMathResult implements DivisionResult<Integer> {
    private final int dividend;
    private final int divider;
    private final List<DivisionStep> steps = new ArrayList<>();

    public DivisionMathResult(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    @Override
    public Integer getResult() {
        return dividend / divider;
    }

    public List<DivisionStep> getDivisionSteps() {
        return steps;
    }

    public void addDivisionStep(DivisionStep divisionStep) {
        steps.add(divisionStep);
    }

    @Override
    public String toString() {
        return steps.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DivisionMathResult that = (DivisionMathResult) o;

        if (dividend != that.dividend) {
            return false;
        }
        if (divider != that.divider) {
            return false;
        }
        return steps.equals(that.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(steps);
    }
}
