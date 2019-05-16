package com.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TNeckletChangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TNeckletChangeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoIsNull() {
            addCriterion("old_necklet_no is null");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoIsNotNull() {
            addCriterion("old_necklet_no is not null");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoEqualTo(String value) {
            addCriterion("old_necklet_no =", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoNotEqualTo(String value) {
            addCriterion("old_necklet_no <>", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoGreaterThan(String value) {
            addCriterion("old_necklet_no >", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoGreaterThanOrEqualTo(String value) {
            addCriterion("old_necklet_no >=", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoLessThan(String value) {
            addCriterion("old_necklet_no <", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoLessThanOrEqualTo(String value) {
            addCriterion("old_necklet_no <=", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoLike(String value) {
            addCriterion("old_necklet_no like", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoNotLike(String value) {
            addCriterion("old_necklet_no not like", value, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoIn(List<String> values) {
            addCriterion("old_necklet_no in", values, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoNotIn(List<String> values) {
            addCriterion("old_necklet_no not in", values, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoBetween(String value1, String value2) {
            addCriterion("old_necklet_no between", value1, value2, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andOldNeckletNoNotBetween(String value1, String value2) {
            addCriterion("old_necklet_no not between", value1, value2, "oldNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoIsNull() {
            addCriterion("new_necklet_no is null");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoIsNotNull() {
            addCriterion("new_necklet_no is not null");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoEqualTo(String value) {
            addCriterion("new_necklet_no =", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoNotEqualTo(String value) {
            addCriterion("new_necklet_no <>", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoGreaterThan(String value) {
            addCriterion("new_necklet_no >", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoGreaterThanOrEqualTo(String value) {
            addCriterion("new_necklet_no >=", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoLessThan(String value) {
            addCriterion("new_necklet_no <", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoLessThanOrEqualTo(String value) {
            addCriterion("new_necklet_no <=", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoLike(String value) {
            addCriterion("new_necklet_no like", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoNotLike(String value) {
            addCriterion("new_necklet_no not like", value, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoIn(List<String> values) {
            addCriterion("new_necklet_no in", values, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoNotIn(List<String> values) {
            addCriterion("new_necklet_no not in", values, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoBetween(String value1, String value2) {
            addCriterion("new_necklet_no between", value1, value2, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andNewNeckletNoNotBetween(String value1, String value2) {
            addCriterion("new_necklet_no not between", value1, value2, "newNeckletNo");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsIsNull() {
            addCriterion("change_reasons is null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsIsNotNull() {
            addCriterion("change_reasons is not null");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsEqualTo(String value) {
            addCriterion("change_reasons =", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsNotEqualTo(String value) {
            addCriterion("change_reasons <>", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsGreaterThan(String value) {
            addCriterion("change_reasons >", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsGreaterThanOrEqualTo(String value) {
            addCriterion("change_reasons >=", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsLessThan(String value) {
            addCriterion("change_reasons <", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsLessThanOrEqualTo(String value) {
            addCriterion("change_reasons <=", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsLike(String value) {
            addCriterion("change_reasons like", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsNotLike(String value) {
            addCriterion("change_reasons not like", value, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsIn(List<String> values) {
            addCriterion("change_reasons in", values, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsNotIn(List<String> values) {
            addCriterion("change_reasons not in", values, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsBetween(String value1, String value2) {
            addCriterion("change_reasons between", value1, value2, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andChangeReasonsNotBetween(String value1, String value2) {
            addCriterion("change_reasons not between", value1, value2, "changeReasons");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDogIdIsNull() {
            addCriterion("dog_id is null");
            return (Criteria) this;
        }

        public Criteria andDogIdIsNotNull() {
            addCriterion("dog_id is not null");
            return (Criteria) this;
        }

        public Criteria andDogIdEqualTo(Integer value) {
            addCriterion("dog_id =", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotEqualTo(Integer value) {
            addCriterion("dog_id <>", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdGreaterThan(Integer value) {
            addCriterion("dog_id >", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dog_id >=", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdLessThan(Integer value) {
            addCriterion("dog_id <", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdLessThanOrEqualTo(Integer value) {
            addCriterion("dog_id <=", value, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdIn(List<Integer> values) {
            addCriterion("dog_id in", values, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotIn(List<Integer> values) {
            addCriterion("dog_id not in", values, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdBetween(Integer value1, Integer value2) {
            addCriterion("dog_id between", value1, value2, "dogId");
            return (Criteria) this;
        }

        public Criteria andDogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dog_id not between", value1, value2, "dogId");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
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