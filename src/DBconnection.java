
//2

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnection {

	public static int currentUserId = 0;

	public static Connection connect() throws ClassNotFoundException {

		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:dailyRp.db");
			System.out.println("Connection to SQLite has been established.");
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println();
			return null;
		}
	}

	public static int Login(Connection conn, String UserName, String Password) {

		int userId = 0;
		try {
			String sql = "select * from Users where username=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, UserName);
			pst.setString(2, Password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				userId = Integer.parseInt(rs.getString("UserId"));
			}
			rs.close();
			pst.close();

		} catch (SQLException e1) {
			userId = 0;
			System.out.println(e1.getMessage());
		}
		return userId;
	}

	public static ResultSet LoadVrc(Connection conn) {
		ResultSet rs = null;
		try {
			String sql = "select * from VRC";
			PreparedStatement pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			// rs.close();
			// pst.close();

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return rs;
	}

	public static boolean Insert(Connection conn, int vrcId, int cardsDistrinutedPC, int cardsDistrinutedPVC,
			int cardsReturned, int entryDay, int entryMonth, int entryYear, int userId) {
		try {
			String sql = "INSERT INTO Entry(VrcId, CardsDistrinutedPC,CardsDistrinutedPVC"
					+ ",CardsReturned,EntryDay,EntryMonth,EntryYear,UserId ) " + "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, vrcId);
			pst.setInt(2, cardsDistrinutedPC);
			pst.setInt(3, cardsDistrinutedPVC);
			pst.setInt(4, cardsReturned);
			pst.setInt(5, entryDay);
			pst.setInt(6, entryMonth);
			pst.setInt(7, entryYear);
			pst.setInt(8, userId);
			pst.execute();
			pst.close();
			return true;

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			return false;
		}
	}

	public static ResultSet LoadTable(Connection conn, int day, int month, int year) {
		ResultSet rs = null;
		try {
			String sql = "select 'EntryId','VRC ID','VRC Name','Cards Distrinuted PC','Cards Distrinuted PVC'\n"
					+ ",'Cards Returned','Entry Day','Entry Month','Entry Year','Full Name'\n" + "union\n"
					+ "select e.EntryId,e.VrcId,v.VrcName\n"
					+ ",e.CardsDistrinutedPC,e.CardsDistrinutedPVC,e.CardsReturned\n"
					+ ",e.EntryDay,e.EntryMonth,e.EntryYear,u.FullName\n" + "from Entry e\n"
					+ "inner join Users u on e.UserId=u.UserId\n" + "inner join VRC v on e.vrcId=v.VrcId\n"
					+ "where EntryDay=? and EntryMonth=? and EntryYear=?\n" + "order by EntryId desc\n" + ";";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, day);
			pst.setInt(2, month);
			pst.setInt(3, year);
			rs = pst.executeQuery();
			// rs.close();
			// pst.close();

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		return rs;
	}

	public static boolean Update(Connection conn, int cardsDistrinutedPC, int cardsDistrinutedPVC, int cardsReturned,
			int entryDay, int entryMonth, int entryYear, int userId, int entryId) {
		try {
			String sql = "update Entry set CardsDistrinutedPC=?,CardsDistrinutedPVC=?,CardsReturned=?,EntryDay=?,EntryMonth=?,EntryYear=?,UserId=? where EntryId=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cardsDistrinutedPC);
			pst.setInt(2, cardsDistrinutedPVC);
			pst.setInt(3, cardsReturned);
			pst.setInt(4, entryDay);
			pst.setInt(5, entryMonth);
			pst.setInt(6, entryYear);
			pst.setInt(7, userId);
			pst.setInt(8, entryId);
			pst.execute();
			pst.close();
			return true;

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			return false;
		}
	}

	public static boolean Delete(Connection conn, int entryId) {
		try {
			String sql = "delete from Entry where EntryId=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, entryId);
			pst.execute();
			pst.close();
			return true;

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			return false;
		}
	}

}
