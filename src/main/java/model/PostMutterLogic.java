package model;
//つぶやきの投稿に関する処理を行うモデル

import dao.MutterDAO;

public class PostMutterLogic {
		public void execute(Mutter mutter) {
			MutterDAO dao=new MutterDAO();
			dao.create(mutter);
		}
	}

