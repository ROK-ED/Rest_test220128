package co.micol.prj.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BankAPI {

	public static void main(String[] args) {
		// Map<String, Object> map = BankAPI.getBalanceInfo();
		// Map<String, Object> map = BankAPI.getTransactionInfo();
		//Map<String, Object> map = BankAPI.getInquiryInfo();
		
		BankVO vo = new BankVO();
		vo.setAccessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY1Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDkwMTQsImp0aSI6IjY1MTIxMTU3LTMwZjgtNDE1MC04MTQ3LWYzZTNhZDU4MWI2YiJ9.gzjNQGA1ouGKN6KQmKyUh4tooGL8h1_glUfTgmhMhvk");
		vo.setFintechUseNum("120220019288941082451817");
		Map<String,Object> map = new BankAPI().getBalanceInfo(vo);
		
		//System.out.println(map);
	}

	String use_org_code = "M202200192";
	String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMjAwMTkyIiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjUxNjMwMzQ1LCJqdGkiOiJkZTZlODQ0Ni00MzI1LTQ3ZTYtOGJjZC1mMDA5ODEwNDdkOTIifQ.om96Y065MXN5IpwYgH_hPJqoWvzjuCF5Bjr0N9HfWrc";

	//public static long seq = 20;
	
	public String getSequence() {
		//seq++;
		//String strSeq = "00000000" + seq;

		// 9자리로 1씩 증가된 값을 생성, 랜덤, 시간
		long t1 = System.nanoTime();
		//long t2 = System.currentTimeMillis();
		//System.out.println(t1);
		//System.out.println(t2);
		
		String result = String.valueOf(t1).substring(6);
		//String result = String.valueOf(t1);
		//result = result.substring(result.length()-9);
		
		System.out.println(result);

		return result;
	}

	public String getDate() {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		result = sdf.format(date);
		return result;
	}

	// public static Map<String, Object> getBalanceInfo() {
	public Map<String, Object> getBalanceInfo(BankVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num";

		//String param = "bank_tran_id=" + use_org_code + "U" + "000000025";
		String param = "bank_tran_id=" + use_org_code + "U" + getSequence();
		param += "&tran_dtime=" + getDate();
		// param += "&fintech_use_num=" + "120220019288941082451817";
		param += "&fintech_use_num=" + vo.getFintechUseNum();

		HttpHeaders headers = new HttpHeaders();
		// String org_access_token =
		// "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY1Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDkwMTQsImp0aSI6IjY1MTIxMTU3LTMwZjgtNDE1MC04MTQ3LWYzZTNhZDU4MWI2YiJ9.gzjNQGA1ouGKN6KQmKyUh4tooGL8h1_glUfTgmhMhvk";
		// headers.set("Authorization", "Bearer " + org_access_token);
		headers.set("Authorization", "Bearer " + vo.getAccessToken());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		return response.getBody();

	}

	public Map<String, Object> getAccountInfo(BankVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/list";

		//String param = "user_seq_no=" + vo.getUserSeqNo();
		//param += "&include_cancel_yn=" + "Y";
		//param += "&sort_order=" + "D";
		
		StringBuffer param = new StringBuffer();
		param.append("user_seq_no=" + vo.getUserSeqNo());
		param.append("&include_cancel_yn=" + "Y");
		param.append("&sort_order=" + "D");

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + vo.getAccessToken());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		return response.getBody();
	}
	
	// public static Map<String, Object> getTransactionInfo() {
	public Map<String, Object> getTransactionInfo(BankVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/transaction_list/fin_num";

		String param = "bank_tran_id=" + use_org_code + "U" + "000000026";
		// param += "&fintech_use_num=" + "120220019288941082451817";
		param += "&fintech_use_num=" + vo.getFintechUseNum();
		param += "&inquiry_type=" + "A";
		param += "&inquiry_base=" + "D";
		param += "&from_date=" + "20190101";
		param += "&to_date=" + "20220128";
		param += "&sort_order=" + "D";
		param += "&tran_dtime=" + getDate();

		HttpHeaders headers = new HttpHeaders();
		// String org_access_token =
		// "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY1Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDkwMTQsImp0aSI6IjY1MTIxMTU3LTMwZjgtNDE1MC04MTQ3LWYzZTNhZDU4MWI2YiJ9.gzjNQGA1ouGKN6KQmKyUh4tooGL8h1_glUfTgmhMhvk";
		// headers.set("Authorization", "Bearer " + org_access_token);
		headers.set("Authorization", "Bearer " + vo.getAccessToken());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		return response.getBody();

	}

	// public static Map<String, Object> getInquiryInfo() {
	public Map<String, Object> getInquiryInfo(BankVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/inquiry/real_name";
		Map<String, String> param = new HashMap<>();
		// MultiValueMap<String, String> param = new LinkedMultiValueMap<String,
		// String>();
		param.put("bank_tran_id", use_org_code + "U" + "000000041");
		param.put("bank_code_std", "031");
		param.put("account_num", "4443333");
		param.put("account_holder_info_type", " ");
		param.put("account_holder_info", "911112");
		param.put("tran_dtime", getDate());

		ObjectMapper mapper = new ObjectMapper();
		String jsonparam = "";
		try {
			jsonparam = mapper.writeValueAsString(param);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		// System.out.println(jsonparam);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json; charset=UTF-8");
		headers.set("Authorization", "Bearer " + org_access_token);
		// System.out.println(headers);

		HttpEntity<String> request = new HttpEntity<String>(jsonparam, headers);

		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.postForObject(reqURL, request, Map.class);

		return response;

	}

	

}
