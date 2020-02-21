package com.lin.json;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private static List<String> urls = Arrays.asList("http://localhost:8080/hot-app/services/customer-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/billing-benefits-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/billing-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/billing-personal-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/customercore-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/accumulators/v1/swagger.json",
            "http://localhost:8080/hot-app/services/claims-rs/v1/dev/swagger.json",
            "http://localhost:8080/hot-app/services/claims-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/claims-dental/v1/swagger.json",
            "http://localhost:8080/hot-app/services/claims-health/v1/swagger.json",
            "http://localhost:8080/hot-app/services/claims-provider-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/product-decision-tables/v1/swagger.json",
            "http://localhost:8080/hot-app/services/product-dt-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/product-rt-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/PfRestful/swagger.json",
            "http://localhost:8080/hot-app/services/platform-rs/v1/activities/swagger.json",
            "http://localhost:8080/hot-app/services/ead/swagger.json",
            "http://localhost:8080/hot-app/services/platform-rs/v1/entities/swagger.json",
            "http://localhost:8080/hot-app/services/propagation/swagger.json",
            "http://localhost:8080/hot-app/services/i18n/swagger.json",
            "http://localhost:8080/hot-app/services/platform-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/openl-rs/swagger.json",
            "http://localhost:8080/hot-app/services/security-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/docgen-rs/swagger.json",
            "http://localhost:8080/hot-app/services/docgen-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/efolder-rs/swagger.json",
            "http://localhost:8080/hot-app/services/efolder-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/platform-rs/v1/scheduler/swagger.json",
            "http://localhost:8080/hot-app/services/thirdparty-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/alerts-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/notes-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/bulletin-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/bpm-rs/v1/work/swagger.json",
            "http://localhost:8080/hot-app/services/party-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/policy-group-enrollment-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/policy-group-qa-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/policy-group-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/policy-rs/v1/swagger.json",
            "http://localhost:8080/hot-app/services/preconfig-pl-rs/v1/swagger.json"
    );

    public static void main(String[] args) throws Exception {
        for (int i = 0; i <urls.size() ; i++) {
            printList(getResponse(urls.get(i)));
        }

    }

    private static void printList(String json) throws JSONException {
        JSONObject obj = new JSONObject(json);
        String title = obj.getJSONObject("info").getString("title");

        JSONArray paths = null;
        try {
            paths = obj.getJSONObject("paths").names();
        } catch (Exception e) {
            System.out.println("============parse exception with title="+title);
            return;
        }

        for (int i = 0; i < paths.length(); i++) {
            String path = paths.get(i).toString();
            String method = obj.getJSONObject("paths").getJSONObject(path).names().get(0).toString();
            String summary = "[No Summary]";
            try {
                summary = obj.getJSONObject("paths").getJSONObject(path).getJSONObject(method).getString("summary");
            } catch (JSONException e) {
                System.out.println("============parse exception with title and path="+title+":"+path);
            }

            System.out.println(title + "\t" + path + "\t" + method + "\t" + summary);

        }
    }


    private static String getResponse(String url) {

        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials("qa", "qa");
        provider.setCredentials(AuthScope.ANY, credentials);

        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();


        HttpGet request = new HttpGet(url);

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity);
//            System.out.println(content);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
