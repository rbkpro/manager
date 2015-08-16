package org.rbkpro.javacf.messenger.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rbkpro.javacf.messenger.database.DataBaseClass;
import org.rbkpro.javacf.messenger.database.Database;
import org.rbkpro.javacf.messenger.database.FetchDatabase;
import org.rbkpro.javacf.messenger.model.Profile;


public class ProfileService {
	
	private Map<String, Profile> profiles = DataBaseClass.getProfiles();
	
	public ProfileService () {
		profiles.put("test", new Profile(1,"test","test","test"));
		profiles.put("rbkpro", new Profile(2,"rbkpro","rbkpro","developper"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
 	}
	
	
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
		
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		 profiles.put(profile.getProfileName(), profile);
		 return profile;
	}
	
	public void removeProfile(String profileName) {
		 profiles.remove(profileName);
		
	}
	
	public List<Profile> GetFeeds()throws Exception {
		ArrayList<Profile> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				FetchDatabase fetchDatabase= new FetchDatabase();
				feeds=fetchDatabase.GetFeeds(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}

}
