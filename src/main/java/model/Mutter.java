package model;
//つぶやきに関する情報を持つJavaBeans

import java.io.Serializable;

public class Mutter implements Serializable{
	private int id;				//ユーザーID
	private String userName;	//ユーザー名
	private String text;		//つぶやき内容
	public Mutter() {}
	//つぶやきに関する情報を保持
	public Mutter(String userName,String text) {
		this.userName=userName;
		this.text=text;
	}

	//DBと連動
	public Mutter(int id,String userName,String text) {
		this.id=id;
		this.userName=userName;
		this.text=text;
	}

	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getText() {
		return text;
	}
}
