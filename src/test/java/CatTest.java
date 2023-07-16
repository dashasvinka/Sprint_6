import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoRule;
import java.util.List;
@RunWith(Parameterized.class)

public class CatTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    Feline feline;

    private List<String> eatslist;

    public CatTest(List<String> eatslist) {
        this.eatslist = eatslist;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {List.of("Мясо", "Рыба", "Птица")},
                {List.of("Трава", "Вода", "Хлеб")}
        };
    }

    @Test

    public void checkGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(eatslist);
        List<String> actual = cat.getFood();
        Assert.assertArrayEquals(eatslist.toArray(), actual.toArray());
    }

    @Test
    public void checkGetSound(){
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        Assert.assertEquals(expected, actual);
    }

}

