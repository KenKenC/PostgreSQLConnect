package mainProc;

import dbProc.ConnectInfo;
import dbProc.TestTableDbProc;
import entity.TestTableEntity;

public class MainProcCls {

	/** サーバホスト */
	private String server = "";
	/** DB名 */
	private String dbName = "";
	/** 接続ユーザID */
	private String userId = "";
	/** 接続パスワード */
	private String password = "";

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

		TestTableDbProc db = new TestTableDbProc(conInfo);
		TestTableEntity te = db.executeSelect(sql.toString(), new TestTableEntity("1", "test", "20"));

		// 接続を解除
		db.close();

		System.out.print("データ : " + te.toString());

	}
}
