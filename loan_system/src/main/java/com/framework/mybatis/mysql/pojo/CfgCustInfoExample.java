package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class CfgCustInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgCustInfoExample() {
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

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(String value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(String value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(String value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(String value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(String value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLike(String value) {
            addCriterion("id_type like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotLike(String value) {
            addCriterion("id_type not like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<String> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<String> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(String value1, String value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(String value1, String value2) {
            addCriterion("id_type not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneIsNull() {
            addCriterion("land_phone is null");
            return (Criteria) this;
        }

        public Criteria andLandPhoneIsNotNull() {
            addCriterion("land_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLandPhoneEqualTo(String value) {
            addCriterion("land_phone =", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotEqualTo(String value) {
            addCriterion("land_phone <>", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneGreaterThan(String value) {
            addCriterion("land_phone >", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("land_phone >=", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneLessThan(String value) {
            addCriterion("land_phone <", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneLessThanOrEqualTo(String value) {
            addCriterion("land_phone <=", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneLike(String value) {
            addCriterion("land_phone like", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotLike(String value) {
            addCriterion("land_phone not like", value, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneIn(List<String> values) {
            addCriterion("land_phone in", values, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotIn(List<String> values) {
            addCriterion("land_phone not in", values, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneBetween(String value1, String value2) {
            addCriterion("land_phone between", value1, value2, "landPhone");
            return (Criteria) this;
        }

        public Criteria andLandPhoneNotBetween(String value1, String value2) {
            addCriterion("land_phone not between", value1, value2, "landPhone");
            return (Criteria) this;
        }

        public Criteria andOccupTypeIsNull() {
            addCriterion("occup_type is null");
            return (Criteria) this;
        }

        public Criteria andOccupTypeIsNotNull() {
            addCriterion("occup_type is not null");
            return (Criteria) this;
        }

        public Criteria andOccupTypeEqualTo(String value) {
            addCriterion("occup_type =", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeNotEqualTo(String value) {
            addCriterion("occup_type <>", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeGreaterThan(String value) {
            addCriterion("occup_type >", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeGreaterThanOrEqualTo(String value) {
            addCriterion("occup_type >=", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeLessThan(String value) {
            addCriterion("occup_type <", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeLessThanOrEqualTo(String value) {
            addCriterion("occup_type <=", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeLike(String value) {
            addCriterion("occup_type like", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeNotLike(String value) {
            addCriterion("occup_type not like", value, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeIn(List<String> values) {
            addCriterion("occup_type in", values, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeNotIn(List<String> values) {
            addCriterion("occup_type not in", values, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeBetween(String value1, String value2) {
            addCriterion("occup_type between", value1, value2, "occupType");
            return (Criteria) this;
        }

        public Criteria andOccupTypeNotBetween(String value1, String value2) {
            addCriterion("occup_type not between", value1, value2, "occupType");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceIsNull() {
            addCriterion("income_source is null");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceIsNotNull() {
            addCriterion("income_source is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceEqualTo(String value) {
            addCriterion("income_source =", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceNotEqualTo(String value) {
            addCriterion("income_source <>", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceGreaterThan(String value) {
            addCriterion("income_source >", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceGreaterThanOrEqualTo(String value) {
            addCriterion("income_source >=", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceLessThan(String value) {
            addCriterion("income_source <", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceLessThanOrEqualTo(String value) {
            addCriterion("income_source <=", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceLike(String value) {
            addCriterion("income_source like", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceNotLike(String value) {
            addCriterion("income_source not like", value, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceIn(List<String> values) {
            addCriterion("income_source in", values, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceNotIn(List<String> values) {
            addCriterion("income_source not in", values, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceBetween(String value1, String value2) {
            addCriterion("income_source between", value1, value2, "incomeSource");
            return (Criteria) this;
        }

        public Criteria andIncomeSourceNotBetween(String value1, String value2) {
            addCriterion("income_source not between", value1, value2, "incomeSource");
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

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andKhhNameIsNull() {
            addCriterion("khh_name is null");
            return (Criteria) this;
        }

        public Criteria andKhhNameIsNotNull() {
            addCriterion("khh_name is not null");
            return (Criteria) this;
        }

        public Criteria andKhhNameEqualTo(String value) {
            addCriterion("khh_name =", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameNotEqualTo(String value) {
            addCriterion("khh_name <>", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameGreaterThan(String value) {
            addCriterion("khh_name >", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameGreaterThanOrEqualTo(String value) {
            addCriterion("khh_name >=", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameLessThan(String value) {
            addCriterion("khh_name <", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameLessThanOrEqualTo(String value) {
            addCriterion("khh_name <=", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameLike(String value) {
            addCriterion("khh_name like", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameNotLike(String value) {
            addCriterion("khh_name not like", value, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameIn(List<String> values) {
            addCriterion("khh_name in", values, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameNotIn(List<String> values) {
            addCriterion("khh_name not in", values, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameBetween(String value1, String value2) {
            addCriterion("khh_name between", value1, value2, "khhName");
            return (Criteria) this;
        }

        public Criteria andKhhNameNotBetween(String value1, String value2) {
            addCriterion("khh_name not between", value1, value2, "khhName");
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
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