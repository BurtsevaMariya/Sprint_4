package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AcountTest {
    private String name;
    private boolean expected;

    public AcountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {"тимоти шаламе", true},
                {"Timothy Chalomet", true},
                {"Q Б", true},
                {"Р12345 O:?*()", true},
                {"Восемнадца тьСимво", true},
                {"Девятнадца тьСимволо", false},
                {"TШ", false},
                {"Болеедевятнадцатисимволов Болеедевятнадцатисимволов", false},
                {"Тимоти ", false},
                {" Тимоти", false},
                {"ТимотиШаламе", false},
                {"Тимоти  Шаламе", false},
                {"   ", false},
                {null, false}
        };
    }

    @Test
    public void testCorrectData() {
        Account account = new Account(name);
        assertEquals("Некорректные данные", account.checkNameToEmboss(), expected);
    }
}
