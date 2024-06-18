package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.custom_exception.TaskException;
import com.app.task.Task;
import com.app.task.TaskStatus;

public class TaskUtils {
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	public static TaskStatus parseStatus(String status) {
		return TaskStatus.valueOf(status.toUpperCase());

	}

	public static Task validateInputs(String tname, String description, String taskDate, String status, boolean active,
			Map<Integer, Task> task) throws TaskException {
		LocalDate tskDate = parseDate(taskDate);
		TaskStatus taskStatus = parseStatus(status);
		return new Task(tname, description, tskDate, taskStatus, active);

	}

	// delete the task
	public static void removeTask(int taskId, Map<Integer, Task> tsks) throws TaskException {
		Task task = tsks.remove(taskId);
		if (task == null)

			throw new TaskException("invalid ID");
		

	}

	public static String updateStatus(int id, TaskStatus newStatus, Map<Integer, Task> tasks) throws TaskException {
		Task task = tasks.get(id);
		if (task == null)
			throw new TaskException("Inavalid id");
		task.setStatus(newStatus);
		return "updated successfully";

	}
	
	// display
	public static void displayAllPendingStatus(TaskStatus status,Map<Integer, Task>tasks)throws TaskException{
		//TaskStatus taskStatus=TaskStatus.PENDING;
		
			for(Task t:tasks.values()) {
				if("pending".equals(t.getStatus())&& t.isActive()) {
					System.out.println("display-"+t);
				}
			}
				
		
		
	}
}
