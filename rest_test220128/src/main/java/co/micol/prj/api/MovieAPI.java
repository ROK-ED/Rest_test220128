package co.micol.prj.api;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieAPI {
	public static void main(String[] args) throws Exception {
		
		//movieList();
		movieInfo("20201965");
	}

	static String boxoffice = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220127";
	
	public static JsonNode restMovieList() throws Exception {
		RestTemplate rest = new RestTemplate();
		JsonNode node = rest.getForObject(boxoffice, JsonNode.class);
		return node.get("boxOfficeResult")
					.get("dailyBoxOfficeList");
	}
	
	
	
	public static JsonNode movieList() throws Exception {
		URL url = new URL(boxoffice);

		URLConnection urlcon = url.openConnection();
		InputStream in = urlcon.getInputStream();

		ObjectMapper mapper = new ObjectMapper();

		JsonNode nodes = mapper.readTree(url);
		
		JsonNode mlist = nodes.get("boxOfficeResult").get("dailyBoxOfficeList");
		
		for(int i=0; i<mlist.size(); i++) {
			String nm = mlist
							.get(i)
							.get("movieNm")
							.asText();
			System.out.println(nm);
		}
		
		return mlist;
			
	}
	public static void movieInfo(String cd) throws Exception {
		String urladdr = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+cd;
		URL url = new URL(urladdr);
		//서버연결
		URLConnection urlcon = url.openConnection();
		//응답결과조회
		InputStream in = urlcon.getInputStream();
		//응답결과 String을 객체로 파싱
		ObjectMapper mapper = new ObjectMapper();
		JsonNode nodes = mapper.readTree(url);
		JsonNode mlist = nodes
						.get("movieInfoResult")
						.get("movieInfo")
						.get("actors");
		for(int i=0; i<mlist.size(); i++) {
			String nm = mlist
							.get(i)
							.get("peopleNm")
							.asText();
			System.out.println(nm);
		}
	}

}
