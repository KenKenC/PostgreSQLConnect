package dbProc;

import java.io.Serializable;

public class ConnectInfo implements Serializable {

	/** サーバ(ホスト名) */
	private final String server;
	/** DB名 */
	private final String dbName;
	/** ユーザID */
	private final String userId;
	/** パスワード */
	private final String password;

	/**
	 * コンストラクタ.
	 * <p>
	 * DBの接続に関する情報を引数で渡します。
	 * </p>
	 *
	 * @param server
	 *            サーバ(ホスト名)
	 * @param dbName
	 *            DB名
	 * @param userId
	 *            ユーザID
	 * @param password
	 *            パスワード
	 */
	public ConnectInfo(String server, String dbName, String userId,
			String password) {
		this.server = server;
		this.dbName = dbName;
		this.userId = userId;
		this.password = password;
	}

	/** サーバ(ホスト名)を取得 */
	public String getServer() {
		return server;
	}

	/** DB名を取得 */
	public String getDbName() {
		return dbName;
	}

	/** ユーザIDを取得 */
	public String getUserId() {
		return userId;
	}

	/** パスワードを取得 */
	public String getPassword() {
		return password;
	}

}
