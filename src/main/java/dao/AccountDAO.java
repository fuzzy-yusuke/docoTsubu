package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	//DBに接続するのに必要な情報
	private final String JDBC_URL=
			"jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER="sa";
	private final String DB_PASS="";
	
	public Account findByLogin(Login login) {
		Account account=null;
		
		//DBへの接続
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SELECT文を準備
			String sql="SELECT USER_ID,PASS,NAME FROM ACCOUNT WHERE USER_ID=? AND PASS=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs=pStmt.executeQuery();
			
			//ユーザーが既存のものと一致した場合、そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {
				//結果表からデータを取得
				String userId=rs.getString("USER_ID");
				String pass=rs.getString("PASS");
				String name=rs.getString("NAME");
				account=new Account(userId,pass,name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//見つかったユーザー、又はnullを返す
		return account;
	}
}
