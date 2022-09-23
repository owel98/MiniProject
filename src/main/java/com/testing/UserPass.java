package com.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserPass {

	@Test
	    void test() {
	        Testing t = new Testing();
	        assertEquals(1, t.isUser());
	    }

}
