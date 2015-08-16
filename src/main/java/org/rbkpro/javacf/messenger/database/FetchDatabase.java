package org.rbkpro.javacf.messenger.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.rbkpro.javacf.messenger.model.Profile;



public class FetchDatabase {
	
	private String GET_PROFILES= "SELECT title,description,url FROM website ORDER BY _id DESC";
	
	public ArrayList<Profile> GetFeeds(Connection connection) throws Exception
	{
		ArrayList<Profile> feedData = new ArrayList<Profile>();
		try
		{
			PreparedStatement ps = connection.prepareStatement(GET_PROFILES);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Profile profile = new Profile();
				profile.setFirstName(rs.getString("title"));
				profile.setLastName(rs.getString("description"));
				profile.setProfileName(rs.getString("url"));
				feedData.add(profile);
			}
			return feedData;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}

