package dmitry.quiz.ctci.arrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class URLIfyTest {

    /**
     * Do not test wrong input, assume that str and strLen are correct.
     */
    @Test
    public void urlify_standard() {
        URLIfy urlify = new URLIfy();
        assertThat(urlify.urlIfy("Mr John Smith    ", 13), is("Mr%20John%20Smith"));
    }
}
