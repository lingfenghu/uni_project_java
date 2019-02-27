package cn.jmu.mapper;

import org.apache.ibatis.annotations.Param;

import cn.jmu.po.Statement;

public interface StatementMapper {
	public Statement getAStatement(@Param("year")String year,@Param("month")String month,@Param("flightID")String flightID) throws Exception;

}
