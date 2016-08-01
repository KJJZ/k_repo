package hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class BaseDaoHibernate4<T> implements BaseDao<T> {
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().createQuery("delete "+entityClazz.getSimpleName()
				+" en where en.id=?0")
		.setParameter("0", id)
		.executeUpdate();
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		return find("select en from "+entityClazz.getSimpleName()+" en");
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		List<?> l = find("select count(*) from "+entityClazz.getSimpleName());
		if(l != null && l.size() == 1){
			return (long)l.size();
		}
		return 0;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql){
		return (List<T>) getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object[] params){
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i=0; i<params.length; i++){
			query.setParameter(i, params[i]);
		}
		return (List<T>)query.list();
	}
	
}
