package dmitry.algorithms;

/**
 * Created by dima on 1/29/16.
 *
 * Useful checks for test
 */
public class TestUtil {

    /**
     * Array sorted check
     * @param array the array to check is it sorted or not
     */
    public static boolean isArraySorted(int[] array){
        if(array.length==1){
            return true;
        }

        for(int i = 1; i < array.length;i++){
            if(array[i-1] > array[i]){
                return false;
            }
        }

        return true;
    }
}
