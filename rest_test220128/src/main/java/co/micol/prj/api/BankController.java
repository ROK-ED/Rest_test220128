package co.micol.prj.api;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //모든 요청이 ajax 일때 사용하면 편함
public class BankController {
	
	@RequestMapping("/balance")
	public Map balance(BankVO vo) {
		//로그인한 유저의 토큰은 DB에서 조회
		vo.setAccessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY1Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDkwMTQsImp0aSI6IjY1MTIxMTU3LTMwZjgtNDE1MC04MTQ3LWYzZTNhZDU4MWI2YiJ9.gzjNQGA1ouGKN6KQmKyUh4tooGL8h1_glUfTgmhMhvk");
		return new BankAPI().getBalanceInfo(vo);
	}
	
	@RequestMapping("/account")
	public Map account(BankVO vo) {
		//로그인한 유저의 토큰은 DB에서 조회
		vo.setAccessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY1Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDkwMTQsImp0aSI6IjY1MTIxMTU3LTMwZjgtNDE1MC04MTQ3LWYzZTNhZDU4MWI2YiJ9.gzjNQGA1ouGKN6KQmKyUh4tooGL8h1_glUfTgmhMhvk");
		vo.setUserSeqNo("1101003065");
		return new BankAPI().getAccountInfo(vo);
	}
	
	
}
