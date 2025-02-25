package toDoApp;

enum Priority {
	LOW("low", 1), MEDIUM("medium", 2), HIGH("high", 3);

	private final String displayName;
	private final int importanceLevel;

	Priority(String displayName, int importanceLevel) {
		this.displayName = displayName;
		this.importanceLevel = importanceLevel;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getImportanceLevel() {
		return importanceLevel;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
