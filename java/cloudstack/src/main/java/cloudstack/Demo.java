package cloudstack;


import br.com.autonomiccs.apacheCloudStack.client.ApacheCloudStackClient;
import br.com.autonomiccs.apacheCloudStack.client.ApacheCloudStackRequest;
import br.com.autonomiccs.apacheCloudStack.client.beans.ApacheCloudStackUser;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String secretKey = "LsQRNf-zNAzre_nL6HfPoML_xIZHPX69h9AiToklCgvb8pbocWz2ZHDNgtjkoONwL779VUYff8f2FKWesq7eEw";
        String apiKey = "HCG9Clhvft9DlWECDA8ALl0I2QhmL2JjNBvO-Zne2voGTLnyjixcep3a7q3JSMo8_Q9ZkpRQ2S_IMf9A1FELUg";
        String cloudStackUrl = "http://172.16.10.10:8080/client/api";

        ApacheCloudStackUser apacheCloudStackUser = new ApacheCloudStackUser(secretKey, apiKey);
        ApacheCloudStackClient apacheCloudStackClient = new ApacheCloudStackClient(cloudStackUrl, apacheCloudStackUser);
//        apacheCloudStackClient.setValidateServerHttpsCertificate(tr);

        ApacheCloudStackRequest apacheCloudStackRequest = new ApacheCloudStackRequest("listTemplates");
        apacheCloudStackRequest.addParameter("response", "json");
        apacheCloudStackRequest.addParameter("templateFilter", "featured");

        String response = apacheCloudStackClient.executeRequest(apacheCloudStackRequest);
        System.out.println(response);


	}

}
