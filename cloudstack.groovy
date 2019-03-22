
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.net.URL; 
import java.net.URLEncoder;
import groovy.json.JsonSlurper
import groovy.json.JsonOutput;
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.SecureRandom;

//Cloudstack Groovy Client
class Cloudstack {
    //parameters for the contructor method
    String endpoint,api_key,secret_key,command
    Map cmdParams = [:]

    //constructor
    Cloudstack(pEndPoint,pApiKey,pSecretKey){
        this.endpoint = pEndPoint;
        this.api_key = pApiKey
        this.secret_key = pSecretKey
    }

    //Set the endpoint
    def setEndPoint(pEndPoint){
        this.endpoint = pEndPoint;
    }
    
    //Set the api key
    def setApiKey(pApiKey){
        this.api_key = pApiKey
    }

    //Set secret key
    def setSecretKey(pSecretKey){
        this.secret_key = pSecretKey
    }
    
    //Return api key
    def getApiKey(){
        return this.api_key;
    }
    //Return secret key
    def getSecretKey(){
        return this.secret_key;
    }
    //Return endpoint
    def getEndPoint(){
        return this.endpoint + '?' 
    }

    //Return command
    def getCommand(){
        return this.command
    }
    def runCommand(pParams = [:],pCommand){
        
        if (pParams.isEmpty()){
            this.command = pCommand
        }else {
            //this.command = pCommand.join('&').toString() +  pParams.collect {k,v -> "$k=$v"}.join('&').toString()
            this.command = pCommand 
            this.cmdParams = pParams
        } 
    }
    def setApiCommand(){
        def params = [
            apikey: getApiKey(),
            command: getCommand(),
            response: "json",
            signature: signApiRequest()
        ]
        def queryString = params + this.cmdParams
        queryString = queryString.collect { k,v -> "$k=$v"}.join('&')
        return queryString
    }
    def transformCommandString(){
        def params = [
            command: getCommand(),
            response: "json",
            apikey: getApiKey()
        ]
        def signature_string = params + this.cmdParams
        signature_string = signature_string.collect { k,v -> "$k=$v".toLowerCase()}.sort().join('&')
        return signature_string
    }

    def getApiRequest(){
       return getEndPoint() + setApiCommand()
    } 

    def signApiRequest(){
        def secret = getSecretKey()
        def message = transformCommandString()
        def signature
        try {
            Mac mac = Mac.getInstance("HmacSHA1")
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA1")
            mac.init(secretKeySpec)
            byte[] digest = mac.doFinal(message.getBytes("UTF-8"))
            signature = digest.encodeBase64().toString()
            signature = URLEncoder.encode(signature,"UTF-8").replaceAll("\\+", "%20");
        }catch (InvalidKeyException e) {
            throw new RuntimeException("Invalid key exception while converting to HMac SHA1")
        }
        return signature
    }
    def makeApiCall(){
        def sc = SSLContext.getInstance("SSL")
        def trustAll = [getAcceptedIssuers: {}, checkClientTrusted: { a, b -> }, checkServerTrusted: { a, b -> }]
        sc.init(null, [trustAll as X509TrustManager] as TrustManager[], new SecureRandom())
        HttpsURLConnection.defaultSSLSocketFactory = sc.socketFactory
        def connection = new URL(getApiRequest()).openConnection() as HttpURLConnection
        def pretty = JsonOutput.prettyPrint(connection.inputStream.text)
        println pretty
    }
    def returnTemplates(){
        def tconnection = new URL(getApiRequest()).openConnection() as HttpURLConnection
        def pretty = JsonOutput.prettyPrint(tconnection.inputStream.text)
        def jsonSlupper = new JsonSlurper()
        def templates = jsonSlupper.parseText(pretty)
        return templates.listtemplatesresponse.template.each{ "${it}" }.name
    }
    def returnOsTypes(){
        def oconnection = new URL(getApiRequest()).openConnection() as HttpURLConnection
        def pretty = JsonOutput.prettyPrint(oconnection.inputStream.text)
        def jsonSlupper = new JsonSlurper()
        def os_list = jsonSlupper.parseText(pretty)
        return os_list.listostypesresponse.ostype.each{ "${it}" }.description
    }
    def returnZones(){
        def zconnection = new URL(getApiRequest()).openConnection() as HttpURLConnection
        def pretty = JsonOutput.prettyPrint(zconnection.inputStream.text)
        def jsonSlupper = new JsonSlurper()
        def zone = jsonSlupper.parseText(pretty)
        return zone.listzonesresponse.zone.each{ "${it}" }.name
    }
    def disableSSL(){
        def sc = SSLContext.getInstance("SSL")
        def trustAll = [getAcceptedIssuers: {}, checkClientTrusted: { a, b -> }, checkServerTrusted: { a, b -> }]
        sc.init(null, [trustAll as X509TrustManager] as TrustManager[], new SecureRandom())
        HttpsURLConnection.defaultSSLSocketFactory = sc.socketFactory
        // hostnameVerifier = [verify: { hostname, session -> true }]
        // HttpsURLConnection.defaultSSLSocketFactory = sc.socketFactory
        // HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier as HostnameVerifier)
    }
}

def endpoint = "http://172.16.10.10:8080/client/api"
def key = "HCG9Clhvft9DlWECDA8ALl0I2QhmL2JjNBvO-Zne2voGTLnyjixcep3a7q3JSMo8_Q9ZkpRQ2S_IMf9A1FELUg"
def secret = "LsQRNf-zNAzre_nL6HfPoML_xIZHPX69h9AiToklCgvb8pbocWz2ZHDNgtjkoONwL779VUYff8f2FKWesq7eEw"
    
Cloudstack client = new Cloudstack(endpoint,key,secret )
client.disableSSL()            
client.runCommand('listTemplates',templatefilter: 'featured')
client.makeApiCall()


