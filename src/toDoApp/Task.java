package toDoApp;

import java.time.LocalDate;

public class Task {
	private String title;
	private String description;
	private LocalDate deadline;
	private Priority priority;

	public Task(String title, String description, LocalDate deadline, Priority priority) {
		this.title = title;
		this.description = description;
		this.deadline = deadline;
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public boolean isOverdue() {
		return this.deadline.isBefore(LocalDate.now());
	}

	@Override
	public String toString() {
		return "Task [title=" + title + ", description=" + description + ", deadline=" + deadline + ", priority="
				+ priority + "]";
	}
}
