package co.micol.prj.emp.web.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	String employee_id;
	String first_name;
	String last_name;
	@JsonIgnore String email;
	@JsonFormat(pattern = "yyyy-MM-dd") Date hire_date;
	String job_id;
	
}
