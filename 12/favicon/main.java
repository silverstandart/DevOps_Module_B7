package favicon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class main {

	static String gl_siteUrl = "";

	static void faviconDownloader() throws ClientProtocolException, IOException {

		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();

			HttpGet request = new HttpGet(gl_siteUrl + "/favicon.ico");
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();

			int responseCode = response.getStatusLine().getStatusCode();

			System.out.println("Request Url: " + request.getURI());
			System.out.println("Response Code: " + responseCode);

			InputStream is = entity.getContent();

			final String dir = System.getProperty("user.dir");
			System.out.println("Current folder path = " + dir);

			String filePath = dir + "/favicon.ico";

			FileOutputStream fos = new FileOutputStream(new File(filePath));

			int inByte;
			while ((inByte = is.read()) != -1) {
				fos.write(inByte);
			}

			is.close();
			fos.close();

			client.close();
			System.out.println("File Download Completed!!!");

			System.out.println("Downloaded favicon.ico path is = " + filePath);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Favicon Crated by Andrey 2022_02_07\n");
		if (args != null && args.length > 0) {
			gl_siteUrl = args[0];
			System.out.println("SiteUrl=" + gl_siteUrl);
		}
		try {
			if (!"".equalsIgnoreCase(gl_siteUrl))
				faviconDownloader();
			else
				System.out.println("Please specify SiteUrl as argument for example http://microsoft.com");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
