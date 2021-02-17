package collections;

public enum BadRequest {

	WRONG_NAME_SIZE("Madhesia e emrit me e madhe se e lejuara");
	
	private String errorMessage;
	
	BadRequest(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
