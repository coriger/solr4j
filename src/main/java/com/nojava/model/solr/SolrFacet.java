package com.nojava.model.solr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.response.FacetField;
@Deprecated
public class SolrFacet {

	private List<FacetField> facetFieldList = new ArrayList<FacetField>();

	public SolrFacet(Map<String, Object> facetFields) {
		init(facetFields);
	}

	public FacetField createFacetField(String fieldName, List<Object> fields) {
		if (fields.size() == 0)
			return null;
		FacetField facetField = new FacetField(fieldName);
		for (int i = 0; i < fields.size(); i += 2) {
			String name = fields.get(i).toString();
			if (StringUtils.isEmpty(name))
				continue;
			Integer count = Integer.parseInt(fields.get(i + 1).toString());
			facetField.add(name, count);
		}
		return facetField;
	}

	public List<FacetField> getList() {
		return facetFieldList;
	}

	private void init(Map<String, Object> facetFields) {
		Set<String> keySet = facetFields.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			@SuppressWarnings("unchecked")
			List<Object> fields = (List<Object>) facetFields.get(key);
			FacetField facetField = createFacetField(key, fields);
			if (facetField != null) {
				facetFieldList.add(facetField);
			}
		}
	}

}
