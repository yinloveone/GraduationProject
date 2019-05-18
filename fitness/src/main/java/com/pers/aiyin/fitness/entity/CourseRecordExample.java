package com.pers.aiyin.fitness.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourseRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCourseRecordIdIsNull() {
            addCriterion("course_record_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdIsNotNull() {
            addCriterion("course_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdEqualTo(Integer value) {
            addCriterion("course_record_id =", value, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdNotEqualTo(Integer value) {
            addCriterion("course_record_id <>", value, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdGreaterThan(Integer value) {
            addCriterion("course_record_id >", value, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_record_id >=", value, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdLessThan(Integer value) {
            addCriterion("course_record_id <", value, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_record_id <=", value, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdIn(List<Integer> values) {
            addCriterion("course_record_id in", values, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdNotIn(List<Integer> values) {
            addCriterion("course_record_id not in", values, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("course_record_id between", value1, value2, "courseRecordId");
            return (Criteria) this;
        }

        public Criteria andCourseRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_record_id not between", value1, value2, "courseRecordId");
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andScdateIsNull() {
            addCriterion("scdate is null");
            return (Criteria) this;
        }

        public Criteria andScdateIsNotNull() {
            addCriterion("scdate is not null");
            return (Criteria) this;
        }

        public Criteria andScdateEqualTo(Date value) {
            addCriterionForJDBCDate("scdate =", value, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("scdate <>", value, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateGreaterThan(Date value) {
            addCriterionForJDBCDate("scdate >", value, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("scdate >=", value, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateLessThan(Date value) {
            addCriterionForJDBCDate("scdate <", value, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("scdate <=", value, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateIn(List<Date> values) {
            addCriterionForJDBCDate("scdate in", values, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("scdate not in", values, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("scdate between", value1, value2, "scdate");
            return (Criteria) this;
        }

        public Criteria andScdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("scdate not between", value1, value2, "scdate");
            return (Criteria) this;
        }

        public Criteria andSignInIsNull() {
            addCriterion("sign_in is null");
            return (Criteria) this;
        }

        public Criteria andSignInIsNotNull() {
            addCriterion("sign_in is not null");
            return (Criteria) this;
        }

        public Criteria andSignInEqualTo(Byte value) {
            addCriterion("sign_in =", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotEqualTo(Byte value) {
            addCriterion("sign_in <>", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInGreaterThan(Byte value) {
            addCriterion("sign_in >", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInGreaterThanOrEqualTo(Byte value) {
            addCriterion("sign_in >=", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInLessThan(Byte value) {
            addCriterion("sign_in <", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInLessThanOrEqualTo(Byte value) {
            addCriterion("sign_in <=", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInIn(List<Byte> values) {
            addCriterion("sign_in in", values, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotIn(List<Byte> values) {
            addCriterion("sign_in not in", values, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInBetween(Byte value1, Byte value2) {
            addCriterion("sign_in between", value1, value2, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotBetween(Byte value1, Byte value2) {
            addCriterion("sign_in not between", value1, value2, "signIn");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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