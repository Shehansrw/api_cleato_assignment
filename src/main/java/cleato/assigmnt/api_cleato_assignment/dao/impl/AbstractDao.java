package cleato.assigmnt.api_cleato_assignment.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Criteria createEntityCriteria(boolean ignoreInactive, String activeField) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		if (ignoreInactive) {
			criteria.add(Restrictions.ne(activeField, 'i'));
		}
		return criteria;
	}
	
	protected Criteria createEntityCriteriaWithBoolean(boolean ignoreInactive, String activeField) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		if (ignoreInactive) {
			criteria.add(Restrictions.ne(activeField, false));
		}
		return criteria;
	}

	protected Criteria createEntityCriteriaWithAlias(boolean ignoreInactive, String activeField, String alias) {
		Criteria criteria = getSession().createCriteria(persistentClass, alias);
		if (ignoreInactive) {
			criteria.add(Restrictions.ne(activeField, 'i'));
		}
		return criteria;
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key, boolean ignoreInactive, String activeField) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		if (ignoreInactive) {
			criteria.add(Restrictions.ne(activeField, 'i'));
		}
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void persistBulk(List<T> entities) {
	    for (T entity : entities) {
            getSession().persist(entity);
        }
    }

	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void merge(T entity) {
		getSession().merge(entity);
	}

	public void mergeBulk(List<T> entities) {
	    for (T entity : entities) {
	        getSession().merge(entity);
        }
    }

	public Object mergeNreturn(T entity) {
		return getSession().merge(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void deleteBulk(List<T> entities) {
		for (T entity : entities) {
	        getSession().delete(entity);
        }
	}

}
