package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class CrdtCaseCustRelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrdtCaseCustRelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCaseIdIsNull() {
            addCriterion("case_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("case_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(String value) {
            addCriterion("case_id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(String value) {
            addCriterion("case_id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(String value) {
            addCriterion("case_id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(String value) {
            addCriterion("case_id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(String value) {
            addCriterion("case_id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(String value) {
            addCriterion("case_id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLike(String value) {
            addCriterion("case_id like", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotLike(String value) {
            addCriterion("case_id not like", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<String> values) {
            addCriterion("case_id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<String> values) {
            addCriterion("case_id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(String value1, String value2) {
            addCriterion("case_id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(String value1, String value2) {
            addCriterion("case_id not between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("cust_id like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("cust_id not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andRelTypeIsNull() {
            addCriterion("rel_type is null");
            return (Criteria) this;
        }

        public Criteria andRelTypeIsNotNull() {
            addCriterion("rel_type is not null");
            return (Criteria) this;
        }

        public Criteria andRelTypeEqualTo(String value) {
            addCriterion("rel_type =", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotEqualTo(String value) {
            addCriterion("rel_type <>", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThan(String value) {
            addCriterion("rel_type >", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rel_type >=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThan(String value) {
            addCriterion("rel_type <", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThanOrEqualTo(String value) {
            addCriterion("rel_type <=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLike(String value) {
            addCriterion("rel_type like", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotLike(String value) {
            addCriterion("rel_type not like", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeIn(List<String> values) {
            addCriterion("rel_type in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotIn(List<String> values) {
            addCriterion("rel_type not in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeBetween(String value1, String value2) {
            addCriterion("rel_type between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotBetween(String value1, String value2) {
            addCriterion("rel_type not between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andIsTrueIsNull() {
            addCriterion("is_true is null");
            return (Criteria) this;
        }

        public Criteria andIsTrueIsNotNull() {
            addCriterion("is_true is not null");
            return (Criteria) this;
        }

        public Criteria andIsTrueEqualTo(String value) {
            addCriterion("is_true =", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotEqualTo(String value) {
            addCriterion("is_true <>", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueGreaterThan(String value) {
            addCriterion("is_true >", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueGreaterThanOrEqualTo(String value) {
            addCriterion("is_true >=", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueLessThan(String value) {
            addCriterion("is_true <", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueLessThanOrEqualTo(String value) {
            addCriterion("is_true <=", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueLike(String value) {
            addCriterion("is_true like", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotLike(String value) {
            addCriterion("is_true not like", value, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueIn(List<String> values) {
            addCriterion("is_true in", values, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotIn(List<String> values) {
            addCriterion("is_true not in", values, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueBetween(String value1, String value2) {
            addCriterion("is_true between", value1, value2, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsTrueNotBetween(String value1, String value2) {
            addCriterion("is_true not between", value1, value2, "isTrue");
            return (Criteria) this;
        }

        public Criteria andIsStreamIsNull() {
            addCriterion("is_stream is null");
            return (Criteria) this;
        }

        public Criteria andIsStreamIsNotNull() {
            addCriterion("is_stream is not null");
            return (Criteria) this;
        }

        public Criteria andIsStreamEqualTo(String value) {
            addCriterion("is_stream =", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamNotEqualTo(String value) {
            addCriterion("is_stream <>", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamGreaterThan(String value) {
            addCriterion("is_stream >", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamGreaterThanOrEqualTo(String value) {
            addCriterion("is_stream >=", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamLessThan(String value) {
            addCriterion("is_stream <", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamLessThanOrEqualTo(String value) {
            addCriterion("is_stream <=", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamLike(String value) {
            addCriterion("is_stream like", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamNotLike(String value) {
            addCriterion("is_stream not like", value, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamIn(List<String> values) {
            addCriterion("is_stream in", values, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamNotIn(List<String> values) {
            addCriterion("is_stream not in", values, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamBetween(String value1, String value2) {
            addCriterion("is_stream between", value1, value2, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsStreamNotBetween(String value1, String value2) {
            addCriterion("is_stream not between", value1, value2, "isStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamIsNull() {
            addCriterion("is_true_stream is null");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamIsNotNull() {
            addCriterion("is_true_stream is not null");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamEqualTo(String value) {
            addCriterion("is_true_stream =", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamNotEqualTo(String value) {
            addCriterion("is_true_stream <>", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamGreaterThan(String value) {
            addCriterion("is_true_stream >", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamGreaterThanOrEqualTo(String value) {
            addCriterion("is_true_stream >=", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamLessThan(String value) {
            addCriterion("is_true_stream <", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamLessThanOrEqualTo(String value) {
            addCriterion("is_true_stream <=", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamLike(String value) {
            addCriterion("is_true_stream like", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamNotLike(String value) {
            addCriterion("is_true_stream not like", value, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamIn(List<String> values) {
            addCriterion("is_true_stream in", values, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamNotIn(List<String> values) {
            addCriterion("is_true_stream not in", values, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamBetween(String value1, String value2) {
            addCriterion("is_true_stream between", value1, value2, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andIsTrueStreamNotBetween(String value1, String value2) {
            addCriterion("is_true_stream not between", value1, value2, "isTrueStream");
            return (Criteria) this;
        }

        public Criteria andStreamValueIsNull() {
            addCriterion("stream_value is null");
            return (Criteria) this;
        }

        public Criteria andStreamValueIsNotNull() {
            addCriterion("stream_value is not null");
            return (Criteria) this;
        }

        public Criteria andStreamValueEqualTo(String value) {
            addCriterion("stream_value =", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueNotEqualTo(String value) {
            addCriterion("stream_value <>", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueGreaterThan(String value) {
            addCriterion("stream_value >", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueGreaterThanOrEqualTo(String value) {
            addCriterion("stream_value >=", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueLessThan(String value) {
            addCriterion("stream_value <", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueLessThanOrEqualTo(String value) {
            addCriterion("stream_value <=", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueLike(String value) {
            addCriterion("stream_value like", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueNotLike(String value) {
            addCriterion("stream_value not like", value, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueIn(List<String> values) {
            addCriterion("stream_value in", values, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueNotIn(List<String> values) {
            addCriterion("stream_value not in", values, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueBetween(String value1, String value2) {
            addCriterion("stream_value between", value1, value2, "streamValue");
            return (Criteria) this;
        }

        public Criteria andStreamValueNotBetween(String value1, String value2) {
            addCriterion("stream_value not between", value1, value2, "streamValue");
            return (Criteria) this;
        }

        public Criteria andCoTypeIsNull() {
            addCriterion("co_type is null");
            return (Criteria) this;
        }

        public Criteria andCoTypeIsNotNull() {
            addCriterion("co_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoTypeEqualTo(String value) {
            addCriterion("co_type =", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeNotEqualTo(String value) {
            addCriterion("co_type <>", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeGreaterThan(String value) {
            addCriterion("co_type >", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("co_type >=", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeLessThan(String value) {
            addCriterion("co_type <", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeLessThanOrEqualTo(String value) {
            addCriterion("co_type <=", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeLike(String value) {
            addCriterion("co_type like", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeNotLike(String value) {
            addCriterion("co_type not like", value, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeIn(List<String> values) {
            addCriterion("co_type in", values, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeNotIn(List<String> values) {
            addCriterion("co_type not in", values, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeBetween(String value1, String value2) {
            addCriterion("co_type between", value1, value2, "coType");
            return (Criteria) this;
        }

        public Criteria andCoTypeNotBetween(String value1, String value2) {
            addCriterion("co_type not between", value1, value2, "coType");
            return (Criteria) this;
        }

        public Criteria andCoNameIsNull() {
            addCriterion("co_name is null");
            return (Criteria) this;
        }

        public Criteria andCoNameIsNotNull() {
            addCriterion("co_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoNameEqualTo(String value) {
            addCriterion("co_name =", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotEqualTo(String value) {
            addCriterion("co_name <>", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameGreaterThan(String value) {
            addCriterion("co_name >", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameGreaterThanOrEqualTo(String value) {
            addCriterion("co_name >=", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLessThan(String value) {
            addCriterion("co_name <", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLessThanOrEqualTo(String value) {
            addCriterion("co_name <=", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameLike(String value) {
            addCriterion("co_name like", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotLike(String value) {
            addCriterion("co_name not like", value, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameIn(List<String> values) {
            addCriterion("co_name in", values, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotIn(List<String> values) {
            addCriterion("co_name not in", values, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameBetween(String value1, String value2) {
            addCriterion("co_name between", value1, value2, "coName");
            return (Criteria) this;
        }

        public Criteria andCoNameNotBetween(String value1, String value2) {
            addCriterion("co_name not between", value1, value2, "coName");
            return (Criteria) this;
        }

        public Criteria andCoPhoneIsNull() {
            addCriterion("co_phone is null");
            return (Criteria) this;
        }

        public Criteria andCoPhoneIsNotNull() {
            addCriterion("co_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCoPhoneEqualTo(String value) {
            addCriterion("co_phone =", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneNotEqualTo(String value) {
            addCriterion("co_phone <>", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneGreaterThan(String value) {
            addCriterion("co_phone >", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("co_phone >=", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneLessThan(String value) {
            addCriterion("co_phone <", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneLessThanOrEqualTo(String value) {
            addCriterion("co_phone <=", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneLike(String value) {
            addCriterion("co_phone like", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneNotLike(String value) {
            addCriterion("co_phone not like", value, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneIn(List<String> values) {
            addCriterion("co_phone in", values, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneNotIn(List<String> values) {
            addCriterion("co_phone not in", values, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneBetween(String value1, String value2) {
            addCriterion("co_phone between", value1, value2, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoPhoneNotBetween(String value1, String value2) {
            addCriterion("co_phone not between", value1, value2, "coPhone");
            return (Criteria) this;
        }

        public Criteria andCoAddressIsNull() {
            addCriterion("co_address is null");
            return (Criteria) this;
        }

        public Criteria andCoAddressIsNotNull() {
            addCriterion("co_address is not null");
            return (Criteria) this;
        }

        public Criteria andCoAddressEqualTo(String value) {
            addCriterion("co_address =", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressNotEqualTo(String value) {
            addCriterion("co_address <>", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressGreaterThan(String value) {
            addCriterion("co_address >", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("co_address >=", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressLessThan(String value) {
            addCriterion("co_address <", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressLessThanOrEqualTo(String value) {
            addCriterion("co_address <=", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressLike(String value) {
            addCriterion("co_address like", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressNotLike(String value) {
            addCriterion("co_address not like", value, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressIn(List<String> values) {
            addCriterion("co_address in", values, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressNotIn(List<String> values) {
            addCriterion("co_address not in", values, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressBetween(String value1, String value2) {
            addCriterion("co_address between", value1, value2, "coAddress");
            return (Criteria) this;
        }

        public Criteria andCoAddressNotBetween(String value1, String value2) {
            addCriterion("co_address not between", value1, value2, "coAddress");
            return (Criteria) this;
        }

        public Criteria andAmountValueIsNull() {
            addCriterion("amount_value is null");
            return (Criteria) this;
        }

        public Criteria andAmountValueIsNotNull() {
            addCriterion("amount_value is not null");
            return (Criteria) this;
        }

        public Criteria andAmountValueEqualTo(Double value) {
            addCriterion("amount_value =", value, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueNotEqualTo(Double value) {
            addCriterion("amount_value <>", value, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueGreaterThan(Double value) {
            addCriterion("amount_value >", value, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueGreaterThanOrEqualTo(Double value) {
            addCriterion("amount_value >=", value, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueLessThan(Double value) {
            addCriterion("amount_value <", value, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueLessThanOrEqualTo(Double value) {
            addCriterion("amount_value <=", value, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueIn(List<Double> values) {
            addCriterion("amount_value in", values, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueNotIn(List<Double> values) {
            addCriterion("amount_value not in", values, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueBetween(Double value1, Double value2) {
            addCriterion("amount_value between", value1, value2, "amountValue");
            return (Criteria) this;
        }

        public Criteria andAmountValueNotBetween(Double value1, Double value2) {
            addCriterion("amount_value not between", value1, value2, "amountValue");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}