package cn.cat.mapper;

import java.util.List;
import cn.cat.pojo.CatNotePojo;
import cn.cat.pojo.CatPojo;
import cn.cat.query.LimitQuery;

public interface CatMapper {
	public Integer insertCat(CatPojo cat);
	public Integer insertCatNote(CatNotePojo note);
	public List<CatPojo> selectCatAll(LimitQuery query);
	public CatPojo selectCatNote(String catid);
}
