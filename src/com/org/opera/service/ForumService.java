package com.org.opera.service;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.Forum;

public interface ForumService extends DaoSupport<Forum>{

	/**
	 * 上移，最上面的不能上移
	 * @param id
	 */
	void moveUp(Long id);

	/**
	 * 下移，最下面的不能下移
	 * @param id
	 */
	void moveDown(Long id);

}
