import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Mock
    Feline feline;

    @Test

    public void checkGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> eatslist = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(eatslist);
        List<String> actual = cat.getFood();
        for (String eat : eatslist) {
            Assert.assertTrue(actual.stream().anyMatch(x -> eat.equals(x)));
        }
    }

    @Test
    public void checkGetSound(){
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        Assert.assertEquals(expected, actual);
    }

}

