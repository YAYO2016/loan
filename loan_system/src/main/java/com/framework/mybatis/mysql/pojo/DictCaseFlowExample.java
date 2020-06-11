package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class DictCaseFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictCaseFlowExample() {
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

        public Criteria andScageNameIsNull() {
            addCriterion("scage_name is null");
            return (Criteria) this;
        }

        public Criteria andScageNameIsNotNull() {
            addCriterion("scage_name is not null");
            return (Criteria) this;
        }

        public Criteria andScageNameEqualTo(String value) {
            addCriterion("scage_name =", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameNotEqualTo(String value) {
            addCriterion("scage_name <>", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameGreaterThan(String value) {
            addCriterion("scage_name >", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameGreaterThanOrEqualTo(String value) {
            addCriterion("scage_name >=", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameLessThan(String value) {
            addCriterion("scage_name <", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameLessThanOrEqualTo(String value) {
            addCriterion("scage_name <=", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameLike(String value) {
            addCriterion("scage_name like", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameNotLike(String value) {
            addCriterion("scage_name not like", value, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameIn(List<String> values) {
            addCriterion("scage_name in", values, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameNotIn(List<String> values) {
            addCriterion("scage_name not in", values, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameBetween(String value1, String value2) {
            addCriterion("scage_name between", value1, value2, "scageName");
            return (Criteria) this;
        }

        public Criteria andScageNameNotBetween(String value1, String value2) {
            addCriterion("scage_name not between", value1, value2, "scageName");
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

        public Criteria andStepNameIsNull() {
            addCriterion("step_name is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("step_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("step_name =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("step_name <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("step_name >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_name >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("step_name <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("step_name <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("step_name like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("step_name not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("step_name in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("step_name not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("step_name between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("step_name not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNull() {
            addCriterion("step_type is null");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNotNull() {
            addCriterion("step_type is not null");
            return (Criteria) this;
        }

        public Criteria andStepTypeEqualTo(String value) {
            addCriterion("step_type =", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotEqualTo(String value) {
            addCriterion("step_type <>", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThan(String value) {
            addCriterion("step_type >", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThanOrEqualTo(String value) {
            addCriterion("step_type >=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThan(String value) {
            addCriterion("step_type <", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThanOrEqualTo(String value) {
            addCriterion("step_type <=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLike(String value) {
            addCriterion("step_type like", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotLike(String value) {
            addCriterion("step_type not like", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeIn(List<String> values) {
            addCriterion("step_type in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotIn(List<String> values) {
            addCriterion("step_type not in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeBetween(String value1, String value2) {
            addCriterion("step_type between", value1, value2, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotBetween(String value1, String value2) {
            addCriterion("step_type not between", value1, value2, "stepType");
            return (Criteria) this;
        }

        public Criteria andNextScageIdIsNull() {
            addCriterion("next_scage_id is null");
            return (Criteria) this;
        }

        public Criteria andNextScageIdIsNotNull() {
            addCriterion("next_scage_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextScageIdEqualTo(String value) {
            addCriterion("next_scage_id =", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdNotEqualTo(String value) {
            addCriterion("next_scage_id <>", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdGreaterThan(String value) {
            addCriterion("next_scage_id >", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdGreaterThanOrEqualTo(String value) {
            addCriterion("next_scage_id >=", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdLessThan(String value) {
            addCriterion("next_scage_id <", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdLessThanOrEqualTo(String value) {
            addCriterion("next_scage_id <=", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdLike(String value) {
            addCriterion("next_scage_id like", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdNotLike(String value) {
            addCriterion("next_scage_id not like", value, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdIn(List<String> values) {
            addCriterion("next_scage_id in", values, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdNotIn(List<String> values) {
            addCriterion("next_scage_id not in", values, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdBetween(String value1, String value2) {
            addCriterion("next_scage_id between", value1, value2, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextScageIdNotBetween(String value1, String value2) {
            addCriterion("next_scage_id not between", value1, value2, "nextScageId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdIsNull() {
            addCriterion("next_step_id is null");
            return (Criteria) this;
        }

        public Criteria andNextStepIdIsNotNull() {
            addCriterion("next_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextStepIdEqualTo(String value) {
            addCriterion("next_step_id =", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdNotEqualTo(String value) {
            addCriterion("next_step_id <>", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdGreaterThan(String value) {
            addCriterion("next_step_id >", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("next_step_id >=", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdLessThan(String value) {
            addCriterion("next_step_id <", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdLessThanOrEqualTo(String value) {
            addCriterion("next_step_id <=", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdLike(String value) {
            addCriterion("next_step_id like", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdNotLike(String value) {
            addCriterion("next_step_id not like", value, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdIn(List<String> values) {
            addCriterion("next_step_id in", values, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdNotIn(List<String> values) {
            addCriterion("next_step_id not in", values, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdBetween(String value1, String value2) {
            addCriterion("next_step_id between", value1, value2, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andNextStepIdNotBetween(String value1, String value2) {
            addCriterion("next_step_id not between", value1, value2, "nextStepId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdIsNull() {
            addCriterion("back_scage_id is null");
            return (Criteria) this;
        }

        public Criteria andBackScageIdIsNotNull() {
            addCriterion("back_scage_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackScageIdEqualTo(String value) {
            addCriterion("back_scage_id =", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdNotEqualTo(String value) {
            addCriterion("back_scage_id <>", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdGreaterThan(String value) {
            addCriterion("back_scage_id >", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdGreaterThanOrEqualTo(String value) {
            addCriterion("back_scage_id >=", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdLessThan(String value) {
            addCriterion("back_scage_id <", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdLessThanOrEqualTo(String value) {
            addCriterion("back_scage_id <=", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdLike(String value) {
            addCriterion("back_scage_id like", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdNotLike(String value) {
            addCriterion("back_scage_id not like", value, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdIn(List<String> values) {
            addCriterion("back_scage_id in", values, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdNotIn(List<String> values) {
            addCriterion("back_scage_id not in", values, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdBetween(String value1, String value2) {
            addCriterion("back_scage_id between", value1, value2, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackScageIdNotBetween(String value1, String value2) {
            addCriterion("back_scage_id not between", value1, value2, "backScageId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdIsNull() {
            addCriterion("back_step_id is null");
            return (Criteria) this;
        }

        public Criteria andBackStepIdIsNotNull() {
            addCriterion("back_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackStepIdEqualTo(String value) {
            addCriterion("back_step_id =", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdNotEqualTo(String value) {
            addCriterion("back_step_id <>", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdGreaterThan(String value) {
            addCriterion("back_step_id >", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("back_step_id >=", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdLessThan(String value) {
            addCriterion("back_step_id <", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdLessThanOrEqualTo(String value) {
            addCriterion("back_step_id <=", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdLike(String value) {
            addCriterion("back_step_id like", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdNotLike(String value) {
            addCriterion("back_step_id not like", value, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdIn(List<String> values) {
            addCriterion("back_step_id in", values, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdNotIn(List<String> values) {
            addCriterion("back_step_id not in", values, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdBetween(String value1, String value2) {
            addCriterion("back_step_id between", value1, value2, "backStepId");
            return (Criteria) this;
        }

        public Criteria andBackStepIdNotBetween(String value1, String value2) {
            addCriterion("back_step_id not between", value1, value2, "backStepId");
            return (Criteria) this;
        }

        public Criteria andDaysLimitIsNull() {
            addCriterion("days_limit is null");
            return (Criteria) this;
        }

        public Criteria andDaysLimitIsNotNull() {
            addCriterion("days_limit is not null");
            return (Criteria) this;
        }

        public Criteria andDaysLimitEqualTo(Integer value) {
            addCriterion("days_limit =", value, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitNotEqualTo(Integer value) {
            addCriterion("days_limit <>", value, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitGreaterThan(Integer value) {
            addCriterion("days_limit >", value, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("days_limit >=", value, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitLessThan(Integer value) {
            addCriterion("days_limit <", value, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitLessThanOrEqualTo(Integer value) {
            addCriterion("days_limit <=", value, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitIn(List<Integer> values) {
            addCriterion("days_limit in", values, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitNotIn(List<Integer> values) {
            addCriterion("days_limit not in", values, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitBetween(Integer value1, Integer value2) {
            addCriterion("days_limit between", value1, value2, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andDaysLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("days_limit not between", value1, value2, "daysLimit");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdIsNull() {
            addCriterion("this_role_id is null");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdIsNotNull() {
            addCriterion("this_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdEqualTo(String value) {
            addCriterion("this_role_id =", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdNotEqualTo(String value) {
            addCriterion("this_role_id <>", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdGreaterThan(String value) {
            addCriterion("this_role_id >", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("this_role_id >=", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdLessThan(String value) {
            addCriterion("this_role_id <", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdLessThanOrEqualTo(String value) {
            addCriterion("this_role_id <=", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdLike(String value) {
            addCriterion("this_role_id like", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdNotLike(String value) {
            addCriterion("this_role_id not like", value, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdIn(List<String> values) {
            addCriterion("this_role_id in", values, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdNotIn(List<String> values) {
            addCriterion("this_role_id not in", values, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdBetween(String value1, String value2) {
            addCriterion("this_role_id between", value1, value2, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andThisRoleIdNotBetween(String value1, String value2) {
            addCriterion("this_role_id not between", value1, value2, "thisRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdIsNull() {
            addCriterion("next_role_id is null");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdIsNotNull() {
            addCriterion("next_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdEqualTo(String value) {
            addCriterion("next_role_id =", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotEqualTo(String value) {
            addCriterion("next_role_id <>", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdGreaterThan(String value) {
            addCriterion("next_role_id >", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("next_role_id >=", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdLessThan(String value) {
            addCriterion("next_role_id <", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdLessThanOrEqualTo(String value) {
            addCriterion("next_role_id <=", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdLike(String value) {
            addCriterion("next_role_id like", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotLike(String value) {
            addCriterion("next_role_id not like", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdIn(List<String> values) {
            addCriterion("next_role_id in", values, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotIn(List<String> values) {
            addCriterion("next_role_id not in", values, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdBetween(String value1, String value2) {
            addCriterion("next_role_id between", value1, value2, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotBetween(String value1, String value2) {
            addCriterion("next_role_id not between", value1, value2, "nextRoleId");
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