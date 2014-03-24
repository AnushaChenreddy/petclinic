package com.studio.ghissues1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IssueParser {
	public List<Issue> parseIssues(String input) {
		// ArrayList<Issue> issues = new ArrayList<Issue>();
		// return issues;
		List<Issue> issues = null;
		try {

			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
					.setFieldNamingPolicy(
							FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.create();
			issues = new ArrayList<Issue>();
			Type collectionType = new TypeToken<List<Issue>>() {
			}.getType();
			issues = gson.fromJson(input, collectionType);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return issues;

	}
}
