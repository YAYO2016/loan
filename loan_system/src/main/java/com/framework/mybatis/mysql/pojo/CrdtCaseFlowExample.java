package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrdtCaseFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrdtCaseFlowExample() {
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

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNull() {
            addCriterion("deal_user is null");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNotNull() {
            addCriterion("deal_user is not null");
            return (Criteria) this;
        }

        public Criteria andDealUserEqualTo(String value) {
            addCriterion("deal_user =", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotEqualTo(String value) {
            addCriterion("deal_user <>", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThan(String value) {
            addCriterion("deal_user >", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThanOrEqualTo(String value) {
            addCriterion("deal_user >=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThan(String value) {
            addCriterion("deal_user <", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThanOrEqualTo(String value) {
            addCriterion("deal_user <=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLike(String value) {
            addCriterion("deal_user like", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotLike(String value) {
            addCriterion("deal_user not like", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserIn(List<String> values) {
            addCriterion("deal_user in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotIn(List<String> values) {
            addCriterion("deal_user not in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserBetween(String value1, String value2) {
            addCriterion("deal_user between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotBetween(String value1, String value2) {
            addCriterion("deal_user not between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealResuleIsNull() {
            addCriterion("deal_resule is null");
            return (Criteria) this;
        }

        public Criteria andDealResuleIsNotNull() {
            addCriterion("deal_resule is not null");
            return (Criteria) this;
        }

        public Criteria andDealResuleEqualTo(String value) {
            addCriterion("deal_resule =", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleNotEqualTo(String value) {
            addCriterion("deal_resule <>", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleGreaterThan(String value) {
            addCriterion("deal_resule >", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleGreaterThanOrEqualTo(String value) {
            addCriterion("deal_resule >=", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleLessThan(String value) {
            addCriterion("deal_resule <", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleLessThanOrEqualTo(String value) {
            addCriterion("deal_resule <=", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleLike(String value) {
            addCriterion("deal_resule like", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleNotLike(String value) {
            addCriterion("deal_resule not like", value, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleIn(List<String> values) {
            addCriterion("deal_resule in", values, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleNotIn(List<String> values) {
            addCriterion("deal_resule not in", values, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleBetween(String value1, String value2) {
            addCriterion("deal_resule between", value1, value2, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealResuleNotBetween(String value1, String value2) {
            addCriterion("deal_resule not between", value1, value2, "dealResule");
            return (Criteria) this;
        }

        public Criteria andDealInfoIsNull() {
            addCriterion("deal_info is null");
            return (Criteria) this;
        }

        public Criteria andDealInfoIsNotNull() {
            addCriterion("deal_info is not null");
            return (Criteria) this;
        }

        public Criteria andDealInfoEqualTo(String value) {
            addCriterion("deal_info =", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoNotEqualTo(String value) {
            addCriterion("deal_info <>", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoGreaterThan(String value) {
            addCriterion("deal_info >", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoGreaterThanOrEqualTo(String value) {
            addCriterion("deal_info >=", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoLessThan(String value) {
            addCriterion("deal_info <", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoLessThanOrEqualTo(String value) {
            addCriterion("deal_info <=", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoLike(String value) {
            addCriterion("deal_info like", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoNotLike(String value) {
            addCriterion("deal_info not like", value, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoIn(List<String> values) {
            addCriterion("deal_info in", values, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoNotIn(List<String> values) {
            addCriterion("deal_info not in", values, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoBetween(String value1, String value2) {
            addCriterion("deal_info between", value1, value2, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andDealInfoNotBetween(String value1, String value2) {
            addCriterion("deal_info not between", value1, value2, "dealInfo");
            return (Criteria) this;
        }

        public Criteria andSeqNumberIsNull() {
            addCriterion("seq_number is null");
            return (Criteria) this;
        }

        public Criteria andSeqNumberIsNotNull() {
            addCriterion("seq_number is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNumberEqualTo(Integer value) {
            addCriterion("seq_number =", value, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberNotEqualTo(Integer value) {
            addCriterion("seq_number <>", value, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberGreaterThan(Integer value) {
            addCriterion("seq_number >", value, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_number >=", value, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberLessThan(Integer value) {
            addCriterion("seq_number <", value, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberLessThanOrEqualTo(Integer value) {
            addCriterion("seq_number <=", value, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberIn(List<Integer> values) {
            addCriterion("seq_number in", values, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberNotIn(List<Integer> values) {
            addCriterion("seq_number not in", values, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberBetween(Integer value1, Integer value2) {
            addCriterion("seq_number between", value1, value2, "seqNumber");
            return (Criteria) this;
        }

        public Criteria andSeqNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_number not between", value1, value2, "seqNumber");
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

        public Criteria andNextUserIsNull() {
            addCriterion("next_user is null");
            return (Criteria) this;
        }

        public Criteria andNextUserIsNotNull() {
            addCriterion("next_user is not null");
            return (Criteria) this;
        }

        public Criteria andNextUserEqualTo(String value) {
            addCriterion("next_user =", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotEqualTo(String value) {
            addCriterion("next_user <>", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserGreaterThan(String value) {
            addCriterion("next_user >", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserGreaterThanOrEqualTo(String value) {
            addCriterion("next_user >=", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserLessThan(String value) {
            addCriterion("next_user <", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserLessThanOrEqualTo(String value) {
            addCriterion("next_user <=", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserLike(String value) {
            addCriterion("next_user like", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotLike(String value) {
            addCriterion("next_user not like", value, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserIn(List<String> values) {
            addCriterion("next_user in", values, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotIn(List<String> values) {
            addCriterion("next_user not in", values, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserBetween(String value1, String value2) {
            addCriterion("next_user between", value1, value2, "nextUser");
            return (Criteria) this;
        }

        public Criteria andNextUserNotBetween(String value1, String value2) {
            addCriterion("next_user not between", value1, value2, "nextUser");
            return (Criteria) this;
        }

        public Criteria andIsTransIsNull() {
            addCriterion("is_trans is null");
            return (Criteria) this;
        }

        public Criteria andIsTransIsNotNull() {
            addCriterion("is_trans is not null");
            return (Criteria) this;
        }

        public Criteria andIsTransEqualTo(String value) {
            addCriterion("is_trans =", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotEqualTo(String value) {
            addCriterion("is_trans <>", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransGreaterThan(String value) {
            addCriterion("is_trans >", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransGreaterThanOrEqualTo(String value) {
            addCriterion("is_trans >=", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransLessThan(String value) {
            addCriterion("is_trans <", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransLessThanOrEqualTo(String value) {
            addCriterion("is_trans <=", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransLike(String value) {
            addCriterion("is_trans like", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotLike(String value) {
            addCriterion("is_trans not like", value, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransIn(List<String> values) {
            addCriterion("is_trans in", values, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotIn(List<String> values) {
            addCriterion("is_trans not in", values, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransBetween(String value1, String value2) {
            addCriterion("is_trans between", value1, value2, "isTrans");
            return (Criteria) this;
        }

        public Criteria andIsTransNotBetween(String value1, String value2) {
            addCriterion("is_trans not between", value1, value2, "isTrans");
            return (Criteria) this;
        }

        public Criteria andAllotUserIsNull() {
            addCriterion("allot_user is null");
            return (Criteria) this;
        }

        public Criteria andAllotUserIsNotNull() {
            addCriterion("allot_user is not null");
            return (Criteria) this;
        }

        public Criteria andAllotUserEqualTo(String value) {
            addCriterion("allot_user =", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserNotEqualTo(String value) {
            addCriterion("allot_user <>", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserGreaterThan(String value) {
            addCriterion("allot_user >", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserGreaterThanOrEqualTo(String value) {
            addCriterion("allot_user >=", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserLessThan(String value) {
            addCriterion("allot_user <", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserLessThanOrEqualTo(String value) {
            addCriterion("allot_user <=", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserLike(String value) {
            addCriterion("allot_user like", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserNotLike(String value) {
            addCriterion("allot_user not like", value, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserIn(List<String> values) {
            addCriterion("allot_user in", values, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserNotIn(List<String> values) {
            addCriterion("allot_user not in", values, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserBetween(String value1, String value2) {
            addCriterion("allot_user between", value1, value2, "allotUser");
            return (Criteria) this;
        }

        public Criteria andAllotUserNotBetween(String value1, String value2) {
            addCriterion("allot_user not between", value1, value2, "allotUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserIsNull() {
            addCriterion("express_user is null");
            return (Criteria) this;
        }

        public Criteria andExpressUserIsNotNull() {
            addCriterion("express_user is not null");
            return (Criteria) this;
        }

        public Criteria andExpressUserEqualTo(String value) {
            addCriterion("express_user =", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserNotEqualTo(String value) {
            addCriterion("express_user <>", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserGreaterThan(String value) {
            addCriterion("express_user >", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserGreaterThanOrEqualTo(String value) {
            addCriterion("express_user >=", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserLessThan(String value) {
            addCriterion("express_user <", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserLessThanOrEqualTo(String value) {
            addCriterion("express_user <=", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserLike(String value) {
            addCriterion("express_user like", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserNotLike(String value) {
            addCriterion("express_user not like", value, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserIn(List<String> values) {
            addCriterion("express_user in", values, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserNotIn(List<String> values) {
            addCriterion("express_user not in", values, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserBetween(String value1, String value2) {
            addCriterion("express_user between", value1, value2, "expressUser");
            return (Criteria) this;
        }

        public Criteria andExpressUserNotBetween(String value1, String value2) {
            addCriterion("express_user not between", value1, value2, "expressUser");
            return (Criteria) this;
        }

        public Criteria andAllotTimeIsNull() {
            addCriterion("allot_time is null");
            return (Criteria) this;
        }

        public Criteria andAllotTimeIsNotNull() {
            addCriterion("allot_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllotTimeEqualTo(Date value) {
            addCriterion("allot_time =", value, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeNotEqualTo(Date value) {
            addCriterion("allot_time <>", value, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeGreaterThan(Date value) {
            addCriterion("allot_time >", value, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("allot_time >=", value, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeLessThan(Date value) {
            addCriterion("allot_time <", value, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeLessThanOrEqualTo(Date value) {
            addCriterion("allot_time <=", value, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeIn(List<Date> values) {
            addCriterion("allot_time in", values, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeNotIn(List<Date> values) {
            addCriterion("allot_time not in", values, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeBetween(Date value1, Date value2) {
            addCriterion("allot_time between", value1, value2, "allotTime");
            return (Criteria) this;
        }

        public Criteria andAllotTimeNotBetween(Date value1, Date value2) {
            addCriterion("allot_time not between", value1, value2, "allotTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeIsNull() {
            addCriterion("get_time is null");
            return (Criteria) this;
        }

        public Criteria andGetTimeIsNotNull() {
            addCriterion("get_time is not null");
            return (Criteria) this;
        }

        public Criteria andGetTimeEqualTo(Date value) {
            addCriterion("get_time =", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotEqualTo(Date value) {
            addCriterion("get_time <>", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeGreaterThan(Date value) {
            addCriterion("get_time >", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("get_time >=", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeLessThan(Date value) {
            addCriterion("get_time <", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeLessThanOrEqualTo(Date value) {
            addCriterion("get_time <=", value, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeIn(List<Date> values) {
            addCriterion("get_time in", values, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotIn(List<Date> values) {
            addCriterion("get_time not in", values, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeBetween(Date value1, Date value2) {
            addCriterion("get_time between", value1, value2, "getTime");
            return (Criteria) this;
        }

        public Criteria andGetTimeNotBetween(Date value1, Date value2) {
            addCriterion("get_time not between", value1, value2, "getTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
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