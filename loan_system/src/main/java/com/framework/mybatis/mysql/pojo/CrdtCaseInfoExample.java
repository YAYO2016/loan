package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrdtCaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrdtCaseInfoExample() {
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

        public Criteria andCaseNameIsNull() {
            addCriterion("case_name is null");
            return (Criteria) this;
        }

        public Criteria andCaseNameIsNotNull() {
            addCriterion("case_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNameEqualTo(String value) {
            addCriterion("case_name =", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotEqualTo(String value) {
            addCriterion("case_name <>", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThan(String value) {
            addCriterion("case_name >", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("case_name >=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThan(String value) {
            addCriterion("case_name <", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThanOrEqualTo(String value) {
            addCriterion("case_name <=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLike(String value) {
            addCriterion("case_name like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotLike(String value) {
            addCriterion("case_name not like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameIn(List<String> values) {
            addCriterion("case_name in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotIn(List<String> values) {
            addCriterion("case_name not in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameBetween(String value1, String value2) {
            addCriterion("case_name between", value1, value2, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotBetween(String value1, String value2) {
            addCriterion("case_name not between", value1, value2, "caseName");
            return (Criteria) this;
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLoanFeeIsNull() {
            addCriterion("loan_fee is null");
            return (Criteria) this;
        }

        public Criteria andLoanFeeIsNotNull() {
            addCriterion("loan_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLoanFeeEqualTo(Double value) {
            addCriterion("loan_fee =", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeNotEqualTo(Double value) {
            addCriterion("loan_fee <>", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeGreaterThan(Double value) {
            addCriterion("loan_fee >", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_fee >=", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeLessThan(Double value) {
            addCriterion("loan_fee <", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeLessThanOrEqualTo(Double value) {
            addCriterion("loan_fee <=", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeIn(List<Double> values) {
            addCriterion("loan_fee in", values, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeNotIn(List<Double> values) {
            addCriterion("loan_fee not in", values, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeBetween(Double value1, Double value2) {
            addCriterion("loan_fee between", value1, value2, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeNotBetween(Double value1, Double value2) {
            addCriterion("loan_fee not between", value1, value2, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanYearIsNull() {
            addCriterion("loan_year is null");
            return (Criteria) this;
        }

        public Criteria andLoanYearIsNotNull() {
            addCriterion("loan_year is not null");
            return (Criteria) this;
        }

        public Criteria andLoanYearEqualTo(String value) {
            addCriterion("loan_year =", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearNotEqualTo(String value) {
            addCriterion("loan_year <>", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearGreaterThan(String value) {
            addCriterion("loan_year >", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearGreaterThanOrEqualTo(String value) {
            addCriterion("loan_year >=", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearLessThan(String value) {
            addCriterion("loan_year <", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearLessThanOrEqualTo(String value) {
            addCriterion("loan_year <=", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearLike(String value) {
            addCriterion("loan_year like", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearNotLike(String value) {
            addCriterion("loan_year not like", value, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearIn(List<String> values) {
            addCriterion("loan_year in", values, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearNotIn(List<String> values) {
            addCriterion("loan_year not in", values, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearBetween(String value1, String value2) {
            addCriterion("loan_year between", value1, value2, "loanYear");
            return (Criteria) this;
        }

        public Criteria andLoanYearNotBetween(String value1, String value2) {
            addCriterion("loan_year not between", value1, value2, "loanYear");
            return (Criteria) this;
        }

        public Criteria andRepayTypeIsNull() {
            addCriterion("repay_type is null");
            return (Criteria) this;
        }

        public Criteria andRepayTypeIsNotNull() {
            addCriterion("repay_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepayTypeEqualTo(String value) {
            addCriterion("repay_type =", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotEqualTo(String value) {
            addCriterion("repay_type <>", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeGreaterThan(String value) {
            addCriterion("repay_type >", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("repay_type >=", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeLessThan(String value) {
            addCriterion("repay_type <", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeLessThanOrEqualTo(String value) {
            addCriterion("repay_type <=", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeLike(String value) {
            addCriterion("repay_type like", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotLike(String value) {
            addCriterion("repay_type not like", value, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeIn(List<String> values) {
            addCriterion("repay_type in", values, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotIn(List<String> values) {
            addCriterion("repay_type not in", values, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeBetween(String value1, String value2) {
            addCriterion("repay_type between", value1, value2, "repayType");
            return (Criteria) this;
        }

        public Criteria andRepayTypeNotBetween(String value1, String value2) {
            addCriterion("repay_type not between", value1, value2, "repayType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNull() {
            addCriterion("loan_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(String value) {
            addCriterion("loan_type =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(String value) {
            addCriterion("loan_type <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(String value) {
            addCriterion("loan_type >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_type >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(String value) {
            addCriterion("loan_type <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(String value) {
            addCriterion("loan_type <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLike(String value) {
            addCriterion("loan_type like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotLike(String value) {
            addCriterion("loan_type not like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<String> values) {
            addCriterion("loan_type in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<String> values) {
            addCriterion("loan_type not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(String value1, String value2) {
            addCriterion("loan_type between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(String value1, String value2) {
            addCriterion("loan_type not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanBranchIsNull() {
            addCriterion("loan_branch is null");
            return (Criteria) this;
        }

        public Criteria andLoanBranchIsNotNull() {
            addCriterion("loan_branch is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBranchEqualTo(String value) {
            addCriterion("loan_branch =", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotEqualTo(String value) {
            addCriterion("loan_branch <>", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchGreaterThan(String value) {
            addCriterion("loan_branch >", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchGreaterThanOrEqualTo(String value) {
            addCriterion("loan_branch >=", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchLessThan(String value) {
            addCriterion("loan_branch <", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchLessThanOrEqualTo(String value) {
            addCriterion("loan_branch <=", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchLike(String value) {
            addCriterion("loan_branch like", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotLike(String value) {
            addCriterion("loan_branch not like", value, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchIn(List<String> values) {
            addCriterion("loan_branch in", values, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotIn(List<String> values) {
            addCriterion("loan_branch not in", values, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchBetween(String value1, String value2) {
            addCriterion("loan_branch between", value1, value2, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanBranchNotBetween(String value1, String value2) {
            addCriterion("loan_branch not between", value1, value2, "loanBranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchIsNull() {
            addCriterion("loan_subbranch is null");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchIsNotNull() {
            addCriterion("loan_subbranch is not null");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchEqualTo(String value) {
            addCriterion("loan_subbranch =", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchNotEqualTo(String value) {
            addCriterion("loan_subbranch <>", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchGreaterThan(String value) {
            addCriterion("loan_subbranch >", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchGreaterThanOrEqualTo(String value) {
            addCriterion("loan_subbranch >=", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchLessThan(String value) {
            addCriterion("loan_subbranch <", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchLessThanOrEqualTo(String value) {
            addCriterion("loan_subbranch <=", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchLike(String value) {
            addCriterion("loan_subbranch like", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchNotLike(String value) {
            addCriterion("loan_subbranch not like", value, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchIn(List<String> values) {
            addCriterion("loan_subbranch in", values, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchNotIn(List<String> values) {
            addCriterion("loan_subbranch not in", values, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchBetween(String value1, String value2) {
            addCriterion("loan_subbranch between", value1, value2, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andLoanSubbranchNotBetween(String value1, String value2) {
            addCriterion("loan_subbranch not between", value1, value2, "loanSubbranch");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNull() {
            addCriterion("contract_price is null");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNotNull() {
            addCriterion("contract_price is not null");
            return (Criteria) this;
        }

        public Criteria andContractPriceEqualTo(Double value) {
            addCriterion("contract_price =", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotEqualTo(Double value) {
            addCriterion("contract_price <>", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThan(Double value) {
            addCriterion("contract_price >", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_price >=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThan(Double value) {
            addCriterion("contract_price <", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThanOrEqualTo(Double value) {
            addCriterion("contract_price <=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceIn(List<Double> values) {
            addCriterion("contract_price in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotIn(List<Double> values) {
            addCriterion("contract_price not in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceBetween(Double value1, Double value2) {
            addCriterion("contract_price between", value1, value2, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotBetween(Double value1, Double value2) {
            addCriterion("contract_price not between", value1, value2, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceIsNull() {
            addCriterion("exam_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceIsNotNull() {
            addCriterion("exam_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceEqualTo(Double value) {
            addCriterion("exam_unit_price =", value, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceNotEqualTo(Double value) {
            addCriterion("exam_unit_price <>", value, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceGreaterThan(Double value) {
            addCriterion("exam_unit_price >", value, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("exam_unit_price >=", value, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceLessThan(Double value) {
            addCriterion("exam_unit_price <", value, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceLessThanOrEqualTo(Double value) {
            addCriterion("exam_unit_price <=", value, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceIn(List<Double> values) {
            addCriterion("exam_unit_price in", values, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceNotIn(List<Double> values) {
            addCriterion("exam_unit_price not in", values, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceBetween(Double value1, Double value2) {
            addCriterion("exam_unit_price between", value1, value2, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andExamUnitPriceNotBetween(Double value1, Double value2) {
            addCriterion("exam_unit_price not between", value1, value2, "examUnitPrice");
            return (Criteria) this;
        }

        public Criteria andLoanScaleIsNull() {
            addCriterion("loan_scale is null");
            return (Criteria) this;
        }

        public Criteria andLoanScaleIsNotNull() {
            addCriterion("loan_scale is not null");
            return (Criteria) this;
        }

        public Criteria andLoanScaleEqualTo(Double value) {
            addCriterion("loan_scale =", value, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleNotEqualTo(Double value) {
            addCriterion("loan_scale <>", value, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleGreaterThan(Double value) {
            addCriterion("loan_scale >", value, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleGreaterThanOrEqualTo(Double value) {
            addCriterion("loan_scale >=", value, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleLessThan(Double value) {
            addCriterion("loan_scale <", value, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleLessThanOrEqualTo(Double value) {
            addCriterion("loan_scale <=", value, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleIn(List<Double> values) {
            addCriterion("loan_scale in", values, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleNotIn(List<Double> values) {
            addCriterion("loan_scale not in", values, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleBetween(Double value1, Double value2) {
            addCriterion("loan_scale between", value1, value2, "loanScale");
            return (Criteria) this;
        }

        public Criteria andLoanScaleNotBetween(Double value1, Double value2) {
            addCriterion("loan_scale not between", value1, value2, "loanScale");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIsNull() {
            addCriterion("repay_account is null");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIsNotNull() {
            addCriterion("repay_account is not null");
            return (Criteria) this;
        }

        public Criteria andRepayAccountEqualTo(String value) {
            addCriterion("repay_account =", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountNotEqualTo(String value) {
            addCriterion("repay_account <>", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountGreaterThan(String value) {
            addCriterion("repay_account >", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("repay_account >=", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountLessThan(String value) {
            addCriterion("repay_account <", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountLessThanOrEqualTo(String value) {
            addCriterion("repay_account <=", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountLike(String value) {
            addCriterion("repay_account like", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountNotLike(String value) {
            addCriterion("repay_account not like", value, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIn(List<String> values) {
            addCriterion("repay_account in", values, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountNotIn(List<String> values) {
            addCriterion("repay_account not in", values, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountBetween(String value1, String value2) {
            addCriterion("repay_account between", value1, value2, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andRepayAccountNotBetween(String value1, String value2) {
            addCriterion("repay_account not between", value1, value2, "repayAccount");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerIsNull() {
            addCriterion("customer_manager is null");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerIsNotNull() {
            addCriterion("customer_manager is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerEqualTo(String value) {
            addCriterion("customer_manager =", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerNotEqualTo(String value) {
            addCriterion("customer_manager <>", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerGreaterThan(String value) {
            addCriterion("customer_manager >", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerGreaterThanOrEqualTo(String value) {
            addCriterion("customer_manager >=", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerLessThan(String value) {
            addCriterion("customer_manager <", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerLessThanOrEqualTo(String value) {
            addCriterion("customer_manager <=", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerLike(String value) {
            addCriterion("customer_manager like", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerNotLike(String value) {
            addCriterion("customer_manager not like", value, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerIn(List<String> values) {
            addCriterion("customer_manager in", values, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerNotIn(List<String> values) {
            addCriterion("customer_manager not in", values, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerBetween(String value1, String value2) {
            addCriterion("customer_manager between", value1, value2, "customerManager");
            return (Criteria) this;
        }

        public Criteria andCustomerManagerNotBetween(String value1, String value2) {
            addCriterion("customer_manager not between", value1, value2, "customerManager");
            return (Criteria) this;
        }

        public Criteria andHighScaleIsNull() {
            addCriterion("high_scale is null");
            return (Criteria) this;
        }

        public Criteria andHighScaleIsNotNull() {
            addCriterion("high_scale is not null");
            return (Criteria) this;
        }

        public Criteria andHighScaleEqualTo(Float value) {
            addCriterion("high_scale =", value, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleNotEqualTo(Float value) {
            addCriterion("high_scale <>", value, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleGreaterThan(Float value) {
            addCriterion("high_scale >", value, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleGreaterThanOrEqualTo(Float value) {
            addCriterion("high_scale >=", value, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleLessThan(Float value) {
            addCriterion("high_scale <", value, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleLessThanOrEqualTo(Float value) {
            addCriterion("high_scale <=", value, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleIn(List<Float> values) {
            addCriterion("high_scale in", values, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleNotIn(List<Float> values) {
            addCriterion("high_scale not in", values, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleBetween(Float value1, Float value2) {
            addCriterion("high_scale between", value1, value2, "highScale");
            return (Criteria) this;
        }

        public Criteria andHighScaleNotBetween(Float value1, Float value2) {
            addCriterion("high_scale not between", value1, value2, "highScale");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeIsNull() {
            addCriterion("pretrade_bus_type is null");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeIsNotNull() {
            addCriterion("pretrade_bus_type is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeEqualTo(String value) {
            addCriterion("pretrade_bus_type =", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeNotEqualTo(String value) {
            addCriterion("pretrade_bus_type <>", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeGreaterThan(String value) {
            addCriterion("pretrade_bus_type >", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pretrade_bus_type >=", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeLessThan(String value) {
            addCriterion("pretrade_bus_type <", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeLessThanOrEqualTo(String value) {
            addCriterion("pretrade_bus_type <=", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeLike(String value) {
            addCriterion("pretrade_bus_type like", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeNotLike(String value) {
            addCriterion("pretrade_bus_type not like", value, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeIn(List<String> values) {
            addCriterion("pretrade_bus_type in", values, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeNotIn(List<String> values) {
            addCriterion("pretrade_bus_type not in", values, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeBetween(String value1, String value2) {
            addCriterion("pretrade_bus_type between", value1, value2, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeBusTypeNotBetween(String value1, String value2) {
            addCriterion("pretrade_bus_type not between", value1, value2, "pretradeBusType");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseIsNull() {
            addCriterion("pretrade_house is null");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseIsNotNull() {
            addCriterion("pretrade_house is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseEqualTo(String value) {
            addCriterion("pretrade_house =", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseNotEqualTo(String value) {
            addCriterion("pretrade_house <>", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseGreaterThan(String value) {
            addCriterion("pretrade_house >", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseGreaterThanOrEqualTo(String value) {
            addCriterion("pretrade_house >=", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseLessThan(String value) {
            addCriterion("pretrade_house <", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseLessThanOrEqualTo(String value) {
            addCriterion("pretrade_house <=", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseLike(String value) {
            addCriterion("pretrade_house like", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseNotLike(String value) {
            addCriterion("pretrade_house not like", value, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseIn(List<String> values) {
            addCriterion("pretrade_house in", values, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseNotIn(List<String> values) {
            addCriterion("pretrade_house not in", values, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseBetween(String value1, String value2) {
            addCriterion("pretrade_house between", value1, value2, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeHouseNotBetween(String value1, String value2) {
            addCriterion("pretrade_house not between", value1, value2, "pretradeHouse");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzIsNull() {
            addCriterion("pretrade_cqz is null");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzIsNotNull() {
            addCriterion("pretrade_cqz is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzEqualTo(String value) {
            addCriterion("pretrade_cqz =", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzNotEqualTo(String value) {
            addCriterion("pretrade_cqz <>", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzGreaterThan(String value) {
            addCriterion("pretrade_cqz >", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzGreaterThanOrEqualTo(String value) {
            addCriterion("pretrade_cqz >=", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzLessThan(String value) {
            addCriterion("pretrade_cqz <", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzLessThanOrEqualTo(String value) {
            addCriterion("pretrade_cqz <=", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzLike(String value) {
            addCriterion("pretrade_cqz like", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzNotLike(String value) {
            addCriterion("pretrade_cqz not like", value, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzIn(List<String> values) {
            addCriterion("pretrade_cqz in", values, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzNotIn(List<String> values) {
            addCriterion("pretrade_cqz not in", values, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzBetween(String value1, String value2) {
            addCriterion("pretrade_cqz between", value1, value2, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeCqzNotBetween(String value1, String value2) {
            addCriterion("pretrade_cqz not between", value1, value2, "pretradeCqz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzIsNull() {
            addCriterion("pretrade_tdz is null");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzIsNotNull() {
            addCriterion("pretrade_tdz is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzEqualTo(String value) {
            addCriterion("pretrade_tdz =", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzNotEqualTo(String value) {
            addCriterion("pretrade_tdz <>", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzGreaterThan(String value) {
            addCriterion("pretrade_tdz >", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzGreaterThanOrEqualTo(String value) {
            addCriterion("pretrade_tdz >=", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzLessThan(String value) {
            addCriterion("pretrade_tdz <", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzLessThanOrEqualTo(String value) {
            addCriterion("pretrade_tdz <=", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzLike(String value) {
            addCriterion("pretrade_tdz like", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzNotLike(String value) {
            addCriterion("pretrade_tdz not like", value, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzIn(List<String> values) {
            addCriterion("pretrade_tdz in", values, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzNotIn(List<String> values) {
            addCriterion("pretrade_tdz not in", values, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzBetween(String value1, String value2) {
            addCriterion("pretrade_tdz between", value1, value2, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeTdzNotBetween(String value1, String value2) {
            addCriterion("pretrade_tdz not between", value1, value2, "pretradeTdz");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaIsNull() {
            addCriterion("pretrade_area is null");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaIsNotNull() {
            addCriterion("pretrade_area is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaEqualTo(String value) {
            addCriterion("pretrade_area =", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaNotEqualTo(String value) {
            addCriterion("pretrade_area <>", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaGreaterThan(String value) {
            addCriterion("pretrade_area >", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaGreaterThanOrEqualTo(String value) {
            addCriterion("pretrade_area >=", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaLessThan(String value) {
            addCriterion("pretrade_area <", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaLessThanOrEqualTo(String value) {
            addCriterion("pretrade_area <=", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaLike(String value) {
            addCriterion("pretrade_area like", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaNotLike(String value) {
            addCriterion("pretrade_area not like", value, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaIn(List<String> values) {
            addCriterion("pretrade_area in", values, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaNotIn(List<String> values) {
            addCriterion("pretrade_area not in", values, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaBetween(String value1, String value2) {
            addCriterion("pretrade_area between", value1, value2, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeAreaNotBetween(String value1, String value2) {
            addCriterion("pretrade_area not between", value1, value2, "pretradeArea");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorIsNull() {
            addCriterion("pretrade_floor is null");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorIsNotNull() {
            addCriterion("pretrade_floor is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorEqualTo(String value) {
            addCriterion("pretrade_floor =", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorNotEqualTo(String value) {
            addCriterion("pretrade_floor <>", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorGreaterThan(String value) {
            addCriterion("pretrade_floor >", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorGreaterThanOrEqualTo(String value) {
            addCriterion("pretrade_floor >=", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorLessThan(String value) {
            addCriterion("pretrade_floor <", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorLessThanOrEqualTo(String value) {
            addCriterion("pretrade_floor <=", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorLike(String value) {
            addCriterion("pretrade_floor like", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorNotLike(String value) {
            addCriterion("pretrade_floor not like", value, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorIn(List<String> values) {
            addCriterion("pretrade_floor in", values, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorNotIn(List<String> values) {
            addCriterion("pretrade_floor not in", values, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorBetween(String value1, String value2) {
            addCriterion("pretrade_floor between", value1, value2, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeFloorNotBetween(String value1, String value2) {
            addCriterion("pretrade_floor not between", value1, value2, "pretradeFloor");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeIsNull() {
            addCriterion("pretrade_age is null");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeIsNotNull() {
            addCriterion("pretrade_age is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeEqualTo(String value) {
            addCriterion("pretrade_age =", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeNotEqualTo(String value) {
            addCriterion("pretrade_age <>", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeGreaterThan(String value) {
            addCriterion("pretrade_age >", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeGreaterThanOrEqualTo(String value) {
            addCriterion("pretrade_age >=", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeLessThan(String value) {
            addCriterion("pretrade_age <", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeLessThanOrEqualTo(String value) {
            addCriterion("pretrade_age <=", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeLike(String value) {
            addCriterion("pretrade_age like", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeNotLike(String value) {
            addCriterion("pretrade_age not like", value, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeIn(List<String> values) {
            addCriterion("pretrade_age in", values, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeNotIn(List<String> values) {
            addCriterion("pretrade_age not in", values, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeBetween(String value1, String value2) {
            addCriterion("pretrade_age between", value1, value2, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradeAgeNotBetween(String value1, String value2) {
            addCriterion("pretrade_age not between", value1, value2, "pretradeAge");
            return (Criteria) this;
        }

        public Criteria andPretradePriceIsNull() {
            addCriterion("pretrade_price is null");
            return (Criteria) this;
        }

        public Criteria andPretradePriceIsNotNull() {
            addCriterion("pretrade_price is not null");
            return (Criteria) this;
        }

        public Criteria andPretradePriceEqualTo(Double value) {
            addCriterion("pretrade_price =", value, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceNotEqualTo(Double value) {
            addCriterion("pretrade_price <>", value, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceGreaterThan(Double value) {
            addCriterion("pretrade_price >", value, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceGreaterThanOrEqualTo(Double value) {
            addCriterion("pretrade_price >=", value, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceLessThan(Double value) {
            addCriterion("pretrade_price <", value, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceLessThanOrEqualTo(Double value) {
            addCriterion("pretrade_price <=", value, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceIn(List<Double> values) {
            addCriterion("pretrade_price in", values, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceNotIn(List<Double> values) {
            addCriterion("pretrade_price not in", values, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceBetween(Double value1, Double value2) {
            addCriterion("pretrade_price between", value1, value2, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradePriceNotBetween(Double value1, Double value2) {
            addCriterion("pretrade_price not between", value1, value2, "pretradePrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceIsNull() {
            addCriterion("pretrade_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceIsNotNull() {
            addCriterion("pretrade_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceEqualTo(Double value) {
            addCriterion("pretrade_unit_price =", value, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceNotEqualTo(Double value) {
            addCriterion("pretrade_unit_price <>", value, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceGreaterThan(Double value) {
            addCriterion("pretrade_unit_price >", value, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("pretrade_unit_price >=", value, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceLessThan(Double value) {
            addCriterion("pretrade_unit_price <", value, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceLessThanOrEqualTo(Double value) {
            addCriterion("pretrade_unit_price <=", value, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceIn(List<Double> values) {
            addCriterion("pretrade_unit_price in", values, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceNotIn(List<Double> values) {
            addCriterion("pretrade_unit_price not in", values, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceBetween(Double value1, Double value2) {
            addCriterion("pretrade_unit_price between", value1, value2, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradeUnitPriceNotBetween(Double value1, Double value2) {
            addCriterion("pretrade_unit_price not between", value1, value2, "pretradeUnitPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceIsNull() {
            addCriterion("pretrade_peak_price is null");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceIsNotNull() {
            addCriterion("pretrade_peak_price is not null");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceEqualTo(Double value) {
            addCriterion("pretrade_peak_price =", value, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceNotEqualTo(Double value) {
            addCriterion("pretrade_peak_price <>", value, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceGreaterThan(Double value) {
            addCriterion("pretrade_peak_price >", value, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("pretrade_peak_price >=", value, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceLessThan(Double value) {
            addCriterion("pretrade_peak_price <", value, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceLessThanOrEqualTo(Double value) {
            addCriterion("pretrade_peak_price <=", value, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceIn(List<Double> values) {
            addCriterion("pretrade_peak_price in", values, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceNotIn(List<Double> values) {
            addCriterion("pretrade_peak_price not in", values, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceBetween(Double value1, Double value2) {
            addCriterion("pretrade_peak_price between", value1, value2, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andPretradePeakPriceNotBetween(Double value1, Double value2) {
            addCriterion("pretrade_peak_price not between", value1, value2, "pretradePeakPrice");
            return (Criteria) this;
        }

        public Criteria andSellerAccountIsNull() {
            addCriterion("seller_account is null");
            return (Criteria) this;
        }

        public Criteria andSellerAccountIsNotNull() {
            addCriterion("seller_account is not null");
            return (Criteria) this;
        }

        public Criteria andSellerAccountEqualTo(String value) {
            addCriterion("seller_account =", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountNotEqualTo(String value) {
            addCriterion("seller_account <>", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountGreaterThan(String value) {
            addCriterion("seller_account >", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountGreaterThanOrEqualTo(String value) {
            addCriterion("seller_account >=", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountLessThan(String value) {
            addCriterion("seller_account <", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountLessThanOrEqualTo(String value) {
            addCriterion("seller_account <=", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountLike(String value) {
            addCriterion("seller_account like", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountNotLike(String value) {
            addCriterion("seller_account not like", value, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountIn(List<String> values) {
            addCriterion("seller_account in", values, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountNotIn(List<String> values) {
            addCriterion("seller_account not in", values, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountBetween(String value1, String value2) {
            addCriterion("seller_account between", value1, value2, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andSellerAccountNotBetween(String value1, String value2) {
            addCriterion("seller_account not between", value1, value2, "sellerAccount");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdIsNull() {
            addCriterion("afttrade_bdc_id is null");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdIsNotNull() {
            addCriterion("afttrade_bdc_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdEqualTo(String value) {
            addCriterion("afttrade_bdc_id =", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdNotEqualTo(String value) {
            addCriterion("afttrade_bdc_id <>", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdGreaterThan(String value) {
            addCriterion("afttrade_bdc_id >", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdGreaterThanOrEqualTo(String value) {
            addCriterion("afttrade_bdc_id >=", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdLessThan(String value) {
            addCriterion("afttrade_bdc_id <", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdLessThanOrEqualTo(String value) {
            addCriterion("afttrade_bdc_id <=", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdLike(String value) {
            addCriterion("afttrade_bdc_id like", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdNotLike(String value) {
            addCriterion("afttrade_bdc_id not like", value, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdIn(List<String> values) {
            addCriterion("afttrade_bdc_id in", values, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdNotIn(List<String> values) {
            addCriterion("afttrade_bdc_id not in", values, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdBetween(String value1, String value2) {
            addCriterion("afttrade_bdc_id between", value1, value2, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcIdNotBetween(String value1, String value2) {
            addCriterion("afttrade_bdc_id not between", value1, value2, "afttradeBdcId");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestIsNull() {
            addCriterion("afttrade_bdc_addrest is null");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestIsNotNull() {
            addCriterion("afttrade_bdc_addrest is not null");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestEqualTo(String value) {
            addCriterion("afttrade_bdc_addrest =", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestNotEqualTo(String value) {
            addCriterion("afttrade_bdc_addrest <>", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestGreaterThan(String value) {
            addCriterion("afttrade_bdc_addrest >", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestGreaterThanOrEqualTo(String value) {
            addCriterion("afttrade_bdc_addrest >=", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestLessThan(String value) {
            addCriterion("afttrade_bdc_addrest <", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestLessThanOrEqualTo(String value) {
            addCriterion("afttrade_bdc_addrest <=", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestLike(String value) {
            addCriterion("afttrade_bdc_addrest like", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestNotLike(String value) {
            addCriterion("afttrade_bdc_addrest not like", value, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestIn(List<String> values) {
            addCriterion("afttrade_bdc_addrest in", values, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestNotIn(List<String> values) {
            addCriterion("afttrade_bdc_addrest not in", values, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestBetween(String value1, String value2) {
            addCriterion("afttrade_bdc_addrest between", value1, value2, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeBdcAddrestNotBetween(String value1, String value2) {
            addCriterion("afttrade_bdc_addrest not between", value1, value2, "afttradeBdcAddrest");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhIsNull() {
            addCriterion("afttrade_qyh is null");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhIsNotNull() {
            addCriterion("afttrade_qyh is not null");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhEqualTo(String value) {
            addCriterion("afttrade_qyh =", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhNotEqualTo(String value) {
            addCriterion("afttrade_qyh <>", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhGreaterThan(String value) {
            addCriterion("afttrade_qyh >", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhGreaterThanOrEqualTo(String value) {
            addCriterion("afttrade_qyh >=", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhLessThan(String value) {
            addCriterion("afttrade_qyh <", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhLessThanOrEqualTo(String value) {
            addCriterion("afttrade_qyh <=", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhLike(String value) {
            addCriterion("afttrade_qyh like", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhNotLike(String value) {
            addCriterion("afttrade_qyh not like", value, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhIn(List<String> values) {
            addCriterion("afttrade_qyh in", values, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhNotIn(List<String> values) {
            addCriterion("afttrade_qyh not in", values, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhBetween(String value1, String value2) {
            addCriterion("afttrade_qyh between", value1, value2, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeQyhNotBetween(String value1, String value2) {
            addCriterion("afttrade_qyh not between", value1, value2, "afttradeQyh");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdIsNull() {
            addCriterion("afttrade_sjd is null");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdIsNotNull() {
            addCriterion("afttrade_sjd is not null");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdEqualTo(String value) {
            addCriterion("afttrade_sjd =", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdNotEqualTo(String value) {
            addCriterion("afttrade_sjd <>", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdGreaterThan(String value) {
            addCriterion("afttrade_sjd >", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdGreaterThanOrEqualTo(String value) {
            addCriterion("afttrade_sjd >=", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdLessThan(String value) {
            addCriterion("afttrade_sjd <", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdLessThanOrEqualTo(String value) {
            addCriterion("afttrade_sjd <=", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdLike(String value) {
            addCriterion("afttrade_sjd like", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdNotLike(String value) {
            addCriterion("afttrade_sjd not like", value, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdIn(List<String> values) {
            addCriterion("afttrade_sjd in", values, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdNotIn(List<String> values) {
            addCriterion("afttrade_sjd not in", values, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdBetween(String value1, String value2) {
            addCriterion("afttrade_sjd between", value1, value2, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeSjdNotBetween(String value1, String value2) {
            addCriterion("afttrade_sjd not between", value1, value2, "afttradeSjd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdIsNull() {
            addCriterion("afttrade_qsd is null");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdIsNotNull() {
            addCriterion("afttrade_qsd is not null");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdEqualTo(String value) {
            addCriterion("afttrade_qsd =", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdNotEqualTo(String value) {
            addCriterion("afttrade_qsd <>", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdGreaterThan(String value) {
            addCriterion("afttrade_qsd >", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdGreaterThanOrEqualTo(String value) {
            addCriterion("afttrade_qsd >=", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdLessThan(String value) {
            addCriterion("afttrade_qsd <", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdLessThanOrEqualTo(String value) {
            addCriterion("afttrade_qsd <=", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdLike(String value) {
            addCriterion("afttrade_qsd like", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdNotLike(String value) {
            addCriterion("afttrade_qsd not like", value, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdIn(List<String> values) {
            addCriterion("afttrade_qsd in", values, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdNotIn(List<String> values) {
            addCriterion("afttrade_qsd not in", values, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdBetween(String value1, String value2) {
            addCriterion("afttrade_qsd between", value1, value2, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeQsdNotBetween(String value1, String value2) {
            addCriterion("afttrade_qsd not between", value1, value2, "afttradeQsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdIsNull() {
            addCriterion("afttrade_zzsd is null");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdIsNotNull() {
            addCriterion("afttrade_zzsd is not null");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdEqualTo(String value) {
            addCriterion("afttrade_zzsd =", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdNotEqualTo(String value) {
            addCriterion("afttrade_zzsd <>", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdGreaterThan(String value) {
            addCriterion("afttrade_zzsd >", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdGreaterThanOrEqualTo(String value) {
            addCriterion("afttrade_zzsd >=", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdLessThan(String value) {
            addCriterion("afttrade_zzsd <", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdLessThanOrEqualTo(String value) {
            addCriterion("afttrade_zzsd <=", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdLike(String value) {
            addCriterion("afttrade_zzsd like", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdNotLike(String value) {
            addCriterion("afttrade_zzsd not like", value, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdIn(List<String> values) {
            addCriterion("afttrade_zzsd in", values, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdNotIn(List<String> values) {
            addCriterion("afttrade_zzsd not in", values, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdBetween(String value1, String value2) {
            addCriterion("afttrade_zzsd between", value1, value2, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAfttradeZzsdNotBetween(String value1, String value2) {
            addCriterion("afttrade_zzsd not between", value1, value2, "afttradeZzsd");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIsNull() {
            addCriterion("agency_id is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIsNotNull() {
            addCriterion("agency_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdEqualTo(String value) {
            addCriterion("agency_id =", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotEqualTo(String value) {
            addCriterion("agency_id <>", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThan(String value) {
            addCriterion("agency_id >", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThanOrEqualTo(String value) {
            addCriterion("agency_id >=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThan(String value) {
            addCriterion("agency_id <", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThanOrEqualTo(String value) {
            addCriterion("agency_id <=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLike(String value) {
            addCriterion("agency_id like", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotLike(String value) {
            addCriterion("agency_id not like", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIn(List<String> values) {
            addCriterion("agency_id in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotIn(List<String> values) {
            addCriterion("agency_id not in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdBetween(String value1, String value2) {
            addCriterion("agency_id between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotBetween(String value1, String value2) {
            addCriterion("agency_id not between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzIsNull() {
            addCriterion("newhouse_qyz is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzIsNotNull() {
            addCriterion("newhouse_qyz is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzEqualTo(String value) {
            addCriterion("newhouse_qyz =", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzNotEqualTo(String value) {
            addCriterion("newhouse_qyz <>", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzGreaterThan(String value) {
            addCriterion("newhouse_qyz >", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_qyz >=", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzLessThan(String value) {
            addCriterion("newhouse_qyz <", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzLessThanOrEqualTo(String value) {
            addCriterion("newhouse_qyz <=", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzLike(String value) {
            addCriterion("newhouse_qyz like", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzNotLike(String value) {
            addCriterion("newhouse_qyz not like", value, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzIn(List<String> values) {
            addCriterion("newhouse_qyz in", values, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzNotIn(List<String> values) {
            addCriterion("newhouse_qyz not in", values, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzBetween(String value1, String value2) {
            addCriterion("newhouse_qyz between", value1, value2, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseQyzNotBetween(String value1, String value2) {
            addCriterion("newhouse_qyz not between", value1, value2, "newhouseQyz");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxIsNull() {
            addCriterion("newhouse_tdnx is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxIsNotNull() {
            addCriterion("newhouse_tdnx is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxEqualTo(String value) {
            addCriterion("newhouse_tdnx =", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxNotEqualTo(String value) {
            addCriterion("newhouse_tdnx <>", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxGreaterThan(String value) {
            addCriterion("newhouse_tdnx >", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_tdnx >=", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxLessThan(String value) {
            addCriterion("newhouse_tdnx <", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxLessThanOrEqualTo(String value) {
            addCriterion("newhouse_tdnx <=", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxLike(String value) {
            addCriterion("newhouse_tdnx like", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxNotLike(String value) {
            addCriterion("newhouse_tdnx not like", value, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxIn(List<String> values) {
            addCriterion("newhouse_tdnx in", values, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxNotIn(List<String> values) {
            addCriterion("newhouse_tdnx not in", values, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxBetween(String value1, String value2) {
            addCriterion("newhouse_tdnx between", value1, value2, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseTdnxNotBetween(String value1, String value2) {
            addCriterion("newhouse_tdnx not between", value1, value2, "newhouseTdnx");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcIsNull() {
            addCriterion("newhouse_lpmc is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcIsNotNull() {
            addCriterion("newhouse_lpmc is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcEqualTo(String value) {
            addCriterion("newhouse_lpmc =", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcNotEqualTo(String value) {
            addCriterion("newhouse_lpmc <>", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcGreaterThan(String value) {
            addCriterion("newhouse_lpmc >", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_lpmc >=", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcLessThan(String value) {
            addCriterion("newhouse_lpmc <", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcLessThanOrEqualTo(String value) {
            addCriterion("newhouse_lpmc <=", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcLike(String value) {
            addCriterion("newhouse_lpmc like", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcNotLike(String value) {
            addCriterion("newhouse_lpmc not like", value, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcIn(List<String> values) {
            addCriterion("newhouse_lpmc in", values, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcNotIn(List<String> values) {
            addCriterion("newhouse_lpmc not in", values, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcBetween(String value1, String value2) {
            addCriterion("newhouse_lpmc between", value1, value2, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseLpmcNotBetween(String value1, String value2) {
            addCriterion("newhouse_lpmc not between", value1, value2, "newhouseLpmc");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestIsNull() {
            addCriterion("newhouse_addrest is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestIsNotNull() {
            addCriterion("newhouse_addrest is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestEqualTo(String value) {
            addCriterion("newhouse_addrest =", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestNotEqualTo(String value) {
            addCriterion("newhouse_addrest <>", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestGreaterThan(String value) {
            addCriterion("newhouse_addrest >", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_addrest >=", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestLessThan(String value) {
            addCriterion("newhouse_addrest <", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestLessThanOrEqualTo(String value) {
            addCriterion("newhouse_addrest <=", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestLike(String value) {
            addCriterion("newhouse_addrest like", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestNotLike(String value) {
            addCriterion("newhouse_addrest not like", value, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestIn(List<String> values) {
            addCriterion("newhouse_addrest in", values, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestNotIn(List<String> values) {
            addCriterion("newhouse_addrest not in", values, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestBetween(String value1, String value2) {
            addCriterion("newhouse_addrest between", value1, value2, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhouseAddrestNotBetween(String value1, String value2) {
            addCriterion("newhouse_addrest not between", value1, value2, "newhouseAddrest");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneIsNull() {
            addCriterion("newhouse_phone is null");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneIsNotNull() {
            addCriterion("newhouse_phone is not null");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneEqualTo(String value) {
            addCriterion("newhouse_phone =", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneNotEqualTo(String value) {
            addCriterion("newhouse_phone <>", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneGreaterThan(String value) {
            addCriterion("newhouse_phone >", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_phone >=", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneLessThan(String value) {
            addCriterion("newhouse_phone <", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneLessThanOrEqualTo(String value) {
            addCriterion("newhouse_phone <=", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneLike(String value) {
            addCriterion("newhouse_phone like", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneNotLike(String value) {
            addCriterion("newhouse_phone not like", value, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneIn(List<String> values) {
            addCriterion("newhouse_phone in", values, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneNotIn(List<String> values) {
            addCriterion("newhouse_phone not in", values, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneBetween(String value1, String value2) {
            addCriterion("newhouse_phone between", value1, value2, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhousePhoneNotBetween(String value1, String value2) {
            addCriterion("newhouse_phone not between", value1, value2, "newhousePhone");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverIsNull() {
            addCriterion("newhouse_dever is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverIsNotNull() {
            addCriterion("newhouse_dever is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverEqualTo(String value) {
            addCriterion("newhouse_dever =", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverNotEqualTo(String value) {
            addCriterion("newhouse_dever <>", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverGreaterThan(String value) {
            addCriterion("newhouse_dever >", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_dever >=", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverLessThan(String value) {
            addCriterion("newhouse_dever <", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverLessThanOrEqualTo(String value) {
            addCriterion("newhouse_dever <=", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverLike(String value) {
            addCriterion("newhouse_dever like", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverNotLike(String value) {
            addCriterion("newhouse_dever not like", value, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverIn(List<String> values) {
            addCriterion("newhouse_dever in", values, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverNotIn(List<String> values) {
            addCriterion("newhouse_dever not in", values, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverBetween(String value1, String value2) {
            addCriterion("newhouse_dever between", value1, value2, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverNotBetween(String value1, String value2) {
            addCriterion("newhouse_dever not between", value1, value2, "newhouseDever");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsIsNull() {
            addCriterion("newhouse_dever_ads is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsIsNotNull() {
            addCriterion("newhouse_dever_ads is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsEqualTo(String value) {
            addCriterion("newhouse_dever_ads =", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsNotEqualTo(String value) {
            addCriterion("newhouse_dever_ads <>", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsGreaterThan(String value) {
            addCriterion("newhouse_dever_ads >", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_ads >=", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsLessThan(String value) {
            addCriterion("newhouse_dever_ads <", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsLessThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_ads <=", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsLike(String value) {
            addCriterion("newhouse_dever_ads like", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsNotLike(String value) {
            addCriterion("newhouse_dever_ads not like", value, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsIn(List<String> values) {
            addCriterion("newhouse_dever_ads in", values, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsNotIn(List<String> values) {
            addCriterion("newhouse_dever_ads not in", values, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsBetween(String value1, String value2) {
            addCriterion("newhouse_dever_ads between", value1, value2, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverAdsNotBetween(String value1, String value2) {
            addCriterion("newhouse_dever_ads not between", value1, value2, "newhouseDeverAds");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhIsNull() {
            addCriterion("newhouse_dever_ph is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhIsNotNull() {
            addCriterion("newhouse_dever_ph is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhEqualTo(String value) {
            addCriterion("newhouse_dever_ph =", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhNotEqualTo(String value) {
            addCriterion("newhouse_dever_ph <>", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhGreaterThan(String value) {
            addCriterion("newhouse_dever_ph >", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_ph >=", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhLessThan(String value) {
            addCriterion("newhouse_dever_ph <", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhLessThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_ph <=", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhLike(String value) {
            addCriterion("newhouse_dever_ph like", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhNotLike(String value) {
            addCriterion("newhouse_dever_ph not like", value, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhIn(List<String> values) {
            addCriterion("newhouse_dever_ph in", values, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhNotIn(List<String> values) {
            addCriterion("newhouse_dever_ph not in", values, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhBetween(String value1, String value2) {
            addCriterion("newhouse_dever_ph between", value1, value2, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverPhNotBetween(String value1, String value2) {
            addCriterion("newhouse_dever_ph not between", value1, value2, "newhouseDeverPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActIsNull() {
            addCriterion("newhouse_dever_act is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActIsNotNull() {
            addCriterion("newhouse_dever_act is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActEqualTo(String value) {
            addCriterion("newhouse_dever_act =", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActNotEqualTo(String value) {
            addCriterion("newhouse_dever_act <>", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActGreaterThan(String value) {
            addCriterion("newhouse_dever_act >", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_act >=", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActLessThan(String value) {
            addCriterion("newhouse_dever_act <", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActLessThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_act <=", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActLike(String value) {
            addCriterion("newhouse_dever_act like", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActNotLike(String value) {
            addCriterion("newhouse_dever_act not like", value, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActIn(List<String> values) {
            addCriterion("newhouse_dever_act in", values, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActNotIn(List<String> values) {
            addCriterion("newhouse_dever_act not in", values, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActBetween(String value1, String value2) {
            addCriterion("newhouse_dever_act between", value1, value2, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverActNotBetween(String value1, String value2) {
            addCriterion("newhouse_dever_act not between", value1, value2, "newhouseDeverAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgIsNull() {
            addCriterion("newhouse_dever_khg is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgIsNotNull() {
            addCriterion("newhouse_dever_khg is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgEqualTo(String value) {
            addCriterion("newhouse_dever_khg =", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgNotEqualTo(String value) {
            addCriterion("newhouse_dever_khg <>", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgGreaterThan(String value) {
            addCriterion("newhouse_dever_khg >", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_khg >=", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgLessThan(String value) {
            addCriterion("newhouse_dever_khg <", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgLessThanOrEqualTo(String value) {
            addCriterion("newhouse_dever_khg <=", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgLike(String value) {
            addCriterion("newhouse_dever_khg like", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgNotLike(String value) {
            addCriterion("newhouse_dever_khg not like", value, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgIn(List<String> values) {
            addCriterion("newhouse_dever_khg in", values, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgNotIn(List<String> values) {
            addCriterion("newhouse_dever_khg not in", values, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgBetween(String value1, String value2) {
            addCriterion("newhouse_dever_khg between", value1, value2, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseDeverKhgNotBetween(String value1, String value2) {
            addCriterion("newhouse_dever_khg not between", value1, value2, "newhouseDeverKhg");
            return (Criteria) this;
        }

        public Criteria andNewhouseManIsNull() {
            addCriterion("newhouse_man is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseManIsNotNull() {
            addCriterion("newhouse_man is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseManEqualTo(String value) {
            addCriterion("newhouse_man =", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManNotEqualTo(String value) {
            addCriterion("newhouse_man <>", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManGreaterThan(String value) {
            addCriterion("newhouse_man >", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_man >=", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManLessThan(String value) {
            addCriterion("newhouse_man <", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManLessThanOrEqualTo(String value) {
            addCriterion("newhouse_man <=", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManLike(String value) {
            addCriterion("newhouse_man like", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManNotLike(String value) {
            addCriterion("newhouse_man not like", value, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManIn(List<String> values) {
            addCriterion("newhouse_man in", values, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManNotIn(List<String> values) {
            addCriterion("newhouse_man not in", values, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManBetween(String value1, String value2) {
            addCriterion("newhouse_man between", value1, value2, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManNotBetween(String value1, String value2) {
            addCriterion("newhouse_man not between", value1, value2, "newhouseMan");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhIsNull() {
            addCriterion("newhouse_man_ph is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhIsNotNull() {
            addCriterion("newhouse_man_ph is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhEqualTo(String value) {
            addCriterion("newhouse_man_ph =", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhNotEqualTo(String value) {
            addCriterion("newhouse_man_ph <>", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhGreaterThan(String value) {
            addCriterion("newhouse_man_ph >", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_man_ph >=", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhLessThan(String value) {
            addCriterion("newhouse_man_ph <", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhLessThanOrEqualTo(String value) {
            addCriterion("newhouse_man_ph <=", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhLike(String value) {
            addCriterion("newhouse_man_ph like", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhNotLike(String value) {
            addCriterion("newhouse_man_ph not like", value, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhIn(List<String> values) {
            addCriterion("newhouse_man_ph in", values, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhNotIn(List<String> values) {
            addCriterion("newhouse_man_ph not in", values, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhBetween(String value1, String value2) {
            addCriterion("newhouse_man_ph between", value1, value2, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseManPhNotBetween(String value1, String value2) {
            addCriterion("newhouse_man_ph not between", value1, value2, "newhouseManPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinIsNull() {
            addCriterion("newhouse_fin is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinIsNotNull() {
            addCriterion("newhouse_fin is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinEqualTo(String value) {
            addCriterion("newhouse_fin =", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinNotEqualTo(String value) {
            addCriterion("newhouse_fin <>", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinGreaterThan(String value) {
            addCriterion("newhouse_fin >", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_fin >=", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinLessThan(String value) {
            addCriterion("newhouse_fin <", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinLessThanOrEqualTo(String value) {
            addCriterion("newhouse_fin <=", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinLike(String value) {
            addCriterion("newhouse_fin like", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinNotLike(String value) {
            addCriterion("newhouse_fin not like", value, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinIn(List<String> values) {
            addCriterion("newhouse_fin in", values, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinNotIn(List<String> values) {
            addCriterion("newhouse_fin not in", values, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinBetween(String value1, String value2) {
            addCriterion("newhouse_fin between", value1, value2, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinNotBetween(String value1, String value2) {
            addCriterion("newhouse_fin not between", value1, value2, "newhouseFin");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhIsNull() {
            addCriterion("newhouse_fin_ph is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhIsNotNull() {
            addCriterion("newhouse_fin_ph is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhEqualTo(String value) {
            addCriterion("newhouse_fin_ph =", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhNotEqualTo(String value) {
            addCriterion("newhouse_fin_ph <>", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhGreaterThan(String value) {
            addCriterion("newhouse_fin_ph >", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_fin_ph >=", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhLessThan(String value) {
            addCriterion("newhouse_fin_ph <", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhLessThanOrEqualTo(String value) {
            addCriterion("newhouse_fin_ph <=", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhLike(String value) {
            addCriterion("newhouse_fin_ph like", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhNotLike(String value) {
            addCriterion("newhouse_fin_ph not like", value, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhIn(List<String> values) {
            addCriterion("newhouse_fin_ph in", values, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhNotIn(List<String> values) {
            addCriterion("newhouse_fin_ph not in", values, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhBetween(String value1, String value2) {
            addCriterion("newhouse_fin_ph between", value1, value2, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseFinPhNotBetween(String value1, String value2) {
            addCriterion("newhouse_fin_ph not between", value1, value2, "newhouseFinPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerIsNull() {
            addCriterion("newhouse_seller is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerIsNotNull() {
            addCriterion("newhouse_seller is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerEqualTo(String value) {
            addCriterion("newhouse_seller =", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerNotEqualTo(String value) {
            addCriterion("newhouse_seller <>", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerGreaterThan(String value) {
            addCriterion("newhouse_seller >", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_seller >=", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerLessThan(String value) {
            addCriterion("newhouse_seller <", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerLessThanOrEqualTo(String value) {
            addCriterion("newhouse_seller <=", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerLike(String value) {
            addCriterion("newhouse_seller like", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerNotLike(String value) {
            addCriterion("newhouse_seller not like", value, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerIn(List<String> values) {
            addCriterion("newhouse_seller in", values, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerNotIn(List<String> values) {
            addCriterion("newhouse_seller not in", values, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerBetween(String value1, String value2) {
            addCriterion("newhouse_seller between", value1, value2, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSellerNotBetween(String value1, String value2) {
            addCriterion("newhouse_seller not between", value1, value2, "newhouseSeller");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhIsNull() {
            addCriterion("newhouse_sel_ph is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhIsNotNull() {
            addCriterion("newhouse_sel_ph is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhEqualTo(String value) {
            addCriterion("newhouse_sel_ph =", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhNotEqualTo(String value) {
            addCriterion("newhouse_sel_ph <>", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhGreaterThan(String value) {
            addCriterion("newhouse_sel_ph >", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_ph >=", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhLessThan(String value) {
            addCriterion("newhouse_sel_ph <", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhLessThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_ph <=", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhLike(String value) {
            addCriterion("newhouse_sel_ph like", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhNotLike(String value) {
            addCriterion("newhouse_sel_ph not like", value, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhIn(List<String> values) {
            addCriterion("newhouse_sel_ph in", values, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhNotIn(List<String> values) {
            addCriterion("newhouse_sel_ph not in", values, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhBetween(String value1, String value2) {
            addCriterion("newhouse_sel_ph between", value1, value2, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPhNotBetween(String value1, String value2) {
            addCriterion("newhouse_sel_ph not between", value1, value2, "newhouseSelPh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2IsNull() {
            addCriterion("newhouse_sel_ph2 is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2IsNotNull() {
            addCriterion("newhouse_sel_ph2 is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2EqualTo(String value) {
            addCriterion("newhouse_sel_ph2 =", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2NotEqualTo(String value) {
            addCriterion("newhouse_sel_ph2 <>", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2GreaterThan(String value) {
            addCriterion("newhouse_sel_ph2 >", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2GreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_ph2 >=", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2LessThan(String value) {
            addCriterion("newhouse_sel_ph2 <", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2LessThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_ph2 <=", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2Like(String value) {
            addCriterion("newhouse_sel_ph2 like", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2NotLike(String value) {
            addCriterion("newhouse_sel_ph2 not like", value, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2In(List<String> values) {
            addCriterion("newhouse_sel_ph2 in", values, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2NotIn(List<String> values) {
            addCriterion("newhouse_sel_ph2 not in", values, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2Between(String value1, String value2) {
            addCriterion("newhouse_sel_ph2 between", value1, value2, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelPh2NotBetween(String value1, String value2) {
            addCriterion("newhouse_sel_ph2 not between", value1, value2, "newhouseSelPh2");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnIsNull() {
            addCriterion("newhouse_sel_actn is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnIsNotNull() {
            addCriterion("newhouse_sel_actn is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnEqualTo(String value) {
            addCriterion("newhouse_sel_actn =", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnNotEqualTo(String value) {
            addCriterion("newhouse_sel_actn <>", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnGreaterThan(String value) {
            addCriterion("newhouse_sel_actn >", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_actn >=", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnLessThan(String value) {
            addCriterion("newhouse_sel_actn <", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnLessThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_actn <=", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnLike(String value) {
            addCriterion("newhouse_sel_actn like", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnNotLike(String value) {
            addCriterion("newhouse_sel_actn not like", value, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnIn(List<String> values) {
            addCriterion("newhouse_sel_actn in", values, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnNotIn(List<String> values) {
            addCriterion("newhouse_sel_actn not in", values, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnBetween(String value1, String value2) {
            addCriterion("newhouse_sel_actn between", value1, value2, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActnNotBetween(String value1, String value2) {
            addCriterion("newhouse_sel_actn not between", value1, value2, "newhouseSelActn");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhIsNull() {
            addCriterion("newhouse_sel_khh is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhIsNotNull() {
            addCriterion("newhouse_sel_khh is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhEqualTo(String value) {
            addCriterion("newhouse_sel_khh =", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhNotEqualTo(String value) {
            addCriterion("newhouse_sel_khh <>", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhGreaterThan(String value) {
            addCriterion("newhouse_sel_khh >", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_khh >=", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhLessThan(String value) {
            addCriterion("newhouse_sel_khh <", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhLessThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_khh <=", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhLike(String value) {
            addCriterion("newhouse_sel_khh like", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhNotLike(String value) {
            addCriterion("newhouse_sel_khh not like", value, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhIn(List<String> values) {
            addCriterion("newhouse_sel_khh in", values, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhNotIn(List<String> values) {
            addCriterion("newhouse_sel_khh not in", values, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhBetween(String value1, String value2) {
            addCriterion("newhouse_sel_khh between", value1, value2, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelKhhNotBetween(String value1, String value2) {
            addCriterion("newhouse_sel_khh not between", value1, value2, "newhouseSelKhh");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActIsNull() {
            addCriterion("newhouse_sel_act is null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActIsNotNull() {
            addCriterion("newhouse_sel_act is not null");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActEqualTo(String value) {
            addCriterion("newhouse_sel_act =", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActNotEqualTo(String value) {
            addCriterion("newhouse_sel_act <>", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActGreaterThan(String value) {
            addCriterion("newhouse_sel_act >", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActGreaterThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_act >=", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActLessThan(String value) {
            addCriterion("newhouse_sel_act <", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActLessThanOrEqualTo(String value) {
            addCriterion("newhouse_sel_act <=", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActLike(String value) {
            addCriterion("newhouse_sel_act like", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActNotLike(String value) {
            addCriterion("newhouse_sel_act not like", value, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActIn(List<String> values) {
            addCriterion("newhouse_sel_act in", values, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActNotIn(List<String> values) {
            addCriterion("newhouse_sel_act not in", values, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActBetween(String value1, String value2) {
            addCriterion("newhouse_sel_act between", value1, value2, "newhouseSelAct");
            return (Criteria) this;
        }

        public Criteria andNewhouseSelActNotBetween(String value1, String value2) {
            addCriterion("newhouse_sel_act not between", value1, value2, "newhouseSelAct");
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