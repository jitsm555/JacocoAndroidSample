package com.jiteshmohite619.jacocoandroidsample;

import com.jiteshmohite619.jacocoandroidsample.model.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class will be responsible for handling all user related test
 * Created by jiteshmohite on 14/02/18.
 */

public class UserTest {

    private static final String EMAIL_ID = "abc@gmail.com";
    private static final String PASSWORD = "12345";

    private User mUser;

    @Before
    public void setUp() {
        mUser = new User();
        mUser.setEmailId(EMAIL_ID);
        mUser.setPassword(PASSWORD);
    }

    @Test
    public void testUser() throws Exception {
        Assert.assertEquals(EMAIL_ID, mUser.getEmailId());
        Assert.assertEquals(PASSWORD, mUser.getPassword());
    }
}
