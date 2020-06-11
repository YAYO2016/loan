package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class CrdtModifyDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrdtModifyDataExample() {
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

        public Criteria andRealInfoIsNull() {
            addCriterion("real_info is null");
            return (Criteria) this;
        }

        public Criteria andRealInfoIsNotNull() {
            addCriterion("real_info is not null");
            return (Criteria) this;
        }

        public Criteria andRealInfoEqualTo(String value) {
            addCriterion("real_info =", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoNotEqualTo(String value) {
            addCriterion("real_info <>", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoGreaterThan(String value) {
            addCriterion("real_info >", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoGreaterThanOrEqualTo(String value) {
            addCriterion("real_info >=", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoLessThan(String value) {
            addCriterion("real_info <", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoLessThanOrEqualTo(String value) {
            addCriterion("real_info <=", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoLike(String value) {
            addCriterion("real_info like", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoNotLike(String value) {
            addCriterion("real_info not like", value, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoIn(List<String> values) {
            addCriterion("real_info in", values, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoNotIn(List<String> values) {
            addCriterion("real_info not in", values, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoBetween(String value1, String value2) {
            addCriterion("real_info between", value1, value2, "realInfo");
            return (Criteria) this;
        }

        public Criteria andRealInfoNotBetween(String value1, String value2) {
            addCriterion("real_info not between", value1, value2, "realInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoIsNull() {
            addCriterion("modify_info is null");
            return (Criteria) this;
        }

        public Criteria andModifyInfoIsNotNull() {
            addCriterion("modify_info is not null");
            return (Criteria) this;
        }

        public Criteria andModifyInfoEqualTo(String value) {
            addCriterion("modify_info =", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoNotEqualTo(String value) {
            addCriterion("modify_info <>", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoGreaterThan(String value) {
            addCriterion("modify_info >", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoGreaterThanOrEqualTo(String value) {
            addCriterion("modify_info >=", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoLessThan(String value) {
            addCriterion("modify_info <", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoLessThanOrEqualTo(String value) {
            addCriterion("modify_info <=", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoLike(String value) {
            addCriterion("modify_info like", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoNotLike(String value) {
            addCriterion("modify_info not like", value, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoIn(List<String> values) {
            addCriterion("modify_info in", values, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoNotIn(List<String> values) {
            addCriterion("modify_info not in", values, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoBetween(String value1, String value2) {
            addCriterion("modify_info between", value1, value2, "modifyInfo");
            return (Criteria) this;
        }

        public Criteria andModifyInfoNotBetween(String value1, String value2) {
            addCriterion("modify_info not between", value1, value2, "modifyInfo");
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