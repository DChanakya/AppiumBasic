package managers;

public enum ExecutionModes {
	WEB("web"),ANDROID("android");
	private String mode;
		
	public String getModeValue() {
			return this.mode;
		}
		
	private ExecutionModes(String mode) {
			this.mode=mode;
		}
}
