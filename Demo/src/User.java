
import java.io.Serializable;

public class User implements Serializable {
	/**
	 * Ëæ»úÐòÁÐºÅ
	 */
	private static final long serialVersionUID = -7185447814341077688L;
	private String change;
	private String pwchange;
    private String answer;
	public User(String change, String pwchange) {
		super();
		this.change = change;
		this.pwchange = pwchange;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getPassword() {
		return pwchange;
	}

	public void setPassword(String pwchange) {
		this.pwchange = pwchange;
	}

	@Override
	public String toString() {
		return "User [change=" + change + ", pwchange=" + pwchange + "]";
	}

	public User(String answer) {
		super();
		this.answer = answer;
	}
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String toString1() {
		return "User [answer=" + answer + "]";
	}
}
