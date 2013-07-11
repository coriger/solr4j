/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojava.model.solr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.client.solrj.SolrQuery;

/**
 *
 * @author cailei
 */
public class SearchBean {

    private Set<String> q = new HashSet<String>();
    private Map<String, Set<String>> qMap = new HashMap<String, Set<String>>();
    private List<DateField> dateFields = new ArrayList<DateField>();
    private Map<String, Set<String>> filter = new HashMap<String, Set<String>>();
    private Map<String, SolrQuery.ORDER> orders = new LinkedHashMap<String, SolrQuery.ORDER>();
    private String coreName;
    private int start = 0;
    private int rows = 10;
    private SelectType selectType = SelectType.SELECT;

    public Set<String> getQ() {
        return q;
    }

    public void setQ(Set<String> q) {
        this.q = q;
    }

    public Map<String, Set<String>> getqMap() {
        return qMap;
    }

    public void setqMap(Map<String, Set<String>> qMap) {
        this.qMap = qMap;
    }

    public List<DateField> getDateFields() {
        return dateFields;
    }

    public void setDateFields(List<DateField> dateFields) {
        this.dateFields = dateFields;
    }

    public Map<String, Set<String>> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, Set<String>> filter) {
        this.filter = filter;
    }

    public Map<String, SolrQuery.ORDER> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, SolrQuery.ORDER> orders) {
        this.orders = orders;
    }

    public String getCoreName() {
        return coreName;
    }

    public void setCoreName(String coreName) {
        this.coreName = coreName;
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

    public SelectType getSelectType() {
        return selectType;
    }

    public void setSelectType(SelectType selectType) {
        this.selectType = selectType;
    }

    public void addQMap(String key, String value) {
        if (qMap.containsKey(key)) {
            qMap.get(key).add(value);
        } else {
            Set<String> values = new HashSet<String>();
            values.add(value);
            qMap.put(key, values);
        }

    }
    
}
