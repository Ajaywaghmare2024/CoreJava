package com.app.task;

import java.time.LocalDate;

public class Task {
	private int taskId;
	private String tname;
	private String description;
	private LocalDate taskDate;
	private TaskStatus status;
	private boolean active;
	public static int cnt=0;

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task( String tname, String description, LocalDate taskDate, TaskStatus status, boolean active) {
		super();
		this.taskId =++cnt;
		this.tname = tname;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", tname=" + tname + ", description=" + description + ", taskDate=" + taskDate
				+ ", status=" + status + ", active=" + active + "]";
	}

}
