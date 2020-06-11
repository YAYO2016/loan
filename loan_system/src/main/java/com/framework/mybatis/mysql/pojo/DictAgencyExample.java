package com.framework.mybatis.mysql.pojo;

import java.util.ArrayList;
import java.util.List;

public class DictAgencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictAgencyExample() {
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

        public Criteria andAgencyNameIsNull() {
            addCriterion("agency_name is null");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIsNotNull() {
            addCriterion("agency_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyNameEqualTo(String value) {
            addCriterion("agency_name =", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotEqualTo(String value) {
            addCriterion("agency_name <>", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameGreaterThan(String value) {
            addCriterion("agency_name >", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("agency_name >=", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLessThan(String value) {
            addCriterion("agency_name <", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLessThanOrEqualTo(String value) {
            addCriterion("agency_name <=", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLike(String value) {
            addCriterion("agency_name like", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotLike(String value) {
            addCriterion("agency_name not like", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIn(List<String> values) {
            addCriterion("agency_name in", values, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotIn(List<String> values) {
            addCriterion("agency_name not in", values, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameBetween(String value1, String value2) {
            addCriterion("agency_name between", value1, value2, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotBetween(String value1, String value2) {
            addCriterion("agency_name not between", value1, value2, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIsNull() {
            addCriterion("agency_phone is null");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIsNotNull() {
            addCriterion("agency_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneEqualTo(String value) {
            addCriterion("agency_phone =", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotEqualTo(String value) {
            addCriterion("agency_phone <>", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneGreaterThan(String value) {
            addCriterion("agency_phone >", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("agency_phone >=", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLessThan(String value) {
            addCriterion("agency_phone <", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLessThanOrEqualTo(String value) {
            addCriterion("agency_phone <=", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLike(String value) {
            addCriterion("agency_phone like", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotLike(String value) {
            addCriterion("agency_phone not like", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIn(List<String> values) {
            addCriterion("agency_phone in", values, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotIn(List<String> values) {
            addCriterion("agency_phone not in", values, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneBetween(String value1, String value2) {
            addCriterion("agency_phone between", value1, value2, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotBetween(String value1, String value2) {
            addCriterion("agency_phone not between", value1, value2, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressIsNull() {
            addCriterion("agency_address is null");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressIsNotNull() {
            addCriterion("agency_address is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressEqualTo(String value) {
            addCriterion("agency_address =", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressNotEqualTo(String value) {
            addCriterion("agency_address <>", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressGreaterThan(String value) {
            addCriterion("agency_address >", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("agency_address >=", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressLessThan(String value) {
            addCriterion("agency_address <", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressLessThanOrEqualTo(String value) {
            addCriterion("agency_address <=", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressLike(String value) {
            addCriterion("agency_address like", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressNotLike(String value) {
            addCriterion("agency_address not like", value, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressIn(List<String> values) {
            addCriterion("agency_address in", values, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressNotIn(List<String> values) {
            addCriterion("agency_address not in", values, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressBetween(String value1, String value2) {
            addCriterion("agency_address between", value1, value2, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andAgencyAddressNotBetween(String value1, String value2) {
            addCriterion("agency_address not between", value1, value2, "agencyAddress");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNull() {
            addCriterion("boss_name is null");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNotNull() {
            addCriterion("boss_name is not null");
            return (Criteria) this;
        }

        public Criteria andBossNameEqualTo(String value) {
            addCriterion("boss_name =", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotEqualTo(String value) {
            addCriterion("boss_name <>", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThan(String value) {
            addCriterion("boss_name >", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThanOrEqualTo(String value) {
            addCriterion("boss_name >=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThan(String value) {
            addCriterion("boss_name <", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThanOrEqualTo(String value) {
            addCriterion("boss_name <=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLike(String value) {
            addCriterion("boss_name like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotLike(String value) {
            addCriterion("boss_name not like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameIn(List<String> values) {
            addCriterion("boss_name in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotIn(List<String> values) {
            addCriterion("boss_name not in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameBetween(String value1, String value2) {
            addCriterion("boss_name between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotBetween(String value1, String value2) {
            addCriterion("boss_name not between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossMphoneIsNull() {
            addCriterion("boss_mphone is null");
            return (Criteria) this;
        }

        public Criteria andBossMphoneIsNotNull() {
            addCriterion("boss_mphone is not null");
            return (Criteria) this;
        }

        public Criteria andBossMphoneEqualTo(String value) {
            addCriterion("boss_mphone =", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneNotEqualTo(String value) {
            addCriterion("boss_mphone <>", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneGreaterThan(String value) {
            addCriterion("boss_mphone >", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneGreaterThanOrEqualTo(String value) {
            addCriterion("boss_mphone >=", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneLessThan(String value) {
            addCriterion("boss_mphone <", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneLessThanOrEqualTo(String value) {
            addCriterion("boss_mphone <=", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneLike(String value) {
            addCriterion("boss_mphone like", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneNotLike(String value) {
            addCriterion("boss_mphone not like", value, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneIn(List<String> values) {
            addCriterion("boss_mphone in", values, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneNotIn(List<String> values) {
            addCriterion("boss_mphone not in", values, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneBetween(String value1, String value2) {
            addCriterion("boss_mphone between", value1, value2, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossMphoneNotBetween(String value1, String value2) {
            addCriterion("boss_mphone not between", value1, value2, "bossMphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneIsNull() {
            addCriterion("boss_lphone is null");
            return (Criteria) this;
        }

        public Criteria andBossLphoneIsNotNull() {
            addCriterion("boss_lphone is not null");
            return (Criteria) this;
        }

        public Criteria andBossLphoneEqualTo(String value) {
            addCriterion("boss_lphone =", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneNotEqualTo(String value) {
            addCriterion("boss_lphone <>", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneGreaterThan(String value) {
            addCriterion("boss_lphone >", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneGreaterThanOrEqualTo(String value) {
            addCriterion("boss_lphone >=", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneLessThan(String value) {
            addCriterion("boss_lphone <", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneLessThanOrEqualTo(String value) {
            addCriterion("boss_lphone <=", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneLike(String value) {
            addCriterion("boss_lphone like", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneNotLike(String value) {
            addCriterion("boss_lphone not like", value, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneIn(List<String> values) {
            addCriterion("boss_lphone in", values, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneNotIn(List<String> values) {
            addCriterion("boss_lphone not in", values, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneBetween(String value1, String value2) {
            addCriterion("boss_lphone between", value1, value2, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andBossLphoneNotBetween(String value1, String value2) {
            addCriterion("boss_lphone not between", value1, value2, "bossLphone");
            return (Criteria) this;
        }

        public Criteria andPmNameIsNull() {
            addCriterion("pm_name is null");
            return (Criteria) this;
        }

        public Criteria andPmNameIsNotNull() {
            addCriterion("pm_name is not null");
            return (Criteria) this;
        }

        public Criteria andPmNameEqualTo(String value) {
            addCriterion("pm_name =", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotEqualTo(String value) {
            addCriterion("pm_name <>", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameGreaterThan(String value) {
            addCriterion("pm_name >", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameGreaterThanOrEqualTo(String value) {
            addCriterion("pm_name >=", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLessThan(String value) {
            addCriterion("pm_name <", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLessThanOrEqualTo(String value) {
            addCriterion("pm_name <=", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLike(String value) {
            addCriterion("pm_name like", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotLike(String value) {
            addCriterion("pm_name not like", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameIn(List<String> values) {
            addCriterion("pm_name in", values, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotIn(List<String> values) {
            addCriterion("pm_name not in", values, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameBetween(String value1, String value2) {
            addCriterion("pm_name between", value1, value2, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotBetween(String value1, String value2) {
            addCriterion("pm_name not between", value1, value2, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmMphoneIsNull() {
            addCriterion("pm_mphone is null");
            return (Criteria) this;
        }

        public Criteria andPmMphoneIsNotNull() {
            addCriterion("pm_mphone is not null");
            return (Criteria) this;
        }

        public Criteria andPmMphoneEqualTo(String value) {
            addCriterion("pm_mphone =", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneNotEqualTo(String value) {
            addCriterion("pm_mphone <>", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneGreaterThan(String value) {
            addCriterion("pm_mphone >", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneGreaterThanOrEqualTo(String value) {
            addCriterion("pm_mphone >=", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneLessThan(String value) {
            addCriterion("pm_mphone <", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneLessThanOrEqualTo(String value) {
            addCriterion("pm_mphone <=", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneLike(String value) {
            addCriterion("pm_mphone like", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneNotLike(String value) {
            addCriterion("pm_mphone not like", value, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneIn(List<String> values) {
            addCriterion("pm_mphone in", values, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneNotIn(List<String> values) {
            addCriterion("pm_mphone not in", values, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneBetween(String value1, String value2) {
            addCriterion("pm_mphone between", value1, value2, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmMphoneNotBetween(String value1, String value2) {
            addCriterion("pm_mphone not between", value1, value2, "pmMphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneIsNull() {
            addCriterion("pm_lphone is null");
            return (Criteria) this;
        }

        public Criteria andPmLphoneIsNotNull() {
            addCriterion("pm_lphone is not null");
            return (Criteria) this;
        }

        public Criteria andPmLphoneEqualTo(String value) {
            addCriterion("pm_lphone =", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneNotEqualTo(String value) {
            addCriterion("pm_lphone <>", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneGreaterThan(String value) {
            addCriterion("pm_lphone >", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneGreaterThanOrEqualTo(String value) {
            addCriterion("pm_lphone >=", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneLessThan(String value) {
            addCriterion("pm_lphone <", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneLessThanOrEqualTo(String value) {
            addCriterion("pm_lphone <=", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneLike(String value) {
            addCriterion("pm_lphone like", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneNotLike(String value) {
            addCriterion("pm_lphone not like", value, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneIn(List<String> values) {
            addCriterion("pm_lphone in", values, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneNotIn(List<String> values) {
            addCriterion("pm_lphone not in", values, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneBetween(String value1, String value2) {
            addCriterion("pm_lphone between", value1, value2, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andPmLphoneNotBetween(String value1, String value2) {
            addCriterion("pm_lphone not between", value1, value2, "pmLphone");
            return (Criteria) this;
        }

        public Criteria andBmNameIsNull() {
            addCriterion("bm_name is null");
            return (Criteria) this;
        }

        public Criteria andBmNameIsNotNull() {
            addCriterion("bm_name is not null");
            return (Criteria) this;
        }

        public Criteria andBmNameEqualTo(String value) {
            addCriterion("bm_name =", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotEqualTo(String value) {
            addCriterion("bm_name <>", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameGreaterThan(String value) {
            addCriterion("bm_name >", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameGreaterThanOrEqualTo(String value) {
            addCriterion("bm_name >=", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameLessThan(String value) {
            addCriterion("bm_name <", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameLessThanOrEqualTo(String value) {
            addCriterion("bm_name <=", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameLike(String value) {
            addCriterion("bm_name like", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotLike(String value) {
            addCriterion("bm_name not like", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameIn(List<String> values) {
            addCriterion("bm_name in", values, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotIn(List<String> values) {
            addCriterion("bm_name not in", values, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameBetween(String value1, String value2) {
            addCriterion("bm_name between", value1, value2, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotBetween(String value1, String value2) {
            addCriterion("bm_name not between", value1, value2, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmMphoneIsNull() {
            addCriterion("bm_mphone is null");
            return (Criteria) this;
        }

        public Criteria andBmMphoneIsNotNull() {
            addCriterion("bm_mphone is not null");
            return (Criteria) this;
        }

        public Criteria andBmMphoneEqualTo(String value) {
            addCriterion("bm_mphone =", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneNotEqualTo(String value) {
            addCriterion("bm_mphone <>", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneGreaterThan(String value) {
            addCriterion("bm_mphone >", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneGreaterThanOrEqualTo(String value) {
            addCriterion("bm_mphone >=", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneLessThan(String value) {
            addCriterion("bm_mphone <", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneLessThanOrEqualTo(String value) {
            addCriterion("bm_mphone <=", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneLike(String value) {
            addCriterion("bm_mphone like", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneNotLike(String value) {
            addCriterion("bm_mphone not like", value, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneIn(List<String> values) {
            addCriterion("bm_mphone in", values, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneNotIn(List<String> values) {
            addCriterion("bm_mphone not in", values, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneBetween(String value1, String value2) {
            addCriterion("bm_mphone between", value1, value2, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmMphoneNotBetween(String value1, String value2) {
            addCriterion("bm_mphone not between", value1, value2, "bmMphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneIsNull() {
            addCriterion("bm_lphone is null");
            return (Criteria) this;
        }

        public Criteria andBmLphoneIsNotNull() {
            addCriterion("bm_lphone is not null");
            return (Criteria) this;
        }

        public Criteria andBmLphoneEqualTo(String value) {
            addCriterion("bm_lphone =", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneNotEqualTo(String value) {
            addCriterion("bm_lphone <>", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneGreaterThan(String value) {
            addCriterion("bm_lphone >", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneGreaterThanOrEqualTo(String value) {
            addCriterion("bm_lphone >=", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneLessThan(String value) {
            addCriterion("bm_lphone <", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneLessThanOrEqualTo(String value) {
            addCriterion("bm_lphone <=", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneLike(String value) {
            addCriterion("bm_lphone like", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneNotLike(String value) {
            addCriterion("bm_lphone not like", value, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneIn(List<String> values) {
            addCriterion("bm_lphone in", values, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneNotIn(List<String> values) {
            addCriterion("bm_lphone not in", values, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneBetween(String value1, String value2) {
            addCriterion("bm_lphone between", value1, value2, "bmLphone");
            return (Criteria) this;
        }

        public Criteria andBmLphoneNotBetween(String value1, String value2) {
            addCriterion("bm_lphone not between", value1, value2, "bmLphone");
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