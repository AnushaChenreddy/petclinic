package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GitHubRestClient {

	public static void main(String[] args) throws Exception {
		GitHubRestClient prototype = new GitHubRestClient();

		// XXXXXX refer to username, password

		String jsonOpen = prototype.requestIssues("AnushaChenreddy",
				"Chenreddy$1", "/repos" + "/Villanova-SoftwareStudio"
						+ "-Spring2014/achenreddy-private-repo" + "/issues");
		String jsonClosed = prototype.requestIssues("AnushaChenreddy",
				"Chenreddy$1", "/repos/Villanova-SoftwareStudio"
						+ "-Spring2014/achenreddy-private-repo"
						+ "/issues?state=closed");

		System.out.println(jsonOpen);
		System.out.println(jsonClosed);

		IssueParser parserObject = new IssueParser();
		ArrayList<Issue> issues = new ArrayList<Issue>();
		List<Issue> issuesClosed = new ArrayList<Issue>();
		issues = (ArrayList<Issue>) parserObject.parseIssues(jsonOpen);
		issuesClosed = parserObject.parseIssues(jsonClosed);

		System.out.println(issues);
		System.out.println(issuesClosed);

		issues.addAll(issuesClosed);
		System.out.println(issues);

		Collections.sort(issues);
		System.out.println(issues);

		IssuesExporter exporterObject = new IssuesExporter();
		exporterObject.numberOfIssues(issues);
		exporterObject.writeToFile(issues);
	}

	/*
	 * method makes a get request to the uri passed to it with given credentials
	 */
	public String requestIssues(String username, String password, String uri)
			throws Exception {

		BufferedReader reader = null;
		String jsonContent = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;

		try {

			HttpHost target = new HttpHost("api.github.com", 443, "https");
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(target.getHostName(),
					target.getPort()), new UsernamePasswordCredentials(
					username, password));

			httpclient = HttpClients.custom()
					.setDefaultCredentialsProvider(credsProvider).build();

			// Create AuthCache instance
			AuthCache authCache = new BasicAuthCache();
			// Generate BASIC scheme object and add it to the local
			// auth cache
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(target, basicAuth);

			// Add AuthCache to the execution context
			HttpClientContext localContext = HttpClientContext.create();
			localContext.setAuthCache(authCache);

			HttpGet httpget = new HttpGet(uri);

			response = httpclient.execute(target, httpget, localContext);
			System.out.println(response.getStatusLine());

			HttpEntity entity = response.getEntity();

			reader = new BufferedReader(new InputStreamReader(
					entity.getContent()));

			jsonContent = reader.readLine();

			EntityUtils.consume(entity);

		} catch (ClientProtocolException e) {
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (httpclient != null) {
				httpclient.close();
			}
			if (response != null) {
				response.close();
			}
		}
		return jsonContent;
	}

}
