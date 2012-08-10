package org.thorn.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.thorn.app.entity.Heritor;
import org.thorn.app.entity.Project;
import org.thorn.core.util.LocalStringUtils;
import org.thorn.dao.core.Configuration;
import org.thorn.dao.exception.DBAccessException;
import org.thorn.dao.mybatis.helper.MyBatisDaoSupport;
import org.thorn.web.entity.Page;

/**
 * @ClassName: ProjectServiceImpl
 * @Description:
 * @author chenyun
 * @date 2012-8-10 上午10:59:48
 */
public class HeritorServiceImpl implements IHeritorService {

	@Autowired
	@Qualifier("myBatisDaoSupport")
	private MyBatisDaoSupport myBatisDaoSupport;

	public void save(Heritor heritor) throws DBAccessException {
		myBatisDaoSupport.save(heritor);
	}

	public void modify(Heritor heritor) throws DBAccessException {
		myBatisDaoSupport.modify(heritor);
	}

	public void delete(String ids) throws DBAccessException {
		List<String> list = LocalStringUtils.splitStr2Array(ids);
		myBatisDaoSupport.deleteForBatch(list, Heritor.class);
	}

	public Page<Heritor> queryPage(String name, String gender,
			String projectName, String isDie, String province, long start,
			long limit, String sort, String dir) throws DBAccessException {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("name", name);
		filter.put("gender", gender);
		filter.put("projectName", projectName);
		filter.put("isDie", isDie);
		filter.put("province", province);
		filter.put(Configuration.PAGE_LIMIT, limit);
		filter.put(Configuration.PAGE_START, start);
		filter.put(Configuration.SROT_NAME, sort);
		filter.put(Configuration.ORDER_NAME, dir);

		Page<Heritor> page = new Page<Heritor>();

		page.setTotal(myBatisDaoSupport.queryCount(filter, Project.class));
		if (page.getTotal() > 0) {
			page.setReslutSet(myBatisDaoSupport
					.queryList(filter, Heritor.class));
		}

		return page;
	}

}
