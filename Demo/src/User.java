
import java.io.Serializable;

public class User implements Serializable {
	/**
	 * Ëæ»úÐòÁÐºÅ
	 */
	private static final long serialVersionUID = -7185447814341077688L;
	private String change;
	private String pwchange;

	public User(String name, String password) {
		super();
		this.change = change;
		this.pwchange = pwchange;
	}

	public String getName() {
		return change;
	}

	public void setName(String name) {
		this.change = change;
	}

	public String getPassword() {
		return pwchange;
	}

	public void setPassword(String password) {
		this.pwchange = password;
	}

	@Override
	public String toString() {
		return "User [change=" + change + ", pwchange=" + pwchange + "]";
	}

}
