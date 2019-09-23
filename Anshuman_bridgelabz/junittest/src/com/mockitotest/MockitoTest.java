package com.mockitotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest 
{
	@InjectMocks
    RecordService record;
    
	@Mock
    DataBaseDao database;
    
    @Mock
    ServerBaseDao server;
    
    @Test
    public void saveTest()
    {
    	boolean saved=record.save("temp.txt");
    	assertEquals(true, saved);
    	
    	
    }
    
}
