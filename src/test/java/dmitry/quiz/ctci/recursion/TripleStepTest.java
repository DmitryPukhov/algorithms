package dmitry.quiz.ctci.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TripleStepTest {

    private TripleStep tripleStep;

    @Before
    public void init() {
        // Reset quiz
        tripleStep = new TripleStep();
    }

    @Test
    public void calcSteps_insideJump() {
        // Steps num is inside single jump
        assertThat(tripleStep.calcSteps(1), is(1));
        assertThat(tripleStep.calcSteps(2), is(2));
        assertThat(tripleStep.calcSteps(3), is(4));
        assertThat(tripleStep.calcSteps(4), is(7));
    }

    @Test
    public void calcSteps_outOfJump() {
        // f(4) +  f(3) + f(2) + f(1) = 7 + 4 + 2 + 1 = 14
        assertThat(tripleStep.calcSteps(5), is(14));

        // f(5) +  f(4) + f(3) + f(2) = 14 + 7 + 4 + 2 = 27
        assertThat(tripleStep.calcSteps(6), is(27));

    }

}