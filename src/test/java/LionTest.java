import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.List;


@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Mock
    Feline feline;

    private final String sex;
    private final boolean expected;


    public LionTest(String sex,boolean expected){
        this.sex = sex;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Самка", false},
                {"Самец", true}
        };
    }
    @Test
    public void checkDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex,feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(100);
        int expectedResult = 100;
        int actualResult = lion.getKittens();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkGetFood() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedRes = List.of("Животные", "Птицы", "Рыба");
        List<String> actualRes = lion.getFood();
        Assert.assertEquals(expectedRes, actualRes);
    }

    @Test
    public void checkDoesHaveManeException() {
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("fake", feline));
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }



}
