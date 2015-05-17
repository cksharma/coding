package com.onmobile.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PlayerDAO 
{
	private DataSource dataSource;
	
	public PlayerDAO()
	{
		super();
		try
		{
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	public Player getPlayerDetails(int playerId) throws DatabaseException
	{
		Player p = null;
		try {
			Connection con = dataSource.getConnection();
			String sql = "select * from player where player_id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, playerId);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				p = new Player();
				p.setPlayerId(rs.getInt(1));
				p.setPlayerName(rs.getString(2));
				p.setSportsCode(rs.getString(3));
				p.setCountryCode(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseException("Unable to connect to / retrive from DB / insert into DB" + e.getMessage());
		}
		return p;
	}
	public boolean successfulAddPlayer(int playerId, String playerName, String sportsCode, String countryCode) throws DatabaseException
	{
		int p = 0;
		try
		{
			System.out.println("Disconnected");
			Connection con = dataSource.getConnection();
			System.out.println("connected");
			String sql = "insert into player values(?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, playerId);
			pst.setString(2, playerName);
			pst.setString(3, sportsCode);
			pst.setString(4, countryCode);
			System.out.println("hero");
			p = pst.executeUpdate();
			System.out.println("executed huwa connected");
		}	
		catch (SQLException e) {
			throw new DatabaseException("Unable to connect to / retrieve from DB");
	 	}
		return p > 0;
	}
}