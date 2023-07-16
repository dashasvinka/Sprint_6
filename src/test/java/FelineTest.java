import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {
    @Test
    public void checkGetKittensFirst(){
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkGetKittensSecond(){
        Feline feline = new Feline();
        int actual = feline.getKittens(5);
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkGetFamily(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String>  actual = feline.eatMeat();
        List<String>  expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
