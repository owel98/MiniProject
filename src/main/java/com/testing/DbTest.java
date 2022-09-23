package com.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DbTest {

	@Test
	void test() throws SQLException{
		  Testing t = new Testing();
	        assertEquals(true, t.isConnected());
	}

}




