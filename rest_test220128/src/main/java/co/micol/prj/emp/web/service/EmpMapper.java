package co.micol.prj.emp.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
	List<Emp> findEmp();
	List<Dept> findDept();
	Dept findDeptById (@Param("id") String id);
	int updateDept (Dept dept);
	int deleteDept (String id);
	int insertDept (Dept dept);

}
