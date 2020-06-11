package com.loan.framework.pagination;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author GuoKang
 * @date 2019-04-17 22:29
 */
public final class LoanPageList<T> implements Serializable {

    /** 业务数据列表 */
    private final List<T> datas;

    /** 分页元信息 */
    private final LoanPage page;

    /**
    * 封闭构造器（获得实例请使用静态方法），并初始化数据。
    */
    private LoanPageList(List<T> datas, LoanPage page) {
        if (null == datas)       //避免null对象
            datas = new LinkedList<T>();
        if (null == page)        //避免null对象
            page =new LoanPage();
        this.datas = datas;
        this.page = page;
    }

    /**
    * 获得一个空的实例
    * @param <T>实例所含业务数据泛型
    */
    public static <T> LoanPageList<T> getEmptyInstance() {
        return new LoanPageList<T>(null, null);
    }

     /**
     * 获得一个包含完整数据的实例
     */
    public static <T> LoanPageList<T> getInstance(List<T> datas, LoanPage page) {
         if (null == datas)
            throw new RuntimeException("业务数据列表不能为空！");
         if (null == page)
            throw new RuntimeException("分页对象page不能为空！");
          return new LoanPageList<T>(datas, page);
    }

    public List<T> getDatas() {
         return datas;
    }

    public LoanPage getPage() {
         return page;
    }
    
    public PageInfo getPageInfo(){
    	return new PageInfo(page.getRowCount(), page.getCurrentPage(), page.getPageSize());
    }
}
