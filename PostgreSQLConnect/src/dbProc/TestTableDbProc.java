package dbProc;

import java.sql.ResultSet;

import entity.TestTableEntity;

/**
 * テストテーブルの操作を行ないます。
 *
 */
public class TestTableDbProc extends AbsDbProc<TestTableEntity>{

	/**
	 * コンストラクタ.
	 * <p>
	 * DBの接続に関する情報を引数で渡します。
	 * </p>
	 *
	 * @param conInfo
	 *            接続に関する情報
	 *
	 */
	public TestTableDbProc(ConnectInfo conInfo) {
		super(conInfo);
	}

	@Override
	public TestTableEntity executeSelect(String sql, TestTableEntity key) throws Exception {

		// プリペアードステートメントの設定
		this.preStatement = this.con.prepareStatement(sql);
		this.preStatement.setNString(0, key.getTestId());

		// SQLの実行
		ResultSet rs = this.preStatement.executeQuery();

		// 1件取得
		TestTableEntity ret = null;
		if (rs.next()) {
			// データがあれば、取得します。
			ret = new TestTableEntity();
			ret.setTestId(rs.getString(0));
			ret.setTestName(rs.getString(1));
			ret.setTestAge(rs.getString(2));
		}

		rs.close();
		this.preStatement.close();

		return ret;

	}

	@Override
	public void executeUpdate(String sql) {

	}
}
