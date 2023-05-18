package friendsDto;

public class FriendsDto {
	private int num;
	private String name;
	private String nick;
	
	public FriendsDto() {}
	
	public FriendsDto(int num, String name, String nick) {
		super();
		this.num=num;
		this.name=name;
		this.nick=nick;
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}
