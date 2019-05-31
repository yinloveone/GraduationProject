package com.pers.aiyin.fitness.entity;

import java.util.ArrayList;
import java.util.List;

public class CourseHourExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseHourExample() {
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

        public Criteria andHourIdIsNull() {
            addCriterion("hour_id is null");
            return (Criteria) this;
        }

        public Criteria andHourIdIsNotNull() {
            addCriterion("hour_id is not null");
            return (Criteria) this;
        }

        public Criteria andHourIdEqualTo(Integer value) {
            addCriterion("hour_id =", value, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdNotEqualTo(Integer value) {
            addCriterion("hour_id <>", value, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdGreaterThan(Integer value) {
            addCriterion("hour_id >", value, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hour_id >=", value, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdLessThan(Integer value) {
            addCriterion("hour_id <", value, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdLessThanOrEqualTo(Integer value) {
            addCriterion("hour_id <=", value, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdIn(List<Integer> values) {
            addCriterion("hour_id in", values, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdNotIn(List<Integer> values) {
            addCriterion("hour_id not in", values, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdBetween(Integer value1, Integer value2) {
            addCriterion("hour_id between", value1, value2, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hour_id not between", value1, value2, "hourId");
            return (Criteria) this;
        }

        public Criteria andHourNameIsNull() {
            addCriterion("hour_name is null");
            return (Criteria) this;
        }

        public Criteria andHourNameIsNotNull() {
            addCriterion("hour_name is not null");
            return (Criteria) this;
        }

        public Criteria andHourNameEqualTo(String value) {
            addCriterion("hour_name =", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameNotEqualTo(String value) {
            addCriterion("hour_name <>", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameGreaterThan(String value) {
            addCriterion("hour_name >", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameGreaterThanOrEqualTo(String value) {
            addCriterion("hour_name >=", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameLessThan(String value) {
            addCriterion("hour_name <", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameLessThanOrEqualTo(String value) {
            addCriterion("hour_name <=", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameLike(String value) {
            addCriterion("hour_name like", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameNotLike(String value) {
            addCriterion("hour_name not like", value, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameIn(List<String> values) {
            addCriterion("hour_name in", values, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameNotIn(List<String> values) {
            addCriterion("hour_name not in", values, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameBetween(String value1, String value2) {
            addCriterion("hour_name between", value1, value2, "hourName");
            return (Criteria) this;
        }

        public Criteria andHourNameNotBetween(String value1, String value2) {
            addCriterion("hour_name not between", value1, value2, "hourName");
            return (Criteria) this;
        }

        public Criteria andCoachIdIsNull() {
            addCriterion("coach_id is null");
            return (Criteria) this;
        }

        public Criteria andCoachIdIsNotNull() {
            addCriterion("coach_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoachIdEqualTo(Integer value) {
            addCriterion("coach_id =", value, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdNotEqualTo(Integer value) {
            addCriterion("coach_id <>", value, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdGreaterThan(Integer value) {
            addCriterion("coach_id >", value, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coach_id >=", value, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdLessThan(Integer value) {
            addCriterion("coach_id <", value, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdLessThanOrEqualTo(Integer value) {
            addCriterion("coach_id <=", value, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdIn(List<Integer> values) {
            addCriterion("coach_id in", values, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdNotIn(List<Integer> values) {
            addCriterion("coach_id not in", values, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdBetween(Integer value1, Integer value2) {
            addCriterion("coach_id between", value1, value2, "coachId");
            return (Criteria) this;
        }

        public Criteria andCoachIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coach_id not between", value1, value2, "coachId");
            return (Criteria) this;
        }

        public Criteria andHourCountIsNull() {
            addCriterion("hour_count is null");
            return (Criteria) this;
        }

        public Criteria andHourCountIsNotNull() {
            addCriterion("hour_count is not null");
            return (Criteria) this;
        }

        public Criteria andHourCountEqualTo(Integer value) {
            addCriterion("hour_count =", value, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountNotEqualTo(Integer value) {
            addCriterion("hour_count <>", value, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountGreaterThan(Integer value) {
            addCriterion("hour_count >", value, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("hour_count >=", value, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountLessThan(Integer value) {
            addCriterion("hour_count <", value, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountLessThanOrEqualTo(Integer value) {
            addCriterion("hour_count <=", value, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountIn(List<Integer> values) {
            addCriterion("hour_count in", values, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountNotIn(List<Integer> values) {
            addCriterion("hour_count not in", values, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountBetween(Integer value1, Integer value2) {
            addCriterion("hour_count between", value1, value2, "hourCount");
            return (Criteria) this;
        }

        public Criteria andHourCountNotBetween(Integer value1, Integer value2) {
            addCriterion("hour_count not between", value1, value2, "hourCount");
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