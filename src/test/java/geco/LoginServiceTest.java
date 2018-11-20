package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService loginService;
    private String[] loginExistants;
    private String login;

    @Before
    public void setUp() throws Exception {
        loginExistants = new String[4];
        loginExistants[0] = "log0";
        loginExistants[1] = "log1";
        loginExistants[2] = "log2";
        loginExistants[3] = "pref0";
        loginService = new LoginService(loginExistants);
        login = "log0";
    }

    @Test
    public void testLoginExists() {
        assertTrue("bug login exists", loginService.loginExists(login));
        assertFalse("bug login exists", loginService.loginExists("erreur"));
    }

    @Test
    public void testAddLogin() {
        loginService.addLogin("testAdd");
        assertTrue("bug add login", loginService.loginExists(login));
    }

    @Test
    public void testFindAllLoginsStartingWith() {
        List<String> logins = loginService.findAllLoginsStartingWith("pref");
        assertEquals(1, logins.size());
        assertEquals("pref0", logins.get(0));
    }

    @Test
    public void testFindAllLogins() {
        List<String> logins = loginService.findAllLogins();
        List<String> testLogins = new ArrayList<String>();
        testLogins.add("log0");
        testLogins.add("log1");
        testLogins.add("log2");
        testLogins.add("pref0");
        assertEquals("bug findAllLogins", testLogins, logins);
    }
}