package mainProc;

import dbProc.ConnectInfo;
import dbProc.TestTableDbProc;
import entity.TestTableEntity;

public class MainProcCls {

	/** サーバホスト */
	private String server = "XXX.XXX.XXX.XXX";
	/** DB名 */
	private String dbName = "{dbName}";
	/** 接続ユーザID */
	private String userId = "{userId}";
	/** 接続パスワード */
	private String password = "{password}";

	/**
	 * プロセスのスタート地点
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		MainProcCls cls = new MainProcCls();
		cls.process();
	}

	/**
	 * 処理を行ないます
	 * @throws Exception
	 */
	private void process() throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT testId ");
		sql.append("       ,testName ");
		sql.append("       ,testAge ");
		sql.append("   FROM TestSchema.TestTable ");
		sql.append("  WHERE testId = ? ");

		// 接続情報作成
		ConnectInfo conInfo = new ConnectInfo(this.server, this.dbName,
				this.userId, this.password);

		// NOTE:下記 実行するテーブルのDbProcとEntityを作成する
		TestTableDbProc db = new TestTableDbProc(conInfo);
		TestTableEntity te = db.executeSelect(sql.toString(), new TestTableEntity("1", "test", "20"));

		// 接続を解除
		db.close();

		System.out.print("データ : " + te.toString());

	}
}
