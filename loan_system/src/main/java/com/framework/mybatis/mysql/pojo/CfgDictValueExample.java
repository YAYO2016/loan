package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class CfgDictValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgDictValueExample() {
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

        public Criteria andDictIdIsNull() {
            addCriterion("dict_id is null");
            return (Criteria) this;
        }

        public Criteria andDictIdIsNotNull() {
            addCriterion("dict_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictIdEqualTo(String value) {
            addCriterion("dict_id =", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotEqualTo(String value) {
            addCriterion("dict_id <>", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThan(String value) {
            addCriterion("dict_id >", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThanOrEqualTo(String value) {
            addCriterion("dict_id >=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThan(String value) {
            addCriterion("dict_id <", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThanOrEqualTo(String value) {
            addCriterion("dict_id <=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLike(String value) {
            addCriterion("dict_id like", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotLike(String value) {
            addCriterion("dict_id not like", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdIn(List<String> values) {
            addCriterion("dict_id in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotIn(List<String> values) {
            addCriterion("dict_id not in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdBetween(String value1, String value2) {
            addCriterion("dict_id between", value1, value2, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotBetween(String value1, String value2) {
            addCriterion("dict_id not between", value1, value2, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNull() {
            addCriterion("dict_value is null");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNotNull() {
            addCriterion("dict_value is not null");
            return (Criteria) this;
        }

        public Criteria andDictValueEqualTo(String value) {
            addCriterion("dict_value =", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotEqualTo(String value) {
            addCriterion("dict_value <>", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThan(String value) {
            addCriterion("dict_value >", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThanOrEqualTo(String value) {
            addCriterion("dict_value >=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThan(String value) {
            addCriterion("dict_value <", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThanOrEqualTo(String value) {
            addCriterion("dict_value <=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLike(String value) {
            addCriterion("dict_value like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotLike(String value) {
            addCriterion("dict_value not like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueIn(List<String> values) {
            addCriterion("dict_value in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotIn(List<String> values) {
            addCriterion("dict_value not in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueBetween(String value1, String value2) {
            addCriterion("dict_value between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotBetween(String value1, String value2) {
            addCriterion("dict_value not between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNameIsNull() {
            addCriterion("dict_value_name is null");
            return (Criteria) this;
        }

        public Criteria andDictValueNameIsNotNull() {
            addCriterion("dict_value_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictValueNameEqualTo(String value) {
            addCriterion("dict_value_name =", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameNotEqualTo(String value) {
            addCriterion("dict_value_name <>", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameGreaterThan(String value) {
            addCriterion("dict_value_name >", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameGreaterThanOrEqualTo(String value) {
            addCriterion("dict_value_name >=", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameLessThan(String value) {
            addCriterion("dict_value_name <", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameLessThanOrEqualTo(String value) {
            addCriterion("dict_value_name <=", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameLike(String value) {
            addCriterion("dict_value_name like", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameNotLike(String value) {
            addCriterion("dict_value_name not like", value, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameIn(List<String> values) {
            addCriterion("dict_value_name in", values, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameNotIn(List<String> values) {
            addCriterion("dict_value_name not in", values, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameBetween(String value1, String value2) {
            addCriterion("dict_value_name between", value1, value2, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andDictValueNameNotBetween(String value1, String value2) {
            addCriterion("dict_value_name not between", value1, value2, "dictValueName");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdIsNull() {
            addCriterion("super_value_id is null");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdIsNotNull() {
            addCriterion("super_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdEqualTo(String value) {
            addCriterion("super_value_id =", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdNotEqualTo(String value) {
            addCriterion("super_value_id <>", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdGreaterThan(String value) {
            addCriterion("super_value_id >", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdGreaterThanOrEqualTo(String value) {
            addCriterion("super_value_id >=", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdLessThan(String value) {
            addCriterion("super_value_id <", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdLessThanOrEqualTo(String value) {
            addCriterion("super_value_id <=", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdLike(String value) {
            addCriterion("super_value_id like", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdNotLike(String value) {
            addCriterion("super_value_id not like", value, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdIn(List<String> values) {
            addCriterion("super_value_id in", values, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdNotIn(List<String> values) {
            addCriterion("super_value_id not in", values, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdBetween(String value1, String value2) {
            addCriterion("super_value_id between", value1, value2, "superValueId");
            return (Criteria) this;
        }

        public Criteria andSuperValueIdNotBetween(String value1, String value2) {
            addCriterion("super_value_id not between", value1, value2, "superValueId");
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