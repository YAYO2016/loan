package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class DictSysFuncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictSysFuncExample() {
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

        public Criteria andFuncIdIsNull() {
            addCriterion("func_id is null");
            return (Criteria) this;
        }

        public Criteria andFuncIdIsNotNull() {
            addCriterion("func_id is not null");
            return (Criteria) this;
        }

        public Criteria andFuncIdEqualTo(String value) {
            addCriterion("func_id =", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotEqualTo(String value) {
            addCriterion("func_id <>", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThan(String value) {
            addCriterion("func_id >", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdGreaterThanOrEqualTo(String value) {
            addCriterion("func_id >=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThan(String value) {
            addCriterion("func_id <", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLessThanOrEqualTo(String value) {
            addCriterion("func_id <=", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdLike(String value) {
            addCriterion("func_id like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotLike(String value) {
            addCriterion("func_id not like", value, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdIn(List<String> values) {
            addCriterion("func_id in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotIn(List<String> values) {
            addCriterion("func_id not in", values, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdBetween(String value1, String value2) {
            addCriterion("func_id between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncIdNotBetween(String value1, String value2) {
            addCriterion("func_id not between", value1, value2, "funcId");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNull() {
            addCriterion("func_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("func_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("func_name =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("func_name <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("func_name >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_name >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("func_name <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("func_name <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("func_name like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("func_name not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("func_name in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("func_name not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("func_name between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("func_name not between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdIsNull() {
            addCriterion("super_func_id is null");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdIsNotNull() {
            addCriterion("super_func_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdEqualTo(String value) {
            addCriterion("super_func_id =", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdNotEqualTo(String value) {
            addCriterion("super_func_id <>", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdGreaterThan(String value) {
            addCriterion("super_func_id >", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdGreaterThanOrEqualTo(String value) {
            addCriterion("super_func_id >=", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdLessThan(String value) {
            addCriterion("super_func_id <", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdLessThanOrEqualTo(String value) {
            addCriterion("super_func_id <=", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdLike(String value) {
            addCriterion("super_func_id like", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdNotLike(String value) {
            addCriterion("super_func_id not like", value, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdIn(List<String> values) {
            addCriterion("super_func_id in", values, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdNotIn(List<String> values) {
            addCriterion("super_func_id not in", values, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdBetween(String value1, String value2) {
            addCriterion("super_func_id between", value1, value2, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andSuperFuncIdNotBetween(String value1, String value2) {
            addCriterion("super_func_id not between", value1, value2, "superFuncId");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNull() {
            addCriterion("func_type is null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIsNotNull() {
            addCriterion("func_type is not null");
            return (Criteria) this;
        }

        public Criteria andFuncTypeEqualTo(String value) {
            addCriterion("func_type =", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotEqualTo(String value) {
            addCriterion("func_type <>", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThan(String value) {
            addCriterion("func_type >", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeGreaterThanOrEqualTo(String value) {
            addCriterion("func_type >=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThan(String value) {
            addCriterion("func_type <", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLessThanOrEqualTo(String value) {
            addCriterion("func_type <=", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeLike(String value) {
            addCriterion("func_type like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotLike(String value) {
            addCriterion("func_type not like", value, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeIn(List<String> values) {
            addCriterion("func_type in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotIn(List<String> values) {
            addCriterion("func_type not in", values, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeBetween(String value1, String value2) {
            addCriterion("func_type between", value1, value2, "funcType");
            return (Criteria) this;
        }

        public Criteria andFuncTypeNotBetween(String value1, String value2) {
            addCriterion("func_type not between", value1, value2, "funcType");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNull() {
            addCriterion("seq_num is null");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNotNull() {
            addCriterion("seq_num is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNumEqualTo(Integer value) {
            addCriterion("seq_num =", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotEqualTo(Integer value) {
            addCriterion("seq_num <>", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThan(Integer value) {
            addCriterion("seq_num >", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_num >=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThan(Integer value) {
            addCriterion("seq_num <", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThanOrEqualTo(Integer value) {
            addCriterion("seq_num <=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumIn(List<Integer> values) {
            addCriterion("seq_num in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotIn(List<Integer> values) {
            addCriterion("seq_num not in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumBetween(Integer value1, Integer value2) {
            addCriterion("seq_num between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_num not between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNull() {
            addCriterion("func_url is null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIsNotNull() {
            addCriterion("func_url is not null");
            return (Criteria) this;
        }

        public Criteria andFuncUrlEqualTo(String value) {
            addCriterion("func_url =", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotEqualTo(String value) {
            addCriterion("func_url <>", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThan(String value) {
            addCriterion("func_url >", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("func_url >=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThan(String value) {
            addCriterion("func_url <", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLessThanOrEqualTo(String value) {
            addCriterion("func_url <=", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlLike(String value) {
            addCriterion("func_url like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotLike(String value) {
            addCriterion("func_url not like", value, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlIn(List<String> values) {
            addCriterion("func_url in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotIn(List<String> values) {
            addCriterion("func_url not in", values, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlBetween(String value1, String value2) {
            addCriterion("func_url between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andFuncUrlNotBetween(String value1, String value2) {
            addCriterion("func_url not between", value1, value2, "funcUrl");
            return (Criteria) this;
        }

        public Criteria andMenuPictureIsNull() {
            addCriterion("menu_picture is null");
            return (Criteria) this;
        }

        public Criteria andMenuPictureIsNotNull() {
            addCriterion("menu_picture is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPictureEqualTo(String value) {
            addCriterion("menu_picture =", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureNotEqualTo(String value) {
            addCriterion("menu_picture <>", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureGreaterThan(String value) {
            addCriterion("menu_picture >", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureGreaterThanOrEqualTo(String value) {
            addCriterion("menu_picture >=", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureLessThan(String value) {
            addCriterion("menu_picture <", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureLessThanOrEqualTo(String value) {
            addCriterion("menu_picture <=", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureLike(String value) {
            addCriterion("menu_picture like", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureNotLike(String value) {
            addCriterion("menu_picture not like", value, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureIn(List<String> values) {
            addCriterion("menu_picture in", values, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureNotIn(List<String> values) {
            addCriterion("menu_picture not in", values, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureBetween(String value1, String value2) {
            addCriterion("menu_picture between", value1, value2, "menuPicture");
            return (Criteria) this;
        }

        public Criteria andMenuPictureNotBetween(String value1, String value2) {
            addCriterion("menu_picture not between", value1, value2, "menuPicture");
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