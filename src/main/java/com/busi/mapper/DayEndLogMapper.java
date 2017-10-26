package com.busi.mapper;

import com.busi.domain.DayEndLog;
import com.busi.domain.DayEndLogExample;
import com.busi.domain.DayEndLogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface DayEndLogMapper {

    int countByExample(DayEndLogExample example);

    int deleteByExample(DayEndLogExample example);

    int deleteByPrimaryKey(DayEndLogKey key);

    int insert(DayEndLog record);

    int insertSelective(DayEndLog record);

    List<DayEndLog> selectByExample(DayEndLogExample example);

    DayEndLog selectByPrimaryKey(DayEndLogKey key);

    int updateByExampleSelective(@Param("record") DayEndLog record, @Param("example") DayEndLogExample example);

    int updateByExample(@Param("record") DayEndLog record, @Param("example") DayEndLogExample example);

    int updateByPrimaryKeySelective(DayEndLog record);

    int updateByPrimaryKey(DayEndLog record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}