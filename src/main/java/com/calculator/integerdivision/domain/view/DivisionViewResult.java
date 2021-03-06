package com.calculator.integerdivision.domain.view;

import com.calculator.integerdivision.domain.DivisionResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisionViewResult implements DivisionResult<DivisionViewStep> {

    private final List<DivisionViewStep> steps = new ArrayList<>();

    /**
     * @param index step index;
     * @return DivisionViewStep object if it exists in the step list
     * by passed index, otherwise returns null
     */
    @Override
    public DivisionViewStep getStep(int index) {
        try {
            return steps.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public DivisionViewResult addStep(DivisionViewStep step) {
        steps.add(step);
        return this;
    }

    @Override
    public DivisionViewResult addAllSteps(DivisionViewStep... steps) {
        Collections.addAll(this.steps, steps);
        return this;
    }

    @Override
    public List<DivisionViewStep> getSteps() {
        return List.copyOf(steps);
    }

    @Override
    public int size() {
        return steps.size();
    }

    @Override
    public String toString() {
        return steps.stream()
                .map(DivisionViewStep::getView)
                .reduce("", (partial, next) -> partial + next);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DivisionViewResult that = (DivisionViewResult) o;

        if (size() != that.size()) {
            return false;
        }

        return steps.equals(that.getSteps());
    }

}
