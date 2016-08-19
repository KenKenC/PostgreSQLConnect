package dbProc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public abstract class AbsDbProc<T> {

	/** ドライバ */
	private static final String DRIVER = "org.postgresql.Driver";

	/** 接続情報 */
	private final ConnectInfo conInfo;
	/** 接続URL */
	private final String url;

	/** DB接続 */
	protected Connection con;
	/** ステートメント */
	protected PreparedStatement preStatement;

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
	public AbsDbProc(ConnectInfo conInfo) {
		this.conInfo = conInfo;
		this.url = "jdbc:postgresql://" + this.conInfo.getServer() + "/"
				+ this.conInfo.getDbName();
	}

	/**
	 * DBとの接続を開始します。
	 *
	 * @throws Exception
	 */
	public void open() throws Exception {
		// JDBCを使う合図
		Class.forName(DRIVER);

		// 接続開始
		this.con = DriverManager.getConnection(this.url,
				this.conInfo.getUserId(), this.conInfo.getPassword());
	}

	public void close() throws Exception {

		this.con.close();

	}

	/**
	 * 検索処理を行ないます。 <br />
	 * Select etc
	 */
	public abstract T executeSelect(String sql, T key) throws Exception;

	/**
	 * 更新処理を行ないます。<br />
	 * Insert, Update, Delete etc...
	 */
	public abstract void executeUpdate(String sql);

}
