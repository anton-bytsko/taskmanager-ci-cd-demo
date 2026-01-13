package com.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getCompletedTasks() {
        List<Task> completed = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completed.add(task);
            }
        }
        return completed;
    }

    public List<Task> getPendingTasks() {
        List<Task> pending = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pending.add(task);
            }
        }
        return pending;
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        }
    }
}