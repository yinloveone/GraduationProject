package com.pers.aiyin.fitness.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DietRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DietRecordExample() {
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

        public Criteria andDietIdIsNull() {
            addCriterion("diet_id is null");
            return (Criteria) this;
        }

        public Criteria andDietIdIsNotNull() {
            addCriterion("diet_id is not null");
            return (Criteria) this;
        }

        public Criteria andDietIdEqualTo(Integer value) {
            addCriterion("diet_id =", value, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdNotEqualTo(Integer value) {
            addCriterion("diet_id <>", value, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdGreaterThan(Integer value) {
            addCriterion("diet_id >", value, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("diet_id >=", value, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdLessThan(Integer value) {
            addCriterion("diet_id <", value, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdLessThanOrEqualTo(Integer value) {
            addCriterion("diet_id <=", value, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdIn(List<Integer> values) {
            addCriterion("diet_id in", values, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdNotIn(List<Integer> values) {
            addCriterion("diet_id not in", values, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdBetween(Integer value1, Integer value2) {
            addCriterion("diet_id between", value1, value2, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietIdNotBetween(Integer value1, Integer value2) {
            addCriterion("diet_id not between", value1, value2, "dietId");
            return (Criteria) this;
        }

        public Criteria andDietDateIsNull() {
            addCriterion("diet_date is null");
            return (Criteria) this;
        }

        public Criteria andDietDateIsNotNull() {
            addCriterion("diet_date is not null");
            return (Criteria) this;
        }

        public Criteria andDietDateEqualTo(Date value) {
            addCriterionForJDBCDate("diet_date =", value, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("diet_date <>", value, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateGreaterThan(Date value) {
            addCriterionForJDBCDate("diet_date >", value, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("diet_date >=", value, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateLessThan(Date value) {
            addCriterionForJDBCDate("diet_date <", value, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("diet_date <=", value, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateIn(List<Date> values) {
            addCriterionForJDBCDate("diet_date in", values, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("diet_date not in", values, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("diet_date between", value1, value2, "dietDate");
            return (Criteria) this;
        }

        public Criteria andDietDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("diet_date not between", value1, value2, "dietDate");
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

        public Criteria andDietContentIsNull() {
            addCriterion("diet_content is null");
            return (Criteria) this;
        }

        public Criteria andDietContentIsNotNull() {
            addCriterion("diet_content is not null");
            return (Criteria) this;
        }

        public Criteria andDietContentEqualTo(String value) {
            addCriterion("diet_content =", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentNotEqualTo(String value) {
            addCriterion("diet_content <>", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentGreaterThan(String value) {
            addCriterion("diet_content >", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentGreaterThanOrEqualTo(String value) {
            addCriterion("diet_content >=", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentLessThan(String value) {
            addCriterion("diet_content <", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentLessThanOrEqualTo(String value) {
            addCriterion("diet_content <=", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentLike(String value) {
            addCriterion("diet_content like", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentNotLike(String value) {
            addCriterion("diet_content not like", value, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentIn(List<String> values) {
            addCriterion("diet_content in", values, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentNotIn(List<String> values) {
            addCriterion("diet_content not in", values, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentBetween(String value1, String value2) {
            addCriterion("diet_content between", value1, value2, "dietContent");
            return (Criteria) this;
        }

        public Criteria andDietContentNotBetween(String value1, String value2) {
            addCriterion("diet_content not between", value1, value2, "dietContent");
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