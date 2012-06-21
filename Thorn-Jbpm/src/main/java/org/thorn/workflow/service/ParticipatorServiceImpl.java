package org.thorn.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.thorn.core.util.LocalStringUtils;
import org.thorn.dao.core.Configuration;
import org.thorn.dao.core.Page;
import org.thorn.dao.exception.DBAccessException;
import org.thorn.workflow.dao.IParticipatorDao;
import org.thorn.workflow.entity.Participator;

/**
 * @ClassName: PermissionServiceImpl
 * @Description:
 * @author chenyun
 * @date 2012-6-20 下午10:50:40
 */
public class ParticipatorServiceImpl implements IParticipatorService {

	@Autowired
	@Qualifier("permissionDao")
	private IParticipatorDao permissionDao;

	public void save(Participator permission) throws DBAccessException {
		permissionDao.save(permission);
	}

	public void modify(Participator permission) throws DBAccessException {
		permissionDao.modify(permission);
	}

	public void delete(String ids) throws DBAccessException {
		List<String> list = LocalStringUtils.splitStr2Array(ids);
		permissionDao.delete(list);
	}

	public Page<Participator> queryPage(String activityId, String processDfId,
			String variable, String entityType, long start, long limit,
			String sort, String dir) throws DBAccessException {
		Map<String, Object> filter = new HashMap<String, Object>();

		filter.put("activityId", activityId);
		filter.put("processDfId", processDfId);
		filter.put("entityType", entityType);
		filter.put("variable", variable);

		filter.put(Configuration.PAGE_LIMIT, limit);
		filter.put(Configuration.PAGE_START, start);

		if (LocalStringUtils.isEmpty(sort)) {
			filter.put(Configuration.SROT_NAME, "processDfId");
			filter.put(Configuration.ORDER_NAME, Configuration.ORDER_ASC);
		} else {
			filter.put(Configuration.SROT_NAME, sort);
			filter.put(Configuration.ORDER_NAME, dir);
		}
		
		return permissionDao.queryPage(filter);
	}

	public Participator queryPermission(String activityId, String processDfId)
			throws DBAccessException {
		Map<String, Object> filter = new HashMap<String, Object>();

		filter.put("activityId", activityId);
		filter.put("processDfId", processDfId);
		
		List<Participator> list = permissionDao.queryList(filter);
		
		if(list.size() == 1) {
			return list.get(0);
		} else {
			throw new DBAccessException("queryPermission find multiple valued");
		}
	}

}