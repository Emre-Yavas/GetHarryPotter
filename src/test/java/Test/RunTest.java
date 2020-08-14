
package Test;

import Base.BaseTest;
import org.junit.Test;

public class RunTest extends BaseTest {

    @Test
    public void TestClass(){

        System.out.println("Step 1: Search the movies included 'Harry Potter' in title and find the id " +
                "of 'Harry Potter and the Sorcerer's Stone'.");
        String imdbId = Search();
        System.out.println("Id of the movie: " + imdbId);

        System.out.println("Step 2: Search the movie with this id.");
        IdTitle(imdbId);


    }
}