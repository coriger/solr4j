package com.nojava.model.solr;

/**
 * 多个条件list以;间隔 key value以:间隔
 *
 * @author cailei
 */
public class SearchReqBeanHtml {

    private String coreName;
    private String qMap;
    private String q;
    private String filterMap;
    private String delFilterMap;
    private String addFilterMap;
    private String ordersMap;
    private String delOrdersMap;
    private String addOrdersMap;
    private int start = 1;
    private int rows = 10;
    private String selectType = "dismax";

    public String getCoreName() {
        return coreName;
    }

    public void setCoreName(String coreName) {
        this.coreName = coreName;
    }

    public String getqMap() {
        return qMap;
    }

    public void setqMap(String qMap) {
        this.qMap = qMap;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }


    public String getFilterMap() {
        return filterMap;
    }

    public void setFilterMap(String filterMap) {
        this.filterMap = filterMap;
    }

    public String getDelFilterMap() {
        return delFilterMap;
    }

    public void setDelFilterMap(String delFilterMap) {
        this.delFilterMap = delFilterMap;
    }

    public String getAddFilterMap() {
        return addFilterMap;
    }

    public void setAddFilterMap(String addFilterMap) {
        this.addFilterMap = addFilterMap;
    }

    public String getOrdersMap() {
        return ordersMap;
    }

    public void setOrdersMap(String ordersMap) {
        this.ordersMap = ordersMap;
    }

    public String getDelOrdersMap() {
        return delOrdersMap;
    }

    public void setDelOrdersMap(String delOrdersMap) {
        this.delOrdersMap = delOrdersMap;
    }

    public String getAddOrdersMap() {
        return addOrdersMap;
    }

    public void setAddOrdersMap(String addOrdersMap) {
        this.addOrdersMap = addOrdersMap;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }
}
