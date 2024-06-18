package com.app.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import com.app.task.Task;
import com.app.task.TaskStatus;
import com.app.utils.TaskUtils;

public class TaskApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<Integer, Task> map = new HashMap<Integer, Task>();
			while (!exit) {
				System.out.println(
						"Enter the option- 1. Add Task\n 2.Display All Task\n 3.Delete the Task\n 4.update the status\n"
								+ " 5.Display All pending task\n 6.Display All pending task for today\n 7.Display all task sorted by taskDate");
				System.out.println("Enter the choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						// Add the task
						System.out.println("Enter the Task Details-");
						System.out.println("Tname,Description,taskDate,status,active");
						Task task = TaskUtils.validateInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextBoolean(), map);
						map.put(task.getTaskId(), task);
						System.out.println("Task Added successfully...............");
						break;
					case 2:
						System.out.println("Display all tasks");
						for (Task t : map.values())
							System.out.println(t);
						break;

					case 3:
						System.out.println("Enter the id -");
						// deleted thr task
						TaskUtils.removeTask(sc.nextInt(), map);
						System.out.println("deleted.........");
						break;

					case 4:
						// update the taskstatus
						System.out.println("Enter the id and status");
						String status = TaskUtils.updateStatus(sc.nextInt(),
								TaskStatus.valueOf(sc.next().toUpperCase()), map);
						System.out.println(status);

						break;
					case 5:
						// Display all pending list
						 TaskUtils.displayAllPendingStatus(TaskStatus.valueOf(sc.next().toUpperCase()), map);
						break;
					case 7:
						System.out.println("Sorted by all task by date");
						LinkedList<Task> list = new LinkedList<Task>(map.values());
						Collections.sort(list, new Comparator<Task>() {

							@Override
							public int compare(Task o1, Task o2) {
								return o1.getTaskDate().compareTo(o2.getTaskDate());

							}
						});
						System.out.println("Sorted as per taskDate");
						for(Task t:list)
							System.out.println(t);
						break;
					case 0:

						exit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
