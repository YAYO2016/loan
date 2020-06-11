package com.loan.framework.service.service;

import com.google.common.base.Preconditions;
import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.model.AbsPojoSetPk;
import com.loan.framework.utils.SnowflakeIdWorker;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-04-17 22:38
 */
public abstract class AbstractLoanService<T extends AbsPojoSetPk> implements LoanService<T> {

    private final static Object initLockSeq = new Object();
    private static SnowflakeIdWorker snowflakeIdWorker = null;

    /**
     * 具体实现类需要提供对应的Dao。
     *
     * @return
     */
    protected abstract ISingleTableDao<T> getMyBatisRepository();

    /**
     * 构建只包含主键ID的实体对象
     */
    protected abstract T constructPkEntity(final Long id);

    /**
     * 获取对象主键ID
     */
    protected abstract Object getPk(T t);

    /**
     * 获取唯一的自增序列
     *
     * @return
     */
    @Override
    public Long getLongUniqueId() {
        if (snowflakeIdWorker == null) {
            synchronized (initLockSeq) {
                if (snowflakeIdWorker == null) {
                    snowflakeIdWorker = new SnowflakeIdWorker();
                }
            }
        }
        return snowflakeIdWorker.nextId();
    }

    /**
     * 注意：只能做一些对于参数的预操作，不能涉及事务。涉及事务请覆盖create
     * 子类可根据情况覆盖此方法
     * 用于在执行新增操作之前进行预处理
     *
     * @param entity 需新增的实体
     */
    protected void preCreate(T entity) {
    }

    @Override
    public Long create(T entity) {
        Preconditions.checkNotNull(entity, "新增对象不能为空");
        preCreate(entity);
        Long pk = this.getLongUniqueId();
        entity.setPk(pk);
        getMyBatisRepository().insert(entity);
        return pk;
    }

    /**
     * 注意：只能做一些对于参数的预操作，不能涉及事务。涉及事务请覆盖modifyEntityById
     * 子类可根据情况覆盖此方法
     * 用于在执行修改操作之前进行预处理
     *
     * @param entity 需修改的实体
     */
    protected void preModify(T entity) {
    }

    @Override
    public void modifyEntityById(T entity) {
        Preconditions.checkNotNull(entity, "修改对象不能为空");
        Preconditions.checkNotNull(getPk(entity), "修改对象对应主键不能为空");

        preModify(entity);
        getMyBatisRepository().updateByPk(entity);
    }

    @Override
    public void deleteEntityById(Long id) {
        Preconditions.checkNotNull(id, "删除对象对应主键不能为空");

        getMyBatisRepository().deleteByPrimaryKey(constructPkEntity(id));
    }

    @Override
    public T getEntityById(Long id) {
        Preconditions.checkNotNull(id, "查询对应主键不能为空");
        return getMyBatisRepository().getOneByPrimaryKey(constructPkEntity(id));
    }

    /**
     * 注意：只能做一些对于参数的预操作，不能涉及事务。涉及事务请覆盖queryEntityList
     * 子类可根据情况覆盖此方法
     * 用于在执行查询列表操作之前进行预处理
     *
     * @param queryObject 查询参数对象
     */
    protected void preQuery(T queryObject) {
    }

    @Override
    public List<T> queryEntityList(T queryObject) {
        Preconditions.checkNotNull(queryObject, "查询参数对象不能为空");
        preQuery(queryObject);
        return getMyBatisRepository().getAllItemsByQueryObject(queryObject);
    }

}
