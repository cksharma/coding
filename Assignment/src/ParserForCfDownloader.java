import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class Status {
	Set <Integer> requestId;
	Set <String> contentType;
	int successCount;
	int failureCount;
	Set <Integer> httpResponse;
	
	public Status(Set<Integer> requestId, Set<String> contentType, int successCount, int failureCount, Set <Integer> httpResponse) {
		super();
		this.requestId = requestId;
		this.contentType = contentType;
		this.successCount = successCount;
		this.failureCount = failureCount;
		this.httpResponse = httpResponse;
	}	
}

class Pair {
	int successCount;
	int failureCount;
	Set <Integer> set;
	public Pair(int successCount, int failureCount, Set <Integer> set) {
		super();
		this.successCount = successCount;
		this.failureCount = failureCount;
		this.set = set;
	}
	public Pair() {
		super();		
	}	
}

public class ParserForCfDownloader {
	
	public static Map <String, Status> hmapSiteId = new HashMap <String, Status> ();
	
	public static Map <Integer, Pair> hmapRequestId = new HashMap <Integer, Pair> ();
	
	public static FileWriter writer;
	
	private static int totalSuccess;
	private static int totalFailure;
	
	public static void printRequestIdWise() throws IOException {
		//System.out.println("Request ID           SuccessCount      FailureCount");
		//System.out.println("====================================================");
		writer.write("Request ID           SuccessCount      FailureCount      StatusSet\n");
		writer.write("=====================================================================\n");
		for (Integer reqId : hmapRequestId.keySet()) {
			Pair pair = hmapRequestId.get(reqId); 
			int totalCount = pair.failureCount + pair.successCount;
			totalSuccess += pair.successCount;
			totalFailure += pair.failureCount;
			int percentSuccess = (int)Math.round(pair.successCount * 1./ totalCount * 100.);
			int percentFailure = (int)Math.round(pair.failureCount * 1./ totalCount * 100.);
			String str = reqId + "                    " + (pair.successCount) + " (" + percentSuccess + " %)" + "              " + (pair.failureCount) + " (" + percentFailure + " %)" + "          " + pair.set;
			//System.out.println(reqId + "                    " + (pair.successCount) + " (" + percentSuccess + " %)" + "              " + (pair.failureCount) + " (" + percentFailure + " %)");			
			//System.out.println();
			writer.write(str);
			writer.write("\n");
		} 
		int total = totalSuccess + totalFailure;
		int totalSuccessPercent = (int)Math.round(totalSuccess * 1./ total * 100.);
		int totalFailurePercent = (int)Math.round(totalFailure * 1./ total * 100.);
		writer.write("------------------------------------------------------------------------------\n");
		writer.write("Total             " + totalSuccess + " ( " + totalSuccessPercent + "% )" +  "           " + totalFailure + " ( " + totalFailurePercent + "% )");
		//System.out.println();
		writer.write("\n\n\n");
		writer.write("---------------------------------------------------------------------------------\n");
	}
	
	public static void printSiteIdWise() throws IOException {
		//System.out.println("Site ID                                  RequestId                             contentType                                                                                                             successCount                  FailureCount");
		//System.out.println("=======================================================================================================================================================================================================================================================");
		writer.write("Site ID                                  RequestId                             contentType                                                                                                             successCount                  FailureCount         HttpResponseCodes         \n");
		writer.write("=============================================================================================================================================================================================================================================================================\n");
		for (String siteId : hmapSiteId.keySet()) {
			Status status = hmapSiteId.get(siteId);
			String str = siteId;
			int totalCount = status.failureCount + status.successCount;
			int successPercent = (int)Math.round(1. * status.successCount /totalCount * 100.);
			int failurePercent = (int)Math.round(1. * status.failureCount /totalCount * 100.);
			while(str.length() < 40) str = str + " ";
			str += status.requestId;
			while(str.length() < 80) str = str + " ";
			str += status.contentType;
			while(str.length() < 200) str = str + " ";
			str += status.successCount + " (" + successPercent + " %)";
			while(str.length() < 220) str = str + " ";
			str += status.failureCount + " (" + failurePercent + " %)";
			while(str.length() < 250) str = str + "  ";
 			//System.out.println(siteId  + "                " + status.requestId +  "                      " + status.contentType + "                                                 " + status.successCount + "                                 " + status.failureCount);
			//System.out.println(str);
			str += status.httpResponse;
			writer.write(str);
			writer.write("\n");
		}
	}
	
