package model;

//MutterDAOを利用してMUTTERテーブルの全レコードを取得する
import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {
	public List<Mutter> execute(){
		MutterDAO dao=new MutterDAO();
		List<Mutter> mutterList=dao.findAll();
		return mutterList;
	}

}
