package dmitry.quiz.bits;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InsertionTest {
    private Insertion insertion = new Insertion();

    @Test
    public void insert_normalCase() {
        int n2 = insertion.insert(0b10000000000, 0b10011, 2,6);
        assertThat(n2, is(0b10001001100));
    }
}