	public static int getHttpResponse(String requestUrl) {
		int indexOfHttp = requestUrl.indexOf("HTTP/1.1\" ");
		int ans = -999;
		if(indexOfHttp != -1) {
			String str = requestUrl.substring(indexOfHttp, indexOfHttp + 13);
			StringTokenizer stk = new StringTokenizer(str, " ");
			//System.out.print(stk.nextToken() + "  ");
			stk.nextToken();
			ans = Integer.parseInt(stk.nextToken());
			//System.out.println(ans);
		}	
		return ans;
	}
	
	public static void parseAndProcessRequest(String requestUrl) {
		if (requestUrl.contains("centralfd")) {
			int indexOfReqId = requestUrl.indexOf("REQID");
			int indexOfSiteId = requestUrl.indexOf("&SITEID");
			int indexOfContentType = requestUrl.indexOf("&CONTENTTYPE");
			int indexOfSiteIp = requestUrl.indexOf("&SITEIP");
			
			if(indexOfReqId > -1 && indexOfSiteId > -1 && indexOfContentType > -1 && indexOfSiteIp > -1) {
				
				//System.out.println(indexOfReqId + " " + indexOfSiteId + " " + indexOfContentType + " " + indexOfSiteIp);
				
				String strReqId = requestUrl.substring(indexOfReqId, indexOfSiteId);
				int requestId = Integer.parseInt(strReqId.split("=")[1]);
				//System.out.println(requestId);
				
				String strSiteId = requestUrl.substring(indexOfSiteId + 1, indexOfContentType);
				strSiteId = strSiteId.split("=")[1];
				//System.out.println(strSiteId);
				
				String strContentType = requestUrl.substring(indexOfContentType + 1, indexOfSiteIp);
				strContentType = strContentType.split("=")[1];
				//System.out.println(strContentType);
				
				int httpResponse = getHttpResponse(requestUrl);
				//System.out.println(httpResponse);
		
				if(hmapRequestId.containsKey(requestId)) {
					
					Pair pair = hmapRequestId.get(requestId);
					if(httpResponse == 200) {
						pair.successCount++;
					} else {
						pair.failureCount++;
					}
					if (httpResponse != -999)
						pair.set.add(httpResponse);
					//System.out.println("Inside if " + httpResponse);
				} else {
					Set <Integer> st = new HashSet <Integer> (); 
					if(httpResponse != -999) st.add(httpResponse);
					if(httpResponse == 200)
						hmapRequestId.put(requestId, new Pair(1, 0, st));
					else 
						hmapRequestId.put(requestId, new Pair(0, 1, st));
					//System.out.println("Inside else if " + httpResponse);
				}
				Status status = null;
				if(hmapSiteId.containsKey(strSiteId)) {
					status = hmapSiteId.get(strSiteId);
					if(httpResponse == 200) status.successCount++;
					else status.failureCount++;
					status.contentType.add(strContentType);
					status.requestId.add(requestId);
					if(httpResponse != -999)
						status.httpResponse.add(httpResponse);
				} else {
					Set <Integer> st = new HashSet <Integer> ();
					if(httpResponse != -999) st.add(httpResponse);
					if(httpResponse == 200) 
						status = new Status(new HashSet <Integer> (), new HashSet <String> (), 1, 0,  st);
					else 
						status = new Status(new HashSet <Integer> (), new HashSet <String> (), 0, 1, st);
					hmapSiteId.put(strSiteId, status);
				}
			} else if (indexOfReqId > -1) {
				String str = requestUrl.substring(indexOfReqId, indexOfReqId + 7);
				StringTokenizer stk = new StringTokenizer(str, "=");
				stk.nextToken();
				int requestId = Integer.parseInt(stk.nextToken());
				int httpResponse = getHttpResponse(requestUrl);
				if(hmapRequestId.containsKey(requestId)) {
					Pair pair = hmapRequestId.get(requestId);
				
					if(httpResponse == 200 ) {
						pair.successCount++;
					} else {
						pair.failureCount++;
					}
					if(httpResponse != -999)
						pair.set.add(httpResponse);
				} else {
					Set <Integer> st = new HashSet <Integer> (); 
					if(httpResponse != -999) st.add(httpResponse);
					if(httpResponse == 200)
						hmapRequestId.put(requestId, new Pair(1, 0, st));
					else 
						hmapRequestId.put(requestId, new Pair(0, 1, st));
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the file path.. Complete file path");
		Scanner si = new Scanner(System.in);
		String fileName = si.nextLine();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				parseAndProcessRequest(line);
				line = br.readLine();
				//break;
			}
			br.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			writer = new FileWriter("E:\\temp\\logs.log");
			printRequestIdWise();
			printSiteIdWise();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
			e.printStackTrace();
		}
		System.out.println("completed parsing");
	}
}
