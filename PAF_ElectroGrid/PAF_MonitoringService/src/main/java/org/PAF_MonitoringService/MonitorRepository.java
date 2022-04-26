package org.PAF_MonitoringService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorRepository {

	Connection con = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public MonitorRepository() {

		String url = "jdbc:mysql://127.0.0.1:3306/electrogrid";
		String driverName = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "";

		try {

			Class.forName(driverName);
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public String getMonitors() {

		String sql = "select * from monitoringservice";
		try {

			Statement st = con.createStatement();
			String output = "<table border=\"1\"><tr><th>Account Number</th>" + "<th>Number of Units</th> "
					+ "<th>Date and Time</th>" + "<th>Additional Units</th></tr>";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Monitor m = new Monitor();
				m.setAccountNo(rs.getInt(1));
				m.setCurrentUnits(rs.getInt(2));
				m.setDate(rs.getString(3));
				m.setAdditionalUnits(rs.getInt(4));

				output += "<tr><td>" + m.getAccountNo() + "</td>";
				output += "<td>" + m.getCurrentUnits() + "</td>";
				output += "<td>" + m.getDate() + "</td>";
				output += "<td>" + m.getAdditionalUnits() + "</td>";
			}
			output += "</table>";
			return output;

		} catch (Exception e) {
			System.out.print(e);
			return "Error occured during retrieving data";
		}

	}

	public Monitor getMonitor(int accNo) {

		Monitor m = new Monitor();
		String sql = "select * from monitoringservice where AccountNumber=" + accNo;
		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				m.setAccountNo(rs.getInt(1));
				m.setCurrentUnits(rs.getInt(2));
				m.setDate(rs.getString(3));

			}

		} catch (Exception e) {
			System.out.print(e);
		}
		return m;
	}

	public void create(Monitor m1) {

		String sql = "insert into monitoringservice values (?,?,?)";

		try {

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, m1.getAccountNo());
			st.setInt(2, m1.getCurrentUnits());
			st.setString(3, formatter.format(new Date()).toString());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public void update(Monitor m1) {

		String sql = "update monitoringservice set  NoOfUnits=? where  AccountNumber=?";

		try {

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(2, m1.getAccountNo());
			st.setInt(1, m1.getCurrentUnits());
			// st.setString(3, formatter.format(new Date()).toString());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public void delete(int accNo) {
		String sql = "delete from monitoringservice  where  AccountNumber=?";

		try {

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, accNo);
			// st.setInt(1, m1.getCurrentUnits());
			// st.setString(3, formatter.format(new Date()).toString());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public String readBill(int Accno, int month) {
		String output = "";
		try {
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Bill ID</th><th>Month</th>" + "<th>Amount</th>" + "<th>Unit Rate</th>"
					+ "<th>Units Used</th><th>Account Number</th></tr>";

			String query = "select * from bill where Account_number=" + Accno + " and month=" + month + "";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
// iterate through the rows in the result set
			while (rs.next()) {
				String BillID = rs.getString("Bill_id");
				String Month = Integer.toString(rs.getInt("Month"));
				String Amount = Integer.toString(rs.getInt("Amount"));
				String UnitRate = Double.toString(rs.getDouble("Unit_rate"));
				String usedUnits = Integer.toString(rs.getInt("used_units"));
				String Account = Integer.toString(rs.getInt("Account_number"));

// Add into the html table
				output += "<tr><td>" + BillID + "</td>";
				output += "<td>" + Month + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + UnitRate + "</td>";
				output += "<td>" + usedUnits + "</td>";
				output += "<td>" + Account + "</td>";
// buttons
				output += "</tr>";
			}
			con.close();
// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Bill data";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
