package com.busi.mapper;

import com.busi.domain.DayEndStep;
import com.busi.domain.DayEndStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface DayEndStepMapper {

    int countByExample(DayEndStepExample example);

    int deleteByExample(DayEndStepExample example);

    int deleteByPrimaryKey(Integer stepNo);

    int insert(DayEndStep record);

    int insertSelective(DayEndStep record);

    List<DayEndStep> selectByExample(DayEndStepExample example);

    DayEndStep selectByPrimaryKey(Integer stepNo);

    int updateByExampleSelective(@Param("record") DayEndStep record, @Param("example") DayEndStepExample example);

    int updateByExample(@Param("record") DayEndStep record, @Param("example") DayEndStepExample example);

    int updateByPrimaryKeySelective(DayEndStep record);

    int updateByPrimaryKey(DayEndStep record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}