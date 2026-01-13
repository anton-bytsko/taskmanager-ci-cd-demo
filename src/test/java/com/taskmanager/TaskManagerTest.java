package com.taskmanager;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TaskManagerTest {
    
    @Test
    public void testAddTask() {
        TaskManager manager = new TaskManager();
        Task task = new Task("Test task");
        
        manager.addTask(task);
        assertEquals(1, manager.getTaskCount());
        assertTrue(manager.getAllTasks().contains(task));
    }
    
    @Test
    public void testRemoveTask() {
        TaskManager manager = new TaskManager();
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        
        manager.addTask(task1);
        manager.addTask(task2);
        assertEquals(2, manager.getTaskCount());
        
        manager.removeTask(task1);
        assertEquals(1, manager.getTaskCount());
        assertFalse(manager.getAllTasks().contains(task1));
        assertTrue(manager.getAllTasks().contains(task2));
    }
    
    @Test
    public void testGetCompletedTasks() {
        TaskManager manager = new TaskManager();
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        task2.complete();
        
        manager.addTask(task1);
        manager.addTask(task2);
        
        List<Task> completed = manager.getCompletedTasks();
        assertEquals(1, completed.size());
        assertTrue(completed.contains(task2));
        assertFalse(completed.contains(task1));
    }
    
    @Test
    public void testGetPendingTasks() {
        TaskManager manager = new TaskManager();
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        task2.complete();
        
        manager.addTask(task1);
        manager.addTask(task2);
        
        List<Task> pending = manager.getPendingTasks();
        assertEquals(1, pending.size());
        assertTrue(pending.contains(task1));
        assertFalse(pending.contains(task2));
    }
    
    @Test
    public void testCompleteTaskByIndex() {
        TaskManager manager = new TaskManager();
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        
        manager.addTask(task1);
        manager.addTask(task2);
        
        assertFalse(task1.isCompleted());
        manager.completeTask(0);
        assertTrue(task1.isCompleted());
        assertFalse(task2.isCompleted());
    }
    
    @Test
    public void testCompleteTaskInvalidIndex() {
        TaskManager manager = new TaskManager();
        Task task = new Task("Task");
        manager.addTask(task);
        
        // Не должно вызывать ошибку при неверном индексе
        manager.completeTask(-1);
        manager.completeTask(5);
    }
}