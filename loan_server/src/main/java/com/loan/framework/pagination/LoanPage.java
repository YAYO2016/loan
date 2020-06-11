package com.loan.framework.pagination;

import java.io.Serializable;

/**
 * @author GuoKang
 * @date 2019-04-17 22:29
 */
public class LoanPage implements Serializable {

    /** 第一页 */
    private int firstPage;
    /** 最后一页 */
    private int lastPage;
    /** 下一页 */
    private int nextPage;
    /** 上一页 */
    private int prevPage;
    /** 当前页 */
    private int currentPage;
    /** 总页数 */
    private int totalPage;
    /** 总记录数 */
    private int rowCount;
    /** 每页记录数 */
    private int pageSize;
    /** 是否有下一页 */
    private boolean hasNext;
    /** 是否有上一页 */
    private boolean hasPrev;
    /** 是否有第一页 */
    private boolean hasFirst;
    /** 是否有最后一页 */
    private boolean hasLast;
    /** 显示切页按钮数 */
    private static final int BUTTON_COUNT = 5;

    public LoanPage() {
        this(1, LoanPageAttribute.DEFAULT_PAGE_SIZE, 0);
    }

    public LoanPage(int currentPage, int pageSize) {
        this(currentPage, pageSize, 0);
    }
    /**
    * @param currentPage 当前页
    * @param pageSize 每页记录数
    * @param rowCount 总记录数
    */
    public LoanPage(int currentPage, int pageSize, int rowCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
        this.totalPage = this.rowCount % pageSize == 0 ? this.rowCount / pageSize : this.rowCount / pageSize + 1 ;
        if(this.totalPage > 0){
            this.hasFirst = true ;
            this.firstPage = currentPage - BUTTON_COUNT/2;
            if (this.firstPage < 1)
            this.firstPage = 1 ;
        }
        if(this.currentPage  > 1 ){
            this.hasPrev = true ;
            this.prevPage = this.currentPage - 1;
        }
        if(this.totalPage > 0 && this.currentPage < this.totalPage){
            this.hasNext = true;
            this.nextPage = this.currentPage + 1 ;
        }
        if(this.totalPage > 0){
            this.hasLast = true;
            this.lastPage = this.firstPage + BUTTON_COUNT - 1;
            if (this.lastPage > this.totalPage)
            this.lastPage = this.totalPage;
        }
    }

    /**
     * 获得一个完整的的page对象
     */
    public static LoanPage getInstance(LoanPageAttribute pageAttr, int rowCount) {
        return new LoanPage(pageAttr.getPageIndex(), pageAttr.getPageSize(), rowCount);
    }


    public int getFirstPage() {
        return firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public boolean getHasPrev() {
        return hasPrev;
    }

    public boolean getHasFirst() {
        return hasFirst;
    }

    public boolean getHasLast() {
        return hasLast;
    }
}

