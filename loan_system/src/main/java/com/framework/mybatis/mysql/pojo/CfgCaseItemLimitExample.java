package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class CfgCaseItemLimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgCaseItemLimitExample() {
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

        public Criteria andCaseTypeIsNull() {
            addCriterion("case_type is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("case_type is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(String value) {
            addCriterion("case_type =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(String value) {
            addCriterion("case_type <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(String value) {
            addCriterion("case_type >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("case_type >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(String value) {
            addCriterion("case_type <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(String value) {
            addCriterion("case_type <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLike(String value) {
            addCriterion("case_type like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotLike(String value) {
            addCriterion("case_type not like", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<String> values) {
            addCriterion("case_type in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<String> values) {
            addCriterion("case_type not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(String value1, String value2) {
            addCriterion("case_type between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(String value1, String value2) {
            addCriterion("case_type not between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andScageIdIsNull() {
            addCriterion("scage_id is null");
            return (Criteria) this;
        }

        public Criteria andScageIdIsNotNull() {
            addCriterion("scage_id is not null");
            return (Criteria) this;
        }

        public Criteria andScageIdEqualTo(String value) {
            addCriterion("scage_id =", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdNotEqualTo(String value) {
            addCriterion("scage_id <>", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdGreaterThan(String value) {
            addCriterion("scage_id >", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdGreaterThanOrEqualTo(String value) {
            addCriterion("scage_id >=", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdLessThan(String value) {
            addCriterion("scage_id <", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdLessThanOrEqualTo(String value) {
            addCriterion("scage_id <=", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdLike(String value) {
            addCriterion("scage_id like", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdNotLike(String value) {
            addCriterion("scage_id not like", value, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdIn(List<String> values) {
            addCriterion("scage_id in", values, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdNotIn(List<String> values) {
            addCriterion("scage_id not in", values, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdBetween(String value1, String value2) {
            addCriterion("scage_id between", value1, value2, "scageId");
            return (Criteria) this;
        }

        public Criteria andScageIdNotBetween(String value1, String value2) {
            addCriterion("scage_id not between", value1, value2, "scageId");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNull() {
            addCriterion("step_id is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("step_id is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(String value) {
            addCriterion("step_id =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(String value) {
            addCriterion("step_id <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(String value) {
            addCriterion("step_id >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("step_id >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(String value) {
            addCriterion("step_id <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(String value) {
            addCriterion("step_id <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLike(String value) {
            addCriterion("step_id like", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotLike(String value) {
            addCriterion("step_id not like", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<String> values) {
            addCriterion("step_id in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<String> values) {
            addCriterion("step_id not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(String value1, String value2) {
            addCriterion("step_id between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(String value1, String value2) {
            addCriterion("step_id not between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andColmNameIsNull() {
            addCriterion("colm_name is null");
            return (Criteria) this;
        }

        public Criteria andColmNameIsNotNull() {
            addCriterion("colm_name is not null");
            return (Criteria) this;
        }

        public Criteria andColmNameEqualTo(String value) {
            addCriterion("colm_name =", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameNotEqualTo(String value) {
            addCriterion("colm_name <>", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameGreaterThan(String value) {
            addCriterion("colm_name >", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameGreaterThanOrEqualTo(String value) {
            addCriterion("colm_name >=", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameLessThan(String value) {
            addCriterion("colm_name <", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameLessThanOrEqualTo(String value) {
            addCriterion("colm_name <=", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameLike(String value) {
            addCriterion("colm_name like", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameNotLike(String value) {
            addCriterion("colm_name not like", value, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameIn(List<String> values) {
            addCriterion("colm_name in", values, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameNotIn(List<String> values) {
            addCriterion("colm_name not in", values, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameBetween(String value1, String value2) {
            addCriterion("colm_name between", value1, value2, "colmName");
            return (Criteria) this;
        }

        public Criteria andColmNameNotBetween(String value1, String value2) {
            addCriterion("colm_name not between", value1, value2, "colmName");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(String value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(String value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(String value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(String value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(String value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLike(String value) {
            addCriterion("is_show like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotLike(String value) {
            addCriterion("is_show not like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<String> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<String> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(String value1, String value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(String value1, String value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsReqIsNull() {
            addCriterion("is_req is null");
            return (Criteria) this;
        }

        public Criteria andIsReqIsNotNull() {
            addCriterion("is_req is not null");
            return (Criteria) this;
        }

        public Criteria andIsReqEqualTo(String value) {
            addCriterion("is_req =", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqNotEqualTo(String value) {
            addCriterion("is_req <>", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqGreaterThan(String value) {
            addCriterion("is_req >", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqGreaterThanOrEqualTo(String value) {
            addCriterion("is_req >=", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqLessThan(String value) {
            addCriterion("is_req <", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqLessThanOrEqualTo(String value) {
            addCriterion("is_req <=", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqLike(String value) {
            addCriterion("is_req like", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqNotLike(String value) {
            addCriterion("is_req not like", value, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqIn(List<String> values) {
            addCriterion("is_req in", values, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqNotIn(List<String> values) {
            addCriterion("is_req not in", values, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqBetween(String value1, String value2) {
            addCriterion("is_req between", value1, value2, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsReqNotBetween(String value1, String value2) {
            addCriterion("is_req not between", value1, value2, "isReq");
            return (Criteria) this;
        }

        public Criteria andIsModifyIsNull() {
            addCriterion("is_modify is null");
            return (Criteria) this;
        }

        public Criteria andIsModifyIsNotNull() {
            addCriterion("is_modify is not null");
            return (Criteria) this;
        }

        public Criteria andIsModifyEqualTo(String value) {
            addCriterion("is_modify =", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyNotEqualTo(String value) {
            addCriterion("is_modify <>", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyGreaterThan(String value) {
            addCriterion("is_modify >", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyGreaterThanOrEqualTo(String value) {
            addCriterion("is_modify >=", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyLessThan(String value) {
            addCriterion("is_modify <", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyLessThanOrEqualTo(String value) {
            addCriterion("is_modify <=", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyLike(String value) {
            addCriterion("is_modify like", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyNotLike(String value) {
            addCriterion("is_modify not like", value, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyIn(List<String> values) {
            addCriterion("is_modify in", values, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyNotIn(List<String> values) {
            addCriterion("is_modify not in", values, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyBetween(String value1, String value2) {
            addCriterion("is_modify between", value1, value2, "isModify");
            return (Criteria) this;
        }

        public Criteria andIsModifyNotBetween(String value1, String value2) {
            addCriterion("is_modify not between", value1, value2, "isModify");
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