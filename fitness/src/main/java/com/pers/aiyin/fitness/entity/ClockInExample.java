package com.pers.aiyin.fitness.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClockInExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClockInExample() {
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

        public Criteria andClockInIdIsNull() {
            addCriterion("clock_in_id is null");
            return (Criteria) this;
        }

        public Criteria andClockInIdIsNotNull() {
            addCriterion("clock_in_id is not null");
            return (Criteria) this;
        }

        public Criteria andClockInIdEqualTo(Integer value) {
            addCriterion("clock_in_id =", value, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdNotEqualTo(Integer value) {
            addCriterion("clock_in_id <>", value, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdGreaterThan(Integer value) {
            addCriterion("clock_in_id >", value, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("clock_in_id >=", value, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdLessThan(Integer value) {
            addCriterion("clock_in_id <", value, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdLessThanOrEqualTo(Integer value) {
            addCriterion("clock_in_id <=", value, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdIn(List<Integer> values) {
            addCriterion("clock_in_id in", values, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdNotIn(List<Integer> values) {
            addCriterion("clock_in_id not in", values, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdBetween(Integer value1, Integer value2) {
            addCriterion("clock_in_id between", value1, value2, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockInIdNotBetween(Integer value1, Integer value2) {
            addCriterion("clock_in_id not between", value1, value2, "clockInId");
            return (Criteria) this;
        }

        public Criteria andClockTimeIsNull() {
            addCriterion("clock_time is null");
            return (Criteria) this;
        }

        public Criteria andClockTimeIsNotNull() {
            addCriterion("clock_time is not null");
            return (Criteria) this;
        }

        public Criteria andClockTimeEqualTo(Date value) {
            addCriterion("clock_time =", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotEqualTo(Date value) {
            addCriterion("clock_time <>", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeGreaterThan(Date value) {
            addCriterion("clock_time >", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("clock_time >=", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeLessThan(Date value) {
            addCriterion("clock_time <", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeLessThanOrEqualTo(Date value) {
            addCriterion("clock_time <=", value, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeIn(List<Date> values) {
            addCriterion("clock_time in", values, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotIn(List<Date> values) {
            addCriterion("clock_time not in", values, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeBetween(Date value1, Date value2) {
            addCriterion("clock_time between", value1, value2, "clockTime");
            return (Criteria) this;
        }

        public Criteria andClockTimeNotBetween(Date value1, Date value2) {
            addCriterion("clock_time not between", value1, value2, "clockTime");
            return (Criteria) this;
        }

        public Criteria andCockContentIsNull() {
            addCriterion("cock_content is null");
            return (Criteria) this;
        }

        public Criteria andCockContentIsNotNull() {
            addCriterion("cock_content is not null");
            return (Criteria) this;
        }

        public Criteria andCockContentEqualTo(String value) {
            addCriterion("cock_content =", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentNotEqualTo(String value) {
            addCriterion("cock_content <>", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentGreaterThan(String value) {
            addCriterion("cock_content >", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentGreaterThanOrEqualTo(String value) {
            addCriterion("cock_content >=", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentLessThan(String value) {
            addCriterion("cock_content <", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentLessThanOrEqualTo(String value) {
            addCriterion("cock_content <=", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentLike(String value) {
            addCriterion("cock_content like", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentNotLike(String value) {
            addCriterion("cock_content not like", value, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentIn(List<String> values) {
            addCriterion("cock_content in", values, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentNotIn(List<String> values) {
            addCriterion("cock_content not in", values, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentBetween(String value1, String value2) {
            addCriterion("cock_content between", value1, value2, "cockContent");
            return (Criteria) this;
        }

        public Criteria andCockContentNotBetween(String value1, String value2) {
            addCriterion("cock_content not between", value1, value2, "cockContent");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(Byte value) {
            addCriterion("is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(Byte value) {
            addCriterion("is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(Byte value) {
            addCriterion("is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(Byte value) {
            addCriterion("is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(Byte value) {
            addCriterion("is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<Byte> values) {
            addCriterion("is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<Byte> values) {
            addCriterion("is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(Byte value1, Byte value2) {
            addCriterion("is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(Byte value1, Byte value2) {
            addCriterion("is_valid not between", value1, value2, "isValid");
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