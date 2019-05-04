package com.pers.aiyin.fitness.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartIsNull() {
            addCriterion("course_time_start is null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartIsNotNull() {
            addCriterion("course_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartEqualTo(Date value) {
            addCriterion("course_time_start =", value, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartNotEqualTo(Date value) {
            addCriterion("course_time_start <>", value, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartGreaterThan(Date value) {
            addCriterion("course_time_start >", value, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("course_time_start >=", value, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartLessThan(Date value) {
            addCriterion("course_time_start <", value, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("course_time_start <=", value, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartIn(List<Date> values) {
            addCriterion("course_time_start in", values, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartNotIn(List<Date> values) {
            addCriterion("course_time_start not in", values, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartBetween(Date value1, Date value2) {
            addCriterion("course_time_start between", value1, value2, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("course_time_start not between", value1, value2, "courseTimeStart");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndIsNull() {
            addCriterion("course_time_end is null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndIsNotNull() {
            addCriterion("course_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndEqualTo(Date value) {
            addCriterion("course_time_end =", value, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndNotEqualTo(Date value) {
            addCriterion("course_time_end <>", value, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndGreaterThan(Date value) {
            addCriterion("course_time_end >", value, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("course_time_end >=", value, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndLessThan(Date value) {
            addCriterion("course_time_end <", value, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("course_time_end <=", value, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndIn(List<Date> values) {
            addCriterion("course_time_end in", values, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndNotIn(List<Date> values) {
            addCriterion("course_time_end not in", values, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndBetween(Date value1, Date value2) {
            addCriterion("course_time_end between", value1, value2, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("course_time_end not between", value1, value2, "courseTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
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

        public Criteria andCoachNameIsNull() {
            addCriterion("coach_name is null");
            return (Criteria) this;
        }

        public Criteria andCoachNameIsNotNull() {
            addCriterion("coach_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoachNameEqualTo(String value) {
            addCriterion("coach_name =", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameNotEqualTo(String value) {
            addCriterion("coach_name <>", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameGreaterThan(String value) {
            addCriterion("coach_name >", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameGreaterThanOrEqualTo(String value) {
            addCriterion("coach_name >=", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameLessThan(String value) {
            addCriterion("coach_name <", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameLessThanOrEqualTo(String value) {
            addCriterion("coach_name <=", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameLike(String value) {
            addCriterion("coach_name like", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameNotLike(String value) {
            addCriterion("coach_name not like", value, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameIn(List<String> values) {
            addCriterion("coach_name in", values, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameNotIn(List<String> values) {
            addCriterion("coach_name not in", values, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameBetween(String value1, String value2) {
            addCriterion("coach_name between", value1, value2, "coachName");
            return (Criteria) this;
        }

        public Criteria andCoachNameNotBetween(String value1, String value2) {
            addCriterion("coach_name not between", value1, value2, "coachName");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityIsNull() {
            addCriterion("course_capacity is null");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityIsNotNull() {
            addCriterion("course_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityEqualTo(Integer value) {
            addCriterion("course_capacity =", value, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityNotEqualTo(Integer value) {
            addCriterion("course_capacity <>", value, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityGreaterThan(Integer value) {
            addCriterion("course_capacity >", value, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_capacity >=", value, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityLessThan(Integer value) {
            addCriterion("course_capacity <", value, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("course_capacity <=", value, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityIn(List<Integer> values) {
            addCriterion("course_capacity in", values, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityNotIn(List<Integer> values) {
            addCriterion("course_capacity not in", values, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityBetween(Integer value1, Integer value2) {
            addCriterion("course_capacity between", value1, value2, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("course_capacity not between", value1, value2, "courseCapacity");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusIsNull() {
            addCriterion("course_surplus is null");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusIsNotNull() {
            addCriterion("course_surplus is not null");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusEqualTo(Integer value) {
            addCriterion("course_surplus =", value, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusNotEqualTo(Integer value) {
            addCriterion("course_surplus <>", value, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusGreaterThan(Integer value) {
            addCriterion("course_surplus >", value, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_surplus >=", value, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusLessThan(Integer value) {
            addCriterion("course_surplus <", value, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusLessThanOrEqualTo(Integer value) {
            addCriterion("course_surplus <=", value, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusIn(List<Integer> values) {
            addCriterion("course_surplus in", values, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusNotIn(List<Integer> values) {
            addCriterion("course_surplus not in", values, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusBetween(Integer value1, Integer value2) {
            addCriterion("course_surplus between", value1, value2, "courseSurplus");
            return (Criteria) this;
        }

        public Criteria andCourseSurplusNotBetween(Integer value1, Integer value2) {
            addCriterion("course_surplus not between", value1, value2, "courseSurplus");
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