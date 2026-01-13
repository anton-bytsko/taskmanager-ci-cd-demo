package com.taskmanager;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {
    
    @Test
    public void testTaskCreation() {
        Task task = new Task("Learn CI/CD");
        assertEquals("Learn CI/CD", task.getTitle());
        assertFalse(task.isCompleted());
    }
    
    @Test
    public void testCompleteTask() {
        Task task = new Task("Write tests");
        assertFalse(task.isCompleted());
        task.complete();
        assertTrue(task.isCompleted());
    }
    
    @Test
    public void testToString() {
        Task task = new Task("Build project");
        String str = task.toString();
        assertTrue(str.contains("Build project"));
        assertTrue(str.contains("[ ]"));
        
        task.complete();
        str = task.toString();
        assertTrue(str.contains("[✓]"));
    }
}