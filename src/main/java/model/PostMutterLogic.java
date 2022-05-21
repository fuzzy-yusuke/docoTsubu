package model;
//つぶやきの投稿に関する処理を行うモデル

import java.util.List;

public class PostMutterLogic {
	public void execute(Mutter mutter,List<Mutter> mutterList) {
		mutterList.add(0,mutter);  //先頭に追加
								   //上書きするのではなく、指定した位置に挿入し、以降のインスタンスを一つずらす
	}
}
