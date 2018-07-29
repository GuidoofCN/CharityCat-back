package cn.cat.mapper;

import java.util.List;

import cn.cat.pojo.Diary;
import cn.cat.query.LimitQuery;

public interface DiaryMapper {
    public List<Diary> selectDiaryAll(LimitQuery query);
    
    
}
