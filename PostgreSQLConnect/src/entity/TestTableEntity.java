package entity;

/**
 * テスト用エンティティクラス
 */
public class TestTableEntity {

	/** テストID */
	private String testId;
	/** テスト名 */
	private String testName;
	/** テスト年齢 */
	private String testAge;

	/** デフォルトコンストラクタ */
	public TestTableEntity() {
	}

	/**
	 * コンストラクタ
	 *
	 * @param testId
	 *            テストID
	 * @param testName
	 *            テスト名
	 * @param testAge
	 *            テスト年齢
	 */
	public TestTableEntity(String testId, String testName, String testAge) {
		this.testId = testId;
		this.testName = testName;
		this.testAge = testAge;
	}

	/** テストIDを設定 */
	public void setTestId(String testId) {
		this.testId = testId;
	}

	/** テストIDを取得 */
	public String getTestId() {
		return this.testId;
	}

	/** テスト名を設定 */
	public void setTestName(String testName) {
		this.testName = testName;
	}

	/** テスト名を取得 */
	public String getTestName() {
		return this.testName;
	}

	/** テスト年齢を設定 */
	public void setTestAge(String testAge) {
		this.testAge = testAge;
	}

	/** テスト年齢を取得 */
	public String getTestAge() {
		return this.testAge;
	}

	@Override
	public String toString() {
		return "TestTableEntity [testId=" + testId + ", testName=" + testName
				+ ", testAge=" + testAge + "]";
	}

}
