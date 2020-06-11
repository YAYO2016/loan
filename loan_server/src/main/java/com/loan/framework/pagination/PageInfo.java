package com.loan.framework.pagination;

/**
 * @author GuoKang
 * @date 2019-04-17 22:46
 */
public class PageInfo {

    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int MAX_PAGE_SIZE = 1000;
    private final int pageIndex;
    private final int pageSize;
    private final int totalItems;
    private final int totalPages;
    private final int offSet;

    public PageInfo() {
        this.pageIndex = 1;
        this.pageSize = 20;
        this.totalItems = 0;
        this.totalPages = 0;
        this.offSet = 0;
    }

    public PageInfo(int totalItems, int pageIndex, int pageSize) {
        this.totalItems = totalItems > 0 ? totalItems : 0;
        this.pageSize = pageSize > 0 && pageSize <= 1000 ? pageSize : 20;
        this.totalPages = this.totalItems % this.pageSize > 0 ? this.totalItems / this.pageSize + 1 : this.totalItems / this.pageSize;
        if (this.totalPages != 0 && pageIndex > this.totalPages) {
            pageIndex = this.totalPages;
        }

        this.pageIndex = pageIndex > 0 ? pageIndex : 1;
        this.offSet = (this.pageIndex - 1) * pageSize;
    }

    public PageInfo(int pageIndex, int pageSize) {
        this.totalItems = 0;
        this.totalPages = 0;
        this.pageSize = pageSize > 0 && pageSize <= 1000 ? pageSize : 20;
        this.pageIndex = pageIndex > 0 ? pageIndex : 1;
        this.offSet = (this.pageIndex - 1) * pageSize;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public int getOffSet() {
        return this.offSet;
    }
}
