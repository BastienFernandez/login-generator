package geco;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void CT1() {
        String log = loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        assertEquals("PDUR", log);

        String log2 = loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        assertEquals("JRAL2", log2);
    }

    @Test
    public void CT2() {
        String log = loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        assertEquals("JROL1", log);
    }

    @Test
    public void CT3() {
        String log = loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertEquals("PDUR", log);
    }


}