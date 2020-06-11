package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class CrdtDataInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrdtDataInfoExample() {
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

        public Criteria andDataBelongIsNull() {
            addCriterion("data_belong is null");
            return (Criteria) this;
        }

        public Criteria andDataBelongIsNotNull() {
            addCriterion("data_belong is not null");
            return (Criteria) this;
        }

        public Criteria andDataBelongEqualTo(String value) {
            addCriterion("data_belong =", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongNotEqualTo(String value) {
            addCriterion("data_belong <>", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongGreaterThan(String value) {
            addCriterion("data_belong >", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongGreaterThanOrEqualTo(String value) {
            addCriterion("data_belong >=", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongLessThan(String value) {
            addCriterion("data_belong <", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongLessThanOrEqualTo(String value) {
            addCriterion("data_belong <=", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongLike(String value) {
            addCriterion("data_belong like", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongNotLike(String value) {
            addCriterion("data_belong not like", value, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongIn(List<String> values) {
            addCriterion("data_belong in", values, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongNotIn(List<String> values) {
            addCriterion("data_belong not in", values, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongBetween(String value1, String value2) {
            addCriterion("data_belong between", value1, value2, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataBelongNotBetween(String value1, String value2) {
            addCriterion("data_belong not between", value1, value2, "dataBelong");
            return (Criteria) this;
        }

        public Criteria andDataNameIsNull() {
            addCriterion("data_name is null");
            return (Criteria) this;
        }

        public Criteria andDataNameIsNotNull() {
            addCriterion("data_name is not null");
            return (Criteria) this;
        }

        public Criteria andDataNameEqualTo(String value) {
            addCriterion("data_name =", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotEqualTo(String value) {
            addCriterion("data_name <>", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameGreaterThan(String value) {
            addCriterion("data_name >", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameGreaterThanOrEqualTo(String value) {
            addCriterion("data_name >=", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLessThan(String value) {
            addCriterion("data_name <", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLessThanOrEqualTo(String value) {
            addCriterion("data_name <=", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLike(String value) {
            addCriterion("data_name like", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotLike(String value) {
            addCriterion("data_name not like", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameIn(List<String> values) {
            addCriterion("data_name in", values, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotIn(List<String> values) {
            addCriterion("data_name not in", values, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameBetween(String value1, String value2) {
            addCriterion("data_name between", value1, value2, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotBetween(String value1, String value2) {
            addCriterion("data_name not between", value1, value2, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNull() {
            addCriterion("data_count is null");
            return (Criteria) this;
        }

        public Criteria andDataCountIsNotNull() {
            addCriterion("data_count is not null");
            return (Criteria) this;
        }

        public Criteria andDataCountEqualTo(Integer value) {
            addCriterion("data_count =", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotEqualTo(Integer value) {
            addCriterion("data_count <>", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThan(Integer value) {
            addCriterion("data_count >", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_count >=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThan(Integer value) {
            addCriterion("data_count <", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountLessThanOrEqualTo(Integer value) {
            addCriterion("data_count <=", value, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountIn(List<Integer> values) {
            addCriterion("data_count in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotIn(List<Integer> values) {
            addCriterion("data_count not in", values, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountBetween(Integer value1, Integer value2) {
            addCriterion("data_count between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andDataCountNotBetween(Integer value1, Integer value2) {
            addCriterion("data_count not between", value1, value2, "dataCount");
            return (Criteria) this;
        }

        public Criteria andOrgInfoIsNull() {
            addCriterion("org_info is null");
            return (Criteria) this;
        }

        public Criteria andOrgInfoIsNotNull() {
            addCriterion("org_info is not null");
            return (Criteria) this;
        }

        public Criteria andOrgInfoEqualTo(String value) {
            addCriterion("org_info =", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoNotEqualTo(String value) {
            addCriterion("org_info <>", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoGreaterThan(String value) {
            addCriterion("org_info >", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoGreaterThanOrEqualTo(String value) {
            addCriterion("org_info >=", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoLessThan(String value) {
            addCriterion("org_info <", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoLessThanOrEqualTo(String value) {
            addCriterion("org_info <=", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoLike(String value) {
            addCriterion("org_info like", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoNotLike(String value) {
            addCriterion("org_info not like", value, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoIn(List<String> values) {
            addCriterion("org_info in", values, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoNotIn(List<String> values) {
            addCriterion("org_info not in", values, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoBetween(String value1, String value2) {
            addCriterion("org_info between", value1, value2, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andOrgInfoNotBetween(String value1, String value2) {
            addCriterion("org_info not between", value1, value2, "orgInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoIsNull() {
            addCriterion("dup_info is null");
            return (Criteria) this;
        }

        public Criteria andDupInfoIsNotNull() {
            addCriterion("dup_info is not null");
            return (Criteria) this;
        }

        public Criteria andDupInfoEqualTo(String value) {
            addCriterion("dup_info =", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoNotEqualTo(String value) {
            addCriterion("dup_info <>", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoGreaterThan(String value) {
            addCriterion("dup_info >", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoGreaterThanOrEqualTo(String value) {
            addCriterion("dup_info >=", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoLessThan(String value) {
            addCriterion("dup_info <", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoLessThanOrEqualTo(String value) {
            addCriterion("dup_info <=", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoLike(String value) {
            addCriterion("dup_info like", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoNotLike(String value) {
            addCriterion("dup_info not like", value, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoIn(List<String> values) {
            addCriterion("dup_info in", values, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoNotIn(List<String> values) {
            addCriterion("dup_info not in", values, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoBetween(String value1, String value2) {
            addCriterion("dup_info between", value1, value2, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andDupInfoNotBetween(String value1, String value2) {
            addCriterion("dup_info not between", value1, value2, "dupInfo");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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