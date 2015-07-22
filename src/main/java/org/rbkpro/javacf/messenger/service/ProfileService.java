package org.rbkpro.javacf.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rbkpro.javacf.messenger.database.DataBaseClass;
import org.rbkpro.javacf.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DataBaseClass.getProfiles();
	
	public ProfileService () {
		profiles.put("rabeh", new Profile(1,"rabeh","rabeh","aoukaba"));
		//profiles.put("rbkpro", new Profile(2L,"rbkpro","rbkpro","developper"));
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

}
